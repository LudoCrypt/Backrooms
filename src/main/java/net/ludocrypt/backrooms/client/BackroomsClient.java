package net.ludocrypt.backrooms.client;

import ladysnake.satin.api.event.ShaderEffectRenderCallback;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.ludocrypt.backrooms.network.SanityUpdateS2CPacket;
import net.ludocrypt.backrooms.sanity.SanityManager;
import net.ludocrypt.backrooms.util.BuzzHandler;
import net.ludocrypt.backrooms.util.SanitySoundEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class BackroomsClient implements ClientModInitializer {

	private static final ManagedShaderEffect FISH_EYE_1 = ShaderEffectManager.getInstance().manage(Backrooms.id("shaders/post/fish_eye_1.json"));
	private static final ManagedShaderEffect FISH_EYE_2 = ShaderEffectManager.getInstance().manage(Backrooms.id("shaders/post/fish_eye_2.json"));
	private static final ManagedShaderEffect PHOSPHOR = ShaderEffectManager.getInstance().manage(new Identifier("shaders/post/phosphor.json"));
	private static final ManagedShaderEffect DECONVERGE = ShaderEffectManager.getInstance().manage(new Identifier("shaders/post/deconverge.json"));
	private static final ManagedShaderEffect BLOBS2 = ShaderEffectManager.getInstance().manage(new Identifier("shaders/post/blobs2.json"));
	private static final ManagedShaderEffect ART = ShaderEffectManager.getInstance().manage(new Identifier("shaders/post/art.json"));

	private final MinecraftClient client = MinecraftClient.getInstance();

	@Override
	public void onInitializeClient() {

		BackroomsSoundEvents.init();
		SanityUpdateS2CPacket.init();
		BlockEntityRendererRegistry.INSTANCE.register(BackroomsBlocks.VOID_BLOCK_ENTITY, VoidBlockEntityRenderer::new);
		ClientTickEvents.START_CLIENT_TICK.register(BackroomsClient::clientTickEvent);

		ShaderEffectRenderCallback.EVENT.register(tickDelta -> {
			if (BackroomsConfig.INSTANCE().SanityEffects) {
				SanityManager sanityManager = ((SanityManagerAccess) client.player).getSanityManager();
				if (sanityManager.getSanityLevel() < 20) {
					DECONVERGE.render(tickDelta);
				}
				if (sanityManager.getSanityLevel() < 15) {
					PHOSPHOR.render(tickDelta);
				}
				if ((sanityManager.getSanityLevel() < 10 && sanityManager.getSanityLevel() >= 5) || sanityManager.getSanityLevel() < 2) {
					FISH_EYE_1.render(tickDelta);
				}
				if (sanityManager.getSanityLevel() < 5) {
					FISH_EYE_2.render(tickDelta);
				}
				if (sanityManager.getSanityLevel() < 1) {
					BLOBS2.render(tickDelta);
					ART.render(tickDelta);
				}
			}
		});

	}

	public static void clientTickEvent(MinecraftClient minecraft) {
		if (minecraft.world != null) {
			BuzzHandler.buzzCheckingAndRunning(minecraft.gameRenderer.getCamera(), minecraft, minecraft.worldRenderer, minecraft.world);
			SanitySoundEffects.sanitySoundEffectsChecker(minecraft.gameRenderer.getCamera(), minecraft, minecraft.worldRenderer, minecraft.world);
		}
	}
}
