package net.ludocrypt.backrooms.dimension;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class Level0DimensionType {
	public static final FabricDimensionType LEVEL0 = FabricDimensionType.builder()
			 .defaultPlacer((oldEntity, destination, portalDir, horizontalOffset, verticalOffset) ->
			 new BlockPattern.TeleportTarget(new Vec3d(oldEntity.getX(), 2, oldEntity.getZ()), oldEntity.getVelocity().multiply(0), 0))
			.factory(Level0Dimension::new).skyLight(true).desiredRawId(672760)
			.buildAndRegister(new Identifier("backrooms", "level0"));

	public static void register() {
	}
}