package net.ludocrypt.backrooms.blocks;

import java.util.Random;
import java.util.stream.IntStream;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlacementEnvironment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.explosion.Explosion;

public class BackroomsStairs extends Block implements Waterloggable {
   public static final DirectionProperty FACING;
   public static final EnumProperty<BlockHalf> HALF;
   public static final EnumProperty<StairShape> SHAPE;
   public static final BooleanProperty WATERLOGGED;
   public static final VoxelShape TOP_SHAPE;
   public static final VoxelShape BOTTOM_SHAPE;
   public static final VoxelShape BOTTOM_NORTH_WEST_CORNER_SHAPE;
   public static final VoxelShape BOTTOM_SOUTH_WEST_CORNER_SHAPE;
   public static final VoxelShape TOP_NORTH_WEST_CORNER_SHAPE;
   public static final VoxelShape TOP_SOUTH_WEST_CORNER_SHAPE;
   public static final VoxelShape BOTTOM_NORTH_EAST_CORNER_SHAPE;
   public static final VoxelShape BOTTOM_SOUTH_EAST_CORNER_SHAPE;
   public static final VoxelShape TOP_NORTH_EAST_CORNER_SHAPE;
   public static final VoxelShape TOP_SOUTH_EAST_CORNER_SHAPE;
   public static final VoxelShape[] TOP_SHAPES;
   public static final VoxelShape[] BOTTOM_SHAPES;
   public static final int[] SHAPE_INDICES;
   public final Block baseBlock;
   public final BlockState baseBlockState;

   public static VoxelShape[] composeShapes(VoxelShape base, VoxelShape northWest, VoxelShape northEast, VoxelShape southWest, VoxelShape southEast) {
      return (VoxelShape[])IntStream.range(0, 16).mapToObj((i) -> {
         return composeShape(i, base, northWest, northEast, southWest, southEast);
      }).toArray((i) -> {
         return new VoxelShape[i];
      });
   }

   public static VoxelShape composeShape(int i, VoxelShape base, VoxelShape northWest, VoxelShape northEast, VoxelShape southWest, VoxelShape southEast) {
      VoxelShape voxelShape = base;
      if ((i & 1) != 0) {
         voxelShape = VoxelShapes.union(base, northWest);
      }

      if ((i & 2) != 0) {
         voxelShape = VoxelShapes.union(voxelShape, northEast);
      }

      if ((i & 4) != 0) {
         voxelShape = VoxelShapes.union(voxelShape, southWest);
      }

      if ((i & 8) != 0) {
         voxelShape = VoxelShapes.union(voxelShape, southEast);
      }

      return voxelShape;
   }

