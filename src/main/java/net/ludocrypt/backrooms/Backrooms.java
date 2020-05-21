package net.ludocrypt.backrooms;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.ludocrypt.backrooms.biome.Level0;
import net.ludocrypt.backrooms.blocks.Carpet;
import net.ludocrypt.backrooms.blocks.Light;
import net.ludocrypt.backrooms.blocks.Poolstone;
import net.ludocrypt.backrooms.blocks.Poolstone_Bricks;
import net.ludocrypt.backrooms.blocks.Poolstone_Path;
import net.ludocrypt.backrooms.blocks.Poolstone_Tile;
import net.ludocrypt.backrooms.blocks.Smooth_Poolstone;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.blocks.Wall;
import net.ludocrypt.backrooms.blocks.Wallpaper;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.Level0DimensionType;
import net.ludocrypt.backrooms.items.AlmondWaterItem;
import net.ludocrypt.backrooms.items.BackroomsMusicDiscItem;
import net.ludocrypt.backrooms.items.RawAlmondWaterItem;
import net.ludocrypt.backrooms.sound.BackroomsSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class Backrooms implements ModInitializer {

	public static boolean Display = false;
	public static boolean teleported = false;
	public static boolean teleported_home = false;
	public static String teleporteduuid = "";
	// items
	public static final Item RAW_ALMOND_WATER = new RawAlmondWaterItem(new Item.Settings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(3)
					.statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 60 * 2), 1f).snack()
					.alwaysEdible().saturationModifier(1).build()));
	public static final Item ALMOND_WATER = new AlmondWaterItem(new Item.Settings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().alwaysEdible().snack().saturationModifier(17).hunger(9)
					.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 60 * 2, 5), 1f)
					.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 60 * 2, 3), 1f)
					.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 60 * 2, 5), 1f).build()));
	// blocks
	public static final Block WALLPAPER = new Wallpaper();
	public static final Block LIGHT = new Light();
	public static final Block WALL = new Wall();
	public static final Block CARPET = new Carpet();
	public static final Block TILE = new Tile();
	//Poolstone
	public static final Block POOLSTONE = new Poolstone();
	public static final Block SMOOTH_POOLSTONE = new Smooth_Poolstone();
	public static final Block POOLSTONE_BRICKS = new Poolstone_Bricks();
	public static final Block POOLSTONE_PATH = new Poolstone_Path();
	public static final Block POOLSTONE_TILE = new Poolstone_Tile();
	// biomes
	public static final Biome LEVEL0 = Registry.register(Registry.BIOME, new Identifier("backrooms", "level0"),
			new Level0());
	//record discs
	public static final Item MUSIC_DISC_GLACIAL_CAVERN = new BackroomsMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_GLACIAL_CAVERN, (new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_ITS_BEEN_SO_LONG = new BackroomsMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_ITS_BEEN_SO_LONG, (new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_OMAE_WA_MOU = new BackroomsMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_OMAE_WA_MOU, (new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_012 = new BackroomsMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_012, (new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
    //Ore Gen
	private void handleBiome(Biome biome) {
    	if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
    		biome.addFeature(
            	    GenerationStep.Feature.UNDERGROUND_ORES,
            	    Feature.ORE.configure(
    			new OreFeatureConfig(
    			    OreFeatureConfig.Target.NATURAL_STONE,
    			    Backrooms.POOLSTONE.getDefaultState(),
    			    25 //Ore vein size
    		   )).createDecoratedFeature(
    			Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
    			    6, //Number of veins per chunk
    			    0, //Bottom Offset
    			    0, //Min y level
    			    64 //Max y level
    		))));
    	}
    }
	
	
	@Override
	public void onInitialize() {
		// dimensions
		Level0DimensionType.register();
		// items
		Registry.register(Registry.ITEM, new Identifier("backrooms", "almond_water"), ALMOND_WATER);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "raw_almond_water"), RAW_ALMOND_WATER);
		// blocks
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "wallpaper"), WALLPAPER);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "wall"), WALL);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "carpet"), CARPET);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "light"), LIGHT);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "tile"), TILE);
		//poolstone
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone"), POOLSTONE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "smooth_poolstone"), SMOOTH_POOLSTONE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_path"), POOLSTONE_PATH);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_tile"), POOLSTONE_TILE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_bricks"), POOLSTONE_BRICKS);
		// blockitems
		Registry.register(Registry.ITEM, new Identifier("backrooms", "wallpaper"),
				new BlockItem(WALLPAPER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "wall"),
				new BlockItem(WALL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "carpet"),
				new BlockItem(CARPET, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "light"),
				new BlockItem(LIGHT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "tile"),
				new BlockItem(TILE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		//poolstone
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone"),
				new BlockItem(POOLSTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "smooth_poolstone"),
				new BlockItem(SMOOTH_POOLSTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_path"),
				new BlockItem(POOLSTONE_PATH, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_tile"),
				new BlockItem(POOLSTONE_TILE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_bricks"),
				new BlockItem(POOLSTONE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		//music discs
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_glacial_cavern"), MUSIC_DISC_GLACIAL_CAVERN);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_its_been_so_long"), MUSIC_DISC_ITS_BEEN_SO_LONG);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_omae_wa_mou"), MUSIC_DISC_OMAE_WA_MOU);	
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_012"), MUSIC_DISC_012);	
		//Config
		AutoConfig.register(BackroomsConfig.class, JanksonConfigSerializer::new);
		//Ore Generation
		Registry.BIOME.forEach(this::handleBiome);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
		}
}
