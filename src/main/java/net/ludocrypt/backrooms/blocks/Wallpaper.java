package net.ludocrypt.backrooms.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.dimension.Level0DottedDimension;
import net.ludocrypt.backrooms.dimension.Level0RedDimension;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Wallpaper extends Block {
	public static final BooleanProperty RED = BooleanProperty.of("red");
	public static final BooleanProperty DOTTED = BooleanProperty.of("dotted");

	public Wallpaper() {

		super(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)
				.hardness(3).resistance(3));
		setDefaultState(getStateManager().getDefaultState().with(RED, false).with(DOTTED, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(RED);
		stateManager.add(DOTTED);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		if (world.dimension instanceof Level0RedDimension)
			world.setBlockState(pos, Backrooms.WALLPAPER.getDefaultState().with(RED, true));
		if (world.dimension instanceof Level0DottedDimension)
			world.setBlockState(pos, Backrooms.WALLPAPER.getDefaultState().with(DOTTED, true));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		if (player.isInSneakingPose()) {
			world.setBlockState(pos, Backrooms.WALLPAPER.getDefaultState().cycle(DOTTED));
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.PASS;
		}
	}

}
