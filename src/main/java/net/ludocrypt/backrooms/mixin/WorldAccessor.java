package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.WorldRenderer;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
public interface WorldAccessor {
	@Accessor("field_20793")
	public int rainSoundTime();

	@Accessor("ticks")
	public int ticks();
}
