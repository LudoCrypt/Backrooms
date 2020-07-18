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

public class Level0RedDimension extends Dimension {
	private static final Vec3d FOG_COLOR = new Vec3d(0.54, 0.0, 0.0);

	public Level0RedDimension(World world, DimensionType type) {
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
		OverworldChunkGeneratorConfig generatorConfig = Level0RedDimension.getDefaultConfig();
		FixedBiomeSourceConfig biomeConfig = BiomeSourceType.FIXED.getConfig(world.getLevelProperties())
				.setBiome(Backrooms.LEVEL0RED);
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
		final int dayLength = 400;
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
		return BackroomsDimensionTypes.LEVEL0RED;
	}

	@Environment(EnvType.CLIENT)
	@Override
	public Vec3d getFogColor(float skyAngle, float tickDelta) {
		return FOG_COLOR;
	}
}