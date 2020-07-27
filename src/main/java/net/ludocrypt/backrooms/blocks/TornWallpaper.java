package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.misc.BackroomsSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TornWallpaper extends Block {

	public static final IntProperty TORN_LEVEL = IntProperty.of("torn_level", 1, 4);

	public TornWallpaper() {
		super(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)
				.hardness(2).resistance(2));
		setDefaultState(getStateManager().getDefaultState().with(TORN_LEVEL, 1));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(TORN_LEVEL);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		Random rand = world.random;
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.getItem() == Items.SHEARS) {
			if (player instanceof ServerPlayerEntity && !player.isCreative()) {
				itemStack.damage(1, rand, (ServerPlayerEntity) player);
			}
			if (world.getBlockState(pos) == Backrooms.TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 1)) {
				this.TornWallpaperSpawn(world, 4, Backrooms.WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 2)) {
				this.TornWallpaperSpawn(world, 3, Backrooms.WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 3)) {
				this.TornWallpaperSpawn(world, 2, Backrooms.WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 4)) {
				this.TornWallpaperSpawn(world, 1, Backrooms.WALLPAPER_PATTERN, pos);
			}
			if (world.getBlockState(pos) == Backrooms.RED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 1)) {
				this.TornWallpaperSpawn(world, 4, Backrooms.RED_WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.RED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 2)) {
				this.TornWallpaperSpawn(world, 3, Backrooms.RED_WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.RED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 3)) {
				this.TornWallpaperSpawn(world, 2, Backrooms.RED_WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.RED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 4)) {
				this.TornWallpaperSpawn(world, 1, Backrooms.RED_WALLPAPER_PATTERN, pos);
			}
			if (world.getBlockState(pos) == Backrooms.DOTTED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL, 1)) {
				this.TornWallpaperSpawn(world, 4, Backrooms.DOTTED_WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.DOTTED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL,
					2)) {
				this.TornWallpaperSpawn(world, 3, Backrooms.DOTTED_WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.DOTTED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL,
					3)) {
				this.TornWallpaperSpawn(world, 2, Backrooms.DOTTED_WALLPAPER_PATTERN, pos);
			} else if (world.getBlockState(pos) == Backrooms.DOTTED_TORN_WALLPAPER.getDefaultState().with(TORN_LEVEL,
					4)) {
				this.TornWallpaperSpawn(world, 1, Backrooms.DOTTED_WALLPAPER_PATTERN, pos);
			}
			world.setBlockState(pos, Blocks.OAK_PLANKS.getDefaultState());
			player.playSound(BackroomsSoundEvents.TEAR, SoundCategory.BLOCKS, 1, 1);
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.FAIL;
		}
	}

	public void TornWallpaperSpawn(World world, int level, Item item, BlockPos pos) {
		ItemStack itemStack = new ItemStack(item, level);
		ItemEntity entity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), itemStack);
		world.spawnEntity(entity);
	}

}
