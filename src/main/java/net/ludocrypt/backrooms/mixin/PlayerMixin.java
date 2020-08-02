package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.BDimension;
import net.ludocrypt.backrooms.dimension.BackroomsPlacers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

@SuppressWarnings("deprecation")
@Mixin(PlayerEntity.class)
public class PlayerMixin {

	@Inject(method = "tick", at = @At(value = "HEAD"))
	private void onEntityTick(CallbackInfo ci) {
		World world = ((PlayerEntity) (Object) this).world;
		PlayerEntity playerEntity = ((PlayerEntity) (Object) this);
		if (!world.isClient) {
			if (playerEntity.isInsideWall()
					&& playerEntity.world.getDimensionRegistryKey() == DimensionType.OVERWORLD_REGISTRY_KEY
					&& !playerEntity.isCreative()) {
				if (Math.random() < 0.75) {
					if (Math.random() < BackroomsConfig.getInstance().SuffocationChance) {
						if (Math.random() < 0.02) {
							FabricDimensions.teleport(playerEntity,
									playerEntity.getServer().getWorld(BDimension.LEVEL1WORLD),
									BackroomsPlacers.LEVEL01);
						} else if (Math.random() < 0.01) {
							FabricDimensions.teleport(playerEntity,
									playerEntity.getServer().getWorld(BDimension.LEVEL2WORLD), BackroomsPlacers.LEVEL2);
						} else {
							FabricDimensions.teleport(playerEntity,
									playerEntity.getServer().getWorld(BDimension.LEVEL0WORLD),
									BackroomsPlacers.LEVEL01);
						}
					}
				}
			}
			if (Backrooms.teleportedEntity == playerEntity) {
				if (Math.random() < 0.02) {
					FabricDimensions.teleport(playerEntity, playerEntity.getServer().getWorld(BDimension.LEVEL1WORLD),
							BackroomsPlacers.LEVEL01);
				} else if (Math.random() < 0.01) {
					FabricDimensions.teleport(playerEntity, playerEntity.getServer().getWorld(BDimension.LEVEL2WORLD),
							BackroomsPlacers.LEVEL2);
				} else {
					FabricDimensions.teleport(playerEntity, playerEntity.getServer().getWorld(BDimension.LEVEL0WORLD),
							BackroomsPlacers.LEVEL01);
				}
				Backrooms.teleportedEntity = null;
			}
		}
	}
}