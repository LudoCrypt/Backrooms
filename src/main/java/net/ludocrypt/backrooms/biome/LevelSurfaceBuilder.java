package net.ludocrypt.backrooms.biome;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class LevelSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
	public LevelSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
		super(codec);
	}

	private static final BlockState WALL = Backrooms.WALL.getDefaultState();

	public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
		SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid,
				seaLevel, seed, config);
		int xpos = x & 15;
		int zpos = z & 15;
		BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable();

		for (int ypos = 255; ypos >= 0; --ypos) {
			blockpos$Mutable.set(xpos, ypos, zpos);
			BlockState currentBlockState = chunkIn.getBlockState(blockpos$Mutable);

			if (currentBlockState.getBlock() != null) {
				chunkIn.setBlockState(blockpos$Mutable, WALL, false);
			}
		}
	}
}
