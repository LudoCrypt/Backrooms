package net.ludocrypt.backrooms.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "backrooms")
public class BackroomsConfig implements ConfigData
{
	//Level 0 Numbers
    public double DoorChance = 0.05;
    public double NormalRoomChance = 0.7;
    public double PickHallwayChance = 0.8;
    public double EastHallwayChance = 0.5;
    public double MoldyCarpetChance = 0.01;
    public double PickStairChance = 0.5;
    public int Level0LayerCount = 3;
    //Level 1 Numbers
    public double Level1DoorChance = 0.05;
    public double Level1NormalRoomChance = 0.5;
    public double Level1PickHallwayChance = 0.5;
    public double Level1EastHallwayChance = 0.5;
    public double Level1PickStairChance = 0.3;
    public int Level1LayerCount = 3;
    //Portal Chances
    public double PortalChance = 0.1;
    public double RedRoomChance = 0.7;
    public double Level0Chance = 0.85;
    public double Level1Chance = 0.85;
    public double SameDimensionChance = 0.7;
    //General
    public double EnderPearlChance = 0.01;
    public double SuffocationChance = 0.01;
    public boolean TallDoors = true;
    public boolean ForceBackrooms = false;
    public boolean ForceNormal = false;
    public boolean SanityEffects = true;

    public static BackroomsConfig getInstance()
    {
        return AutoConfig.getConfigHolder(BackroomsConfig.class).getConfig();
    }

}