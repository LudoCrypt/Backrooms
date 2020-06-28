package net.ludocrypt.backrooms.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class LevelsFeatureInit {
	public static Feature<DefaultFeatureConfig> LEVEL0ROOM = new Level0Room(DefaultFeatureConfig::deserialize);
	public static Feature<DefaultFeatureConfig> LEVEL0REDROOM = new Level0RedRoom(DefaultFeatureConfig::deserialize);
	public static Feature<DefaultFeatureConfig> LEVEL1ROOM = new Level1Room(DefaultFeatureConfig::deserialize);

	public static void registerFeatures() {
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0room"), LEVEL0ROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0redroom"), LEVEL0REDROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level1room"), LEVEL1ROOM);
	}
}