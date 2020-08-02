package net.ludocrypt.backrooms.items;

import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CompressedWallPickaxe extends PickaxeItem {

	public CompressedWallPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}

	@Override
	public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
		if (state == Backrooms.WALL.getDefaultState()) {
			return 15000;
		} else if (state == Backrooms.COMPRESSED_WALL.getDefaultState()) {
			return 10000;
		} else if (state == Backrooms.VOID_BLOCK.getDefaultState()) {
			return 25000;
		} else {
			return 32767;
		}
	}

	@Override
	public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
		if (state == Backrooms.WALL.getDefaultState() || state == Backrooms.COMPRESSED_WALL.getDefaultState()
				|| state == Backrooms.VOID_BLOCK.getDefaultState()) {
			return true;
		} else {
			return false;
		}
	}

}
