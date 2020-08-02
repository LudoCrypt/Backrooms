package net.ludocrypt.backrooms.misc;

import java.util.function.Supplier;

import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum WallMaterial implements ToolMaterial {
	WALL(4, 5000, 20.0F, 4.0F, 15, () -> {
		return Ingredient.ofItems(Backrooms.WALL);
	}),

	COMPRESSED_WALL(4, 10000, 20.0F, 4.0F, 15, () -> {
		      return Ingredient.ofItems(Backrooms.COMPRESSED_WALL);
		   });

	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy<Ingredient> repairIngredient;

	private WallMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability,
			Supplier<Ingredient> repairIngredient) {
		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
	}

	public int getDurability() {
		return this.itemDurability;
	}

	public float getMiningSpeedMultiplier() {
		return this.miningSpeed;
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}

	public int getMiningLevel() {
		return this.miningLevel;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public Ingredient getRepairIngredient() {
		return (Ingredient) this.repairIngredient.get();
	}
}
