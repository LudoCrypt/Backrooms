package net.ludocrypt.backrooms;

import net.fabricmc.api.ModInitializer;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.init.BackroomsBiomes;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.ludocrypt.backrooms.init.BackroomsCommands;
import net.ludocrypt.backrooms.init.BackroomsFeatures;
import net.ludocrypt.backrooms.init.BackroomsGamerules;
import net.ludocrypt.backrooms.init.BackroomsGroups;
import net.ludocrypt.backrooms.init.BackroomsItems;
import net.ludocrypt.backrooms.init.BackroomsSoundEvents;
import net.ludocrypt.backrooms.init.BackroomsSurfaces;
import net.ludocrypt.backrooms.init.ConfiguredLevelDestinations;
import net.ludocrypt.backrooms.util.NoiseCollisionChecker;
import net.minecraft.util.Identifier;

public class Backrooms implements ModInitializer {

	public static final String NAMESPACE = "backrooms";

	@Override
	public void onInitialize() {

		BackroomsConfig.init();
		BackroomsItems.init();
		BackroomsBlocks.init();
		BackroomsGroups.init();
		BackroomsSurfaces.init();
		BackroomsFeatures.init();
		BackroomsBiomes.init();
		BackroomsGamerules.init();

		BackroomsSoundEvents.init();

		ConfiguredLevelDestinations.init();

		BackroomsCommands.init();
		NoiseCollisionChecker.init();
	}

	public static Identifier id(String id) {
		return new Identifier(NAMESPACE, id);
	}

}
