package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(EndermanEntity.class)
public abstract class EndermanEntityMixin extends HostileEntity {

	protected EndermanEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "isPlayerStaring", at = @At(value = "RETURN", ordinal = 1), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private void BACKROOMS_isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> ci, Vec3d vec3d, Vec3d vec3d2, double d, double e) {
		if ((e > 1.0D - 0.025D / d ? player.canSee(this) : false)) {
			((SanityManagerAccess) player).getSanityManager().addsanitySpeedExhaustion(0.5F);
		}
	}
}
