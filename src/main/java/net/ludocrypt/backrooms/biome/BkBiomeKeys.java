package net.ludocrypt.backrooms.biome;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public abstract class BkBiomeKeys {

	public static final RegistryKey<Biome> LEVEL0KEY = register(new Identifier("backrooms", "level0"));
	public static final RegistryKey<Biome> LEVEL0DECREPITKEY = register(new Identifier("backrooms", "level0decrepit"));
	public static final RegistryKey<Biome> LEVEL0DOTTEDKEY = register(new Identifier("backrooms", "level0dotted"));
	public static final RegistryKey<Biome> LEVEL0DOTTEDREDKEY = register(new Identifier("backrooms", "level0dottedred"));
	public static final RegistryKey<Biome> LEVEL0REDKEY = register(new Identifier("backrooms", "level0red"));
	public static final RegistryKey<Biome> LEVEL1KEY = register(new Identifier("backrooms", "level1"));
	public static final RegistryKey<Biome> LEVEL1OFFKEY = register(new Identifier("backrooms", "level1off"));
	public static final RegistryKey<Biome> LEVEL2KEY = register(new Identifier("backrooms", "level2"));
	public static final RegistryKey<Biome> LEVEL2LONGKEY = register(new Identifier("backrooms", "level2long"));
	public static final RegistryKey<Biome> LEVEL2MESSYKEY = register(new Identifier("backrooms", "level2messy"));
	public static final RegistryKey<Biome> LEVEL3KEY = register(new Identifier("backrooms", "level3"));

	private static RegistryKey<Biome> register(Identifier id) {
		return RegistryKey.of(Registry.BIOME_KEY, id);
	}

	public static void turnOn() {
	}
}
