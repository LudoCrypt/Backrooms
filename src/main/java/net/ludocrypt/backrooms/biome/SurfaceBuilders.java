package net.ludocrypt.backrooms.biome;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class SurfaceBuilders {

	public static final SurfaceBuilder<TernarySurfaceConfig> LEVELBUILDER;

	private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> F register(Identifier id, F surfaceBuilder) {
		return (F) Registry.register(Registry.SURFACE_BUILDER, id, surfaceBuilder);
	}

	static {
		LEVELBUILDER = register(new Identifier("backrooms", "level_builder"),
				new LevelBuilder(TernarySurfaceConfig.CODEC));
	}

	public static void turnOn() {
	}

}
