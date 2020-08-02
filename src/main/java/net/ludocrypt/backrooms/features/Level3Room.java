package net.ludocrypt.backrooms.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level3Room extends Feature<DefaultFeatureConfig> {
	public Level3Room(Codec<DefaultFeatureConfig> configFactory) {
		super(configFactory);
	}

	private int[][] White = { { 6, 6, 6, 6 }, { 4, 5, 5, 4 }, { 3, 1, 1, 3 }, { 3, 1, 1, 3 }, { 3, 1, 1, 3 },
			{ 2, 7, 2, 2 } };
	private int[][] Orange = { { 6, 6, 6, 6 }, { 4, 4, 4, 4 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 },
			{ 2, 2, 2, 2 } };
	private int[][] Yellow = { { 6, 6, 6, 6 }, { 5, 5, 5, 4 }, { 1, 1, 1, 3 }, { 1, 1, 1, 3 }, { 1, 1, 1, 3 },
			{ 2, 2, 2, 2 } };
	private int[][] Magenta = { { 6, 6, 6, 6 }, { 4, 5, 5, 5 }, { 3, 1, 1, 1 }, { 3, 1, 1, 1 }, { 3, 1, 1, 1 },
			{ 2, 2, 2, 2 } };
	private int[][] Blue = { { 6, 6, 6, 6 }, { 5, 5, 5, 5 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 },
			{ 2, 2, 2, 2 } };

	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState CEILING = Backrooms.CEMENT.getDefaultState();
	private static final BlockState FLOOR = Backrooms.WHITE_CHECKERED.getDefaultState();
	private static final BlockState WALL = Backrooms.CEMENT_BRICKS.getDefaultState();
	private static final BlockState BRICKS = Blocks.BRICKS.getDefaultState();
	private static final BlockState VOID_BLOCK = Backrooms.VOID_BLOCK.getDefaultState();
	private static final BlockState PIPE = Backrooms.LINEDPIPE.getDefaultState();
	private static final BlockState CHEST = Blocks.CHEST.getDefaultState().with(ChestBlock.CHEST_TYPE, ChestType.SINGLE)
			.with(ChestBlock.FACING, Direction.NORTH).with(ChestBlock.WATERLOGGED, false);

	public boolean generate(ServerWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGen,
			Random rand, BlockPos position, DefaultFeatureConfig config) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable().set(position);

		Random generator = new Random(world.getSeed());
		Random generator2 = new Random(world.getSeed());
		Random generatorFront = new Random(world.getSeed());
		Random generatorLeft = new Random(world.getSeed());
		long seed = world.getSeed();
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = position.getX() * l ^ position.getY() * m ^ position.getZ() * n ^ seed;
		long p = position.getX() * l ^ position.getY() * m ^ (position.getZ() - 4) * n ^ seed;
		long q = (position.getX() - 4) * l ^ position.getY() * m ^ position.getZ() * n ^ seed;
		generator = new Random(o);
		generatorFront = new Random(p);
		generatorLeft = new Random(q);
		generator2 = new Random(o * 8);

		int k = generator.nextInt(16);
		int r = generatorFront.nextInt(16);
		int s = generatorLeft.nextInt(16);
		int t = generator2.nextInt(7);
		int u = generator2.nextInt(3);

		if (s == 3 || s == 6 || s == 7 || s == 9 || s == 10 || s == 11 || s == 12 || s == 15) {
			switch (t) {
			case 0:
				k = 4;
				break;
			case 1:
				k = 5;
				break;
			case 2:
				k = 8;
				break;
			case 3:
				k = 9;
				break;
			case 4:
				k = 11;
				break;
			case 5:
				k = 12;
				break;
			case 6:
				k = 15;
				break;
			}
		}

		if (r == 2 || r == 5 || r == 6 || r == 8 || r == 9 || r == 10 || r == 13 || r == 15) {
			switch (u) {
			case 0:
				k = 9;
				break;
			case 1:
				k = 11;
				break;
			case 2:
				k = 12;
				break;
			case 3:
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
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
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
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 4:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 5:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 6:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 7:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 8:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Magenta, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 9:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 10:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Yellow, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 11:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 12:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			break;
		case 13:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 14:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Orange, rand);
			break;
		case 15:
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), Blue, rand);
			generateSlice(world, mutableBlockPos.move(Direction.WEST), White, rand);
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
						world.setBlockState(currentPosition, FLOOR, 2);
						if (rand.nextDouble() < 0.01) {
							if (rand.nextDouble() < BackroomsConfig.getInstance().ChestSpawnChance) {
								world.setBlockState(currentPosition.add(0, 1, 0), CHEST, 2);
								LootableContainerBlockEntity.setLootTable(world, rand, currentPosition.add(0, 1, 0),
										Backrooms.LEVEL3CHEST);
							}
						}
						break;
					case 3:
						world.setBlockState(currentPosition, WALL, 2);
						break;
					case 4:
						world.setBlockState(currentPosition, BRICKS, 2);
						break;
					case 5:
						world.setBlockState(currentPosition, PIPE, 2);
						break;
					case 6:
						world.setBlockState(currentPosition, CEILING, 3);
						break;
					case 7:
						world.setBlockState(currentPosition, FLOOR, 2);
						if (rand.nextDouble() < BackroomsConfig.getInstance().VBDoor) {
							if (rand.nextDouble() < 0.05) {
								world.setBlockState(currentPosition.add(0, 1, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 2, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 3, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 4, 0), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 1, 1), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 2, 1), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 3, 1), VOID_BLOCK, 2);
								world.setBlockState(currentPosition.add(0, 4, 1), VOID_BLOCK, 2);
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