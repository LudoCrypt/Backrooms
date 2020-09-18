package net.ludocrypt.backrooms.features;

import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.annotation.Nullable;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Light;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.blocks.TornWallpaper;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;

public class RoomArchives {

	public static boolean door1 = true;
	public static boolean door2 = true;
	public static boolean door3 = true;
	public static boolean door4 = true;

	public static int[][] One = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 6, 5, 6, 5, 6, 6, 6, 6, 5, 6, 5, 6, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	public static int[][] Two = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	public static int[][] Three = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 3, 3, 2, 11, 12, 3, 3, 12, 2, 11, 3, 3, 2, 11 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	public static int[][] Four = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 9, 5, 9, 5, 9, 9, 9, 9, 5, 9, 5, 9, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	public static int[][] Stair1Light = { { 0, 0, 0, 0, 0, 10, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 1, 10, 4, 4, 4, 4, 4, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 1, 1, 10, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 5, 5, 5, 5, 1, 1, 1, 10, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 10, 4, 4, 4, 4, 4, 5 }, { 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 10, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	public static int[][] Stair1NoLight = { { 0, 0, 0, 0, 0, 10, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0 },
			{ 2, 11, 3, 3, 2, 1, 10, 4, 4, 4, 4, 4, 3, 3, 2, 11 }, { 5, 5, 5, 5, 5, 1, 1, 10, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 10, 4, 4, 4, 4, 4, 4, 5 }, { 5, 5, 5, 5, 5, 1, 1, 1, 1, 10, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 10, 4, 4, 4, 4, 8 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	public static int[][] StairWall = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 8, 8, 8, 8, 8, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	private static final BlockState SOUTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.SOUTH)
			.with(Tile.SINGLE, false);
	private static final BlockState NORTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.NORTH)
			.with(Tile.SINGLE, false);
	private static final BlockState TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.EAST)
			.with(Tile.SINGLE, true);
	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState CHEST = Blocks.CHEST.getDefaultState().with(ChestBlock.CHEST_TYPE, ChestType.SINGLE)
			.with(ChestBlock.FACING, Direction.NORTH).with(ChestBlock.WATERLOGGED, false);
	private static final BlockState VOID_BLOCK = Backrooms.VOID_BLOCK.getDefaultState();
	private static final BlockState VENT = Backrooms.VENT.getDefaultState();

	public static void generateSlice(ServerWorldAccess world, BlockPos.Mutable centerPos, int[][] slice, Random rand,
			Block wallpaper, @Nullable Block tornWallpaper, BlockState stair, Block floor,
			@Nullable BlockState floorAlternative, boolean lightsOn) {

		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1 - 16, centerPos.getY(),
				centerPos.getZ());
		BlockState WALLPAPER = wallpaper.getDefaultState();
		BlockState TORN_WALLPAPER_1;
		BlockState TORN_WALLPAPER_2;
		BlockState TORN_WALLPAPER_3;
		BlockState TORN_WALLPAPER_4;
		if (tornWallpaper != null) {
			TORN_WALLPAPER_1 = tornWallpaper.getDefaultState().with(TornWallpaper.TORN_LEVEL, 1);
			TORN_WALLPAPER_2 = tornWallpaper.getDefaultState().with(TornWallpaper.TORN_LEVEL, 2);
			TORN_WALLPAPER_3 = tornWallpaper.getDefaultState().with(TornWallpaper.TORN_LEVEL, 3);
			TORN_WALLPAPER_4 = tornWallpaper.getDefaultState().with(TornWallpaper.TORN_LEVEL, 4);
		} else {
			TORN_WALLPAPER_1 = wallpaper.getDefaultState();
			TORN_WALLPAPER_2 = wallpaper.getDefaultState();
			TORN_WALLPAPER_3 = wallpaper.getDefaultState();
			TORN_WALLPAPER_4 = wallpaper.getDefaultState();
		}
		BlockState STAIRS = stair;
		BlockState CARPET = floor.getDefaultState();
		BlockState MOLDY_CARPET;
		if (floorAlternative != null) {
			MOLDY_CARPET = floorAlternative;
		} else {
			MOLDY_CARPET = floor.getDefaultState();
		}
		BlockState LIGHT;
		if (lightsOn) {
			LIGHT = Backrooms.LIGHT.getDefaultState();
		} else {
			LIGHT = Backrooms.LIGHT.getDefaultState().with(Light.ON, false);
		}

		for (int y = 0; y < slice.length; y++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[y][z];

				if (((world.getBlockState(currentPosition).getBlock() == Backrooms.WALL)
						|| (world.getBlockState(currentPosition).getBlock() == Blocks.BEDROCK))
						&& (world.getBlockState(currentPosition).getBlock() != Backrooms.CARPET_STAIRS)) {

					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						RoomArchives.door1 = true;
					} else {
						RoomArchives.door1 = false;
					}
					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						RoomArchives.door2 = true;
					} else {
						RoomArchives.door2 = false;
					}
					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						RoomArchives.door3 = true;
					} else {
						RoomArchives.door3 = false;
					}
					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						RoomArchives.door4 = true;
					} else {
						RoomArchives.door4 = false;
					}

					switch (sliceBlock) {
					case 0:
						break;
					case 2:
						world.setBlockState(currentPosition, SOUTH_TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 11:
						world.setBlockState(currentPosition, NORTH_TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 12:
						world.setBlockState(currentPosition, TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 3:
						world.setBlockState(currentPosition, LIGHT, 2);
						break;
					case 4:
						world.setBlockState(currentPosition, AIR, 2);
						break;
					case 5:
						if (rand.nextDouble() < 0.005) {
							int k = rand.nextInt(4);
							switch (k) {
							case 0:
								world.setBlockState(currentPosition, TORN_WALLPAPER_1, 2);
								break;
							case 1:
								world.setBlockState(currentPosition, TORN_WALLPAPER_2, 2);
								break;
							case 2:
								world.setBlockState(currentPosition, TORN_WALLPAPER_3, 2);
								break;
							case 3:
								world.setBlockState(currentPosition, TORN_WALLPAPER_4, 2);
								break;
							}
						} else {
							world.setBlockState(currentPosition, WALLPAPER, 2);
						}
						break;
					case 6:
						if (door1) {
							world.setBlockState(currentPosition, AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 0, -1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, -1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, -1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 0, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 0, -1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 1, -1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 2, -1), AIR, 2);
							if (BackroomsConfig.getInstance().TallDoors) {
								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(0, 3, -1), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, -1), AIR, 2);
							}
						} else {
							world.setBlockState(currentPosition, WALLPAPER, 2);
						}
						break;
					case 7:
						if (door2) {
							world.setBlockState(currentPosition, AIR, 3);
							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 3);
							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 3);
							world.setBlockState(currentPosition.add(-1, 1, 0), AIR, 3);
							world.setBlockState(currentPosition.add(-1, 2, 0), AIR, 3);
							world.setBlockState(currentPosition.add(0, 0, -1), AIR, 3);
							world.setBlockState(currentPosition.add(0, 1, -1), AIR, 3);
							world.setBlockState(currentPosition.add(0, 2, -1), AIR, 3);
							world.setBlockState(currentPosition.add(-1, 0, -1), AIR, 3);
							world.setBlockState(currentPosition.add(-1, 1, -1), AIR, 3);
							world.setBlockState(currentPosition.add(-1, 2, -1), AIR, 3);
							if (BackroomsConfig.getInstance().TallDoors) {
								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(0, 3, -1), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, -1), AIR, 2);
							}
							if (rand.nextDouble() < BackroomsConfig.getInstance().VBDoor) {
								world.setBlockState(currentPosition, VOID_BLOCK, 3);
								world.setBlockState(currentPosition.add(0, 1, 0), VOID_BLOCK, 3);
								world.setBlockState(currentPosition.add(0, 2, 0), VOID_BLOCK, 3);
								world.setBlockState(currentPosition.add(-1, 0, 0), VOID_BLOCK, 3);
								world.setBlockState(currentPosition.add(-1, 1, 0), VOID_BLOCK, 3);
								world.setBlockState(currentPosition.add(-1, 2, 0), VOID_BLOCK, 3);
								if (BackroomsConfig.getInstance().TallDoors) {
									world.setBlockState(currentPosition.add(0, 3, 0), VOID_BLOCK, 2);
									world.setBlockState(currentPosition.add(-1, 3, 0), VOID_BLOCK, 2);
								}
							} else {
								world.setBlockState(currentPosition.add(-1, 0, 0), AIR, 3);
							}

						} else {
							world.setBlockState(currentPosition, WALLPAPER, 2);
						}
						break;
					case 8:
						if (door3) {
							world.setBlockState(currentPosition, AIR, 3);
							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 0, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 0, 1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, 1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, 1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 0, 1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 1, 1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 2, 1), AIR, 2);
							if (BackroomsConfig.getInstance().TallDoors) {
								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(0, 3, 1), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, 1), AIR, 2);
							}
						} else {
							world.setBlockState(currentPosition, WALLPAPER, 2);
						}
						break;
					case 9:
						if (door4) {
							world.setBlockState(currentPosition, AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 0, -1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, -1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, -1), AIR, 2);
							world.setBlockState(currentPosition.add(1, 0, 0), AIR, 2);
							world.setBlockState(currentPosition.add(1, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(1, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(1, 0, -1), AIR, 2);
							world.setBlockState(currentPosition.add(1, 1, -1), AIR, 2);
							world.setBlockState(currentPosition.add(1, 2, -1), AIR, 2);
							if (BackroomsConfig.getInstance().TallDoors) {
								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(0, 3, -1), AIR, 2);
								world.setBlockState(currentPosition.add(1, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(1, 3, -1), AIR, 2);
							}
						} else {
							world.setBlockState(currentPosition, WALLPAPER, 2);
						}
						break;
					case 10:
						world.setBlockState(currentPosition, STAIRS, 2);
						break;
					case 1:
						if (rand.nextDouble() < 0.01) {
							world.setBlockState(currentPosition, MOLDY_CARPET, 2);
						} else {
							world.setBlockState(currentPosition, CARPET, 2);
						}

						if (rand.nextDouble() < 0.001) {
							if (rand.nextDouble() < BackroomsConfig.getInstance().ChestSpawnChance) {
								world.setBlockState(currentPosition.add(0, 1, 0), CHEST, 2);
								LootableContainerBlockEntity.setLootTable(world, rand, currentPosition.add(0, 1, 0),
										Backrooms.LEVEL0CHEST);
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
