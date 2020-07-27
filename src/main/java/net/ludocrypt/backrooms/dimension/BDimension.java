package net.ludocrypt.backrooms.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class BDimension {
	public static final RegistryKey<DimensionType> LEVEL0 = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
			new Identifier("backrooms", "level_0"));
	public static final RegistryKey<World> LEVEL0WORLD = RegistryKey.of(Registry.DIMENSION,
			new Identifier("backrooms", "level_0"));

	public static final RegistryKey<DimensionType> LEVEL0RED = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
			new Identifier("backrooms", "level_0_red"));
	public static final RegistryKey<World> LEVEL0REDWORLD = RegistryKey.of(Registry.DIMENSION,
			new Identifier("backrooms", "level_0_red"));

	public static final RegistryKey<DimensionType> LEVEL0DOTTED = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
			new Identifier("backrooms", "level_0_dotted"));
	public static final RegistryKey<World> LEVEL0DOTTEDWORLD = RegistryKey.of(Registry.DIMENSION,
			new Identifier("backrooms", "level_0_dotted"));

	public static final RegistryKey<DimensionType> LEVEL1 = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
			new Identifier("backrooms", "level_1"));
	public static final RegistryKey<World> LEVEL1WORLD = RegistryKey.of(Registry.DIMENSION,
			new Identifier("backrooms", "level_1"));

	public static final RegistryKey<DimensionType> LEVEL2 = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
			new Identifier("backrooms", "level_2"));
	public static final RegistryKey<World> LEVEL2WORLD = RegistryKey.of(Registry.DIMENSION,
			new Identifier("backrooms", "level_2"));

	public static final RegistryKey<DimensionType> LEVEL3 = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
			new Identifier("backrooms", "level_3"));
	public static final RegistryKey<World> LEVEL3WORLD = RegistryKey.of(Registry.DIMENSION,
			new Identifier("backrooms", "level_3"));


	public static void register() {
	}
}
