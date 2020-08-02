package net.ludocrypt.backrooms.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.BackroomsStairs;
import net.ludocrypt.backrooms.blocks.Carpet;
import net.ludocrypt.backrooms.blocks.Light;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.blocks.TornWallpaper;
import net.ludocrypt.backrooms.config.BackroomsConfig;
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
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level0DecrepitRoom extends Feature<DefaultFeatureConfig> {
	public Level0DecrepitRoom(Codec<DefaultFeatureConfig> configFactory) {
		super(configFactory);
	}

	public static boolean door1 = true;
	public static boolean door2 = true;
	public static boolean door3 = true;
	public static boolean door4 = true;

	private int[][] One = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 6, 5, 6, 5, 6, 6, 6, 6, 5, 6, 5, 6, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Two = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Three = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 3, 3, 2, 11, 12, 3, 3, 12, 2, 11, 3, 3, 2, 11 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Four = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 9, 5, 9, 5, 9, 9, 9, 9, 5, 9, 5, 9, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] OneNoLight = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] TwoLight = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 3, 3, 2, 11, 12, 3, 3, 12, 2, 11, 3, 3, 2, 11 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Hallway1NoLight = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 7, 4, 4, 4, 4, 8, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Hallway1Light = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 3, 3, 2, 11, 12, 3, 3, 12, 2, 11, 3, 3, 2, 11 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 7, 4, 4, 4, 4, 8, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Hallway2Wall1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 6, 5, 6, 5, 6, 6, 6, 6, 5, 6, 5, 6, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Hallway2Wall2 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 9, 5, 9, 5, 9, 9, 9, 9, 5, 9, 5, 9, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Hallway2NoLight = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Hallway2Light = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 3, 3, 2, 11, 12, 3, 3, 12, 2, 11, 3, 3, 2, 11 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, { 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Stair1Light = { { 0, 0, 0, 0, 0, 10, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 1, 10, 4, 4, 4, 4, 4, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 1, 1, 10, 4, 4, 4, 4, 4, 4, 4, 5 }, { 5, 5, 5, 5, 5, 1, 1, 1, 10, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 10, 4, 4, 4, 4, 4, 5 }, { 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 10, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int[][] Stair1NoLight = { { 0, 0, 0, 0, 0, 10, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0 },
			{ 2, 11, 3, 3, 2, 1, 10, 4, 4, 4, 4, 4, 3, 3, 2, 11 }, { 5, 5, 5, 5, 5, 1, 1, 10, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 10, 4, 4, 4, 4, 4, 4, 5 }, { 5, 5, 5, 5, 5, 1, 1, 1, 1, 10, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 10, 4, 4, 4, 4, 8 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	private int[][] StairWall = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11, 2, 11 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 8, 8, 8, 8, 8, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

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
	private static final BlockState LIGHT = Backrooms.LIGHT.getDefaultState().with(Light.ON, false);
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

	public boolean generate(ServerWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGen,
			Random rand, BlockPos position, DefaultFeatureConfig config) {

		Random generator = new Random(world.getSeed());
		long seed = world.getSeed();
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = position.getX() * l ^ position.getY() * m ^ position.getZ() * n ^ seed;
		generator = new Random(o);
		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable().set(position);

		if (generator.nextDouble() < 0.7) {
			generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
		} else if (generator.nextDouble() < 0.8) {
			if (generator.nextDouble() < 0.5) {
				generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Wall1, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Wall2, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
			} else {
				generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
			}
		} else if (generator.nextDouble() < 0.5) {
			generateSlice(world, mutableBlockPos.move(Direction.EAST), One, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), StairWall, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1NoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1Light, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1Light, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Stair1NoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), StairWall, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), Four, rand);
		} else {
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.move(Direction.EAST), OneNoLight, rand);
		}

		return true;

	}

	private void generateSlice(ServerWorldAccess world, BlockPos.Mutable centerPos, int[][] slice, Random rand) {

		BlockPos currentPositionOffsetted = new BlockPos(centerPos.add(-1, 3, slice[0].length));
		BlockPos.Mutable currentPosition = new BlockPos.Mutable(currentPositionOffsetted.getX(),
				currentPositionOffsetted.getY(), currentPositionOffsetted.getZ());

		Random generator = new Random(world.getSeed());
		Random generator2 = new Random(world.getSeed());
		long seed = world.getSeed();
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = currentPosition.getX() * l ^ currentPosition.getY() * m ^ currentPosition.getZ() * n ^ seed;
		generator = new Random(o);
		generator2 = new Random(o + 2);

		for (int y = 0; y < slice.length; y++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[y][z];

				if (((world.getBlockState(currentPosition).getBlock() == Backrooms.WALL)
						|| (world.getBlockState(currentPosition).getBlock() == Blocks.BEDROCK))
						&& (world.getBlockState(currentPosition).getBlock() != Backrooms.CARPET_STAIRS)) {

					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0DecrepitRoom.door1 = true;
					} else {
						Level0DecrepitRoom.door1 = false;
					}
					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0DecrepitRoom.door2 = true;
					} else {
						Level0DecrepitRoom.door2 = false;
					}
					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0DecrepitRoom.door3 = true;
					} else {
						Level0DecrepitRoom.door3 = false;
					}
					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0DecrepitRoom.door4 = true;
					} else {
						Level0DecrepitRoom.door4 = false;
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
						world.setBlockState(currentPosition, LIGHT, 8);
						break;
					case 4:
						world.setBlockState(currentPosition, AIR, 2);
						break;
					case 5:
						if (rand.nextDouble() < 0.35) {
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
							if (generator2.nextDouble() < BackroomsConfig.getInstance().VBDoor) {
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
						world.setBlockState(currentPosition, CARPET_STAIRS, 2);
						break;
					case 1:
						if (rand.nextDouble() < 0.25) {
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