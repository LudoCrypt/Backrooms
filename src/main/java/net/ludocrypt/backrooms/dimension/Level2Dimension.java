package net.ludocrypt.backrooms.dimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.biome.source.FixedBiomeSourceConfig;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;
import net.minecraft.world.gen.chunk.OverworldChunkGeneratorConfig;

public class Level2Dimension extends Dimension {
	private static final Vec3d FOG_COLOR = new Vec3d(1, 1, 1);

	public Level2Dimension(World world, DimensionType type) {
		super(world, type, 0.1f);
	}

	public static OverworldChunkGeneratorConfig getDefaultConfig() {
		OverworldChunkGeneratorConfig OverworldChunkGeneratorConfig = (OverworldChunkGeneratorConfig) ChunkGeneratorType.SURFACE
				.createSettings();
		OverworldChunkGeneratorConfig.setDefaultBlock(Backrooms.WALL.getDefaultState());
		OverworldChunkGeneratorConfig.setDefaultFluid(Blocks.AIR.getDefaultState());
		return OverworldChunkGeneratorConfig;
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		OverworldChunkGeneratorConfig generatorConfig = Level2Dimension.getDefaultConfig();
		FixedBiomeSourceConfig biomeConfig = BiomeSourceType.FIXED.getConfig(world.getLevelProperties())
				.setBiome(Backrooms.LEVEL2);
		return ChunkGeneratorType.SURFACE.create(world, BiomeSourceType.FIXED.applyConfig(biomeConfig),
				generatorConfig);
	}

	@Override
	public BlockPos getSpawningBlockInChunk(ChunkPos chunkPos, boolean checkMobSpawnValidity) {
		return null;
	}

	@Override
	public BlockPos getTopSpawningBlockPosition(int x, int z, boolean checkMobSpawnValidity) {
		return null;
	}

	@Override
	public float getSkyAngle(long worldTime, float tickDelta) {
		final int dayLength = 980000;
		double daysPassed = ((double) worldTime + tickDelta) / dayLength;
		return (float) MathHelper.fractionalPart(daysPassed - 0.25);
	}

	@Override
	public boolean hasVisibleSky() {
		return true;
	}

	@Override
	public boolean canPlayersSleep() {
		return false;
	}

	@Environment(EnvType.CLIENT)
	@Override
	public boolean isFogThick(int x, int z) {
		return true;
	}

	@Override
	public DimensionType getType() {
		return BackroomsDimensionTypes.LEVEL2;
	}

	@Environment(EnvType.CLIENT)
	@Override
	public Vec3d getFogColor(float skyAngle, float tickDelta) {
		return FOG_COLOR;
	}
}