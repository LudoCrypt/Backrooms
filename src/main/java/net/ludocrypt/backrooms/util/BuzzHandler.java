package net.ludocrypt.backrooms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.ludocrypt.backrooms.blocks.LightBlock;
import net.ludocrypt.backrooms.client.BackroomsSoundEvents;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.Level1;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class BuzzHandler {

	public static void buzzCheckingAndRunning(Camera cam, MinecraftClient client, WorldRenderer worldRenderer, ClientWorld world) {
		int rainTime = worldRenderer.field_20793 == 0 ? 1 : worldRenderer.field_20793;
		long ticks = worldRenderer.ticks;
		BlockPos playerPos = cam.getBlockPos();
		int radius = BackroomsConfig.INSTANCE().SearchRange;
		Random random = new Random(ticks * cam.hashCode());

		boolean play_buzz;
		boolean play_vent;

		List<Boolean> buzzList = new ArrayList<Boolean>();
		List<Boolean> ventList = new ArrayList<Boolean>();

		for (double x = playerPos.getX() - radius; x <= playerPos.getX() + radius; x++) {
			for (double y = playerPos.getY() - radius; y <= playerPos.getY() + radius; y++) {
				for (double z = playerPos.getZ() - radius; z <= playerPos.getZ() + radius; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					if (world.getBlockState(pos).isOf(BackroomsBlocks.LIGHT) && world.getBlockState(pos).get(LightBlock.LIT)) {
						buzzList.add(true);
					}
					if (world.getBlockState(pos).isOf(BackroomsBlocks.VENT)) {
						ventList.add(true);
					}
				}
			}
		}
		play_buzz = buzzList.size() > 1;
		play_vent = ventList.size() > 1;
		if (random.nextInt(3) < rainTime++ && !client.isPaused()) {
			float i = 1;

			if (client.musicTracker.current != null) {
				i = (float) BackroomsConfig.INSTANCE().AmbientMultiplierWhenMusic;
			}

			if (play_buzz) {
				if (client.player.isSubmergedInWater()) {
					world.playSound(cam.getBlockPos(), BackroomsSoundEvents.BUZZ_BACKGROUND, SoundCategory.AMBIENT, 0.1F * i, 1.0F, true);
				} else {
					world.playSound(cam.getBlockPos(), BackroomsSoundEvents.BUZZ, SoundCategory.AMBIENT, 0.1F * i, 1.0F, true);
				}
			}

			if (play_vent) {
				world.playSound(cam.getBlockPos(), BackroomsSoundEvents.VENT, SoundCategory.AMBIENT, 0.25F * i, 1.0F, true);
			}

			if (world.getRegistryKey() == Level0.LEVEL_0_WORLD || world.getRegistryKey() == Level1.LEVEL_1_WORLD) {
				if (play_buzz) {
					world.playSound(cam.getBlockPos(), BackroomsSoundEvents.BUZZ_BACKGROUND, SoundCategory.AMBIENT, 0.02F * i, 0.5F, true);
				} else {
					world.playSound(cam.getBlockPos(), BackroomsSoundEvents.BUZZ_BACKGROUND, SoundCategory.AMBIENT, 0.05F * i, 0.5F, true);
				}
			}
		}
	}

}
