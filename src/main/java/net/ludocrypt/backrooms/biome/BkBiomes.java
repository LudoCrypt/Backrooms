package net.ludocrypt.backrooms.biome;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.features.LevelsFeatureInit;
import net.ludocrypt.backrooms.misc.BackroomsSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.FeatureConfig;

public abstract class BkBiomes {

	protected static final BlockState WALL = Backrooms.WALL.getDefaultState();

	public static Biome Level0() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 5, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL0ROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL0DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level0")).depth(0F)
				.scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(14402413).waterFogColor(14402413).fogColor(14402413)
						.skyColor(14402413).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL0MUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level0Decrepit() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 5, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL0DECREPITROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL0DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level0"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(14402413).waterFogColor(14402413).fogColor(14402413)
						.skyColor(14402413).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL0WEIGHTEDMUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level0Dotted() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder()).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL0DOTTEDROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL0DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level0"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(14402413).waterFogColor(14402413).fogColor(14402413)
						.skyColor(14402413).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL0MUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level0DottedRed() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder()).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL0DOTTEDREDROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL0DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level0"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(14402413).waterFogColor(14402413).fogColor(-5171911)
						.skyColor(-5171911).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL0WEIGHTEDMUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level0Red() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 4, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL0REDROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL0DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level0"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(14402413).waterFogColor(14402413).fogColor(-5171911)
						.skyColor(-5171911).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL0WEIGHTEDMUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level1() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 4, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 4, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL1ROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL1DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level1"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(-6710887).waterFogColor(-6710887).fogColor(-6710887)
						.skyColor(-6710887).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL1ONMUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level1Off() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 4, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 4, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL1OFFROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL1DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level1"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(-6710887).waterFogColor(-6710887).fogColor(-6710887)
						.skyColor(-6710887).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL1OFFMUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level2() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 2, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.VEX, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL2ROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL2DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level2"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(-6710887).waterFogColor(-6710887).fogColor(-6710887)
						.skyColor(-6710887).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL2MUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level2Long() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 2, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.VEX, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL2LONGROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL2DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level2"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(-6710887).waterFogColor(-6710887).fogColor(-6710887)
						.skyColor(-6710887).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL2LONGMUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level2Messy() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 2, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.VEX, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL2MESSYROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL2DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level2"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(-6710887).waterFogColor(-6710887).fogColor(-6710887)
						.skyColor(-6710887).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL2MESSYMUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

	public static Biome Level3() {
		SpawnSettings spawnSettings = (new SpawnSettings.Builder())
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 2, 0, 2))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.VEX, 2, 0, 3))
				.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOWBALL, 500, 0, 2)).build();
		GenerationSettings.Builder builder = (new GenerationSettings.Builder())
				.surfaceBuilder(ConfiguratedSurfaceBuilders.LEVELBUILDER)
				.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
						LevelsFeatureInit.LEVEL3ROOM.configure(FeatureConfig.DEFAULT)
								.decorate(LevelsFeatureInit.LEVEL3DECORATOR.configure(DecoratorConfig.DEFAULT)));
		return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.valueOf("level3"))
				.depth(0F).scale(0F).temperature(1.0F).downfall(0.0F)
				.effects((new BiomeEffects.Builder()).waterColor(-6710887).waterFogColor(-6710887).fogColor(-6710887)
						.skyColor(-6710887).music(MusicType.createIngameMusic(BackroomsSoundEvents.LEVEL3MUSIC))
						.build())
				.spawnSettings(spawnSettings).generationSettings(builder.build()).build();
	}

}
