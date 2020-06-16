package net.ludocrypt.backrooms;

import ladysnake.satin.api.event.ShaderEffectRenderCallback;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.fabricmc.api.ClientModInitializer;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.util.Identifier;

public class BackroomsClient implements ClientModInitializer {

	public static boolean phosphorShader = false;
	public static boolean fishEyeShader = false;
	public static boolean largeFishEyeShader = false;
	public static boolean artShader = false;

	private static final ManagedShaderEffect PHOSPHOR = ShaderEffectManager.getInstance()
			.manage(new Identifier("minecraft", "shaders/post/phosphor.json"));
	private static final ManagedShaderEffect ART = ShaderEffectManager.getInstance()
			.manage(new Identifier("minecraft", "shaders/post/art.json"));
	private static final ManagedShaderEffect FISHEYE = ShaderEffectManager.getInstance()
			.manage(Backrooms.id("shaders/post/fish_eye_1.json"));
	private static final ManagedShaderEffect LARGE_FISHEYE = ShaderEffectManager.getInstance()
			.manage(Backrooms.id("shaders/post/fish_eye_2.json"));

	@Override
	public void onInitializeClient() {
		ShaderEffectRenderCallback.EVENT.register(tickDelta -> {
		/*
	 			if (Sanity.getSanity(playerEntity) > 15) {
				BackroomsClient.phosphorShader = false;
				BackroomsClient.fishEyeShader = false;
				BackroomsClient.largeFishEyeShader = false;
				BackroomsClient.artShader = false;
			}
			if (Sanity.getSanity(playerEntity) <= 15 && Sanity.getSanity(playerEntity) > 10) {
				BackroomsClient.phosphorShader = true;
				BackroomsClient.fishEyeShader = false;
				BackroomsClient.largeFishEyeShader = false; 
				BackroomsClient.artShader = false;
			}
			if (Sanity.getSanity(playerEntity) <= 10 && Sanity.getSanity(playerEntity) > 5) {
				BackroomsClient.phosphorShader = true;
				BackroomsClient.fishEyeShader = true;
				BackroomsClient.largeFishEyeShader = false;
				BackroomsClient.artShader = false;
			}
			if (Sanity.getSanity(playerEntity) <= 5 && Sanity.getSanity(playerEntity) >= 0) {
				BackroomsClient.phosphorShader = true;
				BackroomsClient.fishEyeShader = false;
				BackroomsClient.largeFishEyeShader = true;
				BackroomsClient.artShader = false;
			}
			if (Sanity.getSanity(playerEntity) == 0) {
				BackroomsClient.phosphorShader = true;
				BackroomsClient.fishEyeShader = true;
				BackroomsClient.largeFishEyeShader = true;
				BackroomsClient.artShader = true;
			}
		*/
			
			if (BackroomsConfig.getInstance().SanityEffects) {
				if (phosphorShader) {
					PHOSPHOR.render(tickDelta);
				}
				if (fishEyeShader) {
					FISHEYE.render(tickDelta);
				}
				if (largeFishEyeShader) {
					LARGE_FISHEYE.render(tickDelta);
				}
				if (artShader) {
					ART.render(tickDelta);
				}
			}
		});
	}

}
