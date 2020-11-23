package net.ludocrypt.backrooms.init;

import java.util.LinkedHashMap;
import java.util.Map;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.client.BackroomsSoundEvents;
import net.ludocrypt.backrooms.items.AlmondWaterItem;
import net.ludocrypt.backrooms.items.RawAlmondWaterItem;
import net.ludocrypt.backrooms.items.WallpaperPatternItem;
import net.ludocrypt.backrooms.mixin.MusicDiscAccessor;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class BackroomsItems {

	// Acts as a kind of local registry for items added by The Backrooms
	private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

	public static final Item WALLPAPER_PATTERN = add("wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item LINED_WALLPAPER_PATTERN = add("lined_wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item DOTTED_WALLPAPER_PATTERN = add("dotted_wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item ARROWED_WALLPAPER_PATTERN = add("arrowed_wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item RED_WALLPAPER_PATTERN = add("red_wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item RED_LINED_WALLPAPER_PATTERN = add("red_lined_wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item RED_DOTTED_WALLPAPER_PATTERN = add("red_dotted_wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item RED_ARROWED_WALLPAPER_PATTERN = add("red_arrowed_wallpaper_pattern", new WallpaperPatternItem(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public static final Item ALMOND_WATER = add("almond_water", new AlmondWaterItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().alwaysEdible().snack().saturationModifier(17).hunger(9).build())));
	public static final Item RAW_ALMOND_WATER = add("raw_almond_water", new RawAlmondWaterItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().alwaysEdible().snack().saturationModifier(17).hunger(9).build())));

	public static final Item MUSIC_DISC_GLACIAL_CAVERN = add("music_disc_glacial_cavern", MusicDiscAccessor.createMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_GLACIAL_CAVERN, new Item.Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_THOSE_TORN_WALLS = add("music_disc_those_torn_walls", MusicDiscAccessor.createMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_THOSE_TORN_WALLS, new Item.Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_ITS_BEEN_SO_LONG = add("music_disc_its_been_so_long", MusicDiscAccessor.createMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_ITS_BEEN_SO_LONG, new Item.Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_OMAE_WA_MOU = add("music_disc_omae_wa_mou", MusicDiscAccessor.createMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_OMAE_WA_MOU, new Item.Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_BURGERS_AND_FRIES = add("music_disc_burgers_and_fries", MusicDiscAccessor.createMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_BURGERS_AND_FRIES, new Item.Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_012 = add("music_disc_012", MusicDiscAccessor.createMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_012, new Item.Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));
	public static final Item MUSIC_DISC_PRETZELS_AND_CHEESE = add("music_disc_pretzels_and_cheese", MusicDiscAccessor.createMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_PRETZELS_AND_CHEESE, new Item.Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));

	private static <I extends Item> I add(String name, I item) {
		ITEMS.put(Backrooms.id(name), item);
		return item;
	}

	public static void init() {
		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
	}

}
