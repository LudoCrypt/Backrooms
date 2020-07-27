package net.ludocrypt.backrooms.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "backrooms")
public class BackroomsConfig implements ConfigData {

	public double Level0DoorChance = 0.05;
	public int Level0LayerCount = 3;

	public double Level1DoorChance = 0.05;
	public int Level1LayerCount = 3;

	public double VBDoor = 0.05;
	
	public double EnderPearlChance = 0.01;
	public double SuffocationChance = 0.01;
	public double ChestSpawnChance = 0.1;
	public boolean TallDoors = true;
	public boolean ForceLevel0 = false;
	public boolean ForceLevel1 = false;
	public boolean ForceLevel2 = false;
	public boolean ForceLevel3 = false;
	public boolean ForceNormal = false;
	public boolean SanityEffects = true;

	public static BackroomsConfig getInstance() {
		return AutoConfig.getConfigHolder(BackroomsConfig.class).getConfig();
	}

}