package net.ludocrypt.backrooms.features.rooms.specifics;

import java.util.Random;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.features.config.RoomConfig;
import net.ludocrypt.backrooms.features.rooms.LayoutRooms;
import net.ludocrypt.backrooms.features.rooms.Level0Room;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class Level1RoomSpecific extends Level0Room {

	public Level1RoomSpecific() {
		super();
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, RoomConfig config) {

		if (random.nextDouble() < 0.05) {
			BlockPos.Mutable mutableBlockPos = pos.mutableCopy();

			int layout = random.nextInt(54);

			// Cement
			generateTopSlice(world, mutableBlockPos, LayoutRooms.singleInt(3), random, config);

			// Tile
			generateRoof(world, mutableBlockPos.move(Direction.DOWN), random, config);

			// Walls and such
			for (int i = 0; i < config.height; i++) {
				generateTopSlice(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.getFromInt(layout), random, config);
			}

			// Floor
			int grid = random.nextInt(3);
			if (grid == 0) {
				floorOverride(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.grid1x, random, config);
			} else if (grid == 1) {
				floorOverride(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.grid2x, random, config);
			} else if (grid == 2) {
				floorOverride(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.grid3x, random, config);
			}
			generateTopSlice(world, mutableBlockPos, LayoutRooms.singleInt(2), random, config);

			// Cement
			generateTopSlice(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.singleInt(3), random, config);

		} else {
			super.generate(world, chunkGenerator, random, pos, config);
		}
		return true;
	}

	protected void floorOverride(ServerWorldAccess world, BlockPos.Mutable centerPos, int[][] slice, Random rand, RoomConfig config) {

		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(), centerPos.getZ());

		for (int x = 0; x < slice.length; x++) {
			for (int z = 0; z < slice[x].length; z++) {
				int sliceBlock = slice[x][z];

				if (world.getBlockState(currentPosition).isOf(BackroomsBlocks.WALL)) {
					if (world.isAir(currentPosition.up())) {
						if (sliceBlock == 1) {
							for (int i = 1; i < 5; i++) {
								if (rand.nextDouble() < config.mold_chance / 10) {
									world.setBlockState(currentPosition.up(i), config.moldy_floor, 2);
								} else {
									world.setBlockState(currentPosition.up(i), config.floor, 2);
								}
							}
						} else if (rand.nextDouble() < 0.02) {
							if (rand.nextDouble() < BackroomsConfig.INSTANCE().Level1ChestSpawnChance) {
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
								LootableContainerBlockEntity.setLootTable(world, rand, currentPosition.up(), Backrooms.id("chests/level_1_chest"));
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
