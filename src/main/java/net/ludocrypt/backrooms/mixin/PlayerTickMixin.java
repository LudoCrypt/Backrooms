package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.Level0DimensionType;
import net.ludocrypt.backrooms.misc.Sanity;
import net.ludocrypt.backrooms.sound.BackroomsSoundEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
		double sanity = Sanity.sanity(playerEntity);

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
				FabricDimensions.teleport(playerEntity, DimensionType.OVERWORLD,
						Level0DimensionType.LEVEL0.getDefaultPlacement());
				Backrooms.teleported_home = false;
				Backrooms.teleporteduuid = "";
			}
		}

		if (BackroomsConfig.getInstance().SanityEffects) {
			if (sanity <= 15) {
				playerEntity.playSound(BackroomsSoundEvents.TONE, SoundCategory.AMBIENT, (float) 0.5, 1);
				playerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.WEAKNESS, 100)));
			}
			if (sanity <= 10) {
				playerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.NAUSEA, 100)));
			}
		}
	}
}