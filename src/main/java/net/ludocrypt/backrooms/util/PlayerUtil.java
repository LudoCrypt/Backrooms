package net.ludocrypt.backrooms.util;

import java.util.Iterator;
import java.util.Random;

import javax.annotation.Nullable;

import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.Level1;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

public class PlayerUtil {

	public static void grantAdvancement(PlayerEntity player, Identifier id) {
		if (player instanceof ServerPlayerEntity) {
			Advancement adv = ((ServerPlayerEntity) player).server.getAdvancementLoader().get(id);
			AdvancementProgress advp = ((ServerPlayerEntity) player).getAdvancementTracker().getProgress(adv);
			if (!advp.isDone()) {
				Iterator<String> itr = advp.getUnobtainedCriteria().iterator();
				while (itr.hasNext()) {
					String crit = itr.next();
					((ServerPlayerEntity) player).getAdvancementTracker().grantCriterion(adv, crit);
				}
			}
		}
	}

	public static void teleportToLevel(RegistryKey<World> nonServerWorld, ServerPlayerEntity entity, @Nullable Random rand) {

		ServerWorld world = entity.getServer().getWorld(nonServerWorld);

		if (rand == null) {
			rand = world.getRandom();
		}

		int newX = (rand.nextInt(25) * 16) + rand.nextInt(16);
		int newZ = (rand.nextInt(25) * 16) + rand.nextInt(16);
		int newY = 9;

		BlockPos.Mutable mutBlockPos = new BlockPos(newX, newY, newZ).mutableCopy().move(Direction.DOWN);
		while (!world.isAir(mutBlockPos) && world.getBlockState(mutBlockPos) != null) {
			mutBlockPos.move(Direction.SOUTH).move(Direction.EAST);
			if (world.isAir(mutBlockPos.up()) && !world.isAir(mutBlockPos)) {
				mutBlockPos.move(Direction.UP);
			}
		}

		entity.teleport(world, mutBlockPos.getX() + 0.5, mutBlockPos.getY(), mutBlockPos.getZ() + 0.5, entity.yaw, entity.pitch);
	}

	public static void teleportEntityToOverworld(ServerPlayerEntity entity) {
		ServerWorld destination = entity.getServer().getWorld(World.OVERWORLD);
		TeleportTarget destinationTarget = new TeleportTarget(new Vec3d(destination.getSpawnPos().getX(), destination.getSpawnPos().getY(), destination.getSpawnPos().getZ()), entity.getVelocity(), entity.yaw, entity.pitch);
		entity.teleport(destination, destinationTarget.position.getX(), destinationTarget.position.getY(), destinationTarget.position.getZ(), entity.yaw, entity.pitch);
	}

	public static boolean isSanityDrainableWorld(World world) {
		return world.getRegistryKey() == Level0.LEVEL_0_WORLD || world.getRegistryKey() == Level1.LEVEL_1_WORLD;
	}

}
