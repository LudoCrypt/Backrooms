package net.ludocrypt.backrooms.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

// Contains the item groups added by The Backrooms
public class BackroomsGroups {
	// Registers the item group added by The Backrooms
	public static void init() {
		FabricItemGroupBuilder.create(Backrooms.id("items"))
				.icon(() -> BackroomsItems.RED_DOTTED_WALLPAPER_PATTERN.getDefaultStack()).appendItems((stacks) -> {
					Registry.ITEM.stream().filter((item) -> {
						return Registry.ITEM.getId(item).getNamespace().equals(Backrooms.NAMESPACE);
					}).forEach((item) -> stacks.add(new ItemStack(item)));
				}).build();
	}
}
