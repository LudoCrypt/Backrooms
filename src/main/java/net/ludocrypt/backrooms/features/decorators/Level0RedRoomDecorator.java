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

public class Level0RedRoomDecorator extends Decorator<NopeDecoratorConfig> {

	public Level0RedRoomDecorator(Function<Dynamic<?>, ? extends NopeDecoratorConfig> configFactory) {
		super(configFactory);
	}

	public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator,
			Random rand, NopeDecoratorConfig placementConfig, BlockPos pos) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(pos.getX() - 12, -2, pos.getZ() + 8);
		List<BlockPos> blockPosList = new ArrayList<BlockPos>();
		mutableBlockPos.setOffset(0, 6, 0);
		blockPosList.add(mutableBlockPos.toImmutable());

		return blockPosList.stream();
	}
}
