package net.ludocrypt.backrooms.blocks.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class VoidBlockEntity extends EndPortalBlockEntity
{
	public static BlockEntityType<?> blockEntityType;

	public VoidBlockEntity()
	{
		super(blockEntityType);
	}

	@SuppressWarnings("static-access")
	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldDrawSide(Direction direction)
	{
		BlockState state = world.getBlockState(getPos());
		return state.getBlock().shouldDrawSide(state, (BlockView) world, getPos(), direction);
	}
}