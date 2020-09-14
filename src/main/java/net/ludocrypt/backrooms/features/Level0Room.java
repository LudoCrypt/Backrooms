package net.ludocrypt.backrooms.features;

import java.util.List;
import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.BackroomsStairs;
import net.ludocrypt.backrooms.blocks.Carpet;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.blocks.TornWallpaper;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.imagereader.Layout;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.ChestType;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level0Room extends Feature<DefaultFeatureConfig> {
	public Level0Room(Codec<DefaultFeatureConfig> configFactory) {
		super(configFactory);
	}

	public static boolean door1 = true;
	public static boolean door2 = true;
	public static boolean door3 = true;
	public static boolean door4 = true;

	private static final BlockState WALLPAPER = Backrooms.WALLPAPER.getDefaultState();
	private static final BlockState CARPET = Backrooms.CARPET.getDefaultState();
	private static final BlockState CARPET_STAIRS = Backrooms.CARPET_STAIRS.getDefaultState()
			.with(BackroomsStairs.FACING, Direction.NORTH).with(BackroomsStairs.HALF, BlockHalf.BOTTOM)
			.with(BackroomsStairs.SHAPE, StairShape.STRAIGHT);
	private static final BlockState MOLDY_CARPET = Backrooms.CARPET.getDefaultState().with(Carpet.MOLDY, true);
	private static final BlockState SOUTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.SOUTH)
			.with(Tile.SINGLE, false);
	private static final BlockState NORTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.NORTH)
			.with(Tile.SINGLE, false);
	private static final BlockState TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.EAST)
			.with(Tile.SINGLE, true);
	private static final BlockState LIGHT = Backrooms.LIGHT.getDefaultState();
	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState CHEST = Blocks.CHEST.getDefaultState().with(ChestBlock.CHEST_TYPE, ChestType.SINGLE)
			.with(ChestBlock.FACING, Direction.NORTH).with(ChestBlock.WATERLOGGED, false);
	private static final BlockState VOID_BLOCK = Backrooms.VOID_BLOCK.getDefaultState();
	private static final BlockState TORN_WALLPAPER_1 = Backrooms.TORN_WALLPAPER.getDefaultState()
			.with(TornWallpaper.TORN_LEVEL, 1);
	private static final BlockState TORN_WALLPAPER_2 = Backrooms.TORN_WALLPAPER.getDefaultState()
			.with(TornWallpaper.TORN_LEVEL, 2);
	private static final BlockState TORN_WALLPAPER_3 = Backrooms.TORN_WALLPAPER.getDefaultState()
			.with(TornWallpaper.TORN_LEVEL, 3);
	private static final BlockState TORN_WALLPAPER_4 = Backrooms.TORN_WALLPAPER.getDefaultState()
			.with(TornWallpaper.TORN_LEVEL, 4);
	private static final BlockState VENT = Backrooms.VENT.getDefaultState();

