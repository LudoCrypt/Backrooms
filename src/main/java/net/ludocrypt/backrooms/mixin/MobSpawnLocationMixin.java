package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.BDimension;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

@Mixin(SpawnHelper.class)
public class MobSpawnLocationMixin {

	// Pretty much stolen directly from the bumblezone

	// Prevents mobs from spawning above
	@Inject(method = "Lnet/minecraft/world/SpawnHelper;spawnEntitiesInChunk(Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/chunk/Chunk;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/SpawnHelper$Checker;Lnet/minecraft/world/SpawnHelper$Runner;)V", at = @At(value = "HEAD"), cancellable = true)
	private static void spawnEntitiesInChunk(SpawnGroup group, ServerWorld world, Chunk chunk, BlockPos pos,
			SpawnHelper.Checker checker, SpawnHelper.Runner runner, CallbackInfo ci) {
		int yheight = 75;
		Biome biomeIn = world.getBiome(pos);
		if (biomeIn == Backrooms.LEVEL0 || biomeIn == Backrooms.LEVEL0DECREPIT || biomeIn == Backrooms.LEVEL0DOTTED
				|| biomeIn == Backrooms.LEVEL0DOTTEDRED || biomeIn == Backrooms.LEVEL0RED) {
			if (BackroomsConfig.getInstance().Level0LayerCount > 11) {
				yheight = (BackroomsConfig.getInstance().Level0LayerCount * 6) + 8;
			}
		} else if (biomeIn == Backrooms.LEVEL1 || biomeIn == Backrooms.LEVEL1OFF) {
			if (BackroomsConfig.getInstance().Level1LayerCount > 11) {
				yheight = (BackroomsConfig.getInstance().Level1LayerCount * 6) + 8;
			}
		}
		// No mobs allowed to spawn on roof
		if ((world.getRegistryKey() == BDimension.LEVEL0WORLD || world.getRegistryKey() == BDimension.LEVEL1WORLD
				|| world.getRegistryKey() == BDimension.LEVEL2WORLD || world.getRegistryKey() == BDimension.LEVEL3WORLD)
				&& pos.getY() > yheight) {
			ci.cancel();
		}
	}

}