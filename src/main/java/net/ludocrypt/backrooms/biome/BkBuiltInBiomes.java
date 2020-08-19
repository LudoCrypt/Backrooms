package net.ludocrypt.backrooms.biome;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public abstract class BkBuiltInBiomes {
	private static final Int2ObjectMap<RegistryKey<Biome>> BY_RAW_ID = new Int2ObjectArrayMap<RegistryKey<Biome>>();

	private static Biome register(int rawId, RegistryKey<Biome> registryKey, Biome biome) {
		BY_RAW_ID.put(rawId, registryKey);
		return (Biome) BuiltinRegistries.set(BuiltinRegistries.BIOME, rawId, registryKey, biome);
	}

	public static RegistryKey<Biome> fromRawId(int rawId) {
		return (RegistryKey<Biome>) BY_RAW_ID.get(rawId);
	}

	static {
		register(672760, BkBiomeKeys.LEVEL0KEY, BkBiomes.Level0());
		register(673760, BkBiomeKeys.LEVEL0DECREPITKEY, BkBiomes.Level0Decrepit());
		register(674760, BkBiomeKeys.LEVEL0DOTTEDKEY, BkBiomes.Level0Dotted());
		register(675760, BkBiomeKeys.LEVEL0DOTTEDREDKEY, BkBiomes.Level0DottedRed());
		register(676760, BkBiomeKeys.LEVEL0REDKEY, BkBiomes.Level0Red());
		register(672761, BkBiomeKeys.LEVEL1KEY, BkBiomes.Level1());
		register(673761, BkBiomeKeys.LEVEL1OFFKEY, BkBiomes.Level1Off());
		
		register(672762, BkBiomeKeys.LEVEL2KEY, BkBiomes.Level2());
		register(673762, BkBiomeKeys.LEVEL2LONGKEY, BkBiomes.Level2Long());
		register(674762, BkBiomeKeys.LEVEL2MESSYKEY, BkBiomes.Level2Messy());
		register(672763, BkBiomeKeys.LEVEL3KEY, BkBiomes.Level3());
	}

	public static void turnOn() {
	}
}
