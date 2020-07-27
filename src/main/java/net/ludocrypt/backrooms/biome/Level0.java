package net.ludocrypt.backrooms.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.features.LevelsFeatureInit;
import net.ludocrypt.backrooms.features.decorators.Level0RoomDecorator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class Level0 extends Biome {
	protected static final BlockState WALL = Backrooms.WALL.getDefaultState();
	public static final Decorator<NopeDecoratorConfig> LEVEL0PLACER = new Level0RoomDecorator(
			NopeDecoratorConfig.field_24891);

	public Level0() {

		super(new Biome.Settings()
				.configureSurfaceBuilder(new LevelSurfaceBuilder(TernarySurfaceConfig.CODEC),
						new TernarySurfaceConfig(WALL, WALL, WALL))
				.precipitation(Biome.Precipitation.NONE).category(Biome.Category.NONE).depth(0F).scale(0F)
				.temperature(1.0F).downfall(0F).effects(new BiomeEffects.Builder().waterColor(14402413)
						.waterFogColor(14402413).fogColor(14402413).build()));

		this.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES,
				LevelsFeatureInit.LEVEL0ROOM.configure(FeatureConfig.DEFAULT)
						.createDecoratedFeature(LEVEL0PLACER.configure(DecoratorConfig.DEFAULT)));
		
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMAN, 50, 2, 5));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMITE, 10, 3, 8));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.SILVERFISH, 50, 0, 2));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ZOMBIE, 50, 4, 12));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMAN, 50, 2, 5));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMITE, 10, 3, 8));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.SILVERFISH, 50, 0, 2));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ZOMBIE, 50, 4, 12));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMAN, 50, 2, 5));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMITE, 10, 3, 8));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.SILVERFISH, 50, 0, 2));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ZOMBIE, 50, 4, 12));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMAN, 50, 2, 5));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMITE, 10, 3, 8));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.SILVERFISH, 50, 0, 2));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ZOMBIE, 50, 4, 12));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMAN, 50, 2, 5));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ENDERMITE, 10, 3, 8));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.SILVERFISH, 50, 0, 2));
		this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnEntry(EntityType.ZOMBIE, 50, 4, 12));
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getGrassColorAt(double p_225528_1_, double p_225528_3_) {
		return 226217111;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getFoliageColor() {
		return 226217111;
	}

}