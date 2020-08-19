package net.ludocrypt.backrooms.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Pipe;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level2LongRoom extends Feature<DefaultFeatureConfig> {
	public Level2LongRoom(Codec<DefaultFeatureConfig> configFactory) {
		super(configFactory);
	}

	private int[][] Orange = { { 2, 2, 2, 2 }, { 2, 2, 2, 2 }, { 2, 2, 2, 2 }, { 2, 2, 2, 2 }, { 2, 2, 2, 2 } };
	private int[][] Red = { { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 4, 4, 4, 4 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
	private int[][] Brown = { { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };

	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState CEMENT = Backrooms.CEMENT.getDefaultState();
	private static final BlockState PIPENORTHSOUTH = Backrooms.PIPE.getDefaultState().with(Pipe.NORTH, true)
			.with(Pipe.SOUTH, true);
	private static final BlockState PIPENORTHSOUTHEAST = Backrooms.PIPE.getDefaultState().with(Pipe.EAST, true)
			.with(Pipe.SOUTH, true).with(Pipe.NORTH, true);

	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random rand, BlockPos position,
			DefaultFeatureConfig featureConfig) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable().set(position);

		generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
		generateSlice(world, mutableBlockPos.move(Direction.WEST), Red, rand);
		generateSlice(world, mutableBlockPos.move(Direction.WEST), Brown, rand);
		generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);

		return true;

	}

	private void generateSlice(ServerWorldAccess world, BlockPos.Mutable centerPos, int[][] slice, Random rand) {

		BlockPos currentPositionOffsetted = new BlockPos(centerPos.add(0, 3, slice[0].length));
		BlockPos.Mutable currentPosition = new BlockPos.Mutable(currentPositionOffsetted.getX(),
				currentPositionOffsetted.getY(), currentPositionOffsetted.getZ());

		for (int y = 0; y < slice.length; y++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[y][z];

				if (((world.getBlockState(currentPosition).getBlock() == Backrooms.WALL)
						|| (world.getBlockState(currentPosition).getBlock() == Blocks.BEDROCK))) {

					switch (sliceBlock) {
					case 0:
						break;
					case 1:
						world.setBlockState(currentPosition, AIR, 2);
						break;
					case 2:
						world.setBlockState(currentPosition, CEMENT, 2);
						break;
					case 4:
						if (rand.nextDouble() > 0.1) {
							world.setBlockState(currentPosition, PIPENORTHSOUTH, 2);
						} else {
							world.setBlockState(currentPosition, PIPENORTHSOUTHEAST, 2);
						}
						break;
					}
				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(0, -1, -slice[0].length);
		}
	}
}