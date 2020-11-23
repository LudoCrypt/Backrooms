package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.access.BackroomsWorldAccess;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.util.PlayerUtil;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

@Mixin(EnderPearlEntity.class)
public class EnderpearlMixin {

	@Inject(method = "onCollision", at = @At(value = "TAIL"), cancellable = true)
	private void BACKROOMS_onPearlHit(HitResult hitResult, CallbackInfo ci) {
		EnderPearlEntity pearlEntity = ((EnderPearlEntity) (Object) this);
		World world = pearlEntity.world;
		if ((!world.isClient && pearlEntity.getOwner() instanceof ServerPlayerEntity)) {
			ServerPlayerEntity playerEntity = (ServerPlayerEntity) pearlEntity.getOwner();
			if (world.random.nextDouble() < (BackroomsConfig.INSTANCE().EnderPearlChance)) {
				if ((world.getRegistryKey() == World.OVERWORLD)) {
					ci.cancel();
					pearlEntity.kill();
					ServerWorld serverWorld = world.getServer().getWorld(world.getRegistryKey());
					PlayerUtil.teleportToLevel(((BackroomsWorldAccess) serverWorld).calculateNextLevel(null), playerEntity, null);
				}
			}
		}
	}
}
