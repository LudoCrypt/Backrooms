package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.BackroomsDimensionTypes;
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
			if (playerEntity.isInsideWall() && playerEntity.dimension == DimensionType.OVERWORLD
					&& !playerEntity.isCreative()) {
				if (Math.random() < 0.75) {
					if (Math.random() < BackroomsConfig.getInstance().SuffocationChance) {
						Backrooms.teleportPlayer(playerEntity, BackroomsDimensionTypes.LEVEL0);
					}
				}
			}
			if (Backrooms.teleportedEntity == playerEntity) {
				Backrooms.teleportPlayer(playerEntity, BackroomsDimensionTypes.LEVEL0);
				Backrooms.teleportedEntity = null;
			}
		}
	}

}