package net.ludocrypt.backrooms.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "backrooms")
public class BackroomsConfig implements ConfigData
{
    public double DoorChance = 0.05;
    public double NormalRoomChance = 0.7;
    public double PickHallwayChance = 0.8;
    public double EastHallwayChance = 0.5;
    public double MoldyCarpetChance = 0.01;
    public double PickStairChance = 0.5;
    public double EnderPearlChance = 0.01;
    public int Level0LayerCount = 3;
    public double PortalChance = 0.3;
    public double RedRoomChance = 0.9;
    public double SameDimensionChance = 0.7;
    public boolean ForceBackrooms = false;
    public boolean ForceNormal = false;
    public boolean SanityEffects = true;

    public static BackroomsConfig getInstance()
    {
        return AutoConfig.getConfigHolder(BackroomsConfig.class).getConfig();
    }

}