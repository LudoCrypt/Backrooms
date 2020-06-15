package net.ludocrypt.backrooms.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlacementEnvironment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.EntityContext;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;

public class BackroomsSlab extends Block implements Waterloggable {
   public static final EnumProperty<SlabType> TYPE;
   public static final BooleanProperty WATERLOGGED;
   public static final VoxelShape BOTTOM_SHAPE;
   public static final VoxelShape TOP_SHAPE;

   public BackroomsSlab(Block.Settings settings) {
      super(settings);
      this.setDefaultState((BlockState)((BlockState)this.getDefaultState().with(TYPE, SlabType.BOTTOM)).with(WATERLOGGED, false));
   }

   public boolean hasSidedTransparency(BlockState state) {
      return state.get(TYPE) != SlabType.DOUBLE;
   }

   public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(TYPE, WATERLOGGED);
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
      SlabType slabType = (SlabType)state.get(TYPE);
      switch(slabType) {
      case DOUBLE:
         return VoxelShapes.fullCube();
      case TOP:
         return TOP_SHAPE;
      default:
         return BOTTOM_SHAPE;
      }
   }

   public BlockState getPlacementState(ItemPlacementContext ctx) {
      BlockPos blockPos = ctx.getBlockPos();
      BlockState blockState = ctx.getWorld().getBlockState(blockPos);
      if (blockState.getBlock() == this) {
         return (BlockState)((BlockState)blockState.with(TYPE, SlabType.DOUBLE)).with(WATERLOGGED, false);
      } else {
         FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
         BlockState blockState2 = (BlockState)((BlockState)this.getDefaultState().with(TYPE, SlabType.BOTTOM)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
         Direction direction = ctx.getSide();
         return direction != Direction.DOWN && (direction == Direction.UP || ctx.getHitPos().y - (double)blockPos.getY() <= 0.5D) ? blockState2 : (BlockState)blockState2.with(TYPE, SlabType.TOP);
      }
   }

   public boolean canReplace(BlockState state, ItemPlacementContext ctx) {
      ItemStack itemStack = ctx.getStack();
      SlabType slabType = (SlabType)state.get(TYPE);
      if (slabType != SlabType.DOUBLE && itemStack.getItem() == this.asItem()) {
         if (ctx.canReplaceExisting()) {
            boolean bl = ctx.getHitPos().y - (double)ctx.getBlockPos().getY() > 0.5D;
            Direction direction = ctx.getSide();
            if (slabType == SlabType.BOTTOM) {
               return direction == Direction.UP || bl && direction.getAxis().isHorizontal();
            } else {
               return direction == Direction.DOWN || !bl && direction.getAxis().isHorizontal();
            }
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public FluidState getFluidState(BlockState state) {
      return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
   }

   public boolean tryFillWithFluid(IWorld world, BlockPos pos, BlockState state, FluidState fluidState) {
      return state.get(TYPE) != SlabType.DOUBLE ? Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState) : false;
   }

   public boolean canFillWithFluid(BlockView view, BlockPos pos, BlockState state, Fluid fluid) {
      return state.get(TYPE) != SlabType.DOUBLE ? Waterloggable.super.canFillWithFluid(view, pos, state, fluid) : false;
   }

   public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {
      if ((Boolean)state.get(WATERLOGGED)) {
         world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
      }

      return super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
   }

   public boolean canPlaceAtSide(BlockState world, BlockView view, BlockPos pos, BlockPlacementEnvironment env) {
      switch(env) {
      case LAND:
         return false;
      case WATER:
         return view.getFluidState(pos).matches(FluidTags.WATER);
      case AIR:
         return false;
      default:
         return false;
      }
   }

   static {
      TYPE = Properties.SLAB_TYPE;
      WATERLOGGED = Properties.WATERLOGGED;
      BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
      TOP_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
   }
}
