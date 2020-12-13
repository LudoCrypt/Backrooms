package net.ludocrypt.backrooms.world.features.rooms;

import java.util.Random;

import net.ludocrypt.backrooms.blocks.LightBlock;
import net.ludocrypt.backrooms.blocks.TileBlock;
import net.ludocrypt.backrooms.blocks.TornWallpaperBlock;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.ludocrypt.backrooms.world.features.config.RoomConfig;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

public class Level0Room extends Feature<RoomConfig> {

	public Level0Room() {
		super(RoomConfig.CODEC);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, RoomConfig config) {
		BlockPos.Mutable mutableBlockPos = pos.mutableCopy();

		int layout = random.nextInt(54);

		Random rand = new Random(MathHelper.hashCode(pos.getX(), pos.getY(), 0) ^ world.getSeed());

		boolean populateDoors = true;
		boolean tryStaircases = true;

		int rint = rand.nextInt(70);

		if (rint == 69) {
			layout = rand.nextInt(54);
			populateDoors = rand.nextBoolean();
			tryStaircases = false;
		} else if (rint == 50) {
			layout = 55;
			populateDoors = false;
			tryStaircases = false;
		} else if (rint == 24) {
			layout = 57;
			populateDoors = false;
			tryStaircases = true;
		}

		// Cement
		generateTopSlice(world, mutableBlockPos, LayoutRooms.singleInt(3), random, config);
		// Tile
		generateRoof(world, mutableBlockPos.move(Direction.DOWN), random, config);
		// wall Edges
		for (int i = 0; i < config.height; i++) {
			generateTopSlice(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.getFromInt(layout), random, config);
		}
		// Carpet
		generateTopSlice(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.singleInt(2), random, config);

		// Cement
		generateTopSlice(world, mutableBlockPos.move(Direction.DOWN), LayoutRooms.singleInt(3), random, config);

		if (tryStaircases) {
			if (config.has_stairs) {
				if (random.nextDouble() < config.stair_chance / 10) {
					// Move to staircase
					mutableBlockPos = mutableBlockPos.move(Direction.UP).west(4).up(9).mutableCopy();

					// Stairs
					generateSideSlice(world, mutableBlockPos.move(Direction.WEST), LayoutRooms.staircaseEdge, random, config);
					generateSideSlice(world, mutableBlockPos.move(Direction.WEST), LayoutRooms.staircaseMiddle, random, config);
					generateSideSlice(world, mutableBlockPos.move(Direction.WEST), LayoutRooms.staircaseMiddle, random, config);
					generateSideSlice(world, mutableBlockPos.move(Direction.WEST), LayoutRooms.staircaseMiddle, random, config);
					generateSideSlice(world, mutableBlockPos.move(Direction.WEST), LayoutRooms.staircaseMiddle, random, config);
					generateSideSlice(world, mutableBlockPos.move(Direction.WEST), LayoutRooms.staircaseEdge, random, config);

					// Move Back
					mutableBlockPos = mutableBlockPos.move(Direction.DOWN).east(10).down(9).mutableCopy();
				}
			}
		}

		// Doors
		if (populateDoors) {
			populateDoors(world, mutableBlockPos.up(2).mutableCopy(), random, config);
		}

		return true;
	}

	protected void generateTopSlice(ServerWorldAccess world, BlockPos.Mutable centerPos, int[][] slice, Random rand, RoomConfig config) {

		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(), centerPos.getZ());

