package net.ludocrypt.backrooms.dimension;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class Level0RedDimensionType {
	public static final FabricDimensionType LEVEL0RED = FabricDimensionType.builder()
			 .defaultPlacer((oldEntity, destination, portalDir, horizontalOffset, verticalOffset) ->
			 new BlockPattern.TeleportTarget(new Vec3d(oldEntity.getX(), 2, oldEntity.getZ()), oldEntity.getVelocity().multiply(0), 0))
			.factory(Level0RedDimension::new).skyLight(true).desiredRawId(672761)
			.buildAndRegister(new Identifier("backrooms", "level0red"));

	public static void register() {
	}
}