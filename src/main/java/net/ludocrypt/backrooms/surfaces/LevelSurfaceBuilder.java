package net.ludocrypt.backrooms.surfaces;

import java.util.Random;

import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class LevelSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
	public LevelSurfaceBuilder() {
		super(TernarySurfaceConfig.CODEC);
	}

	@Override
	public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig surfaceBlocks) {
		for (int y = 0; y < 256; y++) {
			BlockPos pos = new BlockPos(x & 15, y, z & 15);
			chunk.setBlockState(pos, BackroomsBlocks.WALL.getDefaultState(), false);
		}
	}
}
