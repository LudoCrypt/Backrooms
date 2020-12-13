package net.ludocrypt.backrooms.world.chunk;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.EmptyBlockView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StructuresConfig;

public class BasicMazeChunkGenerator extends ChunkGenerator {

	private static final BlockState wallBlock = BackroomsBlocks.CEMENT.getDefaultState();
	private static final BlockState airBlock = Blocks.AIR.getDefaultState();

	public static final Codec<BasicMazeChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(BiomeSource.CODEC.fieldOf("biome_source").forGetter((chg) -> {
			return chg.biomeSource;
		}), Codec.LONG.fieldOf("seed").stable().forGetter((chg) -> {
			return chg.worldSeed;
		})).apply(instance, instance.stable(BasicMazeChunkGenerator::new));
	});

	public BasicMazeChunkGenerator(BiomeSource biomeSource, long worldSeed) {
		super(biomeSource, biomeSource, new StructuresConfig(false), worldSeed);
	}

	public BasicMazeChunkGenerator(BiomeSource populationSource, BiomeSource biomeSource, StructuresConfig structuresConfig, long worldSeed) {
		super(populationSource, biomeSource, structuresConfig, worldSeed);
	}

	@Override
	public void buildSurface(ChunkRegion region, Chunk chunk) {
	}

	@Override
	public int getSpawnHeight() {
		return 100;
	}

	private void placeWalls(WorldAccess world, Chunk chunk, Random rand, int i, int j) {
		BlockPos.Mutable mutable = new BlockPos.Mutable();

		int x = (chunk.getPos().x << 16) + i;
		int y = 3;
		int z = (chunk.getPos().z << 16) + j;

		boolean bl1 = rand.nextBoolean();
		boolean bl2 = rand.nextBoolean();
		boolean bl3 = rand.nextBoolean();
		boolean bl4 = rand.nextBoolean();

		for (int ii = 0; ii < 3; ii++) {
			y++;

			BlockPos pos = new BlockPos(x, y, z);

			chunk.setBlockState(mutable.set(x, y, z), wallBlock, false);

			if (bl1) {
				for (int xi = 1; xi < 4; xi++) {
					chunk.setBlockState(mutable.set(x + xi, y, z), wallBlock, false);
				}
			} else {
				for (int zi = 1; zi < 4; zi++) {
					chunk.setBlockState(mutable.set(x, y, z + zi), wallBlock, false);
				}
			}

			if (bl2) {
				if (bl3) {
					for (int xi = 1; xi < 4; xi++) {
						chunk.setBlockState(mutable.set(x + xi, y, z), airBlock, false);
					}
				} else {
					for (int zi = 1; zi < 4; zi++) {
						chunk.setBlockState(mutable.set(x, y, z + zi), airBlock, false);
					}
				}
			}

			if (bl4) {
				if (isTouchingBlock(chunk, airBlock, pos)) {
					chunk.setBlockState(mutable.set(x, y, z), airBlock, false);
				}
			}
		}

	}

	@Deprecated
	private boolean isTouchingBlock(Chunk chunk, BlockState state, BlockPos pos) {
		return chunk.getBlockState(pos.north()) == state && chunk.getBlockState(pos.east()) == state && chunk.getBlockState(pos.south()) == state && chunk.getBlockState(pos.west()) == state;
	}

	@Override
	public int getHeight(int x, int z, Heightmap.Type heightmapType) {
		return 100;
	}

	@Override
	public BlockView getColumnSample(int x, int z) {
		return EmptyBlockView.INSTANCE;
	}

	@Override
	protected Codec<? extends ChunkGenerator> getCodec() {
		return CODEC;
	}

	@Override
	public ChunkGenerator withSeed(long seed) {
		return new BasicMazeChunkGenerator(biomeSource, biomeSource, structuresConfig, seed);
	}

	@Override
	public void populateNoise(WorldAccess world, StructureAccessor accessor, Chunk chunk) {
		ChunkPos chunkPos = chunk.getPos();
		BlockState blockState = BackroomsBlocks.WALL.getDefaultState();
		BlockPos.Mutable mutable = new BlockPos.Mutable();

		for (int i = 0; i < 16; ++i) {
			for (int k = 0; k < 16; ++k) {
				for (int j = 0; j < 3; ++j) {
					chunk.setBlockState(mutable.set(i, j, k), blockState, false);
				}

				chunk.setBlockState(mutable.set(i, 3, k), wallBlock, false);

				chunk.setBlockState(mutable.set(i, 7, k), wallBlock, false);

				for (int j = 8; j < 256; ++j) {
					chunk.setBlockState(mutable.set(i, j, k), blockState, false);
				}
			}
		}

		int x = (chunkPos.x << 16);
		int y = 4;
		int z = (chunkPos.z << 16);

		Random random = new Random(MathHelper.hashCode(x, y, z));
		Random randomTwo = new Random(MathHelper.hashCode(x ^ y, y ^ x, z ^ y));

		this.placeWalls(world, chunk, random, 0, 0);
		this.placeWalls(world, chunk, random, 0, 3);
		this.placeWalls(world, chunk, random, 3, 0);
		this.placeWalls(world, chunk, random, 3, 3);

		for (int xi = 0; xi < 4; xi++) {
			for (int zi = 0; zi < 4; zi++) {
				this.placeWalls(world, chunk, random, xi * 3, zi * 3);
				this.placeWalls(world, chunk, random, (xi * 3) + 3, zi * 3);
				this.placeWalls(world, chunk, random, xi * 3, (zi * 3) + 3);
				this.placeWalls(world, chunk, random, (xi * 3) + 3, (zi * 3) + 3);

				this.placeWalls(world, chunk, randomTwo, xi * 3, zi * 3);
				this.placeWalls(world, chunk, randomTwo, (xi * 3) + 3, zi * 3);
				this.placeWalls(world, chunk, randomTwo, xi * 3, (zi * 3) + 3);
				this.placeWalls(world, chunk, randomTwo, (xi * 3) + 3, (zi * 3) + 3);
			}
		}
	}

}