		for (int x = 0; x < slice.length; x++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[x][z];

				if (world.getBlockState(currentPosition).isOf(BackroomsBlocks.WALL) || world.getBlockState(currentPosition).isOf(BackroomsBlocks.VENT)) {
					if (sliceBlock == 0) {
						if (rand.nextDouble() < config.torn_chance / 10) {
							if (rand.nextDouble() < config.tall_torn_chance) {
								if (config.torn_wall.getBlock() instanceof TornWallpaperBlock) {
									int height = rand.nextInt(3) + 1;
									if (world.getBlockState(currentPosition.up(height)).isOf(config.wall.getBlock())) {
										switch (height) {
										case 1:
											world.setBlockState(currentPosition, rand.nextBoolean() ? config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER) : config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
											break;
										case 2:
											world.setBlockState(currentPosition, config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER), 2);
											world.setBlockState(currentPosition.up(), config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
											break;
										case 3:
											world.setBlockState(currentPosition, config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER), 2);
											world.setBlockState(currentPosition.up(), Blocks.OAK_PLANKS.getDefaultState(), 2);
											world.setBlockState(currentPosition.up().up(), config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
											break;
										}
									} else {
										world.setBlockState(currentPosition, rand.nextBoolean() ? config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER) : config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
									}
								} else {
									world.setBlockState(currentPosition, config.torn_wall, 2);
								}
							} else {
								world.setBlockState(currentPosition, config.torn_wall, 2);
							}
						} else {
							world.setBlockState(currentPosition, config.wall, 2);
						}
					}
				}
				if (world.getBlockState(currentPosition).isOf(BackroomsBlocks.WALL)) {
					if (sliceBlock == 1) {
						world.setBlockState(currentPosition, Blocks.AIR.getDefaultState(), 2);
					} else if (sliceBlock == 2) {
						if (rand.nextDouble() < config.mold_chance / 10) {
							world.setBlockState(currentPosition, config.moldy_floor, 2);
						} else {
							world.setBlockState(currentPosition, config.floor, 2);
						}
					} else if (sliceBlock == 3) {
						world.setBlockState(currentPosition, BackroomsBlocks.CEMENT.getDefaultState(), 2);
					}
				} else if (world.getBlockState(currentPosition).isOf(BackroomsBlocks.VOID_BLOCK)) {
					world.setBlockState(currentPosition, Blocks.AIR.getDefaultState(), 2);
				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(-1, 0, -slice[0].length);
		}

	}

	protected void generateSideSlice(ServerWorldAccess world, BlockPos.Mutable centerPos, int[][] slice, Random rand, RoomConfig config) {

		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(), centerPos.getZ());

