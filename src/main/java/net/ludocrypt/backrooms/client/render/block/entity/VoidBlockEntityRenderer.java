package net.ludocrypt.backrooms.client.render.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.blocks.entity.VoidBlockEntity;
import net.ludocrypt.backrooms.client.render.EndPortalRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;

@Environment(EnvType.CLIENT)
public class VoidBlockEntityRenderer extends EndPortalRenderer<VoidBlockEntity>
{
	public VoidBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher)
	{
		super(dispatcher);
	}

	@Override
	protected float method_3594()
	{
		// Height of top face
		return 1;
	}
}