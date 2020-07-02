package net.ludocrypt.backrooms.items;

import net.ludocrypt.backrooms.misc.BackroomsSoundEvents;
import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class RawAlmondWaterItem extends Item {

	public RawAlmondWaterItem(Settings settings) {
		super(settings);
	}

	public int getMaxUseTime(ItemStack stack) {
		return 80;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	public SoundEvent getDrinkSound() {
		return BackroomsSoundEvents.GULP;
	}

	public SoundEvent getEatSound() {
		return BackroomsSoundEvents.GULP;
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		super.finishUsing(stack, world, user);
		ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) user;
		Criterions.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
		serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!world.isClient) {
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 60 * 2));
		}
		if (stack.isEmpty()) {
			return new ItemStack(Items.GLASS_BOTTLE);
		} else {
			if (user instanceof PlayerEntity && !((PlayerEntity) user).abilities.creativeMode) {
				ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
				PlayerEntity playerEntity = (PlayerEntity) user;
				if (!playerEntity.inventory.insertStack(itemStack)) {
					playerEntity.dropItem(itemStack, false);
				}
			}
			return stack;
		}
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		user.setCurrentHand(hand);
		return TypedActionResult.success(user.getStackInHand(hand));
	}
}
