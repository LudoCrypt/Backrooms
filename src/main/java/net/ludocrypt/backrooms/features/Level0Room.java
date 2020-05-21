package net.ludocrypt.backrooms.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Carpet;
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

public class Level0Room extends Feature<DefaultFeatureConfig> {
	public Level0Room(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configFactory)
	{
		super(configFactory);
	}
	
	public static boolean door1 = true;
	public static boolean door2 = true;
	public static boolean door3 = true;
	public static boolean door4 = true;

	private int[][] One = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 6, 5, 6, 5, 6, 6, 6, 6, 5, 6, 5, 6, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	
	private int[][] Two = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	
	private int[][] Three = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	
	private int[][] Four = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 9, 5, 9, 5, 9, 9, 9, 9, 5, 9, 5, 9, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	
	private int[][] OneNoLight = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, 
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, 
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] TwoLight = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, 
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }, 
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] Hallway1NoLight = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, 
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, 
			{ 7, 4, 4, 4, 4, 7, 4, 4, 4, 4, 8, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] Hallway1Light = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, 
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5, 4, 4, 4, 4, 5 }, 
			{ 7, 4, 4, 4, 4, 7, 4, 4, 4, 4, 8, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	
	private int[][] Hallway2Wall1 = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 6, 5, 6, 5, 6, 6, 6, 6, 5, 6, 5, 6, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] Hallway2Wall2 = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 9, 5, 9, 5, 9, 9, 9, 9, 5, 9, 5, 9, 5, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] Hallway2NoLight = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] Hallway2Light = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2, 2, 3, 3, 2, 2 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] Stair1NoLight = 
		{
			{ 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 1, 4, 4, 4, 4, 4, 4, 2, 2, 2, 2 },
			{ 5, 5, 5, 5, 5, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 5, 5, 5, 5, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 5 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	private int[][] Stair1Light = 
		{
			{ 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0 },
			{ 2, 2, 3, 2, 2, 1, 4, 4, 4, 4, 4, 4, 2, 3, 2, 2 },
			{ 5, 5, 5, 5, 5, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 5, 5, 5, 5, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 5 },
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5 }, 
			{ 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};
	
	private int[][] StairWall = 
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, 
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 8, 8, 8, 8, 8, 8 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
		};

	private static final BlockState WALLPAPER = Backrooms.WALLPAPER.getDefaultState();
	private static final BlockState CARPET = Backrooms.CARPET.getDefaultState();
	private static final BlockState MOLDY_CARPET = Backrooms.CARPET.getDefaultState().with(Carpet.MOLDY, true);
	private static final BlockState TILE = Backrooms.TILE.getDefaultState();
	private static final BlockState LIGHT = Backrooms.LIGHT.getDefaultState();
	private static final BlockState AIR = Blocks.AIR.getDefaultState();

	public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> changedBlock, Random rand,
			BlockPos position, DefaultFeatureConfig config) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(position);

		if ((Math.random())<((BackroomsConfig.getInstance().NormalRoomChance))) {
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
		}
		else if ((Math.random())<((BackroomsConfig.getInstance().PickHallwayChance))) {
			if ((Math.random())<((BackroomsConfig.getInstance().EastHallwayChance))) {
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
			}
			else {
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
		}
		else if (Math.random() < BackroomsConfig.getInstance().PickStairChance) {
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), One, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), StairWall, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Stair1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Stair1Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Stair1Light, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Stair1NoLight, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), StairWall, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Three, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Two, rand);
				generateSlice(world, mutableBlockPos.setOffset(Direction.EAST), Four, rand);
		}
		else {
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

		BlockPos currentPositionOffsetted = new BlockPos(centerPos.add(-5, slice.length / 2, -slice[0].length / 2));
		BlockPos.Mutable currentPosition = new BlockPos.Mutable(currentPositionOffsetted.getX(),
				currentPositionOffsetted.getY(), currentPositionOffsetted.getZ());

		for (int y = 0; y < slice.length; y++) {
			for (int z = 0; z < slice[0].length; z++) {
				int sliceBlock = slice[y][z];

				if (world.getBlockState(currentPosition).isOpaque()) {
					if ((Math.random())<((BackroomsConfig.getInstance().DoorChance))) {
						Level0Room.door1 = true;
					} else {
						Level0Room.door1 = false;
					}
					if ((Math.random())<((BackroomsConfig.getInstance().DoorChance))) {
						Level0Room.door2 = true;
					} else {
						Level0Room.door2 = false;
					}
					if ((Math.random())<((BackroomsConfig.getInstance().DoorChance))) {
						Level0Room.door3 = true;
					} else {
						Level0Room.door3 = false;
					}
					if ((Math.random())<((BackroomsConfig.getInstance().DoorChance))) {
						Level0Room.door4 = true;
					} else {
						Level0Room.door4 = false;
					}
					if (sliceBlock == 0) {
						
					} else if (sliceBlock == 2) {
						world.setBlockState(currentPosition, TILE, 2);
					} else if (sliceBlock == 3) {
						world.setBlockState(currentPosition, LIGHT, 2);
					} else if (sliceBlock == 4) {
						world.setBlockState(currentPosition, AIR, 2);
					} else if (sliceBlock == 5) {
						world.setBlockState(currentPosition, WALLPAPER, 2);
					} else if ((door1 == true) && (sliceBlock == 6)) {
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
					} else if ((door2 == true) && (sliceBlock == 7)) {
							world.setBlockState(currentPosition, AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 0, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 1, 0), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 2, 0), AIR, 2);
							world.setBlockState(currentPosition.add(0, 0, -1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 1, -1), AIR, 2);
							world.setBlockState(currentPosition.add(0, 2, -1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 0, -1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 1, -1), AIR, 2);
							world.setBlockState(currentPosition.add(-1, 2, -1), AIR, 2);
							} else if ((door3 == true) && (sliceBlock == 8)) {
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
					} else if ((door4 == true) && (sliceBlock == 9)) {
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
					} else if ((door1 == false) && (sliceBlock == 6)) {
						world.setBlockState(currentPosition, WALLPAPER, 2);
					} else if ((door2 == false) && (sliceBlock == 7)) {
						world.setBlockState(currentPosition, WALLPAPER, 2);
					} else if ((door3 == false) && (sliceBlock == 8)) {
						world.setBlockState(currentPosition, WALLPAPER, 2);
					} else if ((door4 == false) && (sliceBlock == 9)) {
						world.setBlockState(currentPosition, WALLPAPER, 2);
					} else if (sliceBlock == 1) {
						if ((Math.random())<((BackroomsConfig.getInstance().MoldyCarpetChance))) {
							world.setBlockState(currentPosition, MOLDY_CARPET, 2);
						}
						else {
							world.setBlockState(currentPosition, CARPET, 2);
						}
					}
				}

				currentPosition.setOffset(Direction.SOUTH);
			}

			currentPosition.setOffset(0, -1, -slice[0].length);
		}
	}
}