package net.ludocrypt.backrooms.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.google.common.collect.ImmutableMap.Builder;

import net.ludocrypt.backrooms.init.BackroomsRegistries;
import net.ludocrypt.backrooms.util.ConfiguredLevelDestination;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

@Mixin(DynamicRegistryManager.class)
public abstract class DynamicRegistryManagerMixin {

	@Inject(method = "method_30531()Lcom/google/common/collect/ImmutableMap;", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/registry/DynamicRegistryManager;register(Lcom/google/common/collect/ImmutableMap$Builder;Lnet/minecraft/util/registry/RegistryKey;Lcom/mojang/serialization/Codec;Lcom/mojang/serialization/Codec;)V", shift = At.Shift.AFTER, ordinal = 1), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
	private static void BACKROOMS_addRegistry(CallbackInfoReturnable<Map<RegistryKey<? extends Registry<?>>, DynamicRegistryManager.Info<?>>> ci, Builder<RegistryKey<? extends Registry<?>>, DynamicRegistryManager.Info<?>> builder) {
		DynamicRegistryManager.register(builder, BackroomsRegistries.CONFIGURED_LEVEL_DESTINATIONS_KEY, ConfiguredLevelDestination.CODEC);
	}

}
