package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.entity.VoidBlockEntity;
import net.ludocrypt.backrooms.dimension.BackroomsDimensionTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class VoidBlock extends BlockWithEntity {

	public VoidBlock() {
		super(FabricBlockSettings.of(Material.PORTAL).strength(-1.0F, 3600000.8F).sounds(BlockSoundGroup.METAL)
				.collidable(false).nonOpaque());
	}

	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return new VoidBlockEntity();
	}

	@Override
	public long getRenderingSeed(BlockState state, BlockPos pos) {
		return 9500L;
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		Random rand = new Random();
		int k = 0;
		double t = 0.0;
		entity.slowMovement(state, new Vec3d(0.25D, 0.05000000074505806D, 0.25D));
		if (!world.isClient && !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals()
				&& VoxelShapes.matchesAnywhere(
						VoxelShapes.cuboid(entity.getBoundingBox().offset((double) (-pos.getX()),
								(double) (-pos.getY()), (double) (-pos.getZ()))),
						state.getOutlineShape(world, pos), BooleanBiFunction.AND)) {
			if (entity.dimension == BackroomsDimensionTypes.LEVEL0
					|| entity.dimension == BackroomsDimensionTypes.LEVEL0DOTTED
					|| entity.dimension == BackroomsDimensionTypes.LEVEL0RED) {
				t = rand.nextDouble();
				if (t < 0.1) {
					Backrooms.teleportPlayer(entity, DimensionType.OVERWORLD);
				} else if (t < 0.25) {
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL1);
				} else if (t < 0.5) {
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL0DOTTED);
				} else if (t < 0.75) {
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL0RED);
				} else {
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL0);
				}
			}
			if (entity.dimension == BackroomsDimensionTypes.LEVEL1) {
				k = rand.nextInt(3);
				switch (k) {
				case 0:
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL0);
					break;
				case 1:
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL1);
					break;
				case 2:
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL2);
					break;
				}
			}
			if (entity.dimension == BackroomsDimensionTypes.LEVEL2) {
				k = rand.nextInt(4);
				switch (k) {
				case 0:
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL0);
					break;
				case 1:
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL1);
					break;
				case 2:
					Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL2);
					break;
				case 3:
					Backrooms.teleportPlayer(entity, DimensionType.OVERWORLD);
					break;
				}
			}
			if (entity.dimension == DimensionType.OVERWORLD) {
				Backrooms.teleportPlayer(entity, BackroomsDimensionTypes.LEVEL0);

			}
		}
	}

}