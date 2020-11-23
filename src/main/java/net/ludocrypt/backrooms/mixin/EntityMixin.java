package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.access.BackroomsWorldAccess;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.util.PlayerUtil;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

@Mixin(Entity.class)
public abstract class EntityMixin {

	@Inject(method = "tick", at = @At(value = "HEAD"))
	private void BACKROOMS_tick(CallbackInfo ci) {
		World world = ((Entity) (Object) this).world;
		Entity entity = ((Entity) (Object) this);
		if (entity instanceof ServerPlayerEntity) {
			ServerPlayerEntity player = (ServerPlayerEntity) entity;
			if (!world.isClient) {
				if (entity.isInsideWall() && world.getRegistryKey() == World.OVERWORLD && !((ServerPlayerEntity) entity).isCreative()) {
					if (world.random.nextDouble() < BackroomsConfig.INSTANCE().SuffocationChance) {
						ServerWorld serverWorld = world.getServer().getWorld(world.getRegistryKey());
						PlayerUtil.teleportToLevel(((BackroomsWorldAccess)serverWorld).calculateNextLevel(null), player, null);
					}
				}
			}
		}
	}
}