//	private static Integer[][] WallsTop = Layout.getLayout("level0_1", 5, 0);
//	private static Integer[][] WallsBottom = Layout.getLayout("level0_1", 4, 0);
//	private static List<Integer[][]> LayoutsTop = Layout.listLayouts(32, "level0", 10, 0, 1, 2, 3, 4, 5, 6, 7, 8);
//	private static List<Integer[][]> LayoutsBottom = Layout.listLayouts(32, "level0", 9, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//	private static Integer[][] layoutTest = Layout.getLayout("level0test", 10, 0, 1, 2, 3, 4, 5, 6, 7, 8);
//	private static Integer[][] layoutTestBottom = Layout.getLayout("level0test", 9, 0, 1, 2, 3, 4, 5, 6, 7, 8);

	private static List<Integer[][]> LayoutsTop = Layout.listLayouts(4, "level0", 10, 0, 1, 2, 3, 4, 5, 6, 7, 8);
	private static List<Integer[][]> LayoutsBottom = Layout.listLayouts(4, "level0", 9, 0, 1, 2, 3, 4, 5, 6, 7, 8);

	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random rand, BlockPos position,
			DefaultFeatureConfig featureConfig) {
		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable().set(position);
		boolean red;
		boolean red2;
		boolean green;
		boolean green2;
		boolean blue;
		boolean blue2;
		boolean purple;
		boolean purple2;
		red = rand.nextBoolean();
		red2 = rand.nextBoolean();
		green = rand.nextBoolean();
		green2 = rand.nextBoolean();
		blue = rand.nextBoolean();
		blue2 = rand.nextBoolean();
		purple = rand.nextBoolean();
		purple2 = rand.nextBoolean();
		int layoutInt;

		if (rand.nextDouble() < 0.7) {
			layoutInt = 0;
		} else if (rand.nextDouble() < 0.8) {
			if (rand.nextDouble() < 0.5) {
				layoutInt = 1;
			} else {
				layoutInt = 2;
			}
		} else if (rand.nextDouble() < 0.5) {
			if (rand.nextDouble() < 0.5) {
				layoutInt = 3;
			} else {
				layoutInt = 4;
			}
		} else {
			layoutInt = 0;
		}

		Integer[][] layoutTop = LayoutsTop.get(layoutInt);
		Integer[][] layoutBottom = LayoutsBottom.get(layoutInt);

		generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutTop, rand, red, red2, green, green2, blue,
				blue2, purple, purple2);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutTop, rand, red, red2, green, green2, blue,
				blue2, purple, purple2);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutTop, rand, red, red2, green, green2, blue,
				blue2, purple, purple2);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutBottom, rand, red, red2, green, green2, blue,
				blue2, purple, purple2);

//		generateSlice(world, mutableBlockPos.move(Direction.DOWN), WallsTop, rand, red, green, blue);
//		generateSlice(world, mutableBlockPos.move(Direction.DOWN), WallsTop, rand, red, green, blue);
//		generateSlice(world, mutableBlockPos.move(Direction.DOWN), WallsTop, rand, red, green, blue);
//		generateSlice(world, mutableBlockPos.move(Direction.DOWN), WallsTop, rand, red, green, blue);

