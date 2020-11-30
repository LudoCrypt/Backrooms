package net.ludocrypt.backrooms.features.rooms.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorContext;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;

public class Level2RoomDecorator extends Decorator<NopeDecoratorConfig> {

	public Level2RoomDecorator(Codec<NopeDecoratorConfig> codec) {
		super(codec);
	}

	@Override
	public Stream<BlockPos> getPositions(DecoratorContext context, Random random, NopeDecoratorConfig config, BlockPos pos) {

		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(pos.getX(), 4, pos.getZ());
		List<BlockPos> blockPosList = new ArrayList<BlockPos>();

		blockPosList.add(mutableBlockPos.toImmutable());

		return blockPosList.stream();
	}
}
