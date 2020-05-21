package net.ludocrypt.backrooms.config;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;

public class ModMenuBackroomsConfig implements ModMenuApi {
    @Override
    public String getModId() {
        return "backrooms";
    }
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return parent -> AutoConfig.getConfigScreen(BackroomsConfig.class, parent).get();
    }
}
