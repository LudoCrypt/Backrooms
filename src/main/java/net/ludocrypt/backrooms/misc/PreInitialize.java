package net.ludocrypt.backrooms.misc;

import com.chocohead.mm.api.ClassTinkerers;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public interface PreInitialize {

	static void initialize() {
		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
		String biomeCategory = remapper.mapClassName("intermediary", "net.minecraft.class_1959$class_1961");
		ClassTinkerers.enumBuilder(biomeCategory, String.class).addEnum("level0", () -> new Object[] { "level0" })
				.addEnum("level1", () -> new Object[] { "level1" }).addEnum("level2", () -> new Object[] { "level2" })
				.addEnum("level3", () -> new Object[] { "level3" }).build();
	}
}
