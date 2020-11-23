package net.ludocrypt.backrooms.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.JsonOps;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.mixin.biome.MultiNoiseBiomeSourceAccessor;
import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.Level1;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;

public class NoiseCollisionChecker {
	public static void init() {
		check(Level0.LEVEL_0_BIOME_SOURCE.getBiomeSource(BuiltinRegistries.BIOME, 0L));
		check(Level1.LEVEL_1_BIOME_SOURCE.getBiomeSource(BuiltinRegistries.BIOME, 0L));

		RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register(((i, identifier, biome) -> {
			check(Level0.LEVEL_0_BIOME_SOURCE.getBiomeSource(BuiltinRegistries.BIOME, 0L));
			check(Level1.LEVEL_1_BIOME_SOURCE.getBiomeSource(BuiltinRegistries.BIOME, 0L));
		}));
	}

	private static void check(MultiNoiseBiomeSource biomeSource) {

		List<Pair<Biome.MixedNoisePoint, Supplier<Biome>>> points = ((MultiNoiseBiomeSourceAccessor) biomeSource).getBiomePoints();

		// Build a reverse-map from noise point to Biome
		Map<Biome.MixedNoisePoint, Biome> noisePoints = new HashMap<>();
		for (Pair<Biome.MixedNoisePoint, Supplier<Biome>> point : points) {
			Biome biome = point.getSecond().get();
			Biome.MixedNoisePoint noisePoint = point.getFirst();
			if (biome == null) {
				System.out.println("WARNING: Found null-biome for noise-point " + toString(noisePoint));
				continue;
			}

			Biome prev = noisePoints.put(noisePoint, biome);
			if (prev != null) {
				System.out.println("WARNING: " + biome + " and " + prev + " have the same mixed noise point " + toString(noisePoint) + "! They won't generate properly!!!!");
			}
		}
	}

	private static String toString(Biome.MixedNoisePoint noisePoint) {
		return Biome.MixedNoisePoint.CODEC.encodeStart(JsonOps.INSTANCE, noisePoint).get().left().get().toString();
	}

}
