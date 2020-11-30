package net.ludocrypt.backrooms.util;

import java.util.Random;

import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.ludocrypt.backrooms.init.BackroomsSoundEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;

public class SanitySoundEffects {

	public static void sanitySoundEffectsChecker(Camera cam, MinecraftClient client, WorldRenderer worldRenderer, ClientWorld world) {
		int rainTime = worldRenderer.field_20793 == 0 ? 1 : worldRenderer.field_20793;
		long ticks = worldRenderer.ticks;
		Random random = new Random(ticks * cam.hashCode());
		int sanity = ((SanityManagerAccess) client.player).getSanityManager().getSanityLevel();
		if (random.nextInt(3) < rainTime++ && !client.isPaused()) {
			if (sanity < 10) {
				world.playSound(cam.getBlockPos(), BackroomsSoundEvents.RING, SoundCategory.AMBIENT, 0.2F, 1.0F, true);
			}
			if (sanity < 5) {
				world.playSound(cam.getBlockPos(), BackroomsSoundEvents.RING, SoundCategory.AMBIENT, 0.2F, (2 ^ (-13 / 12)), true);
			}
		}
	}

}
