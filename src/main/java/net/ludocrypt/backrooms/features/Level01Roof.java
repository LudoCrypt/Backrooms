package net.ludocrypt.backrooms.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Carpet;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.imagereader.Layout;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level01Roof extends Feature<DefaultFeatureConfig> {
	public Level01Roof(Codec<DefaultFeatureConfig> configFactory) {
		super(configFactory);
	}

	private static final BlockState SOUTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.SOUTH)
			.with(Tile.SINGLE, false);
	private static final BlockState NORTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.NORTH)
			.with(Tile.SINGLE, false);
	private static final BlockState TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.EAST)
			.with(Tile.SINGLE, true);
	private static final BlockState LIGHT = Backrooms.LIGHT.getDefaultState();
	private static final BlockState VENT = Backrooms.VENT.getDefaultState();
	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState CARPET = Backrooms.CARPET.getDefaultState();
	private static final BlockState MOLDY_CARPET = Backrooms.CARPET.getDefaultState().with(Carpet.MOLDY, true);
	private static final BlockState CHEST = Blocks.CHEST.getDefaultState().with(ChestBlock.CHEST_TYPE, ChestType.SINGLE)
			.with(ChestBlock.FACING, Direction.NORTH).with(ChestBlock.WATERLOGGED, false);

	Integer[][] Roof = Layout.getLayout("roof", 0, 0, 1, 0, 3, 4, 2, 0, 0, 0);
	Integer[][] air = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	};
	Integer[][] carpet = { { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },

	};

	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random rand, BlockPos position,
			DefaultFeatureConfig featureConfig) {
		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable().set(position);

		generateSlice(world, mutableBlockPos.move(Direction.DOWN), Roof, rand);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), air, rand);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), air, rand);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), air, rand);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), air, rand);
		generateSlice(world, mutableBlockPos.move(Direction.DOWN), carpet, rand);

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
						&& (world.getBlockState(currentPosition).getBlock() != Backrooms.CARPET_STAIRS)) {
					switch (sliceBlock) {
					case 0:
						break;
					case 1:
						world.setBlockState(currentPosition, SOUTH_TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 2:
						world.setBlockState(currentPosition, NORTH_TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 3:
						world.setBlockState(currentPosition, TILE, 2);
						if (world.getBlockState(currentPosition.add(0, -1, 0)) == AIR && rand.nextDouble() < 0.25) {
							world.setBlockState(currentPosition.add(0, -1, 0), VENT, 2);
						}
						break;
					case 4:
						world.setBlockState(currentPosition, LIGHT, 2);
						break;
					case 5:
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
			currentPosition.move(-1, 0, -slice[0].length);
		}
	}
}