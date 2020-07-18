package net.ludocrypt.backrooms.dimension;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class BackroomsDimensionTypes {
	public static final FabricDimensionType LEVEL0 = FabricDimensionType.builder()
			.defaultPlacer((oldEntity, destination, portalDir, horizontalOffset,
					verticalOffset) -> new BlockPattern.TeleportTarget(
							new Vec3d(oldEntity.getX() + (destination.random.nextInt(10000) - 5000), 6,
									oldEntity.getZ() + (destination.random.nextInt(10000) - 5000)),
							oldEntity.getVelocity().multiply(0), 0))
			.factory(Level0Dimension::new).skyLight(true).desiredRawId(672760)
			.buildAndRegister(new Identifier("backrooms", "level0"));
	public static final FabricDimensionType LEVEL0DOTTED = FabricDimensionType.builder()
			.defaultPlacer((oldEntity, destination, portalDir, horizontalOffset,
					verticalOffset) -> new BlockPattern.TeleportTarget(
							new Vec3d(oldEntity.getX() + (destination.random.nextInt(10000) - 5000), 6,
									oldEntity.getZ() + (destination.random.nextInt(10000) - 5000)),
							oldEntity.getVelocity().multiply(0), 0))
			.factory(Level0DottedDimension::new).skyLight(true).desiredRawId(6727602)
			.buildAndRegister(new Identifier("backrooms", "level0dotted"));
	public static final FabricDimensionType LEVEL0RED = FabricDimensionType.builder()
			.defaultPlacer((oldEntity, destination, portalDir, horizontalOffset,
					verticalOffset) -> new BlockPattern.TeleportTarget(
							new Vec3d(oldEntity.getX() + (destination.random.nextInt(10000) - 5000), 6,
									oldEntity.getZ() + (destination.random.nextInt(10000) - 5000)),
							oldEntity.getVelocity().multiply(0), 0))
			.factory(Level0RedDimension::new).skyLight(true).desiredRawId(6727601)
			.buildAndRegister(new Identifier("backrooms", "level0red"));
	public static final FabricDimensionType LEVEL1 = FabricDimensionType.builder()
			.defaultPlacer((oldEntity, destination, portalDir, horizontalOffset,
					verticalOffset) -> new BlockPattern.TeleportTarget(
							new Vec3d(oldEntity.getX() + (destination.random.nextInt(10000) - 5000), 6,
									oldEntity.getZ() + (destination.random.nextInt(10000) - 5000)),
							oldEntity.getVelocity().multiply(0), 0))
			.factory(Level1Dimension::new).skyLight(true).desiredRawId(672761)
			.buildAndRegister(new Identifier("backrooms", "level1"));
	public static final FabricDimensionType LEVEL2 = FabricDimensionType.builder()
			.defaultPlacer((oldEntity, destination, portalDir, horizontalOffset,
					verticalOffset) -> new BlockPattern.TeleportTarget(
							new Vec3d(oldEntity.getX() + (destination.random.nextInt(10000) - 5000), 5,
									oldEntity.getZ() + (destination.random.nextInt(10000) - 5000)),
							oldEntity.getVelocity().multiply(0), 0))
			.factory(Level2Dimension::new).skyLight(true).desiredRawId(672762)
			.buildAndRegister(new Identifier("backrooms", "level2"));

	public static void register() {
	}

}
