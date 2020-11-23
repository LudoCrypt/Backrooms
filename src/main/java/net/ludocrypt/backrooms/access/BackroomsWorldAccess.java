package net.ludocrypt.backrooms.access;

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public interface BackroomsWorldAccess {

	public Map<RegistryKey<World>, Double> getLevelWorlds();

	public RegistryKey<World> calculateNextLevel(@Nullable Random rand);

	public void putLevelWorld(RegistryKey<World> world, double chance);

}
