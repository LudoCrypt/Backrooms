package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.init.BackroomsSoundEvents;
import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.Level1;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.MusicSound;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public class MusicMixin {

	@Shadow
	public ClientPlayerEntity player;
	@Shadow
	public ClientWorld world;

	@Inject(method = "getMusicType", at = @At("HEAD"), cancellable = true)
	private void BACKROOMS_getMusicType(CallbackInfoReturnable<MusicSound> ci) {

		if (this.player == null) {
			if (BackroomsConfig.INSTANCE().BackgroundLevel == 0) {
				ci.setReturnValue(BackroomsSoundEvents.LEVEL_0_MENU_SOUND);
			} else if (BackroomsConfig.INSTANCE().BackgroundLevel == 1) {
				ci.setReturnValue(BackroomsSoundEvents.LEVEL_1_MENU_SOUND);
			} else if (BackroomsConfig.INSTANCE().BackgroundLevel == 2) {
				ci.setReturnValue(BackroomsSoundEvents.LEVEL_2_MENU_SOUND);
			} else if (BackroomsConfig.INSTANCE().BackgroundLevel == 3) {
				ci.setReturnValue(BackroomsSoundEvents.LEVEL_3_MENU_SOUND);
			}
		} else {
			if (this.world.getRegistryKey() == Level0.LEVEL_0_WORLD) {
				ci.setReturnValue((MusicSound) this.world.getBiomeAccess().getBiome(this.player.getBlockPos()).getMusic().orElse(BackroomsSoundEvents.LEVEL_0_MUSIC_SOUND));
			} else if (this.world.getRegistryKey() == Level1.LEVEL_1_WORLD) {
				ci.setReturnValue((MusicSound) this.world.getBiomeAccess().getBiome(this.player.getBlockPos()).getMusic().orElse(BackroomsSoundEvents.LEVEL_1_MUSIC_SOUND));
			}
//			else if (this.world.getRegistryKey() == BackroomsWorlds.LEVEL_2_WORLD) {
//
//			} else if (this.world.getRegistryKey() == BackroomsWorlds.LEVEL_3_WORLD) {
//
//			}
		}
	}
}
