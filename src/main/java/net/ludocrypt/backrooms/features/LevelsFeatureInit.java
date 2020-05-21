package net.ludocrypt.backrooms.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class LevelsFeatureInit {
	public static Feature<DefaultFeatureConfig> LEVEL0ROOM = new Level0Room(DefaultFeatureConfig::deserialize);

	public static void registerFeatures() {
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0room"), LEVEL0ROOM);
	}
}