package net.ludocrypt.backrooms.dimension;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class Level1DimensionType {
	public static final FabricDimensionType LEVEL1 = FabricDimensionType.builder()
			 .defaultPlacer((oldEntity, destination, portalDir, horizontalOffset, verticalOffset) ->
			 new BlockPattern.TeleportTarget(new Vec3d(oldEntity.getX(), 2, oldEntity.getZ()), oldEntity.getVelocity().multiply(0), 0))
			.factory(Level1Dimension::new).skyLight(true).desiredRawId(672761)
			.buildAndRegister(new Identifier("backrooms", "level1"));

	public static void register() {
	}
}