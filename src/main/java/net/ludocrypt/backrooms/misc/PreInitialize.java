package net.ludocrypt.backrooms.misc;

import com.chocohead.mm.api.ClassTinkerers;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

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
				.addEnum("LEVEL0MUSIC", () -> new Object[] { BackroomsSoundEvents.LEVEL0MUSIC, 500, 1000 })
				.addEnum("LEVEL1MUSIC", () -> new Object[] { BackroomsSoundEvents.LEVEL1MUSIC, 500, 1000 })
				.addEnum("LEVEL2MUSIC", () -> new Object[] { BackroomsSoundEvents.LEVEL2MUSIC, 500, 1000 })
				.addEnum("LEVEL3MUSIC", () -> new Object[] { BackroomsSoundEvents.LEVEL3MUSIC, 500, 1000 })
				.addEnum("LEVEL0MENU", () -> new Object[] { BackroomsSoundEvents.LEVEL0MUSIC, 20, 600 })
				.addEnum("LEVEL1MENU", () -> new Object[] { BackroomsSoundEvents.LEVEL1MUSIC, 20, 600 })
				.addEnum("LEVEL2MENU", () -> new Object[] { BackroomsSoundEvents.LEVEL2MUSIC, 20, 600 })
				.addEnum("LEVEL3MENU", () -> new Object[] { BackroomsSoundEvents.LEVEL3MUSIC, 20, 600 })
				.build();
	}
}