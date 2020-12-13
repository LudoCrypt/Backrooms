package net.ludocrypt.backrooms.world.features.rooms.specifics;

import java.util.Random;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.ludocrypt.backrooms.world.features.config.RoomConfig;
import net.ludocrypt.backrooms.world.features.rooms.LayoutRooms;
import net.ludocrypt.backrooms.world.features.rooms.Level0Room;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class Level0RoomSpecific extends Level0Room {

	public Level0RoomSpecific() {
		super();
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, RoomConfig config) {

		if (random.nextDouble() < 0.05) {
			BlockPos.Mutable mutableBlockPos = pos.mutableCopy();

			int layout = random.nextInt(54);

			Random rand = new Random(MathHelper.hashCode(pos.getX(), pos.getY(), 0) ^ world.getSeed());

			boolean populateDoors = true;

			int rint = rand.nextInt(70);

			if (rint == 69) {
				layout = rand.nextInt(54);
				populateDoors = rand.nextBoolean();
			} else if (rint == 50) {
				layout = 55;
				populateDoors = false;
			} else if (rint == 24) {
				layout = 57;
				populateDoors = false;
			}

			// Cement
			generateTopSlice(world, mutableBlockPos, LayoutRooms.singleInt(3), random, config);

			// Tile
			generateRoof(world, mutableBlockPos.move(Direction.DOWN), random, config);

			// Walls and such
			for (int i = 0; i < config.height; i++) {
				generateTopSlice(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.getFromInt(layout), random, config);
			}

			// Carpet
			carpetOverride(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.singleInt(0), random, config);
			generateTopSlice(world, mutableBlockPos, LayoutRooms.singleInt(2), random, config);

			// Cement
			generateTopSlice(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.singleInt(3), random, config);

			// Doors
			if (populateDoors) {
				populateDoors(world, mutableBlockPos.up(2).mutableCopy(), random, config);
			}

		} else {
			super.generate(world, chunkGenerator, random, pos, config);
		}
		return true;
	}

	protected void carpetOverride(ServerWorldAccess world, BlockPos.Mutable centerPos, int[][] slice, Random rand, RoomConfig config) {

		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(), centerPos.getZ());

		for (int x = 0; x < slice.length; x++) {
			for (int z = 0; z < slice[x].length; z++) {

				if (world.getBlockState(currentPosition).isOf(BackroomsBlocks.WALL)) {
					if (rand.nextBoolean()) {
						if (rand.nextDouble() < 0.02) {
							switch (rand.nextInt(3)) {
							case 0:
								if (world.isAir(currentPosition.up().north()) && world.isAir(currentPosition.up().south()) && world.isAir(currentPosition.up())) {
									world.setBlockState(currentPosition.up().north(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.NORTH), 2);
									world.setBlockState(currentPosition.up(), Blocks.OAK_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.WEST), 2);
									world.setBlockState(currentPosition.up().south(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.SOUTH), 2);
								}
								break;
							case 1:
								if (world.isAir(currentPosition.up().north()) && world.isAir(currentPosition.up().south()) && world.isAir(currentPosition.up())) {
									world.setBlockState(currentPosition.up().north(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.NORTH), 2);
									world.setBlockState(currentPosition.up(), Blocks.OAK_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.EAST), 2);
									world.setBlockState(currentPosition.up().south(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.SOUTH), 2);
								}
								break;
							case 2:
								if (world.isAir(currentPosition.up().east()) && world.isAir(currentPosition.up().west()) && world.isAir(currentPosition.up())) {
									world.setBlockState(currentPosition.up().east(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.EAST), 2);
									world.setBlockState(currentPosition.up(), Blocks.OAK_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.NORTH), 2);
									world.setBlockState(currentPosition.up().west(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.WEST), 2);
								}
								break;
							case 3:
								if (world.isAir(currentPosition.up().east()) && world.isAir(currentPosition.up().west()) && world.isAir(currentPosition.up())) {
									world.setBlockState(currentPosition.up().east(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.EAST), 2);
									world.setBlockState(currentPosition.up(), Blocks.OAK_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 2);
									world.setBlockState(currentPosition.up().west(), Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.WEST), 2);
								}
								break;
							}
						}
					} else {
						if (rand.nextDouble() < 0.1) {
							if (rand.nextDouble() < BackroomsConfig.INSTANCE().Level0ChestSpawnChance) {
								if (world.isAir(currentPosition.up())) {
									switch (rand.nextInt(3)) {
									case 0:
										world.setBlockState(currentPosition.up(), Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.NORTH), 2);
										break;
									case 1:
										world.setBlockState(currentPosition.up(), Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.EAST), 2);
										break;
									case 2:
										world.setBlockState(currentPosition.up(), Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH), 2);
										break;
									case 3:
										world.setBlockState(currentPosition.up(), Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.WEST), 2);
										break;
									}
									LootableContainerBlockEntity.setLootTable(world, rand, currentPosition.up(), Backrooms.id("chests/level_0_chest"));
								}
							}
						}
					}
				} else if (world.getBlockState(currentPosition).isOf(BackroomsBlocks.VOID_BLOCK)) {
					world.setBlockState(currentPosition, Blocks.AIR.getDefaultState(), 2);
				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(-1, 0, -slice[x].length);
		}
	}
}
