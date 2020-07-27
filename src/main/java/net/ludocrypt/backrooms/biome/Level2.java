package net.ludocrypt.backrooms.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.features.LevelsFeatureInit;
import net.ludocrypt.backrooms.features.decorators.Level2RoomDecorator;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class Level2 extends Biome {
	protected static final BlockState WALL = Backrooms.WALL.getDefaultState();
	public static final Decorator<NopeDecoratorConfig> LEVEL2PLACER = new Level2RoomDecorator(
			NopeDecoratorConfig.field_24891);

	public Level2() {

		super(new Biome.Settings()
				.configureSurfaceBuilder(new LevelSurfaceBuilder(TernarySurfaceConfig.CODEC),
						new TernarySurfaceConfig(WALL, WALL, WALL))
				.precipitation(Biome.Precipitation.NONE).category(Biome.Category.NONE).depth(0F).scale(0F)
				.temperature(1.0F).downfall(0F).effects(new BiomeEffects.Builder().waterColor(-6710887)
						.waterFogColor(-6710887).fogColor(-6710887).build()));

		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
				LevelsFeatureInit.LEVEL2ROOM.configure(FeatureConfig.DEFAULT)
						.createDecoratedFeature(LEVEL2PLACER.configure(DecoratorConfig.DEFAULT)));
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