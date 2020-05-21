package net.ludocrypt.backrooms.items;

import net.ludocrypt.backrooms.sound.BackroomsSoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.UseAction;

public class AlmondWaterItem extends Item {

	public AlmondWaterItem(Settings settings) {
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
}
