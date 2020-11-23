package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.ludocrypt.backrooms.sanity.SanityManager;
import net.ludocrypt.backrooms.util.PlayerUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements SanityManagerAccess {

	@Unique
	private SanityManager sanityManager = new SanityManager();

	@Override
	public SanityManager getSanityManager() {
		return this.sanityManager;
	}

	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "Lnet/minecraft/entity/player/PlayerEntity;tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/HungerManager;update(Lnet/minecraft/entity/player/PlayerEntity;)V", shift = Shift.AFTER))
	private void tickMixinTwo(CallbackInfo ci) {
		PlayerEntity player = (PlayerEntity) (Object) this;
		this.sanityManager.update(player);
	}

	@Inject(method = "Lnet/minecraft/entity/player/PlayerEntity;readCustomDataFromTag(Lnet/minecraft/nbt/CompoundTag;)V", at = @At(value = "TAIL"))
	private void BACKROOMS_readCustomDataFromTagMixin(CompoundTag tag, CallbackInfo ci) {
		this.sanityManager.fromTag(tag);
	}

	@Inject(method = "Lnet/minecraft/entity/player/PlayerEntity;writeCustomDataToTag(Lnet/minecraft/nbt/CompoundTag;)V", at = @At(value = "TAIL"))
	private void BACKROOMS_writeCustomDataToTagMixin(CompoundTag tag, CallbackInfo ci) {
		this.sanityManager.toTag(tag);
	}

	@Inject(method = "damage", at = @At(value = "RETURN", ordinal = 3, shift = Shift.BEFORE))
	private void BACKROOMS_damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
		float exhaust = 0.2f;
		exhaust *= amount;
		this.sanityManager.addsanitySpeedExhaustion(exhaust);
	}

	@Inject(method = "Lnet/minecraft/entity/player/PlayerEntity;tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;updateItems()V", shift = Shift.BEFORE))
	private void BACKROOMS_tickMovementMixin(CallbackInfo info) {
		PlayerEntity player = (PlayerEntity) (Object) this;
		if (player.world.getDifficulty() != Difficulty.PEACEFUL && player.isSprinting() && PlayerUtil.isSanityDrainableWorld(player.world)) {
			if (this.age % 18 == 0) {
				this.sanityManager.addsanitySpeedExhaustion(0.3f);
			}
		}
	}

}
