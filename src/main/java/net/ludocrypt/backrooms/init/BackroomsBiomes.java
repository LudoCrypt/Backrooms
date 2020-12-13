package net.ludocrypt.backrooms.init;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.biome.Level0Biome;
import net.ludocrypt.backrooms.biome.Level1Biome;
import net.ludocrypt.backrooms.biome.Level2Biome;
import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.Level1;
import net.ludocrypt.backrooms.world.Level2;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class BackroomsBiomes {

	// Level 0
	public static final RegistryKey<Biome> LEVEL_0_BLANK = add("level_0_blank", Level0Biome.create(BackroomsFeatures.BLANK_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_DOTTED = add("level_0_dotted", Level0Biome.create(BackroomsFeatures.DOTTED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_LINED = add("level_0_lined", Level0Biome.create(BackroomsFeatures.LINED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_ARROWED = add("level_0_arrowed", Level0Biome.create(BackroomsFeatures.ARROWED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));

	public static final RegistryKey<Biome> LEVEL_0_RED_BLANK = add("level_0_red_blank", Level0Biome.create(BackroomsFeatures.RED_BLANK_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_RED_DOTTED = add("level_0_red_dotted", Level0Biome.create(BackroomsFeatures.RED_DOTTED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_RED_LINED = add("level_0_red_lined", Level0Biome.create(BackroomsFeatures.RED_LINED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_RED_ARROWED = add("level_0_red_arrowed", Level0Biome.create(BackroomsFeatures.RED_ARROWED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));

	public static final RegistryKey<Biome> LEVEL_0_MOLDY_BLANK = add("level_0_moldy_blank", Level0Biome.create(BackroomsFeatures.MOLDY_BLANK_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_MOLDY_DOTTED = add("level_0_moldy_dotted", Level0Biome.create(BackroomsFeatures.MOLDY_DOTTED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_MOLDY_LINED = add("level_0_moldy_lined", Level0Biome.create(BackroomsFeatures.MOLDY_LINED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_MOLDY_ARROWED = add("level_0_moldy_arrowed", Level0Biome.create(BackroomsFeatures.MOLDY_ARROWED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));

	public static final RegistryKey<Biome> LEVEL_0_MOLDY_RED_BLANK = add("level_0_moldy_red_blank", Level0Biome.create(BackroomsFeatures.MOLDY_RED_BLANK_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_MOLDY_RED_DOTTED = add("level_0_moldy_red_dotted", Level0Biome.create(BackroomsFeatures.MOLDY_RED_DOTTED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_MOLDY_RED_LINED = add("level_0_moldy_red_lined", Level0Biome.create(BackroomsFeatures.MOLDY_RED_LINED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_MOLDY_RED_ARROWED = add("level_0_moldy_red_arrowed", Level0Biome.create(BackroomsFeatures.MOLDY_RED_ARROWED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));

	public static final RegistryKey<Biome> LEVEL_0_DECREPIT_BLANK = add("level_0_decrepit_blank", Level0Biome.create(BackroomsFeatures.DECREPIT_BLANK_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_DECREPIT_DOTTED = add("level_0_decrepit_dotted", Level0Biome.create(BackroomsFeatures.DECREPIT_DOTTED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_DECREPIT_LINED = add("level_0_decrepit_lined", Level0Biome.create(BackroomsFeatures.DECREPIT_LINED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_DECREPIT_ARROWED = add("level_0_decrepit_arrowed", Level0Biome.create(BackroomsFeatures.DECREPIT_ARROWED_0_ROOM, BackroomsSoundEvents.LEVEL_0_WEIGHTED_MUSIC));

	public static final RegistryKey<Biome> LEVEL_0_AIRY_BLANK = add("level_0_airy_blank", Level0Biome.create(BackroomsFeatures.AIRY_BLANK_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_AIRY_DOTTED = add("level_0_airy_dotted", Level0Biome.create(BackroomsFeatures.AIRY_DOTTED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_AIRY_LINED = add("level_0_airy_lined", Level0Biome.create(BackroomsFeatures.AIRY_LINED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));
	public static final RegistryKey<Biome> LEVEL_0_AIRY_ARROWED = add("level_0_airy_arrowed", Level0Biome.create(BackroomsFeatures.AIRY_ARROWED_0_ROOM, BackroomsSoundEvents.LEVEL_0_MUSIC));

	// Level 1
	public static final RegistryKey<Biome> LEVEL_1_ON = add("level_1_on", Level1Biome.create(BackroomsFeatures.ON_LEVEL_1_ROOM, BackroomsSoundEvents.LEVEL_1_ON_MUSIC));
	public static final RegistryKey<Biome> LEVEL_1_CRACKED_BRICKS = add("level_1_cracked_bricks", Level1Biome.create(BackroomsFeatures.CRACKED_BRICKS_LEVEL_1_ROOM, BackroomsSoundEvents.LEVEL_1_ON_MUSIC));
	public static final RegistryKey<Biome> LEVEL_1_CRACKED_CEMENT = add("level_1_cracked_cement", Level1Biome.create(BackroomsFeatures.CRACKED_CEMENT_LEVEL_1_ROOM, BackroomsSoundEvents.LEVEL_1_ON_MUSIC));
	public static final RegistryKey<Biome> LEVEL_1_CRACKED = add("level_1_cracked", Level1Biome.create(BackroomsFeatures.CRACKED_LEVEL_1_ROOM, BackroomsSoundEvents.LEVEL_1_ON_MUSIC));
	public static final RegistryKey<Biome> LEVEL_1_OFF = add("level_1_off", Level1Biome.create(BackroomsFeatures.OFF_LEVEL_1_ROOM, BackroomsSoundEvents.LEVEL_1_OFF_MUSIC));

	// Level 2
	public static final RegistryKey<Biome> LEVEL_2 = add("level_2", Level2Biome.create(BackroomsSoundEvents.LEVEL_2_MUSIC));

	public static void init() {

		// Level 0
		addLevel0Biome(LEVEL_0_ARROWED, new Biome.MixedNoisePoint(0.0F, 0.0F, 0.0F, 0.0F, 0.0F), 30, false, false, true, false);
		addLevel0Biome(LEVEL_0_BLANK, new Biome.MixedNoisePoint(0.0F, 0.1F, 0.0F, 0.0F, 0.0F), 15, false, false, true, false);
		addLevel0Biome(LEVEL_0_DOTTED, new Biome.MixedNoisePoint(0.0F, 0.2F, 0.0F, 0.0F, 0.0F), 25, false, false, true, false);
		addLevel0Biome(LEVEL_0_LINED, new Biome.MixedNoisePoint(0.0F, 0.3F, 0.0F, 0.0F, 0.0F), 20, false, false, true, false);

		addLevel0Biome(LEVEL_0_MOLDY_ARROWED, new Biome.MixedNoisePoint(0.1F, 0.0F, 0.0F, 0.0F, 0.0F), 15, false, false, false, true);
		addLevel0Biome(LEVEL_0_MOLDY_BLANK, new Biome.MixedNoisePoint(0.1F, 0.1F, 0.0F, 0.0F, 0.0F), 8, false, false, false, true);
		addLevel0Biome(LEVEL_0_MOLDY_DOTTED, new Biome.MixedNoisePoint(0.1F, 0.2F, 0.0F, 0.0F, 0.0F), 12, false, false, false, true);
		addLevel0Biome(LEVEL_0_MOLDY_LINED, new Biome.MixedNoisePoint(0.1F, 0.3F, 0.0F, 0.0F, 0.0F), 10, false, false, false, true);

		addLevel0Biome(LEVEL_0_RED_ARROWED, new Biome.MixedNoisePoint(0.8F, 0.0F, 0.0F, 0.0F, 0.0F), 20, false, false, true, true);
		addLevel0Biome(LEVEL_0_RED_BLANK, new Biome.MixedNoisePoint(0.8F, 0.1F, 0.0F, 0.0F, 0.0F), 5, false, false, true, true);
		addLevel0Biome(LEVEL_0_RED_DOTTED, new Biome.MixedNoisePoint(0.8F, 0.2F, 0.0F, 0.0F, 0.0F), 15, false, false, true, true);
		addLevel0Biome(LEVEL_0_RED_LINED, new Biome.MixedNoisePoint(0.8F, 0.3F, 0.0F, 0.0F, 0.0F), 10, false, false, true, true);

		addLevel0Biome(LEVEL_0_MOLDY_RED_ARROWED, new Biome.MixedNoisePoint(0.9F, 0.0F, 0.0F, 0.0F, 0.0F), 10, false, true, true, false);
		addLevel0Biome(LEVEL_0_MOLDY_RED_BLANK, new Biome.MixedNoisePoint(0.9F, 0.0F, 0.0F, 0.1F, 0.0F), 1, false, true, true, false);
		addLevel0Biome(LEVEL_0_MOLDY_RED_DOTTED, new Biome.MixedNoisePoint(0.9F, 0.0F, 0.0F, 0.2F, 0.0F), 7, false, true, true, false);
		addLevel0Biome(LEVEL_0_MOLDY_RED_LINED, new Biome.MixedNoisePoint(0.9F, 0.0F, 0.0F, 0.3F, 0.0F), 5, false, true, true, false);

		addLevel0Biome(LEVEL_0_DECREPIT_ARROWED, new Biome.MixedNoisePoint(0.7F, 0.0F, 0.0F, 0.0F, 0.0F), 25, false, false, true, true);
		addLevel0Biome(LEVEL_0_DECREPIT_BLANK, new Biome.MixedNoisePoint(0.7F, 0.1F, 0.0F, 0.0F, 0.0F), 10, false, false, true, true);
		addLevel0Biome(LEVEL_0_DECREPIT_DOTTED, new Biome.MixedNoisePoint(0.7F, 0.2F, 0.0F, 0.0F, 0.0F), 20, false, false, true, true);
		addLevel0Biome(LEVEL_0_DECREPIT_LINED, new Biome.MixedNoisePoint(0.7F, 0.3F, 0.0F, 0.0F, 0.0F), 15, false, false, true, true);

		addLevel0Biome(LEVEL_0_ARROWED, new Biome.MixedNoisePoint(0.5F, 0.0F, 0.0F, 0.0F, 0.0F), 10, false, false, true, true);
		addLevel0Biome(LEVEL_0_BLANK, new Biome.MixedNoisePoint(0.5F, 0.1F, 0.0F, 0.0F, 0.0F), 2, false, false, true, true);
		addLevel0Biome(LEVEL_0_DOTTED, new Biome.MixedNoisePoint(0.5F, 0.2F, 0.0F, 0.0F, 0.0F), 5, false, false, true, true);
		addLevel0Biome(LEVEL_0_LINED, new Biome.MixedNoisePoint(0.5F, 0.3F, 0.0F, 0.0F, 0.0F), 4, false, false, true, true);

		addLevel0Biome(LEVEL_0_AIRY_ARROWED, new Biome.MixedNoisePoint(0.2F, 0.0F, 0.0F, 0.5F, 0.0F), 6, false, false, true, false);
		addLevel0Biome(LEVEL_0_AIRY_BLANK, new Biome.MixedNoisePoint(0.2F, 0.9F, 0.0F, 0.6F, 0.0F), 3, false, false, true, false);
		addLevel0Biome(LEVEL_0_AIRY_DOTTED, new Biome.MixedNoisePoint(0.2F, 0.8F, 0.0F, 0.7F, 0.0F), 5, false, false, true, false);
		addLevel0Biome(LEVEL_0_AIRY_LINED, new Biome.MixedNoisePoint(0.2F, 0.7F, 0.0F, 0.8F, 0.0F), 4, false, false, true, false);

		// Level 1
		addLevel1Biome(LEVEL_1_ON, new Biome.MixedNoisePoint(0.0F, 0.0F, 0.0F, 0.0F, 0.0F), 10, false, false, true, false);
		addLevel1Biome(LEVEL_1_CRACKED_BRICKS, new Biome.MixedNoisePoint(0.1F, 0.1F, 0.0F, 0.0F, 0.0F), 6, false, false, true, true);
		addLevel1Biome(LEVEL_1_CRACKED_CEMENT, new Biome.MixedNoisePoint(0.2F, 0.1F, 0.0F, 0.0F, 0.0F), 6, false, false, true, true);
		addLevel1Biome(LEVEL_1_CRACKED, new Biome.MixedNoisePoint(0.3F, 0.1F, 0.0F, 0.0F, 0.0F), 4, false, false, true, true);
		addLevel1Biome(LEVEL_1_OFF, new Biome.MixedNoisePoint(0.5F, 0.2F, 0.0F, 0.0F, 0.0F), 5, false, false, true, false);

		// Level 2
		addLevel2Biome(LEVEL_2, new Biome.MixedNoisePoint(0.0F, 0.0F, 0.0F, 0.0F, 0.0F), 10, false, false, true, false);
	}

	// Adds biomes to level 0
	private static void addLevel0Biome(RegistryKey<Biome> biome, Biome.MixedNoisePoint noise, int weight, boolean temperature, boolean humidity, boolean altitude, boolean weirdness) {
		for (int i = 0; i < weight; i++) {
			Level0.addLevel0Biome(biome, new Biome.MixedNoisePoint(!temperature ? noise.temperature : (1 / weight) * i + noise.temperature, !humidity ? noise.humidity : (1 / weight) * i + noise.humidity, !altitude ? noise.altitude : (1 / weight) * i + noise.altitude, !weirdness ? noise.weirdness : (1 / weight) * i + noise.weirdness, noise.weight));
		}
	}

	// Adds biomes to level 1
	private static void addLevel1Biome(RegistryKey<Biome> biome, Biome.MixedNoisePoint noise, int weight, boolean temperature, boolean humidity, boolean altitude, boolean weirdness) {
		for (int i = 0; i < weight; i++) {
			Level1.addLevel1Biome(biome, new Biome.MixedNoisePoint(!temperature ? noise.temperature : (1 / weight) * i + noise.temperature, !humidity ? noise.humidity : (1 / weight) * i + noise.humidity, !altitude ? noise.altitude : (1 / weight) * i + noise.altitude, !weirdness ? noise.weirdness : (1 / weight) * i + noise.weirdness, noise.weight));
		}
	}

	// Adds biomes to level 2
	private static void addLevel2Biome(RegistryKey<Biome> biome, Biome.MixedNoisePoint noise, int weight, boolean temperature, boolean humidity, boolean altitude, boolean weirdness) {
		for (int i = 0; i < weight; i++) {
			Level2.addLevel2Biome(biome, new Biome.MixedNoisePoint(!temperature ? noise.temperature : (1 / weight) * i + noise.temperature, !humidity ? noise.humidity : (1 / weight) * i + noise.humidity, !altitude ? noise.altitude : (1 / weight) * i + noise.altitude, !weirdness ? noise.weirdness : (1 / weight) * i + noise.weirdness, noise.weight));
		}
	}

	private static RegistryKey<Biome> add(String s, Biome b) {
		Identifier id = Backrooms.id(s);
		Registry.register(BuiltinRegistries.BIOME, id, b);
		RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, id);
		return key;
	}

}
