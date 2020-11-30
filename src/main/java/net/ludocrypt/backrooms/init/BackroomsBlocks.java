package net.ludocrypt.backrooms.init;

import java.util.LinkedHashMap;
import java.util.Map;

import com.terraformersmc.terraform.wood.block.TerraformStairsBlock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.CarpetBlock;
import net.ludocrypt.backrooms.blocks.LightBlock;
import net.ludocrypt.backrooms.blocks.PipeBlock;
import net.ludocrypt.backrooms.blocks.TileBlock;
import net.ludocrypt.backrooms.blocks.TornWallpaperBlock;
import net.ludocrypt.backrooms.blocks.VentBlock;
import net.ludocrypt.backrooms.blocks.VoidBlock;
import net.ludocrypt.backrooms.blocks.WallpaperBlock;
import net.ludocrypt.backrooms.blocks.entity.VoidBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsBlocks {

	// Acts as a kind of local registry for block items added by The Backrooms
	private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
	// Acts as a kind of local registry for blocks added by The Backrooms
	private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

	public static final Block WALLPAPER = add("wallpaper", new WallpaperBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).hardness(2.2f).resistance(3), BackroomsItems.WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block LINED_WALLPAPER = add("lined_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.LINED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block DOTTED_WALLPAPER = add("dotted_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.DOTTED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block ARROWED_WALLPAPER = add("arrowed_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.ARROWED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);

	public static final Block RED_WALLPAPER = add("red_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.RED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block RED_LINED_WALLPAPER = add("red_lined_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.RED_LINED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block RED_DOTTED_WALLPAPER = add("red_dotted_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.RED_DOTTED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block RED_ARROWED_WALLPAPER = add("red_arrowed_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.RED_ARROWED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);

	public static final Block OLD_WALLPAPER = add("old_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block OLD_LINED_WALLPAPER = add("old_lined_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.LINED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block OLD_DOTTED_WALLPAPER = add("old_dotted_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.DOTTED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);
	public static final Block OLD_ARROWED_WALLPAPER = add("old_arrowed_wallpaper", new WallpaperBlock(FabricBlockSettings.copy(WALLPAPER), BackroomsItems.ARROWED_WALLPAPER_PATTERN), ItemGroup.BUILDING_BLOCKS);

	public static final Block TORN_WALLPAPER = add("torn_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(WALLPAPER), WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_LINED_WALLPAPER = add("torn_lined_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(LINED_WALLPAPER), LINED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_DOTTED_WALLPAPER = add("torn_dotted_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(DOTTED_WALLPAPER), DOTTED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_ARROWED_WALLPAPER = add("torn_arrowed_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(ARROWED_WALLPAPER), ARROWED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);

	public static final Block TORN_RED_WALLPAPER = add("torn_red_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(RED_WALLPAPER), RED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_RED_LINED_WALLPAPER = add("torn_red_lined_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(RED_LINED_WALLPAPER), RED_LINED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_RED_DOTTED_WALLPAPER = add("torn_red_dotted_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(RED_DOTTED_WALLPAPER), RED_DOTTED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_RED_ARROWED_WALLPAPER = add("torn_red_arrowed_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(RED_ARROWED_WALLPAPER), RED_ARROWED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);

	public static final Block TORN_OLD_WALLPAPER = add("torn_old_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(OLD_WALLPAPER), WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_OLD_LINED_WALLPAPER = add("torn_old_lined_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(OLD_WALLPAPER), LINED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_OLD_DOTTED_WALLPAPER = add("torn_old_dotted_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(OLD_WALLPAPER), DOTTED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);
	public static final Block TORN_OLD_ARROWED_WALLPAPER = add("torn_old_arrowed_wallpaper", new TornWallpaperBlock(FabricBlockSettings.copy(OLD_WALLPAPER), ARROWED_WALLPAPER), ItemGroup.BUILDING_BLOCKS);

	public static final Block CARPET = add("carpet", new CarpetBlock(FabricBlockSettings.of(Material.WOOL).breakByTool(FabricToolTags.SHEARS, 9).sounds(BlockSoundGroup.WOOL).hardness(1).resistance(2)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CARPET_STAIRS = add("carpet_stairs", new TerraformStairsBlock(CARPET, FabricBlockSettings.copy(CARPET)), ItemGroup.BUILDING_BLOCKS);
	public static final Block TILE = add("tile", new TileBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(3).resistance(2).requiresTool()), ItemGroup.BUILDING_BLOCKS);
	public static final Block LIGHT = add("light", new LightBlock(FabricBlockSettings.copy(Blocks.REDSTONE_LAMP)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CEMENT = add("cement", new Block(FabricBlockSettings.copy(Blocks.STONE)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CRACKED_CEMENT = add("cracked_cement", new Block(FabricBlockSettings.copy(Blocks.STONE)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CEMENT_STAIRS = add("cement_stairs", new TerraformStairsBlock(CEMENT, FabricBlockSettings.copy(CEMENT)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CEMENT_BRICKS = add("cement_bricks", new Block(FabricBlockSettings.copy(CEMENT)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CRACKED_CEMENT_BRICKS = add("cracked_cement_bricks", new Block(FabricBlockSettings.copy(CEMENT_BRICKS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CEMENT_BRICK_STAIRS = add("cement_brick_stairs", new TerraformStairsBlock(CEMENT_BRICKS, FabricBlockSettings.copy(CEMENT_BRICKS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block VENT = add("vent", new VentBlock(FabricBlockSettings.copy(Blocks.STONE)), ItemGroup.BUILDING_BLOCKS);

	public static final Block PIPE = add("pipe", new PipeBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(6).resistance(6).luminance(5).requiresTool()), ItemGroup.BUILDING_BLOCKS);

	public static final Block WALL = add("wall", new Block(FabricBlockSettings.copy(Blocks.BEDROCK)), ItemGroup.BUILDING_BLOCKS);
	public static final Block VOID_BLOCK = add("void_block", new VoidBlock(FabricBlockSettings.copy(Blocks.END_GATEWAY)));

	public static BlockEntityType<VoidBlockEntity> VOID_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, Backrooms.id("void_block"), BlockEntityType.Builder.create(VoidBlockEntity::new, VOID_BLOCK).build(null));

	private static <B extends Block> B add(String name, B block, ItemGroup tab) {
		return add(name, block, new BlockItem(block, new Item.Settings().group(tab)));
	}

	private static <B extends Block> B add(String name, B block, BlockItem item) {
		add(name, block);
		if (item != null) {
			item.appendBlocks(Item.BLOCK_ITEMS, item);
			ITEMS.put(Backrooms.id(name), item);
		}
		return block;
	}

	private static <B extends Block> B add(String name, B block) {
		BLOCKS.put(Backrooms.id(name), block);
		return block;
	}

	@SuppressWarnings("unused")
	private static <I extends BlockItem> I add(String name, I item) {
		item.appendBlocks(Item.BLOCK_ITEMS, item);
		ITEMS.put(Backrooms.id(name), item);
		return item;
	}

	public static void init() {
		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
		for (Identifier id : BLOCKS.keySet()) {
			Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
		}
	}

}
