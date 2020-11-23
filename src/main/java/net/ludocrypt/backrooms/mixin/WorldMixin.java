package net.ludocrypt.backrooms.mixin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import net.ludocrypt.backrooms.access.BackroomsWorldAccess;
import net.ludocrypt.backrooms.world.Level0;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

@Mixin(World.class)
public abstract class WorldMixin implements BackroomsWorldAccess, WorldAccess, AutoCloseable {

	@Unique
	private Map<RegistryKey<World>, Double> levelWorld = new LinkedHashMap<RegistryKey<World>, Double>();
	@Unique
	private boolean areLightsOff = false;

	@Unique
	private DynamicRegistryManager dynamicRegistryManager;

	@Shadow
	public RegistryKey<World> registryKey;

	@Override
	public Map<RegistryKey<World>, Double> getLevelWorlds() {
		return levelWorld;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RegistryKey<World> calculateNextLevel(@Nullable Random rand) {
		RegistryKey<World> nextLevel = null;
		double maxChance = 0;

		if (rand == null) {
			rand = this.getRandom();
		}

		for (Entry<RegistryKey<World>, Double> entry : levelWorld.entrySet()) {
			RegistryKey<World> level = entry.getKey();
			double chance = entry.getValue();
			if (nextLevel == null) {
				if (rand.nextDouble() < chance) {
					nextLevel = level;
				}
				if (chance > maxChance) {
					maxChance = chance;
				}
			}
		}

		if (nextLevel == null) {
			System.out.println("Chance set returned all below, trying highest");
			for (int i = 0; i < levelWorld.values().size(); i++) {
				double chance = (double) levelWorld.values().toArray()[i];
				if (chance == maxChance) {
					nextLevel = (RegistryKey<World>) levelWorld.keySet().toArray()[i];
				}
			}
		}

		if (nextLevel == null) {
			System.out.println("List empty, throwing to 0");
			nextLevel = Level0.LEVEL_0_WORLD;
		}

		return nextLevel;
	}

	@Override
	public void putLevelWorld(RegistryKey<World> world, double chance) {
		levelWorld.put(world, chance);
	}

}
