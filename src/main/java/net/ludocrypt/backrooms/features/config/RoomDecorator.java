package net.ludocrypt.backrooms.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.gen.decorator.DecoratorConfig;

public class RoomDecorator implements DecoratorConfig {

	public final int layer_count;

	public RoomDecorator(int LayerCount) {
		this.layer_count = LayerCount;
	}

	public static final Codec<RoomDecorator> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Codec.INT.fieldOf("layer_count").forGetter((config) -> {
			return config.layer_count;
		})).apply(instance, RoomDecorator::new);
	});
}
