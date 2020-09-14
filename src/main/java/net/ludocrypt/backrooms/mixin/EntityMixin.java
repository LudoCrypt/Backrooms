package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.BDimension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

@Mixin(Entity.class)
public class EntityMixin {

	@Inject(method = "getTeleportTarget", at = @At(value = "HEAD"), cancellable = true)
	private void getTeleportTarget(ServerWorld destination, CallbackInfoReturnable<TeleportTarget> ci) {
		Entity entity = ((Entity) (Object) this);
		ServerWorld overworld = entity.getServer().getOverworld();
		ServerWorld lvl0 = entity.getServer().getWorld(BDimension.LEVEL0WORLD);
		ServerWorld lvl1 = entity.getServer().getWorld(BDimension.LEVEL1WORLD);
		ServerWorld lvl2 = entity.getServer().getWorld(BDimension.LEVEL2WORLD);
		ServerWorld lvl3 = entity.getServer().getWorld(BDimension.LEVEL3WORLD);
		if (destination == lvl0 || destination == lvl1 || destination == lvl2 || destination == lvl3) {
			ci.setReturnValue(new TeleportTarget(
					new Vec3d(entity.getX() + ((destination.random.nextInt(120) - 60) * 16) + 3.5, 4,
							entity.getZ() + ((destination.random.nextInt(120) - 60) * 16) + 3.5),
					new Vec3d(0, 0, 0), entity.yaw, entity.pitch));
		} else if ((entity.world == lvl0 || entity.world == lvl1 || entity.world == lvl2 || entity.world == lvl3)
				&& destination == overworld) {
			ci.setReturnValue(new TeleportTarget(new Vec3d(destination.getSpawnPos().getX(),
					destination.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, destination.getSpawnPos().getX(),
							destination.getSpawnPos().getZ()),
					destination.getSpawnPos().getZ()), new Vec3d(0, 0, 0), entity.yaw, entity.pitch));
		}
	}

	@Inject(method = "tick", at = @At(value = "HEAD"))
	private void onEntityTick(CallbackInfo ci) {
		World world = ((Entity) (Object) this).world;
		Entity entity = ((Entity) (Object) this);
		if (entity instanceof PlayerEntity) {
			if (!world.isClient) {
				if (entity.isInsideWall() && entity.world.getRegistryKey() == World.OVERWORLD
						&& !((PlayerEntity) entity).isCreative()) {
					if (Math.random() < 0.75) {
						if (Math.random() < BackroomsConfig.getInstance().SuffocationChance) {
							if (Math.random() < 0.02) {
								entity.moveToWorld(entity.getServer().getWorld(BDimension.LEVEL1WORLD));
							} else if (Math.random() < 0.01) {
								entity.moveToWorld(entity.getServer().getWorld(BDimension.LEVEL2WORLD));
							} else {
								entity.moveToWorld(entity.getServer().getWorld(BDimension.LEVEL0WORLD));
							}
						}
					}
				}

				if (Backrooms.teleportedEntity == (PlayerEntity) entity) {
					if (Math.random() < 0.02) {
						entity.moveToWorld(entity.getServer().getWorld(BDimension.LEVEL1WORLD));
					} else if (Math.random() < 0.01) {
						entity.moveToWorld(entity.getServer().getWorld(BDimension.LEVEL2WORLD));
					} else {
						entity.moveToWorld(entity.getServer().getWorld(BDimension.LEVEL0WORLD));
					}
					Backrooms.teleportedEntity = null;
				}
			}
		}
	}
}
