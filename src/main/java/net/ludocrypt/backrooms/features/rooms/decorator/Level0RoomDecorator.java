package net.ludocrypt.backrooms.features.rooms.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.features.config.RoomDecorator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorContext;

public class Level0RoomDecorator extends Decorator<RoomDecorator> {

	public Level0RoomDecorator(Codec<RoomDecorator> codec) {
		super(codec);
	}

	@Override
	public Stream<BlockPos> getPositions(DecoratorContext context, Random random, RoomDecorator config, BlockPos pos) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(pos.getX(), 4, pos.getZ());
		List<BlockPos> blockPosList = new ArrayList<BlockPos>();

		for (int i = 0; i < config.layer_count; i++) {
			mutableBlockPos.move(0, 9, 0);
			blockPosList.add(mutableBlockPos.toImmutable());
		}
		return blockPosList.stream();
	}
}
