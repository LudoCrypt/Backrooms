package net.ludocrypt.backrooms.blocks;

import java.util.Random;
import java.util.function.Consumer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TornWallpaperBlock extends WallpaperBlock {

	public final Block owner;

	public static final BooleanProperty VERY_TORN = BooleanProperty.of("very_torn");
	public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;

	public TornWallpaperBlock(Settings settings, Block owner) {
		super(settings, ((WallpaperBlock) owner).wallpaperPattern);
		this.owner = owner;
		setDefaultState(getDefaultState().with(VERY_TORN, false).with(HALF, DoubleBlockHalf.LOWER));
	}

	@Override
	protected void appendProperties(Builder<Block, BlockState> builder) {
		builder.add(VERY_TORN).add(HALF);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {

		World world = ctx.getWorld();
		BlockPos currentPos = ctx.getBlockPos();
		BlockState state = this.getDefaultState().with(VERY_TORN, true);

		BlockState aboveState = world.getBlockState(currentPos.up());
		BlockState belowState = world.getBlockState(currentPos.down());

		if (belowState.isOf(this) && belowState.get(VERY_TORN)) {
			return belowState.get(HALF).equals(DoubleBlockHalf.UPPER) ? state.with(HALF, DoubleBlockHalf.LOWER) : state.with(HALF, DoubleBlockHalf.UPPER);
		} else if (aboveState.isOf(this) && aboveState.get(VERY_TORN)) {
			return aboveState.get(HALF).equals(DoubleBlockHalf.UPPER) ? state.with(HALF, DoubleBlockHalf.LOWER) : state.with(HALF, DoubleBlockHalf.UPPER);
		} else if (belowState.isOf(Blocks.OAK_PLANKS)) {
			return state.with(HALF, DoubleBlockHalf.UPPER);
		} else if (aboveState.isOf(Blocks.OAK_PLANKS)) {
			return state.with(HALF, DoubleBlockHalf.LOWER);
		}

		return this.getDefaultState();
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

		Random rand = world.random;
		ItemStack itemStack = player.getStackInHand(hand);

		if (itemStack.getItem() == Items.SHEARS) {

			if (!world.isClient) {
				itemStack.damage(1, (LivingEntity) player, (Consumer<LivingEntity>) ((e) -> {
					((LivingEntity) e).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
				}));
			}

			if (state.get(VERY_TORN) == false) {
				world.setBlockState(pos, state.getBlock().getDefaultState().with(VERY_TORN, true).with(HALF, rand.nextBoolean() ? DoubleBlockHalf.LOWER : DoubleBlockHalf.UPPER));
			} else {
				ItemStack wallpaper = new ItemStack(((WallpaperBlock) state.getBlock()).wallpaperPattern, 1);
				ItemEntity wallpaperItem = new ItemEntity(world, hit.getPos().getX(), hit.getPos().getY(), hit.getPos().getZ(), wallpaper);
				world.spawnEntity(wallpaperItem);
				world.setBlockState(pos, Blocks.OAK_PLANKS.getDefaultState());
			}

			player.playSound(SoundEvents.BLOCK_STEM_STEP, 0.5f, rand.nextFloat());
//			Backrooms.grantAdvancement(player, Backrooms.id("tear_wallpaper"));
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.FAIL;
		}
	}

}
