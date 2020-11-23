package net.ludocrypt.backrooms.util;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class DimensionUtil {

	public static RegistryKey<World> getWorld(Identifier id) {
		return RegistryKey.of(Registry.DIMENSION, id);
	}

	public static RegistryKey<DimensionType> getDimensionType(Identifier id) {
		return RegistryKey.of(Registry.DIMENSION_TYPE_KEY, id);
	}

	public static RegistryKey<DimensionOptions> getDimensionOptions(Identifier id) {
		return RegistryKey.of(Registry.DIMENSION_OPTIONS, id);
	}

}
