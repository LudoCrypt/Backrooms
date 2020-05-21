package net.ludocrypt.backrooms.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Light extends Block {

	public Light() {

		super(FabricBlockSettings.of(Material.GLASS).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.GLASS)
				.hardness(2).resistance(1).lightLevel(10));
	}
}
