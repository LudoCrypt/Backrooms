package net.ludocrypt.backrooms.blocks;

import java.util.function.ToIntFunction;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

public class Light extends Block {
	public static final BooleanProperty ON = BooleanProperty.of("on");

	public Light() {

		super(FabricBlockSettings.of(Material.GLASS).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.GLASS)
				.hardness(2).resistance(1).lightLevel(createLightLevelFromBlockState(15)));
		setDefaultState(getStateManager().getDefaultState().with(ON, true));
	}

	private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
		return (blockState) -> {
			return (Boolean) blockState.get(Light.ON) ? litLevel : 0;
		};
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(ON);
	}

}