   public BackroomsStairs(BlockState baseBlockState, Block.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(HALF, BlockHalf.BOTTOM)).with(SHAPE, StairShape.STRAIGHT)).with(WATERLOGGED, false));
      this.baseBlock = baseBlockState.getBlock();
      this.baseBlockState = baseBlockState;
   }

   public boolean hasSidedTransparency(BlockState state) {
      return true;
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
      return (state.get(HALF) == BlockHalf.TOP ? TOP_SHAPES : BOTTOM_SHAPES)[SHAPE_INDICES[this.getShapeIndexIndex(state)]];
   }

   public int getShapeIndexIndex(BlockState state) {
      return ((StairShape)state.get(SHAPE)).ordinal() * 4 + ((Direction)state.get(FACING)).getHorizontal();
   }

   @Environment(EnvType.CLIENT)
   public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
      this.baseBlock.randomDisplayTick(state, world, pos, random);
   }

   public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
      this.baseBlockState.onBlockBreakStart(world, pos, player);
   }

   public void onBroken(IWorld world, BlockPos pos, BlockState state) {
      this.baseBlock.onBroken(world, pos, state);
   }

   public float getBlastResistance() {
      return this.baseBlock.getBlastResistance();
   }

   public int getTickRate(WorldView worldView) {
      return this.baseBlock.getTickRate(worldView);
   }

   public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moved) {
      if (state.getBlock() != state.getBlock()) {
         this.baseBlockState.neighborUpdate(world, pos, Blocks.AIR, pos, false);
         this.baseBlock.onBlockAdded(this.baseBlockState, world, pos, oldState, false);
      }
   }

   public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
      if (state.getBlock() != newState.getBlock()) {
         this.baseBlockState.onBlockRemoved(world, pos, newState, moved);
      }
   }

   public void onSteppedOn(World world, BlockPos pos, Entity entity) {
      this.baseBlock.onSteppedOn(world, pos, entity);
   }

   public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
      this.baseBlock.scheduledTick(state, world, pos, random);
   }

   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      return this.baseBlockState.onUse(world, player, hand, hit);
   }

   public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
      this.baseBlock.onDestroyedByExplosion(world, pos, explosion);
   }

   public BlockState getPlacementState(ItemPlacementContext ctx) {
      Direction direction = ctx.getSide();
      BlockPos blockPos = ctx.getBlockPos();
      FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
      BlockState blockState = (BlockState)((BlockState)((BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing())).with(HALF, direction != Direction.DOWN && (direction == Direction.UP || ctx.getHitPos().y - (double)blockPos.getY() <= 0.5D) ? BlockHalf.BOTTOM : BlockHalf.TOP)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
      return (BlockState)blockState.with(SHAPE, method_10675(blockState, ctx.getWorld(), blockPos));
   }

   public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {
      if ((Boolean)state.get(WATERLOGGED)) {
         world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
      }

      return facing.getAxis().isHorizontal() ? (BlockState)state.with(SHAPE, method_10675(state, world, pos)) : super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
   }

   public static StairShape method_10675(BlockState state, BlockView view, BlockPos pos) {
      Direction direction = (Direction)state.get(FACING);
      BlockState blockState = view.getBlockState(pos.offset(direction));
      if (isStairs(blockState) && state.get(HALF) == blockState.get(HALF)) {
         Direction direction2 = (Direction)blockState.get(FACING);
         if (direction2.getAxis() != ((Direction)state.get(FACING)).getAxis() && method_10678(state, view, pos, direction2.getOpposite())) {
            if (direction2 == direction.rotateYCounterclockwise()) {
               return StairShape.OUTER_LEFT;
            }

            return StairShape.OUTER_RIGHT;
         }
      }

      BlockState blockState2 = view.getBlockState(pos.offset(direction.getOpposite()));
      if (isStairs(blockState2) && state.get(HALF) == blockState2.get(HALF)) {
         Direction direction3 = (Direction)blockState2.get(FACING);
         if (direction3.getAxis() != ((Direction)state.get(FACING)).getAxis() && method_10678(state, view, pos, direction3)) {
            if (direction3 == direction.rotateYCounterclockwise()) {
               return StairShape.INNER_LEFT;
            }

            return StairShape.INNER_RIGHT;
         }
      }

      return StairShape.STRAIGHT;
   }

   public static boolean method_10678(BlockState state, BlockView view, BlockPos pos, Direction dir) {
      BlockState blockState = view.getBlockState(pos.offset(dir));
      return !isStairs(blockState) || blockState.get(FACING) != state.get(FACING) || blockState.get(HALF) != state.get(HALF);
   }

   public static boolean isStairs(BlockState state) {
      return state.getBlock() instanceof BackroomsStairs;
   }

   public BlockState rotate(BlockState state, BlockRotation rotation) {
      return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
   }

   @SuppressWarnings("incomplete-switch")
public BlockState mirror(BlockState state, BlockMirror mirror) {
      Direction direction = (Direction)state.get(FACING);
      StairShape stairShape = (StairShape)state.get(SHAPE);
      switch(mirror) {
      case LEFT_RIGHT:
         if (direction.getAxis() == Direction.Axis.Z) {
            switch(stairShape) {
            case INNER_LEFT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.INNER_RIGHT);
            case INNER_RIGHT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.INNER_LEFT);
            case OUTER_LEFT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.OUTER_RIGHT);
            case OUTER_RIGHT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.OUTER_LEFT);
            default:
               return state.rotate(BlockRotation.CLOCKWISE_180);
            }
         }
         break;
      case FRONT_BACK:
         if (direction.getAxis() == Direction.Axis.X) {
            switch(stairShape) {
            case INNER_LEFT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.INNER_LEFT);
            case INNER_RIGHT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.INNER_RIGHT);
            case OUTER_LEFT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.OUTER_RIGHT);
            case OUTER_RIGHT:
               return (BlockState)state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, StairShape.OUTER_LEFT);
            case STRAIGHT:
               return state.rotate(BlockRotation.CLOCKWISE_180);
            }
         }
      }

      return super.mirror(state, mirror);
   }

   public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(FACING, HALF, SHAPE, WATERLOGGED);
   }

   public FluidState getFluidState(BlockState state) {
      return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
   }

   public boolean canPlaceAtSide(BlockState world, BlockView view, BlockPos pos, BlockPlacementEnvironment env) {
      return false;
   }

   static {
      FACING = HorizontalFacingBlock.FACING;
      HALF = Properties.BLOCK_HALF;
      SHAPE = Properties.STAIR_SHAPE;
      WATERLOGGED = Properties.WATERLOGGED;
      TOP_SHAPE = BackroomsSlab.TOP_SHAPE;
      BOTTOM_SHAPE = BackroomsSlab.BOTTOM_SHAPE;
      BOTTOM_NORTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D);
      BOTTOM_SOUTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D);
      TOP_NORTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D);
      TOP_SOUTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D);
      BOTTOM_NORTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
      BOTTOM_SOUTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D);
      TOP_NORTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
      TOP_SOUTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
      TOP_SHAPES = composeShapes(TOP_SHAPE, BOTTOM_NORTH_WEST_CORNER_SHAPE, BOTTOM_NORTH_EAST_CORNER_SHAPE, BOTTOM_SOUTH_WEST_CORNER_SHAPE, BOTTOM_SOUTH_EAST_CORNER_SHAPE);
      BOTTOM_SHAPES = composeShapes(BOTTOM_SHAPE, TOP_NORTH_WEST_CORNER_SHAPE, TOP_NORTH_EAST_CORNER_SHAPE, TOP_SOUTH_WEST_CORNER_SHAPE, TOP_SOUTH_EAST_CORNER_SHAPE);
      SHAPE_INDICES = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};
   }
}
