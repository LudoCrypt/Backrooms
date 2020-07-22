package net.ludocrypt.backrooms;

import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.Sets;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.ludocrypt.backrooms.biome.Level0;
import net.ludocrypt.backrooms.biome.Level0Dotted;
import net.ludocrypt.backrooms.biome.Level0Red;
import net.ludocrypt.backrooms.biome.Level1;
import net.ludocrypt.backrooms.biome.Level2;
import net.ludocrypt.backrooms.biome.Level3;
import net.ludocrypt.backrooms.blocks.BackroomsSlab;
import net.ludocrypt.backrooms.blocks.BackroomsStairs;
import net.ludocrypt.backrooms.blocks.Carpet;
import net.ludocrypt.backrooms.blocks.Cement;
import net.ludocrypt.backrooms.blocks.Cement_Bricks;
import net.ludocrypt.backrooms.blocks.Checkered_Block;
import net.ludocrypt.backrooms.blocks.Light;
import net.ludocrypt.backrooms.blocks.LinedPipe;
import net.ludocrypt.backrooms.blocks.Pipe;
import net.ludocrypt.backrooms.blocks.Poolstone;
import net.ludocrypt.backrooms.blocks.Poolstone_Bricks;
import net.ludocrypt.backrooms.blocks.Poolstone_Path;
import net.ludocrypt.backrooms.blocks.Poolstone_Tile;
import net.ludocrypt.backrooms.blocks.Smooth_Poolstone;
import net.ludocrypt.backrooms.blocks.Tile;
import net.ludocrypt.backrooms.blocks.TornWallpaper;
import net.ludocrypt.backrooms.blocks.VoidBlock;
import net.ludocrypt.backrooms.blocks.Wall;
import net.ludocrypt.backrooms.blocks.Wallpaper;
import net.ludocrypt.backrooms.blocks.entity.VoidBlockEntity;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.BackroomsDimensionTypes;
import net.ludocrypt.backrooms.items.AlmondWaterItem;
import net.ludocrypt.backrooms.items.BackroomsMusicDiscItem;
import net.ludocrypt.backrooms.items.RawAlmondWaterItem;
import net.ludocrypt.backrooms.items.Wrench;
import net.ludocrypt.backrooms.misc.BackroomsSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class Backrooms implements ModInitializer {
	// loot tables
	private static final Set<Identifier> LOOT_TABLES = Sets.newHashSet();
	public static final Identifier LEVEL0CHEST = register("backrooms:chests/level0");
	public static final Identifier LEVEL1CHEST = register("backrooms:chests/level1");
	public static final Identifier LEVEL3CHEST = register("backrooms:chests/level3");
	// variables
	public static boolean Display = false;
	public static int DisplayLevel = 0;
	public static final String MOD_ID = "backrooms";
	public static PlayerEntity teleportedEntity = null;
	// items
	public static final Item RAW_ALMOND_WATER = new RawAlmondWaterItem(new Item.Settings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().hunger(3).snack().alwaysEdible().saturationModifier(1).build()));
	public static final Item ALMOND_WATER = new AlmondWaterItem(new Item.Settings().group(ItemGroup.FOOD)
			.food(new FoodComponent.Builder().alwaysEdible().snack().saturationModifier(17).hunger(9).build()));
	public static final Item WRENCH = new Wrench(new Item.Settings().group(ItemGroup.MISC).maxCount(1));

	// blocks
	public static final Block WALLPAPER = new Wallpaper();
	public static final Block DOTTED_WALLPAPER = new Wallpaper();
	public static final Block RED_WALLPAPER = new Wallpaper();
	public static final Block TORN_WALLPAPER = new TornWallpaper();
	public static final Block RED_TORN_WALLPAPER = new TornWallpaper();
	public static final Block DOTTED_TORN_WALLPAPER = new TornWallpaper();
	public static final Block LIGHT = new Light();
	public static final Block WALL = new Wall();
	public static final Block CARPET = new Carpet();
	public static final Block CARPET_STAIRS = new BackroomsStairs(CARPET.getDefaultState(),
			Block.Settings.copy(CARPET));
	public static final Block TILE = new Tile();
	public static final Block CEMENT = new Cement();
	public static final Block CEMENT_STAIRS = new BackroomsStairs(CEMENT.getDefaultState(),
			Block.Settings.copy(CEMENT));
	public static final Block CEMENT_BRICKS = new Cement_Bricks();
	public static final Block CEMENT_BRICK_STAIRS = new BackroomsStairs(CEMENT_BRICKS.getDefaultState(),
			Block.Settings.copy(CEMENT_BRICKS));
	public static final Block CEMENT_BRICK_SLAB = new BackroomsSlab(Block.Settings.copy(CEMENT_BRICKS));
	// Poolstone
	public static final Block POOLSTONE = new Poolstone();
	public static final Block SMOOTH_POOLSTONE = new Smooth_Poolstone();
	public static final Block POOLSTONE_BRICKS = new Poolstone_Bricks();
	public static final Block POOLSTONE_PATH = new Poolstone_Path();
	public static final Block POOLSTONE_TILE = new Poolstone_Tile();
	// stairs
	public static final Block POOLSTONE_STAIRS = new BackroomsStairs(POOLSTONE.getDefaultState(),
			Block.Settings.copy(POOLSTONE));
	public static final Block SMOOTH_POOLSTONE_STAIRS = new BackroomsStairs(SMOOTH_POOLSTONE.getDefaultState(),
			Block.Settings.copy(SMOOTH_POOLSTONE));
	public static final Block POOLSTONE_PATH_STAIRS = new BackroomsStairs(POOLSTONE_PATH.getDefaultState(),
			Block.Settings.copy(POOLSTONE_PATH));
	public static final Block POOLSTONE_TILE_STAIRS = new BackroomsStairs(POOLSTONE_TILE.getDefaultState(),
			Block.Settings.copy(POOLSTONE_TILE));
	public static final Block POOLSTONE_BRICK_STAIRS = new BackroomsStairs(POOLSTONE_BRICKS.getDefaultState(),
			Block.Settings.copy(POOLSTONE_BRICKS));
	// slabs
	public static final Block POOLSTONE_SLAB = new BackroomsSlab(Block.Settings.copy(POOLSTONE));
	public static final Block SMOOTH_POOLSTONE_SLAB = new BackroomsSlab(Block.Settings.copy(SMOOTH_POOLSTONE));
	public static final Block POOLSTONE_PATH_SLAB = new BackroomsSlab(Block.Settings.copy(POOLSTONE_PATH));
	public static final Block POOLSTONE_TILE_SLAB = new BackroomsSlab(Block.Settings.copy(POOLSTONE_TILE));
	public static final Block POOLSTONE_BRICK_SLAB = new BackroomsSlab(Block.Settings.copy(POOLSTONE_BRICKS));
	// hm
	public static final Block VOID_BLOCK = new VoidBlock();
	public static BlockEntityType<VoidBlockEntity> VOID_BLOCK_ENTITY;
	public static final Block PIPE = new Pipe();
	public static final Block LINEDPIPE = new LinedPipe();
	// checkered
	public static final Block CHECKERED_BLOCK = new Checkered_Block();
	// colours
	public static final Block BLACK_CHECKERED = new Checkered_Block();
	public static final Block BLUE_CHECKERED = new Checkered_Block();
	public static final Block BROWN_CHECKERED = new Checkered_Block();
	public static final Block CYAN_CHECKERED = new Checkered_Block();
	public static final Block GRAY_CHECKERED = new Checkered_Block();
	public static final Block GREEN_CHECKERED = new Checkered_Block();
	public static final Block LIGHT_BLUE_CHECKERED = new Checkered_Block();
	public static final Block LIGHT_GRAY_CHECKERED = new Checkered_Block();
	public static final Block LIME_CHECKERED = new Checkered_Block();
	public static final Block MAGENTA_CHECKERED = new Checkered_Block();
	public static final Block ORANGE_CHECKERED = new Checkered_Block();
	public static final Block PINK_CHECKERED = new Checkered_Block();
	public static final Block PURPLE_CHECKERED = new Checkered_Block();
	public static final Block RED_CHECKERED = new Checkered_Block();
	public static final Block WHITE_CHECKERED = new Checkered_Block();
	public static final Block YELLOW_CHECKERED = new Checkered_Block();
	// biomes
	public static final Biome LEVEL0 = Registry.register(Registry.BIOME, new Identifier("backrooms", "level0"),
			new Level0());
	public static final Biome LEVEL0RED = Registry.register(Registry.BIOME, new Identifier("backrooms", "level0red"),
			new Level0Red());
	public static final Biome LEVEL0DOTTED = Registry.register(Registry.BIOME,
			new Identifier("backrooms", "level0dotted"), new Level0Dotted());
	public static final Biome LEVEL1 = Registry.register(Registry.BIOME, new Identifier("backrooms", "level1"),
			new Level1());
	public static final Biome LEVEL2 = Registry.register(Registry.BIOME, new Identifier("backrooms", "level2"),
			new Level2());
	public static final Biome LEVEL3 = Registry.register(Registry.BIOME, new Identifier("backrooms", "level3"),
			new Level3());
	// record discs
	public static final Item MUSIC_DISC_GLACIAL_CAVERN = new BackroomsMusicDiscItem(1,
			BackroomsSoundEvents.MUSIC_DISC_GLACIAL_CAVERN,
			(new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_THOSE_TORN_WALLS = new BackroomsMusicDiscItem(1,
			BackroomsSoundEvents.MUSIC_DISC_THOSE_TORN_WALLS,
			(new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_ITS_BEEN_SO_LONG = new BackroomsMusicDiscItem(1,
			BackroomsSoundEvents.MUSIC_DISC_ITS_BEEN_SO_LONG,
			(new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_OMAE_WA_MOU = new BackroomsMusicDiscItem(1,
			BackroomsSoundEvents.MUSIC_DISC_OMAE_WA_MOU,
			(new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_BURGERS_AND_FRIES = new BackroomsMusicDiscItem(1,
			BackroomsSoundEvents.MUSIC_DISC_BURGERS_AND_FRIES,
			(new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
	public static final Item MUSIC_DISC_012 = new BackroomsMusicDiscItem(1, BackroomsSoundEvents.MUSIC_DISC_012,
			(new Item.Settings()).maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));

	// Ore Gen
	private void handleBiome(Biome biome) {
		if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE,
							Backrooms.POOLSTONE.getDefaultState(), 25 // Ore vein size
					)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(6, // Number of
																											// veins per
																											// chunk
							0, // Bottom Offset
							0, // Min y level
							64 // Max y level
					))));
		}
	}

	// identifier
	public static Identifier getId(String id) {
		return new Identifier(MOD_ID, id);
	}

	@Override
	public void onInitialize() {

		// dimensions
		BackroomsDimensionTypes.register();
		// items
		Registry.register(Registry.ITEM, new Identifier("backrooms", "almond_water"), ALMOND_WATER);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "raw_almond_water"), RAW_ALMOND_WATER);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "wrench"), WRENCH);
		// blocks
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "wallpaper"), WALLPAPER);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "dotted_wallpaper"), DOTTED_WALLPAPER);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "red_wallpaper"), RED_WALLPAPER);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "torn_wallpaper"), TORN_WALLPAPER);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "red_torn_wallpaper"), RED_TORN_WALLPAPER);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "dotted_torn_wallpaper"), DOTTED_TORN_WALLPAPER);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "wall"), WALL);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "carpet"), CARPET);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "carpet_stairs"), CARPET_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "light"), LIGHT);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "tile"), TILE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "cement"), CEMENT);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "cement_stairs"), CEMENT_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "cement_bricks"), CEMENT_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "cement_brick_stairs"), CEMENT_BRICK_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "cement_brick_slab"), CEMENT_BRICK_SLAB);
		// poolstone
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone"), POOLSTONE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "smooth_poolstone"), SMOOTH_POOLSTONE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_path"), POOLSTONE_PATH);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_tile"), POOLSTONE_TILE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_bricks"), POOLSTONE_BRICKS);
		// stairs
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_stairs"), POOLSTONE_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "smooth_poolstone_stairs"),
				SMOOTH_POOLSTONE_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_path_stairs"), POOLSTONE_PATH_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_tile_stairs"), POOLSTONE_TILE_STAIRS);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_brick_stairs"),
				POOLSTONE_BRICK_STAIRS);
		// slabs
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_slab"), POOLSTONE_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "smooth_poolstone_slab"), SMOOTH_POOLSTONE_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_path_slab"), POOLSTONE_PATH_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_tile_slab"), POOLSTONE_TILE_SLAB);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "poolstone_brick_slab"), POOLSTONE_BRICK_SLAB);

		Registry.register(Registry.BLOCK, new Identifier("backrooms", "pipe"), PIPE);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "linedpipe"), LINEDPIPE);

		// checkered
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "black_checkered"), BLACK_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "blue_checkered"), BLUE_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "brown_checkered"), BROWN_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "cyan_checkered"), CYAN_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "gray_checkered"), GRAY_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "green_checkered"), GREEN_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "light_blue_checkered"), LIGHT_BLUE_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "light_gray_checkered"), LIGHT_GRAY_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "lime_checkered"), LIME_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "magenta_checkered"), MAGENTA_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "orange_checkered"), ORANGE_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "pink_checkered"), PINK_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "purple_checkered"), PURPLE_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "red_checkered"), RED_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "white_checkered"), WHITE_CHECKERED);
		Registry.register(Registry.BLOCK, new Identifier("backrooms", "yellow_checkered"), YELLOW_CHECKERED);

		// blockitems
		Registry.register(Registry.ITEM, new Identifier("backrooms", "wallpaper"),
				new BlockItem(WALLPAPER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "dotted_wallpaper"),
				new BlockItem(DOTTED_WALLPAPER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "red_wallpaper"),
				new BlockItem(RED_WALLPAPER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "torn_wallpaper"),
				new BlockItem(TORN_WALLPAPER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "red_torn_wallpaper"),
				new BlockItem(RED_TORN_WALLPAPER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "dotted_torn_wallpaper"),
				new BlockItem(DOTTED_TORN_WALLPAPER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "wall"),
				new BlockItem(WALL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "carpet"),
				new BlockItem(CARPET, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "carpet_stairs"),
				new BlockItem(CARPET_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "light"),
				new BlockItem(LIGHT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "tile"),
				new BlockItem(TILE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "cement"),
				new BlockItem(CEMENT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "cement_stairs"),
				new BlockItem(CEMENT_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "cement_bricks"),
				new BlockItem(CEMENT_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "cement_brick_stairs"),
				new BlockItem(CEMENT_BRICK_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "cement_brick_slab"),
				new BlockItem(CEMENT_BRICK_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		// poolstone
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
		// stairs
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_stairs"),
				new BlockItem(POOLSTONE_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "smooth_poolstone_stairs"),
				new BlockItem(SMOOTH_POOLSTONE_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_path_stairs"),
				new BlockItem(POOLSTONE_PATH_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_tile_stairs"),
				new BlockItem(POOLSTONE_TILE_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_brick_stairs"),
				new BlockItem(POOLSTONE_BRICK_STAIRS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		// slabs
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_slab"),
				new BlockItem(POOLSTONE_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "smooth_poolstone_slab"),
				new BlockItem(SMOOTH_POOLSTONE_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_path_slab"),
				new BlockItem(POOLSTONE_PATH_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_tile_slab"),
				new BlockItem(POOLSTONE_TILE_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "poolstone_brick_slab"),
				new BlockItem(POOLSTONE_BRICK_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("backrooms", "pipe"),
				new BlockItem(PIPE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		// checkered

		Registry.register(Registry.ITEM, new Identifier("backrooms", "white_checkered"),
				new BlockItem(WHITE_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "orange_checkered"),
				new BlockItem(ORANGE_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "magenta_checkered"),
				new BlockItem(MAGENTA_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "light_blue_checkered"),
				new BlockItem(LIGHT_BLUE_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "yellow_checkered"),
				new BlockItem(YELLOW_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "lime_checkered"),
				new BlockItem(LIME_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "pink_checkered"),
				new BlockItem(PINK_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "gray_checkered"),
				new BlockItem(GRAY_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "light_gray_checkered"),
				new BlockItem(LIGHT_GRAY_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "cyan_checkered"),
				new BlockItem(CYAN_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "purple_checkered"),
				new BlockItem(PURPLE_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "blue_checkered"),
				new BlockItem(BLUE_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "brown_checkered"),
				new BlockItem(BROWN_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "green_checkered"),
				new BlockItem(GREEN_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "red_checkered"),
				new BlockItem(RED_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("backrooms", "black_checkered"),
				new BlockItem(BLACK_CHECKERED, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		// hm
//		Registry.register(Registry.ITEM, new Identifier("backrooms", "void_block"),
//				new BlockItem(VOID_BLOCK, new Item.Settings().group(ItemGroup.MISC)));

		// music discs
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_glacial_cavern"),
				MUSIC_DISC_GLACIAL_CAVERN);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_those_torn_walls"),
				MUSIC_DISC_THOSE_TORN_WALLS);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_its_been_so_long"),
				MUSIC_DISC_ITS_BEEN_SO_LONG);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_omae_wa_mou"), MUSIC_DISC_OMAE_WA_MOU);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_burgers_and_fries"),
				MUSIC_DISC_BURGERS_AND_FRIES);
		Registry.register(Registry.ITEM, new Identifier("backrooms", "music_disc_012"), MUSIC_DISC_012);
		// config
		AutoConfig.register(BackroomsConfig.class, GsonConfigSerializer::new);
		// Ore Generation
		Registry.BIOME.forEach(this::handleBiome);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
		registerBlockEntity("void_block", VOID_BLOCK, VoidBlockEntity::new,
				(blockEntityType) -> VoidBlockEntity.blockEntityType = blockEntityType);

	}

	@SuppressWarnings("rawtypes")
	private <T extends BlockEntity> ItemStack registerBlockEntity(String identifier, Block block,
			Supplier<? extends T> blockEntitySupplier, Consumer<BlockEntityType> blockEntityConsumer) {

		Registry.register(Registry.BLOCK, getId(identifier), block);

		BlockEntityType blockEntityType = Registry.register(Registry.BLOCK_ENTITY_TYPE, getId(identifier),
				BlockEntityType.Builder.create(blockEntitySupplier, block).build(null));

		blockEntityConsumer.accept(blockEntityType);

		BlockItem blockItem = new BlockItem(block, new Item.Settings().group(ItemGroup.MISC));

		Registry.register(Registry.ITEM, getId(identifier), blockItem);

		return new ItemStack(blockItem);
	}

	private static Identifier register(String id) {
		return registerLootTable(new Identifier(id));
	}

	private static Identifier registerLootTable(Identifier id) {
		if (LOOT_TABLES.add(id)) {
			return id;
		} else {
			throw new IllegalArgumentException(id + " is already a registered built-in loot table");
		}
	}

	public static void ambientSoundGenerator(PlayerEntity target, SoundEvent sound, SoundCategory category,
			float volume, float pitch, Random random) {
		float d = volume + random.nextFloat();
		float e = pitch + random.nextFloat();
		target.playSound(sound, category, d, e);
	}

	public static void teleportPlayer(Entity entity, DimensionType newDimension) {
		entity.changeDimension(newDimension);
		if (newDimension == DimensionType.OVERWORLD) {
			entity.teleport(entity.getX(), entity.world.getTopY(Heightmap.Type.MOTION_BLOCKING, (int) entity.getX(), (int) entity.getZ()) + 1, entity.getZ());
		}
	}

}
