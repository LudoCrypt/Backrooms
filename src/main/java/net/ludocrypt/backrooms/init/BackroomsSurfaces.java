package net.ludocrypt.backrooms.init;

import java.util.HashMap;
import java.util.Map;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.surfaces.LevelSurfaceBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

// Contains all of the surface builders and surface configs added by The Backrooms
public class BackroomsSurfaces {
	// Acts as a kind of local registry for surface builders added by The Backrooms
	private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();
	private static final Map<Identifier, ConfiguredSurfaceBuilder<? extends SurfaceConfig>> CONFIGURED_SURFACE_BUILDERS = new HashMap<>();

	/////////////////////
	// SURFACE CONFIGS //
	/////////////////////
	private static final TernarySurfaceConfig LEVEL_BUILDER_CONFIG = new TernarySurfaceConfig(BackroomsBlocks.WALL.getDefaultState(), BackroomsBlocks.WALL.getDefaultState(), BackroomsBlocks.WALL.getDefaultState());

	//////////////////////
	// SURFACE BUILDERS //
	//////////////////////
	public static final SurfaceBuilder<TernarySurfaceConfig> LEVEL_BUILDER = add("level_builder", new LevelSurfaceBuilder());

	public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_LEVEL_BUILDER = add("configured_level_builder", LEVEL_BUILDER.withConfig(LEVEL_BUILDER_CONFIG));

	/**
	 * Adds a surface builder to the Backrooms local registry
	 * 
	 * @param name The path of the surface builder within the The Backrooms
	 *             namespace
	 * @param s    The surface builder to be added to the local registry
	 * @param <S>  The specific class type of the surface builder
	 * @return The surface builder that was registered in the Backrooms local
	 *         surface builder registry
	 */
	private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S s) {
		SURFACE_BUILDERS.put(Backrooms.id(name), s);
		return s;
	}

	private static <SC extends SurfaceConfig> ConfiguredSurfaceBuilder<SC> add(String name, ConfiguredSurfaceBuilder<SC> s) {
		CONFIGURED_SURFACE_BUILDERS.put(Backrooms.id(name), s);
		return s;
	}

	/**
	 * Initializes the surface builders added by The Backrooms
	 */
	public static void init() {
		// Registers all of the surface builders within The Backrooms local registry
		// with the greater surface builder registry
		for (Identifier id : SURFACE_BUILDERS.keySet()) {
			Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
		}
	}
}
