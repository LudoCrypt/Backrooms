package net.ludocrypt.backrooms;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.ludocrypt.backrooms.client.render.block.entity.VoidBlockEntityRenderer;
import net.ludocrypt.backrooms.misc.BuzzHandler;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class BackroomsClient implements ClientModInitializer {
	// variables
	public static boolean Display = false;
	public static int DisplayLevel = 0;

	private static Map<Item, RenderLayer> itemRenderLayerMap = new HashMap<Item, RenderLayer>();

	@Override
	public void onInitializeClient() {
		registerBlockEntityRenderer("void_block", VoidBlockEntityRenderer::new);
		ClientTickEvents.START_CLIENT_TICK.register(BackroomsClient::clientTickEvent);

	}

	public static void putItemRenderLayer(Item item, RenderLayer layer) {
		itemRenderLayerMap.put(item, layer);
	}

	public static RenderLayer getItemRenderLayer(Item item) {
		return itemRenderLayerMap.get(item);
	}

	@SuppressWarnings("unchecked")
	private <E extends BlockEntity> void registerBlockEntityRenderer(String identifier,
			Function<BlockEntityRenderDispatcher, BlockEntityRenderer<E>> blockEntityRenderer) {
		BlockEntityRendererRegistry.INSTANCE.register(
				(BlockEntityType<E>) Registry.BLOCK_ENTITY_TYPE.get(Backrooms.getId(identifier)), blockEntityRenderer);
	}

	public static void clientTickEvent(MinecraftClient minecraft) {
		if (minecraft.world != null) {
			BuzzHandler.buzzCheckingAndRunning(minecraft.gameRenderer.getCamera(), minecraft, minecraft.worldRenderer,
					minecraft.world);
		}
	}

}
