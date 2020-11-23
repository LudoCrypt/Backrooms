package net.ludocrypt.backrooms.init;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.util.ConfiguredLevelDestination;
import net.ludocrypt.backrooms.world.Level0;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ConfiguredLevelDestinations {

	// Acts as a kind of local registry for destinations added by The Backrooms
	private static final Map<Identifier, ConfiguredLevelDestination> CONFIGURED_LEVEL_DESTINATIONS = new LinkedHashMap<>();

	public static final ConfiguredLevelDestination EMPTY = add("empty", new ConfiguredLevelDestination(new ArrayList<Identifier>(), new ArrayList<Double>()).add(Level0.LEVEL_0_WORLD.getValue(), 0.0));

	private static <C extends ConfiguredLevelDestination> C add(String name, C configured_level_destination) {
		CONFIGURED_LEVEL_DESTINATIONS.put(Backrooms.id(name), configured_level_destination);
		return configured_level_destination;
	}

	public static void init() {
		for (Identifier id : CONFIGURED_LEVEL_DESTINATIONS.keySet()) {
			Registry.register(BackroomsRegistries.CONFIGURED_LEVEL_DESTINATIONS, id, CONFIGURED_LEVEL_DESTINATIONS.get(id));
		}
	}

}