//		if (generator.nextDouble() < 0.7) {
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
//		} else if (generator.nextDouble() < 0.8) {
//			if (generator.nextDouble() < 0.5) {
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Wall1, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Wall2, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
//			} else {
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
//				generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
//			}
//		} else if (generator.nextDouble() < 0.5) {
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), StairWall, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1NoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1Light, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1Light, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1NoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), StairWall, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
//		} else {
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
//		}

		return true;

	}

	private void generateSlice(ServerWorldAccess world, BlockPos.Mutable centerPos, Integer[][] slice, Random rand,
			boolean red, boolean red2, boolean green, boolean green2, boolean blue, boolean blue2, boolean purple,
			boolean purple2) {

//		BlockPos currentPositionOffsetted = new BlockPos(centerPos.add(-1, 3, slice[0].length));
		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(),
				centerPos.getZ());

		for (int x = 0; x < slice.length; x++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[x][z];

				if (((world.getBlockState(currentPosition).getBlock() == Backrooms.WALL)
						|| (world.getBlockState(currentPosition).getBlock() == Blocks.BEDROCK))
						&& (world.getBlockState(currentPosition).getBlock() != Backrooms.CARPET_STAIRS)) {

//					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
//						Level0Room.door1 = rand.nextBoolean();
//					}
					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0Room.door1 = true;
					} else {
						Level0Room.door1 = false;
					}
//					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
//						Level0Room.door2 = true;
//					} else {
//						Level0Room.door2 = false;
//					}
//					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
//						Level0Room.door3 = true;
//					} else {
//						Level0Room.door3 = false;
//					}
//					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
//						Level0Room.door4 = true;
//					} else {
//						Level0Room.door4 = false;
//					}

					switch (sliceBlock) {

					case 0:
						world.setBlockState(currentPosition, AIR, 2);
						break;
					case 1:
						if (red) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;
					case 2:
						if (red2) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;
					case 3:
						if (green) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;
					case 4:
						if (green2) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;
					case 5:
						if (blue) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;
					case 6:
						if (blue2) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;
					case 7:
						if (purple) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;
					case 8:
						if (purple2) {
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
						} else {
							world.setBlockState(currentPosition, AIR, 2);
						}
						break;

					case 9:
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
							world.setBlockState(currentPosition.add(0, 0, 1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, 1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, 1), AIR, 2);
							world.setBlockState(currentPosition.add(1, 0, 0), AIR, 2);
							world.setBlockState(currentPosition.add(1, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(1, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(1, 0, 1), AIR, 2);
							world.setBlockState(currentPosition.add(1, 1, 1), AIR, 2);
							world.setBlockState(currentPosition.add(1, 2, 1), AIR, 2);
							if (BackroomsConfig.getInstance().TallDoors) {
								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(0, 3, -1), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(-1, 3, -1), AIR, 2);
								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(0, 3, 1), AIR, 2);
								world.setBlockState(currentPosition.add(1, 3, 0), AIR, 2);
								world.setBlockState(currentPosition.add(1, 3, 1), AIR, 2);
							}
						} else {
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
						}
						break;
					case 10:
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

//					case 0:
//						break;
//					case 2:
//						world.setBlockState(currentPosition, SOUTH_TILE, 2);
//						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
//							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
//						}
//						break;
//					case 11:
//						world.setBlockState(currentPosition, NORTH_TILE, 2);
//						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
//							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
//						}
//						break;
//					case 12:
//						world.setBlockState(currentPosition, TILE, 2);
//						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
//							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
//						}
//						break;
//					case 3:
//						world.setBlockState(currentPosition, LIGHT, 2);
//						break;
//					case 4:
//						world.setBlockState(currentPosition, AIR, 2);
//						break;
//					case 5:
//						if (rand.nextDouble() < 0.005) {
//							int k = rand.nextInt(4);
//							switch (k) {
//							case 0:
//								world.setBlockState(currentPosition, TORN_WALLPAPER_1, 2);
//								break;
//							case 1:
//								world.setBlockState(currentPosition, TORN_WALLPAPER_2, 2);
//								break;
//							case 2:
//								world.setBlockState(currentPosition, TORN_WALLPAPER_3, 2);
//								break;
//							case 3:
//								world.setBlockState(currentPosition, TORN_WALLPAPER_4, 2);
//								break;
//							}
//						} else {
//							world.setBlockState(currentPosition, WALLPAPER, 2);
//						}
//						break;
//					case 6:
//						if (door1) {
//							world.setBlockState(currentPosition, AIR, 2);
//							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 0, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 1, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 2, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 0, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 1, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 2, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 0, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 1, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 2, -1), AIR, 2);
//							if (BackroomsConfig.getInstance().TallDoors) {
//								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(0, 3, -1), AIR, 2);
//								world.setBlockState(currentPosition.add(-1, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(-1, 3, -1), AIR, 2);
//							}
//						} else {
//							world.setBlockState(currentPosition, WALLPAPER, 2);
//						}
//						break;
//					case 7:
//						if (door2) {
//							world.setBlockState(currentPosition, AIR, 3);
//							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 3);
//							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 3);
//							world.setBlockState(currentPosition.add(-1, 1, 0), AIR, 3);
//							world.setBlockState(currentPosition.add(-1, 2, 0), AIR, 3);
//							world.setBlockState(currentPosition.add(0, 0, -1), AIR, 3);
//							world.setBlockState(currentPosition.add(0, 1, -1), AIR, 3);
//							world.setBlockState(currentPosition.add(0, 2, -1), AIR, 3);
//							world.setBlockState(currentPosition.add(-1, 0, -1), AIR, 3);
//							world.setBlockState(currentPosition.add(-1, 1, -1), AIR, 3);
//							world.setBlockState(currentPosition.add(-1, 2, -1), AIR, 3);
//							if (BackroomsConfig.getInstance().TallDoors) {
//								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(-1, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(0, 3, -1), AIR, 2);
//								world.setBlockState(currentPosition.add(-1, 3, -1), AIR, 2);
//							}
//							if (rand.nextDouble() < BackroomsConfig.getInstance().VBDoor) {
//								world.setBlockState(currentPosition, VOID_BLOCK, 3);
//								world.setBlockState(currentPosition.add(0, 1, 0), VOID_BLOCK, 3);
//								world.setBlockState(currentPosition.add(0, 2, 0), VOID_BLOCK, 3);
//								world.setBlockState(currentPosition.add(-1, 0, 0), VOID_BLOCK, 3);
//								world.setBlockState(currentPosition.add(-1, 1, 0), VOID_BLOCK, 3);
//								world.setBlockState(currentPosition.add(-1, 2, 0), VOID_BLOCK, 3);
//								if (BackroomsConfig.getInstance().TallDoors) {
//									world.setBlockState(currentPosition.add(0, 3, 0), VOID_BLOCK, 2);
//									world.setBlockState(currentPosition.add(-1, 3, 0), VOID_BLOCK, 2);
//								}
//							} else {
//								world.setBlockState(currentPosition.add(-1, 0, 0), AIR, 3);
//							}
//
//						} else {
//							world.setBlockState(currentPosition, WALLPAPER, 2);
//						}
//						break;
//					case 8:
//						if (door3) {
//							world.setBlockState(currentPosition, AIR, 3);
//							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 0, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 1, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 2, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 0, 1), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 1, 1), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 2, 1), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 0, 1), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 1, 1), AIR, 2);
//							world.setBlockState(currentPosition.add(-1, 2, 1), AIR, 2);
//							if (BackroomsConfig.getInstance().TallDoors) {
//								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(-1, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(0, 3, 1), AIR, 2);
//								world.setBlockState(currentPosition.add(-1, 3, 1), AIR, 2);
//							}
//						} else {
//							world.setBlockState(currentPosition, WALLPAPER, 2);
//						}
//						break;
//					case 9:
//						if (door4) {
//							world.setBlockState(currentPosition, AIR, 2);
//							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 0, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 1, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(0, 2, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(1, 0, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(1, 1, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(1, 2, 0), AIR, 2);
//							world.setBlockState(currentPosition.add(1, 0, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(1, 1, -1), AIR, 2);
//							world.setBlockState(currentPosition.add(1, 2, -1), AIR, 2);
//							if (BackroomsConfig.getInstance().TallDoors) {
//								world.setBlockState(currentPosition.add(0, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(0, 3, -1), AIR, 2);
//								world.setBlockState(currentPosition.add(1, 3, 0), AIR, 2);
//								world.setBlockState(currentPosition.add(1, 3, -1), AIR, 2);
//							}
//						} else {
//							world.setBlockState(currentPosition, WALLPAPER, 2);
//						}
//						break;
//					case 10:
//						world.setBlockState(currentPosition, CARPET_STAIRS, 2);
//						break;
//					case 1:
//						if (rand.nextDouble() < 0.01) {
//							world.setBlockState(currentPosition, MOLDY_CARPET, 2);
//						} else {
//							world.setBlockState(currentPosition, CARPET, 2);
//						}
//						if (rand.nextDouble() < 0.001) {
//							if (rand.nextDouble() < BackroomsConfig.getInstance().ChestSpawnChance) {
//								world.setBlockState(currentPosition.add(0, 1, 0), CHEST, 2);
//								LootableContainerBlockEntity.setLootTable(world, rand, currentPosition.add(0, 1, 0),
//										Backrooms.LEVEL0CHEST);
//							}
//						}
//						break;
					}
				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(-1, 0, -slice[0].length);
		}
	}
}