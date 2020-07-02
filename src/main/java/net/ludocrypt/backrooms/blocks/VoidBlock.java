package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.entity.VoidBlockEntity;
import net.ludocrypt.backrooms.dimension.Level0DimensionType;
import net.ludocrypt.backrooms.dimension.Level0RedDimensionType;
import net.ludocrypt.backrooms.dimension.Level1DimensionType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class VoidBlock extends BlockWithEntity {

	public VoidBlock() {
		super(FabricBlockSettings.of(Material.PORTAL).strength(-1.0F, 3600000.8F).sounds(BlockSoundGroup.METAL)
				.collidable(false));
	}

	@Override
	public BlockEntity createBlockEntity(BlockView blockView) {
		return new VoidBlockEntity();
	}

	@Override
	public long getRenderingSeed(BlockState state, BlockPos pos) {
		return 31100L;
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		entity.slowMovement(state, new Vec3d(0.25D, 0.05000000074505806D, 0.25D));
		if (!world.isClient && entity instanceof PlayerEntity) {
			PlayerEntity playerEntity = (PlayerEntity) entity;
			Random k = new Random();
			if (k.nextInt(3) == 0) {
				Backrooms.teleportPlayer(entity, Level0DimensionType.LEVEL0);
			}
			if (k.nextInt(3) == 1) {
				Backrooms.teleportPlayer(entity, Level1DimensionType.LEVEL1);
			}
			if (k.nextInt(3) == 2) {
				Backrooms.teleportPlayer(entity, Level0RedDimensionType.LEVEL0RED);
			}
			if (k.nextInt(3) == 3) {
				Backrooms.teleportPlayer(entity, DimensionType.OVERWORLD);
			}
		}
	}

}