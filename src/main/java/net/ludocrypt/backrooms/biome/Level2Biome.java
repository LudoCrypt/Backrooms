package net.ludocrypt.backrooms.biome;

import net.ludocrypt.backrooms.init.BackroomsSurfaces;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class Level2Biome {

	public static Biome create(ConfiguredFeature<?, ?> room, SoundEvent music) {
		SpawnSettings.Builder spawnSettings = (new SpawnSettings.Builder());
		spawnSettings.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 2, 0, 2));
		spawnSettings.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 2, 0, 3));
		spawnSettings.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.VEX, 2, 0, 3));
		spawnSettings.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 0));
		GenerationSettings.Builder builder = (new GenerationSettings.Builder());
		builder.surfaceBuilder(BackroomsSurfaces.CONFIGURED_LEVEL_BUILDER);
		builder.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, room);
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level2")).depth(0.2F).scale(1F).temperature(1.0F).downfall(0.0F).effects((new BiomeEffects.Builder()).waterColor(-6710887).waterFogColor(-6710887).fogColor(-6710887).skyColor(-6710887).music(MusicType.createIngameMusic(music)).build()).spawnSettings(spawnSettings.build()).generationSettings(builder.build()).build();
	}

}
