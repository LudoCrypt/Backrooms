package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.dimension.Level0DimensionType;
import net.ludocrypt.backrooms.sound.BackroomsSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

@Mixin(PlayerEntity.class)
public class PlayerTickMixin {
	@Inject(method = "tick", at = @At(value = "HEAD"))
	private void onEntityTick(CallbackInfo ci) {
		World world = ((PlayerEntity) (Object) this).world;
		PlayerEntity playerEntity = ((PlayerEntity) (Object) this);
		
		if (!world.isClient && Backrooms.teleported) {
			if (playerEntity.getUuidAsString() == Backrooms.teleporteduuid) {
				playerEntity.removeAllPassengers();
				playerEntity.stopRiding();
				playerEntity.changeDimension(Level0DimensionType.LEVEL0);
				Backrooms.teleported = false;
				Backrooms.teleporteduuid = "";
			}
		}
		if (!world.isClient && Backrooms.teleported_home) {
			if (playerEntity.getUuidAsString() == Backrooms.teleporteduuid) {
				playerEntity.removeAllPassengers();
				playerEntity.stopRiding();
				playerEntity.changeDimension(DimensionType.OVERWORLD);
				Backrooms.teleported_home = false;
				Backrooms.teleporteduuid = "";
			}
		}
		if (playerEntity.dimension == Level0DimensionType.LEVEL0 && Math.random() < 0.001) {
			playerEntity.playSound(BackroomsSoundEvents.AMBIENT, SoundCategory.AMBIENT, (float) 0.2, 1);
		}
	}
}