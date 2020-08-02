package net.ludocrypt.backrooms.dimension;

import net.fabricmc.fabric.api.dimension.v1.EntityPlacer;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;

@SuppressWarnings("deprecation")
public class BackroomsPlacers {

	public static final EntityPlacer LEVEL01 = (oldEntity, destination, portalDir, horizontalOffset,
			verticalOffset) -> {
		return new BlockPattern.TeleportTarget(
				new Vec3d(oldEntity.getX() + ((destination.random.nextInt(100) - 50) * 16) + 3.5, 6,
						oldEntity.getZ() + ((destination.random.nextInt(100) - 50) * 16) + 3.5),
				oldEntity.getVelocity(), (int) oldEntity.yaw);
	};

	public static final EntityPlacer LEVEL2 = (oldEntity, destination, portalDir, horizontalOffset, verticalOffset) -> {
		return new BlockPattern.TeleportTarget(
				new Vec3d(oldEntity.getX() + ((destination.random.nextInt(100) - 10) * 16) + 3.5, 5,
						oldEntity.getZ() + ((destination.random.nextInt(100) - 10) * 16) + 3.5),
				oldEntity.getVelocity(), (int) oldEntity.yaw);
	};

	public static final EntityPlacer LEVEL3 = (oldEntity, destination, portalDir, horizontalOffset, verticalOffset) -> {
		return new BlockPattern.TeleportTarget(
				new Vec3d(oldEntity.getX() + ((destination.random.nextInt(100) - 50) * 16) + 3.5, 4,
						oldEntity.getZ() + ((destination.random.nextInt(100) - 50) * 16) + 3.5),
				oldEntity.getVelocity(), (int) oldEntity.yaw);
	};

	public static final EntityPlacer HOME = (oldEntity, destination, portalDir, horizontalOffset, verticalOffset) -> {
		return new BlockPattern.TeleportTarget(
				new Vec3d(destination.getSpawnPos().getX(),
						destination.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, destination.getSpawnPos().getX(),
								destination.getSpawnPos().getZ()),
						destination.getSpawnPos().getZ()),
				oldEntity.getVelocity(), (int) oldEntity.yaw);
	};
}
