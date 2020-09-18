package net.ludocrypt.backrooms.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;

public class Tile extends Block {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public static final BooleanProperty SINGLE = BooleanProperty.of("single");

	public Tile() {
		super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
				.hardness(3).resistance(2).requiresTool());
		setDefaultState(getStateManager().getDefaultState().with(SINGLE, true).with(FACING, Direction.EAST));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(FACING).add(SINGLE);
	}

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		if (ctx.getPlayerFacing() == Direction.EAST || ctx.getPlayerFacing() == Direction.WEST) {
			return (BlockState) this.getDefaultState().with(FACING, Direction.EAST).with(SINGLE, true);
		}
		return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite()).with(SINGLE, false);
	}
}
