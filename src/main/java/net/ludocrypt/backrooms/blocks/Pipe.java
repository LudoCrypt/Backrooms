package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class Pipe extends Block {

	public static final BooleanProperty UP = BooleanProperty.of("up");
	public static final BooleanProperty DOWN = BooleanProperty.of("down");
	public static final BooleanProperty EAST = BooleanProperty.of("east");
	public static final BooleanProperty WEST = BooleanProperty.of("west");
	public static final BooleanProperty NORTH = BooleanProperty.of("north");
	public static final BooleanProperty SOUTH = BooleanProperty.of("south");
	public static final VoxelShape MIDDLESHAPE = Block.createCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 12.0D, 12.0D);
	public static final VoxelShape UPSHAPE = Block.createCuboidShape(4.0D, 12.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	public static final VoxelShape DOWNSHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D);
	public static final VoxelShape EASTSHAPE = Block.createCuboidShape(12.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	public static final VoxelShape WESTSHAPE = Block.createCuboidShape(0.0D, 4.0D, 4.0D, 4.0D, 12.0D, 12.0D);
	public static final VoxelShape NORTHSHAPE = Block.createCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 4.0D);
	public static final VoxelShape SOUTHSHAPE = Block.createCuboidShape(4.0D, 4.0D, 12.0D, 12.0D, 12.0D, 16.0D);

	public Pipe() {
		super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
				.hardness(6).resistance(6).lightLevel(5));
		setDefaultState(getStateManager().getDefaultState().with(UP, false).with(DOWN, false).with(EAST, false)
				.with(WEST, false).with(NORTH, false).with(SOUTH, false));
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		VoxelShape up = UPSHAPE;
		VoxelShape down = DOWNSHAPE;
		VoxelShape east = EASTSHAPE;
		VoxelShape west = WESTSHAPE;
		VoxelShape north = NORTHSHAPE;
		VoxelShape south = SOUTHSHAPE;
		if (!state.get(UP)) {
			up = MIDDLESHAPE;
		}
		if (!state.get(DOWN)) {
			down = MIDDLESHAPE;
		}
		if (!state.get(EAST)) {
			east = MIDDLESHAPE;
		}
		if (!state.get(WEST)) {
			west = MIDDLESHAPE;
		}
		if (!state.get(NORTH)) {
			north = MIDDLESHAPE;
		}
		if (!state.get(SOUTH)) {
			south = MIDDLESHAPE;
		}
		VoxelShape alltogether = VoxelShapes.union(up, down, east, west, north, south);
		return alltogether;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(UP, DOWN, EAST, WEST, NORTH, SOUTH);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		super.randomDisplayTick(state, world, pos, random);
		if (random.nextInt(2) == 0) {
			world.addParticle(ParticleTypes.MYCELIUM, (double) pos.getX() + (double) random.nextFloat(),
					(double) pos.getY() + (double) random.nextFloat(),
					(double) pos.getZ() + (double) random.nextFloat(), 1.0D, -1.0D, 1.0D);
		}
		if (random.nextInt(10) == 0) {
			world.addParticle(ParticleTypes.DRIPPING_WATER, (double) pos.getX() + (random.nextDouble() / 4) + 0.5,
					(double) pos.getY() + 0.18, (double) pos.getZ() + (random.nextDouble() / 4) + 0.5, 0.0D, 0.0D,
					0.0D);
		}
	}

	public BlockState withConnectionProperties(BlockView view, BlockPos pos) {
		Block block = view.getBlockState(pos.down()).getBlock();
		Block block2 = view.getBlockState(pos.up()).getBlock();
		Block block3 = view.getBlockState(pos.north()).getBlock();
		Block block4 = view.getBlockState(pos.east()).getBlock();
		Block block5 = view.getBlockState(pos.south()).getBlock();
		Block block6 = view.getBlockState(pos.west()).getBlock();
		return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.getDefaultState()
				.with(DOWN, block == Backrooms.PIPE)).with(UP, block2 == Backrooms.PIPE)).with(NORTH,
						block3 == Backrooms.PIPE)).with(EAST, block4 == Backrooms.PIPE)).with(SOUTH,
								block5 == Backrooms.PIPE)).with(WEST, block6 == Backrooms.PIPE);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.withConnectionProperties(ctx.getWorld(), ctx.getBlockPos());
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState,
			WorldAccess world, BlockPos pos, BlockPos posFrom) {
		Block block = neighborState.getBlock();
		boolean bl = block == Backrooms.PIPE;
		return (BlockState) state.with((Property<Boolean>) ConnectingBlock.FACING_PROPERTIES.get(facing), bl);
	}
	
}
