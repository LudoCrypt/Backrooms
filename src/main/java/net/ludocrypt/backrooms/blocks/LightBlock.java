package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightBlock extends Block {

	public static final BooleanProperty LIT = Properties.LIT;
	public static final BooleanProperty FORCED = BooleanProperty.of("forced");

	public LightBlock(Settings settings) {
		super(settings.luminance(Blocks.createLightLevelFromBlockState(15)));
		setDefaultState(getStateManager().getDefaultState().with(LIT, false).with(FORCED, false));
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return (BlockState) this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
		if (!world.isClient) {
			if (!state.get(FORCED)) {
				boolean bl = (Boolean) state.get(LIT);
				if (bl != world.isReceivingRedstonePower(pos)) {
					if (bl) {
						world.getBlockTickScheduler().schedule(pos, this, 4);
					} else {
						world.setBlockState(pos, (BlockState) state.cycle(LIT), 2);
					}
				}
			}
		}
	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (!state.get(FORCED)) {
			if ((Boolean) state.get(LIT) && !world.isReceivingRedstonePower(pos)) {
				world.setBlockState(pos, (BlockState) state.cycle(LIT), 2);
			}
		}
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(LIT).add(FORCED);
	}

}
