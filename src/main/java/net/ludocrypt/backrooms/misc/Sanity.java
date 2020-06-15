package net.ludocrypt.backrooms.misc;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.player.PlayerEntity;

public class Sanity {

	public static final EntityAttribute sanityAttribute = (new ClampedEntityAttribute((EntityAttribute) null,
			"backrooms.sanity", 10.0D, 0.0D, 20.0D)).setName("Sanity Level").setTracked(true);

	public static double sanity(PlayerEntity playerEntity) {
		return playerEntity.getAttributeInstance(sanityAttribute).getValue();
	}
}
