package net.ludocrypt.backrooms.init;

import com.google.common.base.Preconditions;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.CarpetBlock;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.world.features.config.RoomConfig;
import net.ludocrypt.backrooms.world.features.config.RoomDecorator;
import net.ludocrypt.backrooms.world.features.rooms.Level0Room;
import net.ludocrypt.backrooms.world.features.rooms.decorator.Level0RoomDecorator;
import net.ludocrypt.backrooms.world.features.rooms.specifics.Level0RoomSpecific;
import net.ludocrypt.backrooms.world.features.rooms.specifics.Level1RoomSpecific;
import net.minecraft.block.StairsBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

// TODO: Check
public class BackroomsFeatures {

	public static Feature<RoomConfig> LEVEL_0_ROOM;
	public static Decorator<RoomDecorator> LEVEL_0_DECORATOR;

	public static Feature<RoomConfig> LEVEL_0_ROOM_SPECIFIC;
	public static Feature<RoomConfig> LEVEL_1_ROOM_SPECIFIC;

	public static ConfiguredFeature<?, ?> BLANK_0_ROOM;
	public static ConfiguredFeature<?, ?> LINED_0_ROOM;
	public static ConfiguredFeature<?, ?> ARROWED_0_ROOM;
	public static ConfiguredFeature<?, ?> DOTTED_0_ROOM;
	public static ConfiguredFeature<?, ?> RED_BLANK_0_ROOM;
	public static ConfiguredFeature<?, ?> RED_LINED_0_ROOM;
	public static ConfiguredFeature<?, ?> RED_ARROWED_0_ROOM;
	public static ConfiguredFeature<?, ?> RED_DOTTED_0_ROOM;

	public static ConfiguredFeature<?, ?> MOLDY_BLANK_0_ROOM;
	public static ConfiguredFeature<?, ?> MOLDY_LINED_0_ROOM;
	public static ConfiguredFeature<?, ?> MOLDY_ARROWED_0_ROOM;
	public static ConfiguredFeature<?, ?> MOLDY_DOTTED_0_ROOM;
	public static ConfiguredFeature<?, ?> MOLDY_RED_BLANK_0_ROOM;
	public static ConfiguredFeature<?, ?> MOLDY_RED_LINED_0_ROOM;
	public static ConfiguredFeature<?, ?> MOLDY_RED_ARROWED_0_ROOM;
	public static ConfiguredFeature<?, ?> MOLDY_RED_DOTTED_0_ROOM;

	public static ConfiguredFeature<?, ?> DECREPIT_BLANK_0_ROOM;
	public static ConfiguredFeature<?, ?> DECREPIT_LINED_0_ROOM;
	public static ConfiguredFeature<?, ?> DECREPIT_ARROWED_0_ROOM;
	public static ConfiguredFeature<?, ?> DECREPIT_DOTTED_0_ROOM;

	public static ConfiguredFeature<?, ?> AIRY_BLANK_0_ROOM;
	public static ConfiguredFeature<?, ?> AIRY_LINED_0_ROOM;
	public static ConfiguredFeature<?, ?> AIRY_ARROWED_0_ROOM;
	public static ConfiguredFeature<?, ?> AIRY_DOTTED_0_ROOM;

	public static ConfiguredFeature<?, ?> ON_LEVEL_1_ROOM;
	public static ConfiguredFeature<?, ?> CRACKED_BRICKS_LEVEL_1_ROOM;
	public static ConfiguredFeature<?, ?> CRACKED_CEMENT_LEVEL_1_ROOM;
	public static ConfiguredFeature<?, ?> CRACKED_LEVEL_1_ROOM;
	public static ConfiguredFeature<?, ?> OFF_LEVEL_1_ROOM;

