package net.ludocrypt.backrooms.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level0RedRoom extends Feature<DefaultFeatureConfig> {
	public Level0RedRoom(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configFactory) {
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

	private static final BlockState WALLPAPER = Backrooms.RED_WALLPAPER.getDefaultState();
	private static final BlockState CARPET = Backrooms.CARPET.getDefaultState();
	private static final BlockState SOUTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.SOUTH)
			.with(Tile.SINGLE, false);
	private static final BlockState NORTH_TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.NORTH)
			.with(Tile.SINGLE, false);
	private static final BlockState TILE = Backrooms.TILE.getDefaultState().with(Tile.FACING, Direction.EAST)
			.with(Tile.SINGLE, true);
	private static final BlockState LIGHT = Backrooms.LIGHT.getDefaultState();
	private static final BlockState AIR = Blocks.AIR.getDefaultState();
	private static final BlockState VOID_BLOCK = Backrooms.VOID_BLOCK.getDefaultState();

	public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> changedBlock, Random rand,
			BlockPos position, DefaultFeatureConfig config) {

		Random generator = new Random(world.getSeed());
		long seed = world.getSeed();
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = position.getX() * l ^ position.getY() * m ^ position.getZ() * n ^ seed;
		generator = new Random(o);

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(position);

		if (generator.nextDouble() < 0.7) {
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), One, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Four, rand);
		} else if (generator.nextDouble() < 0.8) {
			if (generator.nextDouble() < 0.5) {
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), One, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2Wall1, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2Wall2, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway2NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Four, rand);
			} else {
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), One, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Hallway1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Four, rand);
			}
		} else if (generator.nextDouble() < 0.5) {
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), One, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Four, rand);
		} else {
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), TwoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
			generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), OneNoLight, rand);
		}

		return true;

	}

	private void generateSlice(IWorld world, BlockPos.Mutable centerPos, int[][] slice, Random rand) {

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
		generator2 = new Random(o * 2);

		for (int y = 0; y < slice.length; y++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[y][z];

				if (((world.getBlockState(currentPosition).getBlock() == Backrooms.WALL)
						|| (world.getBlockState(currentPosition).getBlock() == Blocks.BEDROCK))) {
					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0RedRoom.door1 = true;
					} else {
						Level0RedRoom.door1 = false;
					}
					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0RedRoom.door2 = true;
					} else {
						Level0RedRoom.door2 = false;
					}
					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0RedRoom.door3 = true;
					} else {
						Level0RedRoom.door3 = false;
					}
					if ((generator.nextDouble()) < ((BackroomsConfig.getInstance().Level0DoorChance))) {
						Level0RedRoom.door4 = true;
					} else {
						Level0RedRoom.door4 = false;
					}

					switch (sliceBlock) {
					case 0:
						break;
					case 2:
						world.setBlockState(currentPosition, SOUTH_TILE, 2);
						break;
					case 11:
						world.setBlockState(currentPosition, NORTH_TILE, 2);
						break;
					case 12:
						world.setBlockState(currentPosition, TILE, 2);
						break;
					case 3:
						world.setBlockState(currentPosition, LIGHT, 2);
						break;
					case 4:
						world.setBlockState(currentPosition, AIR, 2);
						break;
					case 5:
						world.setBlockState(currentPosition, WALLPAPER, 2);
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
							world.setBlockState(currentPosition, AIR, 2);
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
					case 1:
						world.setBlockState(currentPosition, CARPET, 2);
						break;
					}
				}
				currentPosition.setOffset(Direction.SOUTH);
			}
			currentPosition.setOffset(0, -1, -slice[0].length);
		}

	}
}