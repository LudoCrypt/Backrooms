package net.ludocrypt.backrooms.features;

import java.util.List;
import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.BackroomsStairs;
import net.ludocrypt.backrooms.blocks.Light;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.imagereader.Layout;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.ChestType;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level1OffRoom extends Feature<DefaultFeatureConfig> {
	public Level1OffRoom(Codec<DefaultFeatureConfig> configFactory) {
		super(configFactory);
	}

	private boolean door1 = true;

	private static final BlockState CEMENT = Backrooms.CEMENT.getDefaultState();
	private static final BlockState CEMENT_BRICKS = Backrooms.CEMENT_BRICKS.getDefaultState();
	private static final BlockState SOUTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.SOUTH)
			.with(Tile.SINGLE, false);
	private static final BlockState NORTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.NORTH)
			.with(Tile.SINGLE, false);
	private static final BlockState TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.EAST)
			.with(Tile.SINGLE, true);
	private static final BlockState LIGHT = Backrooms.LIGHT.getDefaultState().with(Light.ON, false);
	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState CHEST = Blocks.CHEST.getDefaultState().with(ChestBlock.CHEST_TYPE, ChestType.SINGLE)
			.with(ChestBlock.FACING, Direction.NORTH).with(ChestBlock.WATERLOGGED, false);
	private static final BlockState VOID_BLOCK = Backrooms.VOID_BLOCK.getDefaultState();
	private static final BlockState VENT = Backrooms.VENT.getDefaultState();
	private static final BlockState STAIR = Backrooms.CEMENT_STAIRS.getDefaultState()
			.with(BackroomsStairs.FACING, Direction.NORTH).with(BackroomsStairs.HALF, BlockHalf.BOTTOM)
			.with(BackroomsStairs.SHAPE, StairShape.STRAIGHT);

	private static List<Integer[][]> LayoutsTop = Layout.listLayouts(27, "level01", 1, 0, new Layout());
	private static List<Integer[][]> LayoutsBottom = Layout.listLayouts(27, "level01", 2, 0, new Layout());
	private static Integer[][] Roof = Layout.getColoredLayout("roof", 0, 0, 3, 0, 6, 5, 4, 0, 0, 0, new Layout());
	private static Integer[][] Floor = Layout.getLayout("whiteblock", 0, 7, new Layout());

	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random rand, BlockPos position,
			DefaultFeatureConfig featureConfig) {
		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable().set(position);
		int layoutInt = 0;

		if (rand.nextDouble() < 0.7) {
			layoutInt = 0;
		} else if (rand.nextDouble() < 0.8) {
			int k = rand.nextInt(9);
			switch (k) {
			case 0:
				layoutInt = 8;
				break;
			case 1:
				layoutInt = 9;
				break;
			case 2:
				layoutInt = 10;
				break;
			case 3:
				layoutInt = 11;
				break;
			case 4:
				layoutInt = 17;
				break;
			case 5:
				layoutInt = 18;
				break;
			case 6:
				layoutInt = 19;
				break;
			case 7:
				layoutInt = 20;
				break;
			case 8:
				layoutInt = 25;
				break;
			case 9:
				layoutInt = 26;
				break;
			}
		} else {
			if (rand.nextDouble() < 0.5) {
				layoutInt = 100;
			} else {
				layoutInt = rand.nextInt(27);
			}
		}

		if (layoutInt == 100) {
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.One, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Two, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Three, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Two, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Two, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.StairWall, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Stair1NoLight, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Stair1Light, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Stair1Light, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Stair1NoLight, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.StairWall, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Two, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Two, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Three, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Two, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
			RoomArchives.generateSlice(world, mutableBlockPos.move(Direction.EAST), RoomArchives.Four, rand,
					Backrooms.CEMENT_BRICKS, null, STAIR, Backrooms.CEMENT, null, false);
		} else {
			Integer[][] layoutTop = LayoutsTop.get(layoutInt);
			Integer[][] layoutBottom = LayoutsBottom.get(layoutInt);

			generateSlice(world, mutableBlockPos.move(Direction.DOWN), Roof, rand);
			generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutTop, rand);
			generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutTop, rand);
			generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutTop, rand);
			generateSlice(world, mutableBlockPos.move(Direction.DOWN), layoutBottom, rand);
			generateSlice(world, mutableBlockPos.move(Direction.DOWN), Floor, rand);
		}

		return true;

	}

	private void generateSlice(ServerWorldAccess world, BlockPos.Mutable centerPos, Integer[][] slice, Random rand) {

		BlockPos.Mutable currentPosition = new BlockPos.Mutable(centerPos.getX() - 1, centerPos.getY(),
				centerPos.getZ());

		for (int x = 0; x < slice.length; x++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[x][z];

				if (((world.getBlockState(currentPosition).getBlock() == Backrooms.WALL)
						|| (world.getBlockState(currentPosition).getBlock() == Blocks.BEDROCK))
						&& (world.getBlockState(currentPosition).getBlock() != Backrooms.CARPET_STAIRS)
						&& (world.getBlockState(currentPosition).getBlock() != Backrooms.VOID_BLOCK)) {
					if ((rand.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						door1 = true;
					} else {
						door1 = false;
					}

					switch (sliceBlock) {
					case 0:
						world.setBlockState(currentPosition, AIR, 2);
						break;
					case 1:
						world.setBlockState(currentPosition, CEMENT_BRICKS, 2);
						break;
					case 2:
						if (door1) {
							BlockState placement;
							if (rand.nextDouble() < BackroomsConfig.getInstance().VBDoor && rand.nextDouble() < 0.1) {
								placement = VOID_BLOCK;
							} else {
								placement = AIR;
							}
							world.setBlockState(currentPosition, placement, 2);
							world.setBlockState(currentPosition.add(0, 1, 0), placement, 2);
							world.setBlockState(currentPosition.add(0, 2, 0), placement, 2);
							world.setBlockState(currentPosition.add(0, 0, -1), placement, 2);
							world.setBlockState(currentPosition.add(0, 1, -1), placement, 2);
							world.setBlockState(currentPosition.add(0, 2, -1), placement, 2);
							world.setBlockState(currentPosition.add(-1, 0, 0), placement, 2);
							world.setBlockState(currentPosition.add(-1, 1, 0), placement, 2);
							world.setBlockState(currentPosition.add(-1, 2, 0), placement, 2);
							world.setBlockState(currentPosition.add(-1, 0, -1), placement, 2);
							world.setBlockState(currentPosition.add(-1, 1, -1), placement, 2);
							world.setBlockState(currentPosition.add(-1, 2, -1), placement, 2);
							world.setBlockState(currentPosition.add(0, 0, 1), placement, 2);
							world.setBlockState(currentPosition.add(0, 1, 1), placement, 2);
							world.setBlockState(currentPosition.add(0, 2, 1), placement, 2);
							world.setBlockState(currentPosition.add(1, 0, 0), placement, 2);
							world.setBlockState(currentPosition.add(1, 1, 0), placement, 2);
							world.setBlockState(currentPosition.add(1, 2, 0), placement, 2);
							world.setBlockState(currentPosition.add(1, 0, 1), placement, 2);
							world.setBlockState(currentPosition.add(1, 1, 1), placement, 2);
							world.setBlockState(currentPosition.add(1, 2, 1), placement, 2);
							world.setBlockState(currentPosition.add(1, 0, -1), placement, 2);
							world.setBlockState(currentPosition.add(1, 1, -1), placement, 2);
							world.setBlockState(currentPosition.add(1, 2, -1), placement, 2);
							world.setBlockState(currentPosition.add(-1, 0, 1), placement, 2);
							world.setBlockState(currentPosition.add(-1, 1, 1), placement, 2);
							world.setBlockState(currentPosition.add(-1, 2, 1), placement, 2);
							if (BackroomsConfig.getInstance().TallDoors) {
								world.setBlockState(currentPosition.add(0, 3, 0), placement, 2);
								world.setBlockState(currentPosition.add(0, 3, -1), placement, 2);
								world.setBlockState(currentPosition.add(-1, 3, 0), placement, 2);
								world.setBlockState(currentPosition.add(-1, 3, -1), placement, 2);
								world.setBlockState(currentPosition.add(0, 3, 0), placement, 2);
								world.setBlockState(currentPosition.add(0, 3, 1), placement, 2);
								world.setBlockState(currentPosition.add(1, 3, 0), placement, 2);
								world.setBlockState(currentPosition.add(1, 3, 1), placement, 2);
								world.setBlockState(currentPosition.add(1, 3, -1), placement, 2);
								world.setBlockState(currentPosition.add(-1, 3, 1), placement, 2);
							}
						} else {
							world.setBlockState(currentPosition, CEMENT_BRICKS, 2);
						}
						break;
					case 3:
						world.setBlockState(currentPosition, NORTH_TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 4:
						world.setBlockState(currentPosition, SOUTH_TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 5:
						world.setBlockState(currentPosition, TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 6:
						world.setBlockState(currentPosition, LIGHT, 2);
						break;
					case 7:
						world.setBlockState(currentPosition, CEMENT, 2);
						if (rand.nextDouble() < 0.001) {
							if (rand.nextDouble() < BackroomsConfig.getInstance().ChestSpawnChance) {
								world.setBlockState(currentPosition.add(0, 1, 0), CHEST, 2);
								LootableContainerBlockEntity.setLootTable(world, rand, currentPosition.add(0, 1, 0),
										Backrooms.LEVEL1CHEST);
							}
						}
						break;
					}
				}
				currentPosition.move(Direction.SOUTH);
			}
			currentPosition.move(-1, 0, -slice[0].length);
		}
	}
}