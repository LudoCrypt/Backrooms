package net.ludocrypt.backrooms.features.rooms;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.init.BackroomsFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.RuleStructureProcessor;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorRule;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class Level2Room extends Feature<DefaultFeatureConfig> {

	public static Logger LOGGER = LogManager.getLogger();

	public Level2Room() {
		super(DefaultFeatureConfig.CODEC);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig config) {

		StructureManager templatemanager = world.toServerWorld().getStructureManager();
		Structure template = templatemanager.getStructure(Backrooms.id("level/two/di"));

		if (template == null) {
			LOGGER.warn("NBT does not exist!");
			return false;
		}

		StructurePlacementData placementsettings = (new StructurePlacementData()).setMirror(BlockMirror.NONE).setRotation(BlockRotation.NONE).setIgnoreEntities(false).setChunkPosition(null);
		template.place(world, pos, placementsettings, random);

		return true;
	}

	public static void init() {

		List<StructureProcessorRule> BUILDING_RULES = Lists.newArrayList();

		StructureProcessorList RANDOM_BLOCK_AFFECTOR_PROCESSOR = register(new StructureProcessorList(ImmutableList.of(new RuleStructureProcessor(BUILDING_RULES), new RandomBlockAffectorProcessor())), "level_two_randomizer");

		// Random
		StructurePools.register(new StructurePool(Backrooms.id("level/two/random"), new Identifier("empty"), ImmutableList.of(Pair.of(StructurePoolElement.method_30426("backrooms:level/two/uo", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ut", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ui", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ub", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ro", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/rt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ri", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/rb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/do", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/dt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/di", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/db", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lo", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/li", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1)), StructurePool.Projection.RIGID));

		// Up
		StructurePools.register(new StructurePool(Backrooms.id("level/two/up"), new Identifier("empty"), ImmutableList.of(Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ui", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 8), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/rb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 7), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 6), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/dt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 5), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/rt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 4), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/db", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 3), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/di", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 2), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/do", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1)), StructurePool.Projection.RIGID));

		// Down
		StructurePools.register(new StructurePool(Backrooms.id("level/two/down"), new Identifier("empty"), ImmutableList.of(Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ui", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 8), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/rb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 7), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 6), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ut", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 5), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 4), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ub", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 3), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/di", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 2), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/uo", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1)), StructurePool.Projection.RIGID));

		// Left
		StructurePools.register(new StructurePool(Backrooms.id("level/two/left"), new Identifier("empty"), ImmutableList.of(Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ri", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 8), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ub", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 7), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/db", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 6), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ut", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 5), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/rt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 4), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/rb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 3), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/di", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 2), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ro", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1)), StructurePool.Projection.RIGID));

		// Right
		StructurePools.register(new StructurePool(Backrooms.id("level/two/right"), new Identifier("empty"), ImmutableList.of(Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ri", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 8), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/ub", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 7), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/db", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 6), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/dt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 5), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lt", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 4), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lb", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 3), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/di", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 2), Pair.of(StructurePoolElement.method_30426("backrooms:level/two/lo", RANDOM_BLOCK_AFFECTOR_PROCESSOR), 1)), StructurePool.Projection.RIGID));

	}

	public static class RandomBlockAffectorProcessor extends StructureProcessor {
		public static final RandomBlockAffectorProcessor INSTANCE = new RandomBlockAffectorProcessor();
		public static final Codec<RandomBlockAffectorProcessor> CODEC = Codec.unit(() -> INSTANCE);

		@Override
		public Structure.StructureBlockInfo process(WorldView worldView, BlockPos pos, BlockPos blockPos, Structure.StructureBlockInfo info, Structure.StructureBlockInfo info2, StructurePlacementData data) {
			@SuppressWarnings("unused")
			BlockState blockState = info2.state;
//			if (blockState.getBlock() == Blocks.BARREL) {
//				BlockEntity be = worldView.getBlockEntity(blockPos);
//				if (be instanceof BarrelBlockEntity) {
//					BarrelBlockEntity barrel = (BarrelBlockEntity) be;
//					barrel.setLootTable(Backrooms.id("ghost_town/loot_" + RandomUtil.RANDOM.nextInt(3)), RandomUtil.RANDOM.nextLong());
//				}
//			}

			return info2;
		}

		@Override
		protected StructureProcessorType<?> getType() {
			return BackroomsFeatures.LEVEL_TWO_RANDOM_BLOCK_AFFECTOR_PROCESSOR;
		}

	}

	public static StructureProcessorList register(StructureProcessorList li, String name) {
		BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST, Backrooms.id(name), li);
		return li;
	}
}
