package net.ludocrypt.backrooms.biome;

import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ConfiguratedSurfaceBuilders {
	private static final BlockState WALL = Backrooms.WALL.getDefaultState();
	public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> LEVELBUILDER;

	private static <SC extends SurfaceConfig> ConfiguredSurfaceBuilder<SC> registerConfigBuilder(Identifier id,
			ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
		return (ConfiguredSurfaceBuilder<SC>) BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, id,
				configuredSurfaceBuilder);
	}

	static {
		LEVELBUILDER = registerConfigBuilder(new Identifier("backrooms", "level_builder"),
				SurfaceBuilders.LEVELBUILDER.method_30478(new TernarySurfaceConfig(WALL, WALL, WALL)));
	}

	public static void turnOn() {
	}
}
