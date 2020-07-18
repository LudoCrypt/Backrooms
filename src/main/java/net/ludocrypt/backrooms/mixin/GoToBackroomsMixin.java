package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.BackroomsDimensionTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.thrown.ThrownEnderpearlEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(ThrownEnderpearlEntity.class)
public class GoToBackroomsMixin {
	@Inject(method = "onCollision", at = @At(value = "HEAD"), cancellable = true)
	private void onPearlHit(HitResult hitResult, CallbackInfo ci) {
		ThrownEnderpearlEntity pearlEntity = ((ThrownEnderpearlEntity) (Object) this);
		World world = pearlEntity.world;
		if ((!world.isClient && pearlEntity.getOwner() instanceof ServerPlayerEntity)) {
			ServerPlayerEntity playerEntity = (ServerPlayerEntity) pearlEntity.getOwner();
			Vec3d hitBlockPos = hitResult.getPos();
			if (world.getBlockState(new BlockPos(hitBlockPos.add(0.1D, 0, 0))).getBlock() != Blocks.AIR
					|| world.getBlockState(new BlockPos(hitBlockPos.add(-0.1D, 0, 0))).getBlock() != Blocks.AIR
					|| world.getBlockState(new BlockPos(hitBlockPos.add(0, 0, 0.1D))).getBlock() != Blocks.AIR
					|| world.getBlockState(new BlockPos(hitBlockPos.add(0, 0, -0.1D))).getBlock() != Blocks.AIR
					|| world.getBlockState(new BlockPos(hitBlockPos.add(0, 0.1D, 0))).getBlock() != Blocks.AIR
					|| world.getBlockState(new BlockPos(hitBlockPos.add(0, -0.1D, 0))).getBlock() != Blocks.AIR) {
				if (Math.random() < (BackroomsConfig.getInstance().EnderPearlChance)) {
					if ((playerEntity.dimension != BackroomsDimensionTypes.LEVEL0)) {
						ci.cancel();
						pearlEntity.kill();
						Backrooms.teleportPlayer(playerEntity, BackroomsDimensionTypes.LEVEL0);
					}
				}

			}
		}
	}
}