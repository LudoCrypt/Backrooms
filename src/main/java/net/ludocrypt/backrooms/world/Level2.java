package net.ludocrypt.backrooms.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.mixin.DimensionTypeAccessor;
import net.ludocrypt.backrooms.mixin.MultiNoiseBiomeSourceAccessor;
import net.ludocrypt.backrooms.util.DimensionUtil;
import net.ludocrypt.backrooms.world.chunk.BasicMazeChunkGenerator;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import net.minecraft.world.biome.source.VoronoiBiomeAccessType;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

public class Level2 {

	public static final RegistryKey<World> LEVEL_2_WORLD = DimensionUtil.getWorld(Backrooms.id("level_2"));
	public static final RegistryKey<DimensionType> LEVEL_2_REGISTRY_KEY = DimensionUtil.getDimensionType(Backrooms.id("level_2"));
	public static final RegistryKey<DimensionOptions> LEVEL_2_DIMENSION_OPTIONS = DimensionUtil.getDimensionOptions(Backrooms.id("level_2"));
	public static final DimensionType LEVEL_2 = DimensionTypeAccessor.createDimensionType(OptionalLong.empty(), true, false, false, false, 2.0D, false, false, false, false, false, 256, VoronoiBiomeAccessType.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getId(), DimensionType.OVERWORLD_ID, 0.0F);

	private static final Map<RegistryKey<Biome>, Biome.MixedNoisePoint> LEVEL_2_BIOME_NOISE_POINTS = new HashMap<>();

	public static void addLevel2Biome(RegistryKey<Biome> biome, Biome.MixedNoisePoint noise) {
		LEVEL_2_BIOME_NOISE_POINTS.put(biome, noise);
	}

	public static Map<RegistryKey<Biome>, Biome.MixedNoisePoint> getLevel2BiomeNoisePoints() {
		return LEVEL_2_BIOME_NOISE_POINTS;
	}

	public static final MultiNoiseBiomeSource.Preset LEVEL_2_BIOME_SOURCE = new MultiNoiseBiomeSource.Preset(Backrooms.id("level_2_biome_source"), (preset, registry, long_) -> {

		List<Pair<Biome.MixedNoisePoint, Supplier<Biome>>> biomes = new ArrayList<>();

		getLevel2BiomeNoisePoints().forEach((biomeKey, noisePoint) -> {
			Biome biome = registry.getOrThrow(biomeKey);
			biomes.add(Pair.of(noisePoint, () -> biome));
		});

		return MultiNoiseBiomeSourceAccessor.createMultiNoiseBiomeSource(long_, biomes, Optional.of(Pair.of(registry, preset)));
	});

	public static ChunkGenerator createLevel2Generator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
		return new BasicMazeChunkGenerator(LEVEL_2_BIOME_SOURCE.getBiomeSource(biomeRegistry, seed), seed);
	}

}
