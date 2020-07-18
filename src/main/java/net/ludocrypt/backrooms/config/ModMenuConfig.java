package net.ludocrypt.backrooms.config;

import java.util.Optional;
import java.util.function.Supplier;

import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class ModMenuConfig implements ModMenuApi {

	@Override
	public String getModId() {
		return Backrooms.MOD_ID;
	}

	@Override
	public Optional<Supplier<Screen>> getConfigScreen(Screen screen) {
		return Optional.of(AutoConfig.getConfigScreen(BackroomsConfig.class, screen));
	}

}
