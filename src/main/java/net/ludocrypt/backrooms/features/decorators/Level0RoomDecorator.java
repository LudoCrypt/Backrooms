package net.ludocrypt.backrooms.features.decorators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;

public class Level0RoomDecorator extends Decorator<NopeDecoratorConfig> {

	public Level0RoomDecorator(Codec<NopeDecoratorConfig> codec) {
        super(codec);
    }

	@Override
	public Stream<BlockPos> getPositions(WorldAccess world, ChunkGenerator generator, Random random,
			NopeDecoratorConfig config, BlockPos pos) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(pos.getX(), 0, pos.getZ());
		List<BlockPos> blockPosList = new ArrayList<BlockPos>();

		for (int repeat = 0; repeat < BackroomsConfig.getInstance().Level0LayerCount; repeat++) {
			mutableBlockPos.move(0, 6, 0);
			blockPosList.add(mutableBlockPos.toImmutable());
		}
		return blockPosList.stream();
	}
}
