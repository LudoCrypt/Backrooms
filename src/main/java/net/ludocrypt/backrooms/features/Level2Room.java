package net.ludocrypt.backrooms.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Pipe;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level2Room extends Feature<DefaultFeatureConfig> {
	public Level2Room(Codec<DefaultFeatureConfig> configFactory) {
		super(configFactory);
	}

	private int[][] White = { { 2, 2, 2, 2 }, { 2, 1, 1, 2 }, { 2, 3, 1, 2 }, { 2, 1, 1, 2 }, { 2, 9, 2, 2 } };
	private int[][] Orange = { { 2, 2, 2, 2 }, { 2, 2, 2, 2 }, { 2, 2, 2, 2 }, { 2, 2, 2, 2 }, { 2, 2, 2, 2 } };
	private int[][] Red = { { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 4, 4, 4, 4 }, { 1, 1, 1, 1 }, { 2, 10, 2, 2 } };
	private int[][] Brown = { { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
	private int[][] Lime = { { 2, 2, 2, 2 }, { 1, 1, 1, 2 }, { 1, 1, 1, 2 }, { 1, 1, 1, 2 }, { 2, 2, 2, 2 } };
	private int[][] Blue = { { 2, 2, 2, 2 }, { 2, 1, 1, 2 }, { 2, 5, 1, 2 }, { 2, 1, 1, 2 }, { 2, 2, 2, 2 } };
	private int[][] Pink = { { 2, 2, 2, 2 }, { 1, 1, 1, 2 }, { 6, 1, 1, 2 }, { 1, 1, 1, 2 }, { 2, 2, 2, 2 } };
	private int[][] Yellow = { { 2, 2, 2, 2 }, { 1, 1, 1, 2 }, { 4, 4, 4, 2 }, { 1, 1, 1, 2 }, { 2, 2, 2, 2 } };
	private int[][] Magenta = { { 2, 2, 2, 2 }, { 2, 1, 1, 1 }, { 2, 4, 4, 4 }, { 2, 1, 1, 1 }, { 2, 2, 2, 2 } };
	private int[][] Green = { { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 6, 1, 1, 7 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
	private int[][] Gray = { { 2, 2, 2, 2 }, { 2, 1, 1, 2 }, { 2, 6, 1, 2 }, { 2, 1, 1, 2 }, { 2, 2, 2, 2 } };
	private int[][] LightGray = { { 2, 2, 2, 2 }, { 2, 1, 1, 1 }, { 2, 3, 1, 1 }, { 2, 1, 1, 1 }, { 2, 2, 2, 2 } };
	private int[][] Cyan = { { 2, 2, 2, 2 }, { 2, 1, 1, 1 }, { 2, 3, 1, 7 }, { 2, 1, 1, 1 }, { 2, 2, 2, 2 } };
	private int[][] Purple = { { 2, 2, 2, 2 }, { 2, 1, 1, 1 }, { 2, 8, 4, 4 }, { 2, 1, 1, 1 }, { 2, 2, 2, 2 } };
	private int[][] LightBlue = { { 2, 2, 2, 2 }, { 2, 1, 1, 1 }, { 2, 1, 1, 1 }, { 2, 1, 1, 1 }, { 2, 2, 2, 2 } };

	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState CEMENT = Backrooms.CEMENT.getDefaultState();
	private static final BlockState PIPEEASTWEST = Backrooms.PIPE.getDefaultState().with(Pipe.EAST, true)
			.with(Pipe.WEST, true);
	private static final BlockState PIPEEASTWESTNORTH = Backrooms.PIPE.getDefaultState().with(Pipe.EAST, true)
			.with(Pipe.WEST, true).with(Pipe.NORTH, true);
	private static final BlockState PIPENORTHSOUTH = Backrooms.PIPE.getDefaultState().with(Pipe.NORTH, true)
			.with(Pipe.SOUTH, true);
	private static final BlockState PIPENORTHWEST = Backrooms.PIPE.getDefaultState().with(Pipe.WEST, true)
			.with(Pipe.NORTH, true);
	private static final BlockState PIPENORTHEAST = Backrooms.PIPE.getDefaultState().with(Pipe.EAST, true)
			.with(Pipe.NORTH, true);
	private static final BlockState PIPESOUTHEAST = Backrooms.PIPE.getDefaultState().with(Pipe.EAST, true)
			.with(Pipe.SOUTH, true);
	private static final BlockState PIPESOUTHWEST = Backrooms.PIPE.getDefaultState().with(Pipe.WEST, true)
			.with(Pipe.SOUTH, true);
	private static final BlockState PIPENORTHSOUTHEAST = Backrooms.PIPE.getDefaultState().with(Pipe.EAST, true)
			.with(Pipe.SOUTH, true).with(Pipe.NORTH, true);
	private static final BlockState VOID_BLOCK = Backrooms.VOID_BLOCK.getDefaultState();

	public boolean generate(ServerWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGen,
			Random rand, BlockPos position, DefaultFeatureConfig config) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable().set(position);

		Random generator = new Random(world.getSeed());
		long seed = world.getSeed();
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = position.getX() * l ^ position.getY() * m ^ position.getZ() * n ^ seed;
		generator = new Random(o);

		int k = 12;
		int t = 8;

		if (rand.nextDouble() < 0.1) {
//			if (rand.nextDouble() < 0.001) {
//			k = generator.nextInt(16);				
//			}
			
			//4 5 6 7 8 9 10 11 13 15
			t = generator.nextInt(10);
			switch (t) {
			case 0:
				k = 4;
				break;
			case 1:
				k = 5;
				break;
			case 2:
				k = 6;
				break;
			case 3:
				k = 7;
				break;
			case 4:
				k = 8;
				break;
			case 5:
				k = 9;
				break;
			case 6:
				k = 10;
				break;
			case 7:
				k = 11;
				break;
			case 8:
				k = 13;
				break;
			case 9:
				k = 15;
				break;
			}
		}

		switch (k) {
		case 0:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 1:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), LightBlue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 2:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 3:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Lime, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 4:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Cyan, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), LightGray, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 5:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Purple, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), LightGray, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 6:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Lime, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			break;
		case 7:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Gray, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Pink, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Lime, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 8:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Cyan, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), LightGray, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 9:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Red, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Brown, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			break;
		case 10:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Gray, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Pink, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Lime, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			break;
		case 11:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Gray, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Green, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Brown, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 12:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Red, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Brown, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 13:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 14:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 15:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Gray, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Green, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Brown, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			break;
		}

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
					case 3:
						if (rand.nextDouble() > 0.1) {
							world.setBlockState(currentPosition, PIPEEASTWEST, 2);
						} else {
							world.setBlockState(currentPosition, PIPEEASTWESTNORTH, 2);
						}
						break;
					case 4:
						if (rand.nextDouble() > 0.1) {
							world.setBlockState(currentPosition, PIPENORTHSOUTH, 2);
						} else {
							world.setBlockState(currentPosition, PIPENORTHSOUTHEAST, 2);
						}
						break;
					case 5:
						world.setBlockState(currentPosition, PIPENORTHWEST, 2);
						break;
					case 6:
						if (world.getBlockState(currentPosition.add(1, 0, 1)) == PIPENORTHEAST) {
							world.setBlockState(currentPosition, PIPENORTHSOUTH, 2);
							world.setBlockState(currentPosition.add(0, 0, 1), PIPENORTHEAST, 2);
							world.setBlockState(currentPosition.add(1, 0, 1), PIPEEASTWEST, 2);
						} else {
							world.setBlockState(currentPosition, PIPENORTHEAST, 2);
						}

						break;
					case 7:
						world.setBlockState(currentPosition, PIPESOUTHEAST, 2);
						break;
					case 8:
						world.setBlockState(currentPosition, PIPESOUTHWEST, 2);
						break;
					case 9:
						world.setBlockState(currentPosition, CEMENT, 2);
						if (rand.nextDouble() < BackroomsConfig.getInstance().VBDoor) {
							world.setBlockState(currentPosition.add(0, 1, 0), VOID_BLOCK, 2);
							world.setBlockState(currentPosition.add(0, 2, 0), VOID_BLOCK, 2);
							world.setBlockState(currentPosition.add(0, 3, 0), VOID_BLOCK, 2);
							world.setBlockState(currentPosition.add(0, 1, 1), VOID_BLOCK, 2);
							world.setBlockState(currentPosition.add(0, 2, 1), VOID_BLOCK, 2);
							world.setBlockState(currentPosition.add(0, 3, 1), VOID_BLOCK, 2);
						}
						break;
					case 10:
						world.setBlockState(currentPosition, CEMENT, 2);
						if (rand.nextDouble() < BackroomsConfig.getInstance().VBDoor) {
							if (rand.nextDouble() < 0.1) {
								world.setBlockState(currentPosition.add(0, 1, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 2, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 3, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(-1, 1, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(-1, 2, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(-1, 3, 0), VOID_BLOCK, 2);
							}
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