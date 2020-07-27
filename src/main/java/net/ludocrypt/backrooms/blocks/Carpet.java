package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Carpet extends Block {
	public static final BooleanProperty MOLDY = BooleanProperty.of("moldy");

	public Carpet() {
		super(FabricBlockSettings.of(Material.WOOL).breakByTool(FabricToolTags.SHEARS, 9).sounds(BlockSoundGroup.WOOL)
				.hardness(1).resistance(2));
		setDefaultState(getStateManager().getDefaultState().with(MOLDY, false));

	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(MOLDY);
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (world.isWater(pos.up())) {
			world.setBlockState(pos, Backrooms.CARPET.getDefaultState().with(MOLDY, true));
		}
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.getItem() == Items.SHEARS && state.get(MOLDY) == true) {
			if (player instanceof ServerPlayerEntity && !player.isCreative()) {
				itemStack.damage(1, world.random, (ServerPlayerEntity) player);
			}
			int k = world.random.nextInt(13);
			Item item = null;
			switch (k) {
			case 0:
				item = Items.OAK_SAPLING;
				break;
			case 1:
				item = Items.OAK_SAPLING;
				break;
			case 2:
				item = Items.BIRCH_SAPLING;
				break;
			case 3:
				item = Items.JUNGLE_SAPLING;
				break;
			case 4:
				item = Items.PUMPKIN_SEEDS;
				break;
			case 5:
				item = Items.PUMPKIN_SEEDS;
				break;
			case 6:
				item = Items.PUMPKIN_SEEDS;
				break;
			case 7:
				item = Items.MELON_SEEDS;
				break;
			case 8:
				item = Items.MELON_SEEDS;
				break;
			case 9:
				item = Items.MELON_SEEDS;
				break;
			case 10:
				item = Items.MELON_SEEDS;
				break;
			case 11:
				item = Items.MELON_SEEDS;
				break;
			case 12:
				item = Items.MELON_SEEDS;
				break;
			}
			ItemEntity entity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5,
					new ItemStack(item, world.random.nextInt(5)));
			if (world.random.nextDouble() < 0.25) {
				world.spawnEntity(entity);
			}
			world.setBlockState(pos, Backrooms.CARPET.getDefaultState());
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.FAIL;
		}
	}
}
