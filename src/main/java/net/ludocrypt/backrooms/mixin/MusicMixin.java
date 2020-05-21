package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.dimension.Level0Dimension;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.sound.MusicTracker.MusicType;
import net.minecraft.client.world.ClientWorld;

@Mixin(MinecraftClient.class)
public class MusicMixin {

	@Shadow
	public ClientPlayerEntity player;
	@Shadow
	public ClientWorld world;

	@Inject(method = "getMusicType", at = @At("HEAD"), cancellable = true)

	private void getMusicType(CallbackInfoReturnable<MusicTracker.MusicType> callbackInfoReturnable) {

		if (this.player == null && Backrooms.Display == true) {
			callbackInfoReturnable.setReturnValue(MusicType.valueOf("BACKROOMSMENU"));

		} else if (this.player == null && Backrooms.Display == false) {
			callbackInfoReturnable.setReturnValue(MusicType.MENU);

		} else if (world != null && this.world.dimension instanceof Level0Dimension) {
			callbackInfoReturnable.setReturnValue(MusicType.valueOf("LEVEL0MUSIC"));
		}
	}
}
