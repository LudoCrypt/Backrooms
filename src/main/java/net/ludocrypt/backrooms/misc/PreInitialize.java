package net.ludocrypt.backrooms.misc;

import com.chocohead.mm.api.ClassTinkerers;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.ludocrypt.backrooms.sound.BackroomsSoundEvents;

public interface PreInitialize {

	static void initialize() {
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			initializeClient();
		}
	}

	static void initializeClient() {
		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

		String musicType = remapper.mapClassName("intermediary", "net.minecraft.class_1142$class_1143");
		String soundEvent = remapper.mapClassName("intermediary", "net.minecraft.class_3414");

		ClassTinkerers.enumBuilder(musicType, 'L' + soundEvent + ';', "I", "I")
				.addEnum("LEVEL0MUSIC", () -> new Object[] { BackroomsSoundEvents.LEVEL0MUSIC, 0, 0 })
				.addEnum("BACKROOMSMENU", () -> new Object[] { BackroomsSoundEvents.BACKROOMSMENU, 0, 0 })
				.addEnum("TONE", () -> new Object[] { BackroomsSoundEvents.TONE, 0, 0 })
				.build();
	}
}