package net.ludocrypt.backrooms.features.decorators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;

public class Level3RoomDecorator extends Decorator<NopeDecoratorConfig> {

	public Level3RoomDecorator(Function<Dynamic<?>, ? extends NopeDecoratorConfig> configFactory) {
		super(configFactory);
	}

	public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator,
			Random rand, NopeDecoratorConfig placementConfig, BlockPos pos) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(pos.getX(), + 4, pos.getZ());
		List<BlockPos> blockPosList = new ArrayList<BlockPos>();

			blockPosList.add(mutableBlockPos.toImmutable());
			blockPosList.add(mutableBlockPos.toImmutable().add(4, 0, 0));
			blockPosList.add(mutableBlockPos.toImmutable().add(8, 0, 0));
			blockPosList.add(mutableBlockPos.toImmutable().add(12, 0, 0));
			blockPosList.add(mutableBlockPos.toImmutable().add(0, 0, 4));
			blockPosList.add(mutableBlockPos.toImmutable().add(4, 0, 4));
			blockPosList.add(mutableBlockPos.toImmutable().add(8, 0, 4));
			blockPosList.add(mutableBlockPos.toImmutable().add(12, 0, 4));
			blockPosList.add(mutableBlockPos.toImmutable().add(0, 0, 8));
			blockPosList.add(mutableBlockPos.toImmutable().add(4, 0, 8));
			blockPosList.add(mutableBlockPos.toImmutable().add(8, 0, 8));
			blockPosList.add(mutableBlockPos.toImmutable().add(12, 0, 8));
			blockPosList.add(mutableBlockPos.toImmutable().add(0, 0, 12));
			blockPosList.add(mutableBlockPos.toImmutable().add(4, 0, 12));
			blockPosList.add(mutableBlockPos.toImmutable().add(8, 0, 12));
			blockPosList.add(mutableBlockPos.toImmutable().add(12, 0, 12));
			


		return blockPosList.stream();
	}
}
