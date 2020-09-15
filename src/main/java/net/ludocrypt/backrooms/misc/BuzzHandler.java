package net.ludocrypt.backrooms.misc;

import java.util.Random;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Light;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.BDimension;
import net.ludocrypt.backrooms.mixin.WorldAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;

public class BuzzHandler {

	public static void buzzCheckingAndRunning(Camera cam, MinecraftClient client, WorldRenderer worldRenderer,
			ClientWorld world) {
		int rainTime = ((WorldAccessor) worldRenderer).rainSoundTime() == 0 ? 1
				: ((WorldAccessor) worldRenderer).rainSoundTime();
		long ticks = ((WorldAccessor) worldRenderer).ticks();
		BlockPos playerPos = cam.getBlockPos();
		int radius = BackroomsConfig.getInstance().SearchRange;
		Random random = new Random(ticks * 312987231L);

		int numOfLight = 0;
		BlockPos posOfLight = null;
		int numOfVent = 0;
		BlockPos posOfVent = null;
		for (double x = playerPos.getX() - radius; x <= playerPos.getX() + radius; x++) {
			for (double y = playerPos.getY() - radius; y <= playerPos.getY() + radius; y++) {
				for (double z = playerPos.getZ() - radius; z <= playerPos.getZ() + radius; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					if (world.getBlockState(pos) == Backrooms.LIGHT.getDefaultState().with(Light.ON, true)) {
						numOfLight = numOfLight + 1;
						if (numOfLight == 1) {
							posOfLight = pos;
						}
					}
					if (world.getBlockState(pos).getBlock() == Backrooms.VENT) {
						numOfVent = numOfVent + 1;
						if (numOfVent == 1) {
							posOfVent = pos;
						}
					}
				}
			}
		}
		if (random.nextInt(3) < rainTime++ && !client.isPaused()) {
			rainTime = 0;
			SoundEvent buzz = BackroomsSoundEvents.HUMM_BUZZ;
			if (client.player.isSubmergedInWater()) {
				buzz = BackroomsSoundEvents.HUMM_BUZZ_AROUND;
			} else {
				buzz = BackroomsSoundEvents.HUMM_BUZZ;
			}
			if (numOfLight > 1) {
				world.playSound(cam.getBlockPos(), buzz, SoundCategory.AMBIENT, 0.1F, 1.0F, false);
			} else if (numOfLight == 1 && posOfLight != null) {
				world.playSound(posOfLight, buzz, SoundCategory.AMBIENT, 0.1F, 1.0F, false);
			}
			if (numOfVent > 1) {
				world.playSound(cam.getBlockPos(), BackroomsSoundEvents.VENT, SoundCategory.AMBIENT, 0.25F, 1.0F,
						false);
			} else if (numOfVent == 1 && posOfVent != null) {
				world.playSound(posOfVent, BackroomsSoundEvents.VENT, SoundCategory.AMBIENT, 0.25F, 1.0F, false);
			}
			if ((world.getRegistryKey() == BDimension.LEVEL0WORLD || world.getRegistryKey() == BDimension.LEVEL1WORLD)
					&& numOfLight == 0) {
				world.playSound(cam.getBlockPos(), BackroomsSoundEvents.HUMM_BUZZ_AROUND, SoundCategory.AMBIENT, 0.05F,
						0.8F, false);
			}
		}
	}

}
