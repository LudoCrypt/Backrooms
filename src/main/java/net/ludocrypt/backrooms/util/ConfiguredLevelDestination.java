package net.ludocrypt.backrooms.util;

import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.Identifier;

public class ConfiguredLevelDestination {

	private List<Identifier> destinationList;
	private List<Double> chanceList;

	public ConfiguredLevelDestination(List<Identifier> destinationList, List<Double> chanceList) {
		this.destinationList = destinationList;
		this.chanceList = chanceList;
	}

	public List<Double> getChanceList() {
		return chanceList;
	}

	public List<Identifier> getDestinationList() {
		return destinationList;
	}

	public ConfiguredLevelDestination addDestination(Identifier id) {
		destinationList.add(id);
		return this;
	}

	public ConfiguredLevelDestination addDouble(double chance) {
		chanceList.add(chance);
		return this;
	}

	public ConfiguredLevelDestination add(Identifier id, double chance) {
		destinationList.add(id);
		chanceList.add(chance);
		return this;
	}

	public static final Codec<ConfiguredLevelDestination> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Codec.list(Identifier.CODEC).fieldOf("destinationList").forGetter((configuredLevelDestination) -> {
			return configuredLevelDestination.destinationList;
		}), Codec.list(Codec.DOUBLE).fieldOf("chanceList").forGetter((configuredLevelDestination) -> {
			return configuredLevelDestination.chanceList;
		})).apply(instance, ConfiguredLevelDestination::new);
	});

}
