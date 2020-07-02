package net.ludocrypt.backrooms.dimension;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class Level0DottedDimensionType {
	public static final FabricDimensionType LEVEL0DOTTED = FabricDimensionType.builder()
			 .defaultPlacer((oldEntity, destination, portalDir, horizontalOffset, verticalOffset) ->
			 new BlockPattern.TeleportTarget(new Vec3d(oldEntity.getX(), 2, oldEntity.getZ()), oldEntity.getVelocity().multiply(0), 0))
			.factory(Level0DottedDimension::new).skyLight(true).desiredRawId(6727602)
			.buildAndRegister(new Identifier("backrooms", "level0dotted"));

	public static void register() {
	}
}