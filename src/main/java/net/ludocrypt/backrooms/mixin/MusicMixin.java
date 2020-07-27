package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.dimension.BDimension;
import net.ludocrypt.backrooms.misc.BackroomsMusicType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.MusicType;
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

	private void getMusicType(CallbackInfoReturnable<MusicSound> callbackInfoReturnable) {
		if (this.player == null && Backrooms.Display == true && Backrooms.DisplayLevel == 0) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL0MENU);
		} else if (this.player == null && Backrooms.Display == true && Backrooms.DisplayLevel == 1) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL1MENU);
		} else if (this.player == null && Backrooms.Display == true && Backrooms.DisplayLevel == 2) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL2MENU);
		} else if (this.player == null && Backrooms.Display == true && Backrooms.DisplayLevel == 3) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL3MENU);
		} else if (this.player == null && Backrooms.Display == false) {
			callbackInfoReturnable.setReturnValue(MusicType.MENU);
		} else if (world != null && this.world.getDimensionRegistryKey() == BDimension.LEVEL0
				|| world != null && this.world.getDimensionRegistryKey() == BDimension.LEVEL0DOTTED
				|| world != null && this.world.getDimensionRegistryKey() == BDimension.LEVEL0RED) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL0MUSIC);
		} else if (world != null && this.world.getDimensionRegistryKey() == BDimension.LEVEL1) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL1MUSIC);
		} else if (world != null && this.world.getDimensionRegistryKey() == BDimension.LEVEL2) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL2MUSIC);
		} else if (world != null && this.world.getDimensionRegistryKey() == BDimension.LEVEL3) {
			callbackInfoReturnable.setReturnValue(BackroomsMusicType.LEVEL3MUSIC);
		}
	}
}
