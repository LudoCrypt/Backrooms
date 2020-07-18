package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.client.render.EndPortalRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
@Mixin(BuiltinModelItemRenderer.class)
public class BuiltinModelItemRendererMixin
{
	private static final Item END_PORTAL_ITEM = Registry.ITEM.get(Backrooms.getId("void_block"));

	@Inject(method = "render", at = @At("HEAD"), cancellable = true)
	private void render(ItemStack itemStack, MatrixStack matrix, VertexConsumerProvider vertexConsumerProvider, int light, int overlay, CallbackInfo callbackInfo)
	{
		if(itemStack.getItem() == END_PORTAL_ITEM)
		{
			EndPortalRenderer.renderInHand(matrix, vertexConsumerProvider, 0);
			callbackInfo.cancel();
		}
	}
}
