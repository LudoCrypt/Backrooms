package net.ludocrypt.backrooms.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "backrooms")
public class BackroomsConfig implements ConfigData
{
    public double DoorChance = 0.05;
    public double NormalRoomChance = 0.7;
    public double PickHallwayChance = 0.75;
    public double EastHallwayChance = 0.5;
    public double MoldyCarpetChance = 0.01;
    public double PickStairChance = 0.6;
    public double EnderPearlChance = 0.01;
    public int Level0LayerCount = 3;
    public boolean ForceBackrooms = false;
    public boolean ForceNormal = false;

    public static BackroomsConfig getInstance()
    {
        return AutoConfig.getConfigHolder(BackroomsConfig.class).getConfig();
    }

}