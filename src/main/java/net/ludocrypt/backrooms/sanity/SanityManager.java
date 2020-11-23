package net.ludocrypt.backrooms.sanity;

import net.ludocrypt.backrooms.init.BackroomsGamerules;
import net.ludocrypt.backrooms.mixin.DamageSourceAccessor;
import net.ludocrypt.backrooms.util.PlayerUtil;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Difficulty;

public class SanityManager {

	// foodLevel
	private int sanityLevel = 30;
	// foodSaturationLevel
	public float sanitySpeed = 5.0F;
	// exhaustion
	private float sanitySpeedExhaustion;
	// foodStarvationTimer
	private int sanityTickTimer;

	public void add(int sanity, float sanitySpeed) {
		sanityLevel = Math.min(sanity + sanityLevel, 30);
		this.sanitySpeed = Math.min(sanitySpeed + (float) sanity * sanitySpeed * 2.0F, (float) sanitySpeed);
	}

	public void update(PlayerEntity player) {
		Difficulty difficulty = player.world.getDifficulty();
		if (sanitySpeedExhaustion > 4.0F) {
			sanitySpeedExhaustion -= 4.0F;
			if (sanitySpeed > 0.0F) {
				sanitySpeed = Math.max(sanitySpeed - 1.0F, 0.0F);
			} else if (difficulty != Difficulty.PEACEFUL) {
				sanityLevel = Math.max(sanityLevel - 1, 0);
			}
		} else if (sanitySpeedExhaustion < -8.0F) {
			sanitySpeedExhaustion += 8.0F;
			if (sanitySpeed > 0.0F) {
				sanitySpeed = Math.max(sanitySpeed - 1.0F, 0.0F);
			} else if (difficulty != Difficulty.PEACEFUL) {
				sanityLevel = Math.max(sanityLevel + 1, 0);
			}
		}

		boolean sanityGrowth = player.world.getGameRules().getBoolean(BackroomsGamerules.NATURAL_SANITY_DRAIN);
		boolean sanityDrain = player.world.getGameRules().getBoolean(BackroomsGamerules.NATURAL_SANITY_GROWTH);
		boolean inBackrooms = PlayerUtil.isSanityDrainableWorld(player.world);
		if (sanityDrain && sanitySpeed > 0.0F && sanityLevel < 23) {
			++sanityTickTimer;
			int sanityCap = 160;
			sanityCap = inBackrooms ? sanityCap /= 3 : sanityCap;
			if (sanityTickTimer >= sanityCap) {
				float f = Math.min(sanitySpeed, 6.0F);
				add(-1, 0.1F);
				addsanitySpeedExhaustion(f);
				sanityTickTimer = 0;
			}
		} else if (sanityDrain && sanityLevel < 23 && sanityLevel <= 11) {
			++sanityTickTimer;
			int sanityCap = 250;
			sanityCap = inBackrooms ? sanityCap /= 3 : sanityCap;
			if (sanityTickTimer >= sanityCap) {
				add(-1, 0.2F);
				addsanitySpeedExhaustion(6.0F);
				sanityTickTimer = 0;
			}
		} else if (sanityGrowth && sanityLevel >= 23 && sanityLevel < 30 && !player.hasStatusEffect(StatusEffects.HUNGER)) {
			++sanityTickTimer;
			int sanityCap = 340;
			sanityCap = inBackrooms ? sanityCap *= 2 : sanityCap;
			if (sanityTickTimer >= sanityCap) {
				add(1, 0.1F);
				addsanitySpeedExhaustion(-2.0F);
				sanityTickTimer = 0;
			}
		} else if (sanityDrain && player.hasStatusEffect(StatusEffects.HUNGER)) {
			++sanityTickTimer;
			int sanityCap = 185;
			sanityCap = inBackrooms ? sanityCap /= 2 : sanityCap;
			if (sanityTickTimer >= sanityCap) {
				add(0, 0.3F);
				addsanitySpeedExhaustion(1.0F);
				sanityTickTimer = 0;
			}
		} else if (sanityLevel <= 0) {
			++sanityTickTimer;
			if (sanityTickTimer >= 170) {
				if (player.getHealth() > 10.0F || difficulty == Difficulty.HARD || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
					player.damage(createDamageSource(), 1.0F);
				}

				sanityTickTimer = 0;
			}
		} else {
			sanityTickTimer = 0;
		}

	}

	public boolean canSanityGrow(PlayerEntity player) {
		return sanityLevel >= 23.0F;
	}

	public void fromTag(CompoundTag tag) {
		if (tag.contains("sanityLevel", 99)) {
			sanityLevel = tag.getInt("sanityLevel");
			sanityTickTimer = tag.getInt("sanityTickTimer");
			sanitySpeed = tag.getFloat("sanitySpeed");
			sanitySpeedExhaustion = tag.getFloat("sanitySpeedExhaustion");
		}
	}

	public void toTag(CompoundTag tag) {
		tag.putInt("sanityLevel", sanityLevel);
		tag.putInt("sanityTickTimer", sanityTickTimer);
		tag.putFloat("sanitySpeed", sanitySpeed);
		tag.putFloat("sanitySpeedExhaustion", sanitySpeedExhaustion);
	}

	public int getSanityLevel() {
		return sanityLevel;
	}

	public boolean isNotFull() {
		return sanityLevel < 30;
	}

	public void addsanitySpeedExhaustion(float sanitySpeedExhaustion) {
		this.sanitySpeedExhaustion = Math.min(Math.max(sanitySpeedExhaustion + sanitySpeedExhaustion, -40.0F), 40.0F);
	}

	public void setSanityLevel(int sanityLevel) {
		this.sanityLevel = sanityLevel;
	}

	public void setSanitySpeed(float sanitySpeed) {
		this.sanitySpeed = sanitySpeed;
	}

	public void setSanitySpeedExhaustion(float sanitySpeedExhaustion) {
		this.sanitySpeedExhaustion = sanitySpeedExhaustion;
	}

	public void setSanityTickTimer(int sanityTickTimer) {
		this.sanityTickTimer = sanityTickTimer;
	}

	public float getSanitySpeed() {
		return sanitySpeed;
	}

	public float getSanitySpeedExhaustion() {
		return sanitySpeedExhaustion;
	}

	public int getSanityTickTimer() {
		return sanityTickTimer;
	}

	public DamageSource createDamageSource() {
		return DamageSourceAccessor.createDamageSource("insane");
	}

	@Override
	public String toString() {
		return "SanityManager{" + sanityLevel + ", " + sanitySpeed + ", " + sanitySpeedExhaustion + ", " + sanityTickTimer + "}";
	}

}
