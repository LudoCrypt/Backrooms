package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.Level0DimensionType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

@Mixin(PlayerEntity.class)
public class PlayerMixin {

	@Inject(method = "tick", at = @At(value = "HEAD"))
	private void onEntityTick(CallbackInfo ci) {
		World world = ((PlayerEntity) (Object) this).world;
		PlayerEntity playerEntity = ((PlayerEntity) (Object) this);
		if (!world.isClient) {
			if (playerEntity.isInsideWall() && playerEntity.dimension == DimensionType.OVERWORLD && !playerEntity.isCreative()) {
				if (Math.random() < 0.75) {
					if (Math.random() < BackroomsConfig.getInstance().SuffocationChance) {
						Backrooms.teleported = true;
						Backrooms.teleporteduuid = playerEntity.getUuidAsString();
					}
				}

			}
			if (Backrooms.teleported) {
				if (playerEntity.getUuidAsString() == Backrooms.teleporteduuid) {
					playerEntity.removeAllPassengers();
					playerEntity.stopRiding();
					playerEntity.changeDimension(Level0DimensionType.LEVEL0);
					Backrooms.teleported = false;
					Backrooms.teleporteduuid = "";
				}
			}
			if (Backrooms.teleported_home) {
				if (playerEntity.getUuidAsString() == Backrooms.teleporteduuid) {
					playerEntity.removeAllPassengers();
					playerEntity.stopRiding();
					FabricDimensions.teleport(playerEntity, DimensionType.OVERWORLD,
							Level0DimensionType.LEVEL0.getDefaultPlacement());
					Backrooms.teleported_home = false;
					Backrooms.teleporteduuid = "";
				}
			}
		}
	}
}