	public static void init() {
		BackroomsConfig c = BackroomsConfig.INSTANCE();

		LEVEL_0_ROOM = Registry.register(Registry.FEATURE, Backrooms.id("level_0_room"), new Level0Room());
		LEVEL_0_DECORATOR = Registry.register(Registry.DECORATOR, Backrooms.id("level_0_decorator"), new Level0RoomDecorator(RoomDecorator.CODEC));

		LEVEL_0_ROOM_SPECIFIC = Registry.register(Registry.FEATURE, Backrooms.id("level_0_room_specific"), new Level0RoomSpecific());
		LEVEL_1_ROOM_SPECIFIC = Registry.register(Registry.FEATURE, Backrooms.id("level_1_room_specific"), new Level1RoomSpecific());

		// Level 0
		BLANK_0_ROOM = register("blank_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		LINED_0_ROOM = register("lined_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		ARROWED_0_ROOM = register("arrowed_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		DOTTED_0_ROOM = register("dotted_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));

		RED_BLANK_0_ROOM = register("red_blank_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		RED_LINED_0_ROOM = register("red_lined_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		RED_ARROWED_0_ROOM = register("red_arrowed_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		RED_DOTTED_0_ROOM = register("red_dotted_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));

		MOLDY_BLANK_0_ROOM = register("moldy_blank_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		MOLDY_LINED_0_ROOM = register("moldy_lined_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		MOLDY_ARROWED_0_ROOM = register("moldy_arrowed_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		MOLDY_DOTTED_0_ROOM = register("moldy_dotted_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));

		MOLDY_RED_BLANK_0_ROOM = register("moldy_red_blank_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		MOLDY_RED_LINED_0_ROOM = register("moldy_red_lined_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		MOLDY_RED_ARROWED_0_ROOM = register("moldy_red_arrowed_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		MOLDY_RED_DOTTED_0_ROOM = register("moldy_red_dotted_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.RED_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_RED_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance * 10, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));

		DECREPIT_BLANK_0_ROOM = register("decrepit_blank_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.OLD_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_OLD_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance * 2, c.Level0LightOffChance * 4.5, c.Level0TornChance * 8, c.Level0TallTornChance * 5, c.Level0MoldChance * 20, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		DECREPIT_LINED_0_ROOM = register("decrepit_lined_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.OLD_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_OLD_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance * 2, c.Level0LightOffChance * 4.5, c.Level0TornChance * 8, c.Level0TallTornChance * 5, c.Level0MoldChance * 20, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		DECREPIT_ARROWED_0_ROOM = register("decrepit_arrowed_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.OLD_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_OLD_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance * 2, c.Level0LightOffChance * 4.5, c.Level0TornChance * 8, c.Level0TallTornChance * 5, c.Level0MoldChance * 20, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		DECREPIT_DOTTED_0_ROOM = register("decrepit_dotted_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.OLD_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_OLD_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance, c.Level0LightChance * 2, c.Level0LightOffChance * 4.5, c.Level0TornChance * 8, c.Level0TallTornChance * 5, c.Level0MoldChance * 20, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));

		AIRY_BLANK_0_ROOM = register("airy_blank_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance * 5, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		AIRY_LINED_0_ROOM = register("airy_lined_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_LINED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance * 5, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		AIRY_ARROWED_0_ROOM = register("airy_arrowed_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_ARROWED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance * 5, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));
		AIRY_DOTTED_0_ROOM = register("airy_dotted_0_room", LEVEL_0_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.TORN_DOTTED_WALLPAPER.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState(), BackroomsBlocks.CARPET.getDefaultState().with(CarpetBlock.MOLDY, true), BackroomsBlocks.CARPET_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level0DoorChance * 5, c.Level0LightChance, c.Level0LightOffChance, c.Level0TornChance, c.Level0TallTornChance, c.Level0MoldChance, c.Level0StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level0LayerCount))));

		// level 1
		ON_LEVEL_1_ROOM = register("on_level_1_room", LEVEL_1_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CEMENT.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT.getDefaultState(), BackroomsBlocks.CEMENT_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level1DoorChance, c.Level1LightChance, c.Level1LightOffChance, c.Level1TornChance, 0, c.Level1MoldChance, c.Level1StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level1LayerCount))));
		CRACKED_BRICKS_LEVEL_1_ROOM = register("cracked_bricks_level_1_room", LEVEL_1_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CEMENT.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT.getDefaultState(), BackroomsBlocks.CEMENT_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level1DoorChance, c.Level1LightChance, c.Level1LightOffChance, c.Level1TornChance * 20, 0, c.Level1MoldChance, c.Level1StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level1LayerCount))));
		CRACKED_CEMENT_LEVEL_1_ROOM = register("cracked_cement_level_1_room", LEVEL_1_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CEMENT.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT.getDefaultState(), BackroomsBlocks.CEMENT_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level1DoorChance, c.Level1LightChance, c.Level1LightOffChance, c.Level1TornChance, 0, c.Level1MoldChance * 20, c.Level1StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level1LayerCount))));
		CRACKED_LEVEL_1_ROOM = register("cracked_level_1_room", LEVEL_1_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CEMENT.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT.getDefaultState(), BackroomsBlocks.CEMENT_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level1DoorChance, c.Level1LightChance, c.Level1LightOffChance, c.Level1TornChance * 20, 0, c.Level1MoldChance * 20, c.Level1StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level1LayerCount))));
		OFF_LEVEL_1_ROOM = register("off_level_1_room", LEVEL_1_ROOM_SPECIFIC.configure(new RoomConfig(BackroomsBlocks.CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT_BRICKS.getDefaultState(), BackroomsBlocks.CEMENT.getDefaultState(), BackroomsBlocks.CRACKED_CEMENT.getDefaultState(), BackroomsBlocks.CEMENT_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH), 4, true, c.Level1DoorChance, c.Level1LightChance * 2, c.Level1LightOffChance * 10, c.Level1TornChance * 25, 0, c.Level1MoldChance * 25, c.Level1StairChance)).decorate(BackroomsFeatures.LEVEL_0_DECORATOR.configure(new RoomDecorator(c.Level1LayerCount))));
	}

	private static ConfiguredFeature<?, ?> register(String id, ConfiguredFeature<?, ?> cf) {
		Identifier realId = Backrooms.id(id);
		Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, realId, cf);
	}
}
