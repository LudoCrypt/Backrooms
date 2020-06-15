package net.ludocrypt.backrooms.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Tile extends Block {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public static final BooleanProperty SINGLE = BooleanProperty.of("single");

	public Tile() {
		super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
				.hardness(3).resistance(2));
		setDefaultState(getStateManager().getDefaultState().with(SINGLE, true).with(FACING, Direction.EAST));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(FACING).add(SINGLE);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		if (player.isInSneakingPose()) {
			world.setBlockState(pos,
					Backrooms.TILE.getDefaultState().with(SINGLE, true).with(FACING, Direction.EAST));
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.PASS;
		}
	}

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		if (ctx.getPlayerFacing() == Direction.EAST || ctx.getPlayerFacing() == Direction.WEST) {
			return (BlockState) this.getDefaultState().with(FACING, Direction.EAST).with(SINGLE, true);
		}
		return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerFacing()).with(SINGLE, false);
	}
}
