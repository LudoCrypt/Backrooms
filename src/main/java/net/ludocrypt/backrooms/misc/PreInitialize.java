package net.ludocrypt.backrooms.misc;

import com.chocohead.mm.api.ClassTinkerers;

public interface PreInitialize {

	static void initialize() {
		ClassTinkerers.enumBuilder("net.minecraft.world.biome.Biome$Category", String.class)
				.addEnum("level0", () -> new Object[] { "level0" }).addEnum("level1", () -> new Object[] { "level1" })
				.addEnum("level2", () -> new Object[] { "level2" }).addEnum("level3", () -> new Object[] { "level3" })
				.build();
	}
}
