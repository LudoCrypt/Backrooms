package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.blocks.entity.VoidBlockEntity;
import net.ludocrypt.backrooms.dimension.BDimension;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class VoidBlock extends BlockWithEntity {

	public VoidBlock() {
		super(FabricBlockSettings.of(Material.PORTAL).strength(100000F, 3600000.8F).sounds(BlockSoundGroup.METAL)
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
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		Backrooms.SEED = world.getServer().getOverworld().getSeed();
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		Random generator = new Random(Backrooms.SEED);
		long seed = (Backrooms.SEED);
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = pos.getX() * l ^ pos.getY() * m ^ pos.getZ() * n ^ seed;
		generator = new Random(o);
		Random rand = generator;
		double t = 0.0;
		if (!(entity instanceof ItemEntity)) {
			entity.slowMovement(state, new Vec3d(0.25D, 0.05000000074505806D, 0.25D));
		}
		if ((!world.isClient && !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals()
				&& VoxelShapes.matchesAnywhere(
						VoxelShapes.cuboid(entity.getBoundingBox().offset((double) (-pos.getX()),
								(double) (-pos.getY()), (double) (-pos.getZ()))),
						state.getOutlineShape(world, pos), BooleanBiFunction.AND))
				&& !(entity instanceof ItemEntity)) {
			ServerWorld overworld = entity.getServer().getWorld(World.OVERWORLD);
			ServerWorld lvl0 = entity.getServer().getWorld(BDimension.LEVEL0WORLD);
			ServerWorld lvl1 = entity.getServer().getWorld(BDimension.LEVEL1WORLD);
			ServerWorld lvl2 = entity.getServer().getWorld(BDimension.LEVEL2WORLD);
			ServerWorld lvl3 = entity.getServer().getWorld(BDimension.LEVEL3WORLD);

			if (world.getRegistryKey() == BDimension.LEVEL0WORLD) {
				t = rand.nextDouble();
				if (t < 0.001) {
					entity.moveToWorld(overworld);
					if (entity instanceof ServerPlayerEntity) {
						Backrooms.grantAdvancement((ServerPlayerEntity) entity,
								new Identifier("backrooms", "come_back"));
					}
				} else if (t < 0.25) {
					entity.moveToWorld(lvl1);
				} else if (t < 0.5) {
					entity.moveToWorld(lvl1);
				} else if (t < 0.75) {
					entity.moveToWorld(lvl0);
				} else {
					entity.moveToWorld(lvl0);
				}
			} else if (entity.world.getRegistryKey() == BDimension.LEVEL1WORLD) {
				t = rand.nextDouble();
				if (t < 0.005) {
					entity.moveToWorld(lvl1);
				} else if (t < 0.25) {
					entity.moveToWorld(lvl2);
				} else if (t < 0.5) {
					entity.moveToWorld(lvl2);
				} else if (t < 0.75) {
					entity.moveToWorld(lvl0);
				} else {
					entity.moveToWorld(lvl1);
				}
			} else if (entity.world.getRegistryKey() == BDimension.LEVEL2WORLD) {
				t = rand.nextDouble();
				if (t < 0.05) {
					entity.moveToWorld(overworld);
					if (entity instanceof ServerPlayerEntity) {
						Backrooms.grantAdvancement((ServerPlayerEntity) entity,
								new Identifier("backrooms", "come_back"));
					}
				} else if (t < 0.25) {
					entity.moveToWorld(lvl3);
				} else if (t < 0.5) {
					entity.moveToWorld(overworld);
					if (entity instanceof ServerPlayerEntity) {
						Backrooms.grantAdvancement((ServerPlayerEntity) entity,
								new Identifier("backrooms", "come_back"));
					}
				} else if (t < 0.75) {
					entity.moveToWorld(lvl2);
				} else {
					entity.moveToWorld(lvl3);
				}
			} else if (entity.world.getRegistryKey() == BDimension.LEVEL3WORLD) {
				t = rand.nextDouble();
				if (t < 0.05) {
					entity.moveToWorld(lvl2);
				} else if (t < 0.15) {
					entity.moveToWorld(overworld);
					if (entity instanceof ServerPlayerEntity) {
						Backrooms.grantAdvancement((ServerPlayerEntity) entity,
								new Identifier("backrooms", "come_back"));
					}
				} else if (t < 0.5) {
					entity.moveToWorld(lvl2);
				} else if (t < 0.75) {
					entity.moveToWorld(overworld);
					if (entity instanceof ServerPlayerEntity) {
						Backrooms.grantAdvancement((ServerPlayerEntity) entity,
								new Identifier("backrooms", "come_back"));
					}
				} else {
					entity.moveToWorld(lvl3);
				}
			} else if (entity.world.getRegistryKey() == World.OVERWORLD) {
				entity.moveToWorld(lvl0);
			}
		}
	}

}