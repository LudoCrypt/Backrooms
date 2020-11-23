package net.ludocrypt.backrooms.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.ludocrypt.backrooms.Backrooms;

@Config(name = Backrooms.NAMESPACE)
public class BackroomsConfig implements ConfigData {

	// Level 0
	public double Level0DoorChance = 0.1;
	public double Level0LightChance = 0.1;
	public double Level0LightOffChance = 0.2;
	public double Level0TornChance = 0.07;
	public double Level0TallTornChance = 0.1;
	public double Level0MoldChance = 0.2;
	public double Level0StairChance = 0.3;
	public int Level0LayerCount = 3;
	public double Level0ChestSpawnChance = 0.1;

	// Level 1
	public double Level1DoorChance = 0.1;
	public double Level1LightChance = 0.1;
	public double Level1LightOffChance = 0.2;
	public double Level1TornChance = 0.07;
	public double Level1MoldChance = 0.2;
	public double Level1StairChance = 0.3;
	public int Level1LayerCount = 3;
	public double Level1ChestSpawnChance = 0.1;
	public double LightShutoffChance = 0.2;

	// Getting in
	public double EnderPearlChance = 0.01;
	public double SuffocationChance = 0.01;

	// Client
	public int BackgroundLevel = -1;
	public int SearchRange = 5;
	public float AmbientMultiplierWhenMusic = 0.4F;
	public boolean SanityEffects = true;

	// Server
	public int changeToSpawnPos = -69;

	public static void init() {
		AutoConfig.register(BackroomsConfig.class, GsonConfigSerializer::new);
	}

	public static BackroomsConfig INSTANCE() {
		return AutoConfig.getConfigHolder(BackroomsConfig.class).getConfig();
	}

}
