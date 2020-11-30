package net.ludocrypt.backrooms.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.Lifecycle;

import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.Level1;
import net.ludocrypt.backrooms.world.Level2;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

@Mixin(DimensionType.class)
public class DimensionTypeMixin {

	@Inject(method = "addRegistryDefaults", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private static void BACKROOMS_addRegistryDefaults(DynamicRegistryManager.Impl registryManager, CallbackInfoReturnable<DynamicRegistryManager.Impl> ci, MutableRegistry<DimensionType> mutableRegistry) {
		mutableRegistry.add(Level0.LEVEL_0_REGISTRY_KEY, Level0.LEVEL_0, Lifecycle.stable());
		mutableRegistry.add(Level1.LEVEL_1_REGISTRY_KEY, Level1.LEVEL_1, Lifecycle.stable());
		mutableRegistry.add(Level2.LEVEL_2_REGISTRY_KEY, Level2.LEVEL_2, Lifecycle.stable());
	}

	@Inject(method = "createDefaultDimensionOptions", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private static void BACKROOMS_createDefaultDimensionOptions(Registry<DimensionType> dimensionRegistry, Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed, CallbackInfoReturnable<SimpleRegistry<DimensionOptions>> ci, SimpleRegistry<DimensionOptions> simpleRegistry) {
		simpleRegistry.add(Level0.LEVEL_0_DIMENSION_OPTIONS, new DimensionOptions(() -> {
			return (DimensionType) dimensionRegistry.getOrThrow(Level0.LEVEL_0_REGISTRY_KEY);
		}, Level0.createLevel0Generator(biomeRegistry, chunkGeneratorSettingsRegistry, seed)), Lifecycle.stable());
		simpleRegistry.add(Level1.LEVEL_1_DIMENSION_OPTIONS, new DimensionOptions(() -> {
			return (DimensionType) dimensionRegistry.getOrThrow(Level1.LEVEL_1_REGISTRY_KEY);
		}, Level1.createLevel1Generator(biomeRegistry, chunkGeneratorSettingsRegistry, seed)), Lifecycle.stable());
		simpleRegistry.add(Level2.LEVEL_2_DIMENSION_OPTIONS, new DimensionOptions(() -> {
			return (DimensionType) dimensionRegistry.getOrThrow(Level2.LEVEL_2_REGISTRY_KEY);
		}, Level2.createLevel2Generator(biomeRegistry, chunkGeneratorSettingsRegistry, seed)), Lifecycle.stable());
	}

	@Inject(method = "method_28521", at = @At("TAIL"), cancellable = true)
	private static void BACKROOMS_method_28521(Dynamic<?> dynamic, CallbackInfoReturnable<DataResult<RegistryKey<World>>> ci) {
		Optional<Number> optional = dynamic.asNumber().result();
		if (optional.isPresent()) {
			int i = ((Number) optional.get()).intValue();
			if (i == 672760) {
				ci.setReturnValue(DataResult.success(Level0.LEVEL_0_WORLD));
			}
			if (i == 672761) {
				ci.setReturnValue(DataResult.success(Level1.LEVEL_1_WORLD));
			}
			if (i == 672762) {
				ci.setReturnValue(DataResult.success(Level2.LEVEL_2_WORLD));
			}
		}
	}

}
