package net.ludocrypt.backrooms.misc;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsPaintingMotive extends PaintingMotive {

	public static final PaintingMotive KEBAB = register("backrooms:kebab", 16, 16);
	public static final PaintingMotive AZTEC = register("backrooms:aztec", 16, 16);
	public static final PaintingMotive ALBAN = register("backrooms:alban", 16, 16);
	public static final PaintingMotive AZTEC2 = register("backrooms:aztec2", 16, 16);
	public static final PaintingMotive BOMB = register("backrooms:bomb", 16, 16);
	public static final PaintingMotive PLANT = register("backrooms:plant", 16, 16);
	public static final PaintingMotive WASTELAND = register("backrooms:wasteland", 16, 16);
	public static final PaintingMotive POOL = register("backrooms:pool", 32, 16);
	public static final PaintingMotive COURBET = register("backrooms:courbet", 32, 16);
	private final int width;
	private final int height;

	private static PaintingMotive register(String id, int width, int height) {
		return Registry.register(Registry.PAINTING_MOTIVE, new Identifier("backrooms", "magenta_checkered"), KEBAB);
	}

	public BackroomsPaintingMotive(int width, int height) {
		super(width, height);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
