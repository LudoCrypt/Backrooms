package net.ludocrypt.backrooms.init;

import net.ludocrypt.backrooms.util.ConfiguredLevelDestination;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class BackroomsRegistries {

	public static final RegistryKey<Registry<ConfiguredLevelDestination>> CONFIGURED_LEVEL_DESTINATIONS_KEY = Registry.createRegistryKey("level_destinations/configured_level_destinations");

	public static final Registry<ConfiguredLevelDestination> CONFIGURED_LEVEL_DESTINATIONS = BuiltinRegistries.addRegistry(BackroomsRegistries.CONFIGURED_LEVEL_DESTINATIONS_KEY, () -> {
		return ConfiguredLevelDestinations.EMPTY;
	});

}
