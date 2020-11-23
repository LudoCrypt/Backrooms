package net.ludocrypt.backrooms.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public class RoomConfig implements FeatureConfig {

	public final BlockState wall;
	public final BlockState torn_wall;
	public final BlockState floor;
	public final BlockState moldy_floor;
	public final BlockState stairs;
	public final int height;
	public final boolean has_stairs;
	public final double door_chance;
	public final double light_chance;
	public final double light_off_chance;
	public final double torn_chance;
	public final double tall_torn_chance;
	public final double mold_chance;
	public final double stair_chance;

	public RoomConfig(BlockState wall, BlockState torn_wall, BlockState floor, BlockState moldy_floor, BlockState stairs, int height, boolean has_stairs, double DoorChance, double LightChance, double LightOffChance, double TornChance, double TallTornChance, double MoldChance, double StairChance) {
		this.wall = wall;
		this.torn_wall = torn_wall;
		this.floor = floor;
		this.moldy_floor = moldy_floor;
		this.stairs = stairs;
		this.height = height;
		this.has_stairs = has_stairs;
		this.door_chance = DoorChance;
		this.light_chance = LightChance;
		this.light_off_chance = LightOffChance;
		this.torn_chance = TornChance;
		this.tall_torn_chance = TallTornChance;
		this.mold_chance = MoldChance;
		this.stair_chance = StairChance;
	}

	public static final Codec<RoomConfig> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(BlockState.CODEC.fieldOf("wall").forGetter((config) -> {
			return config.wall;
		}), BlockState.CODEC.fieldOf("torn_wall").forGetter((config) -> {
			return config.torn_wall;
		}), BlockState.CODEC.fieldOf("floor").forGetter((config) -> {
			return config.floor;
		}), BlockState.CODEC.fieldOf("moldy_floor").forGetter((config) -> {
			return config.moldy_floor;
		}), BlockState.CODEC.fieldOf("stairs").forGetter((config) -> {
			return config.stairs;
		}), Codec.INT.fieldOf("height").forGetter((config) -> {
			return config.height;
		}), Codec.BOOL.fieldOf("has_stairs").forGetter((config) -> {
			return config.has_stairs;
		}), Codec.DOUBLE.fieldOf("door_chance").forGetter((config) -> {
			return config.door_chance;
		}), Codec.DOUBLE.fieldOf("light_chance").forGetter((config) -> {
			return config.light_chance;
		}), Codec.DOUBLE.fieldOf("light_off_chance").forGetter((config) -> {
			return config.light_off_chance;
		}), Codec.DOUBLE.fieldOf("torn_chance").forGetter((config) -> {
			return config.torn_chance;
		}), Codec.DOUBLE.fieldOf("tall_torn_chance").forGetter((config) -> {
			return config.tall_torn_chance;
		}), Codec.DOUBLE.fieldOf("mold_chance").forGetter((config) -> {
			return config.mold_chance;
		}), Codec.DOUBLE.fieldOf("stair_chance").forGetter((config) -> {
			return config.stair_chance;
		})).apply(instance, RoomConfig::new);
	});
}
