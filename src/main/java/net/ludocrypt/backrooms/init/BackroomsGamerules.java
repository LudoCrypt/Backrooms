package net.ludocrypt.backrooms.init;

import net.minecraft.world.GameRules;

public class BackroomsGamerules {

	public static GameRules.Key<GameRules.BooleanRule> NATURAL_SANITY_DRAIN = GameRules.register("naturalSanityDrain", GameRules.Category.PLAYER, GameRules.BooleanRule.create(true));
	public static GameRules.Key<GameRules.BooleanRule> NATURAL_SANITY_GROWTH = GameRules.register("naturalSanityGrowth", GameRules.Category.PLAYER, GameRules.BooleanRule.create(true));

	public static void init() {
	}
}
