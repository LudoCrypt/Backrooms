package net.ludocrypt.backrooms.biome;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.features.LevelsFeatureInit;
import net.ludocrypt.backrooms.features.decorators.Level2RoomDecorator;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class Level3 extends Biome {
	protected static final BlockState WALL = Backrooms.WALL.getDefaultState();
	public static final Decorator<NopeDecoratorConfig> LEVEL3PLACER = new Level2RoomDecorator(NopeDecoratorConfig::deserialize);
	
	public Level3() {

		super(new Biome.Settings().configureSurfaceBuilder(SurfaceBuilder.NOPE, SurfaceBuilder.AIR_CONFIG)
				.precipitation(Biome.Precipitation.NONE).category(Biome.Category.NONE).depth(0F).scale(0F)
				.temperature(5.0F).downfall(0F).waterColor(69).waterFogColor(69).parent((String) null));

		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS,
				LevelsFeatureInit.LEVEL3ROOM.configure(FeatureConfig.DEFAULT)
						.createDecoratedFeature(LEVEL3PLACER.configure(DecoratorConfig.DEFAULT)));
	}

	@Environment(EnvType.CLIENT)
	public int getGrassColorAt(double p_225528_1_, double p_225528_3_) {
		return 226217111;
	}

	@Environment(EnvType.CLIENT)
	public int getFoliageColor() {
		return 226217111;
	}
}