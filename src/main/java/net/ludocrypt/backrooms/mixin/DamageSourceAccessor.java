package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.entity.damage.DamageSource;

@Mixin(DamageSource.class)
public interface DamageSourceAccessor {
	@Invoker("<init>")
	public static DamageSource createDamageSource(String name) {
		throw new UnsupportedOperationException();
	}
}
