package net.ludocrypt.backrooms.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

public class Carpet extends Block {
	public static final BooleanProperty MOLDY = BooleanProperty.of("moldy");

	public Carpet() {
		super(FabricBlockSettings.of(Material.WOOL).breakByTool(FabricToolTags.SHEARS).sounds(BlockSoundGroup.WOOL)
				.hardness(1).resistance(2));
		setDefaultState(getStateManager().getDefaultState().with(MOLDY, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(MOLDY);
	}
}
