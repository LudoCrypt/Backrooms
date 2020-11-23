package net.ludocrypt.backrooms.blocks;

import java.util.Random;
import java.util.function.Consumer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WallpaperBlock extends Block {

	public Item wallpaperPattern;

	public WallpaperBlock(Settings settings, Item wallpaperPattern) {
		super(settings);
		this.wallpaperPattern = wallpaperPattern;
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		Random rand = world.random;
		ItemStack itemStack = player.getStackInHand(hand);

		if (itemStack.getItem() instanceof AxeItem) {

			if (!world.isClient) {
				itemStack.damage(1, (LivingEntity) player, (Consumer<LivingEntity>) ((e) -> {
					((LivingEntity) e).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
				}));
			}

			ItemStack wallpaper = new ItemStack(wallpaperPattern, rand.nextInt(4) + 1);
			ItemEntity wallpaperItem = new ItemEntity(world, hit.getPos().getX(), hit.getPos().getY(), hit.getPos().getZ(), wallpaper);
			world.spawnEntity(wallpaperItem);

			world.setBlockState(pos, Blocks.OAK_PLANKS.getDefaultState());
			player.playSound(SoundEvents.BLOCK_STEM_STEP, 0.5f, rand.nextFloat());
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.FAIL;
		}
	}

}