		for (int x = 0; x < slice.length; x++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[x][z];

				if (sliceBlock == 0) {
					if (rand.nextDouble() < config.mold_chance / 10) {
						world.setBlockState(currentPosition, config.moldy_floor, 2);
					} else {
						world.setBlockState(currentPosition, config.floor, 2);
					}
				} else if (sliceBlock == 1) {
					if (rand.nextDouble() < config.torn_chance / 10) {
						if (rand.nextDouble() < config.tall_torn_chance) {
							if (config.torn_wall.getBlock() instanceof TornWallpaperBlock) {
								int height = rand.nextInt(3) + 1;
								if (world.getBlockState(currentPosition.up(height)).isOf(config.wall.getBlock())) {
									switch (height) {
									case 1:
										world.setBlockState(currentPosition, rand.nextBoolean() ? config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER) : config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
										break;
									case 2:
										world.setBlockState(currentPosition, config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER), 2);
										world.setBlockState(currentPosition.up(), config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
										break;
									case 3:
										world.setBlockState(currentPosition, config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER), 2);
										world.setBlockState(currentPosition.up(), Blocks.OAK_PLANKS.getDefaultState(), 2);
										world.setBlockState(currentPosition.up().up(), config.torn_wall.with(TornWallpaperBlock.VERY_TORN, true).with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
										break;
									}
								} else {
									world.setBlockState(currentPosition, rand.nextBoolean() ? config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.LOWER) : config.torn_wall.with(TornWallpaperBlock.HALF, DoubleBlockHalf.UPPER), 2);
								}
							} else {
								world.setBlockState(currentPosition, config.torn_wall, 2);
							}
						} else {
							world.setBlockState(currentPosition, config.torn_wall, 2);
						}
					} else {
						world.setBlockState(currentPosition, config.wall, 2);
					}
				} else if (sliceBlock == 2) {
					world.setBlockState(currentPosition, Blocks.AIR.getDefaultState(), 2);
					if (world.getBlockState(currentPosition.up()).isOf(BackroomsBlocks.WALL)) {
						world.setBlockState(currentPosition.up(), BackroomsBlocks.VOID_BLOCK.getDefaultState(), 2);
					}
				} else if (sliceBlock == 3) {
					world.setBlockState(currentPosition, BackroomsBlocks.CEMENT.getDefaultState(), 2);
				} else if (sliceBlock == 4) {
					world.setBlockState(currentPosition, config.stairs, 2);
					if (world.getBlockState(currentPosition.up()).isOf(BackroomsBlocks.WALL)) {
						world.setBlockState(currentPosition.up(), BackroomsBlocks.VOID_BLOCK.getDefaultState(), 2);
					}
				} else if (sliceBlock == 5) {
					if (rand.nextDouble() < config.light_chance) {
						world.setBlockState(currentPosition, BackroomsBlocks.LIGHT.getDefaultState().with(LightBlock.FORCED, true).with(Properties.LIT, true), 2);
					} else {
						world.setBlockState(currentPosition, BackroomsBlocks.TILE.getDefaultState(), 2);
					}
				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(0, -1, -slice[0].length);
		}
	}

	protected void generateRoof(ServerWorldAccess world, BlockPos.Mutable centerPos, Random rand, RoomConfig config) {
		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(), centerPos.getZ());
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {

				if (world.getBlockState(currentPosition).isOf(BackroomsBlocks.WALL)) {
					if (x % 2 == 0) {
						if (rand.nextDouble() < config.light_chance) {
							if (rand.nextDouble() < config.light_off_chance) {
								world.setBlockState(currentPosition, BackroomsBlocks.LIGHT.getDefaultState().with(LightBlock.FORCED, true).with(Properties.LIT, false), 2);
								world.setBlockState(currentPosition.east(), BackroomsBlocks.LIGHT.getDefaultState().with(LightBlock.FORCED, true).with(Properties.LIT, false), 2);
							} else {
								world.setBlockState(currentPosition, BackroomsBlocks.LIGHT.getDefaultState().with(LightBlock.FORCED, true).with(Properties.LIT, true), 2);
								world.setBlockState(currentPosition.east(), BackroomsBlocks.LIGHT.getDefaultState().with(LightBlock.FORCED, true).with(Properties.LIT, true), 2);
							}
						} else {
							world.setBlockState(currentPosition, BackroomsBlocks.TILE.getDefaultState().with(TileBlock.FACING, Direction.EAST), 2);
							if (rand.nextDouble() < 0.01) {
								world.setBlockState(currentPosition.down(), BackroomsBlocks.VENT.getDefaultState(), 2);
							}
						}
					} else {
						world.setBlockState(currentPosition, BackroomsBlocks.TILE.getDefaultState().with(TileBlock.FACING, Direction.WEST), 2);
						if (rand.nextDouble() < 0.01) {
							world.setBlockState(currentPosition.down(), BackroomsBlocks.VENT.getDefaultState(), 2);
						}
					}

				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(-1, 0, -16);
		}
	}

	protected void populateDoors(ServerWorldAccess world, BlockPos.Mutable centerPos, Random rand, RoomConfig config) {
		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(), centerPos.getZ());
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				if (world.getBlockState(currentPosition).isOf(config.wall.getBlock())) {
					if (rand.nextDouble() < config.door_chance) {
						for (int u = 0; u < 4; u++) {
							for (int n = 0; n < 2; n++) {
								for (int e = 0; e < 2; e++) {
									Block block = world.getBlockState(currentPosition.up(u).north(n).east(e)).getBlock();
									if (block != config.stairs.getBlock() || block != config.floor.getBlock() || block != config.moldy_floor.getBlock()) {
										world.setBlockState(currentPosition.up(u).north(n).east(e), Blocks.AIR.getDefaultState(), 2);
									}
								}
							}
						}
					}
				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(-1, 0, -16);
		}
	}
}
