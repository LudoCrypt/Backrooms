package net.ludocrypt.backrooms.items;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.Pipe;
import net.ludocrypt.backrooms.blocks.Tile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Wrench extends Item {

	public Wrench(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos pos = context.getBlockPos();
		World world = context.getWorld();
		BlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		PlayerEntity playerEntity = context.getPlayer();

		if (block == Backrooms.PIPE) {
			Vec3d hitPos = context.getHitPos();
			double posX = pos.getX();
			double posY = pos.getY();
			double posZ = pos.getZ();
			double hitX = hitPos.getX();
			double hitY = hitPos.getY();
			double hitZ = hitPos.getZ();
			Vec3d newPos = new Vec3d(hitX - posX, hitY - posY, hitZ - posZ);
			if (playerEntity.isSneaking()) {
				if (newPos.getY() > 0.75) {
					world.setBlockState(pos, state.cycle(Pipe.DOWN), 16);
				}
				if (newPos.getY() < 0.25) {
					world.setBlockState(pos, state.cycle(Pipe.UP), 16);
				}
				if (newPos.getZ() > 0.75) {
					world.setBlockState(pos, state.cycle(Pipe.NORTH), 16);
				}
				if (newPos.getZ() < 0.25) {
					world.setBlockState(pos, state.cycle(Pipe.SOUTH), 16);
				}
				if (newPos.getX() > 0.75) {
					world.setBlockState(pos, state.cycle(Pipe.WEST), 16);
				}
				if (newPos.getX() < 0.25) {
					world.setBlockState(pos, state.cycle(Pipe.EAST), 16);
				}
				if (newPos.getY() == 0.75 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)) {
					world.setBlockState(pos, state.cycle(Pipe.DOWN), 16);
				}
				if (newPos.getY() == 0.25 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)) {
					world.setBlockState(pos, state.cycle(Pipe.UP), 16);
				}
				if (newPos.getZ() == 0.75 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.NORTH), 16);
				}
				if (newPos.getZ() == 0.25 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.SOUTH), 16);
				}
				if (newPos.getX() == 0.75 && (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.WEST), 16);
				}
				if (newPos.getX() == 0.25 && (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.EAST), 16);
				}
			} else if (!playerEntity.isSneaking()) {
				if (newPos.getY() > 0.75) {
					world.setBlockState(pos, state.cycle(Pipe.UP), 16);
				}
				if (newPos.getY() < 0.25) {
					world.setBlockState(pos, state.cycle(Pipe.DOWN), 16);
				}
				if (newPos.getZ() > 0.75) {
					world.setBlockState(pos, state.cycle(Pipe.SOUTH), 16);
				}
				if (newPos.getZ() < 0.25) {
					world.setBlockState(pos, state.cycle(Pipe.NORTH), 16);
				}
				if (newPos.getX() > 0.75) {
					world.setBlockState(pos, state.cycle(Pipe.EAST), 16);
				}
				if (newPos.getX() < 0.25) {
					world.setBlockState(pos, state.cycle(Pipe.WEST), 16);
				}
				if (newPos.getY() == 0.75 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)) {
					world.setBlockState(pos, state.cycle(Pipe.UP), 16);
				}
				if (newPos.getY() == 0.25 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)) {
					world.setBlockState(pos, state.cycle(Pipe.DOWN), 16);
				}
				if (newPos.getZ() == 0.75 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.SOUTH), 16);
				}
				if (newPos.getZ() == 0.25 && (newPos.getX() < 0.75 && newPos.getX() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.NORTH), 16);
				}
				if (newPos.getX() == 0.75 && (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.EAST), 16);
				}
				if (newPos.getX() == 0.25 && (newPos.getZ() < 0.75 && newPos.getZ() > 0.25)
						&& (newPos.getY() > 0.25 && newPos.getY() < 0.75)) {
					world.setBlockState(pos, state.cycle(Pipe.WEST), 16);
				}
			}
			return ActionResult.SUCCESS;
		} else if (block == Backrooms.TILE) {
			world.setBlockState(pos,
					Backrooms.TILE.getDefaultState().with(Tile.SINGLE, true).with(Tile.FACING, Direction.EAST));
			return ActionResult.SUCCESS;
		}

		else {
			return ActionResult.FAIL;
		}
	}
}
