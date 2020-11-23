package net.ludocrypt.backrooms.mixin;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.access.BackroomsWorldAccess;
import net.ludocrypt.backrooms.init.BackroomsRegistries;
import net.ludocrypt.backrooms.util.ConfiguredLevelDestination;
import net.ludocrypt.backrooms.util.DimensionUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Spawner;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.level.storage.LevelStorage;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World implements BackroomsWorldAccess {

	protected ServerWorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef, DimensionType dimensionType, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long seed) {
		super(properties, registryRef, dimensionType, profiler, isClient, debugWorld, seed);
	}

	@Shadow
	private MinecraftServer server;

	@Inject(method = "<init>", at = @At("TAIL"))
	private void BACKROOMS_serverWorldInit(MinecraftServer server, Executor workerExecutor, LevelStorage.Session session, ServerWorldProperties properties, RegistryKey<World> registryKey, DimensionType dimensionType, WorldGenerationProgressListener worldGenerationProgressListener, ChunkGenerator chunkGenerator, boolean debugWorld, long l, List<Spawner> list, boolean bl, CallbackInfo ci) {
		initWorld();
	}

	private void initWorld() {

		server.getRegistryManager().get(BackroomsRegistries.CONFIGURED_LEVEL_DESTINATIONS_KEY).getEntries().forEach((entrySet) -> {

			RegistryKey<ConfiguredLevelDestination> key = entrySet.getKey();
			ConfiguredLevelDestination cld = entrySet.getValue();

			String plusAddition = registryKey.getValue().getPath() + "_additions";
			String keyPath = key.getValue().getPath();

			if (keyPath.matches(plusAddition)) {
				addFromCLD(cld);
			}
		});

	}

	private void addFromCLD(ConfiguredLevelDestination cld) {

		List<Identifier> destinationList = cld.getDestinationList();
		List<Double> chanceList = cld.getChanceList();

		for (int i = 0; i < cld.getDestinationList().size(); i++) {
			Identifier configuredId = destinationList.get(i);
			double configuredChance = chanceList.get(i);
			putLevelWorld(DimensionUtil.getWorld(configuredId), configuredChance);
		}
	}

}
