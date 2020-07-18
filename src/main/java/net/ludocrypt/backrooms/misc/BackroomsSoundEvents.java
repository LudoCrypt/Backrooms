package net.ludocrypt.backrooms.misc;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsSoundEvents {

	public static final SoundEvent LEVEL0MUSIC = register("backrooms:level.0.music");
	public static final SoundEvent LEVEL1MUSIC = register("backrooms:level.1.music");
	public static final SoundEvent LEVEL2MUSIC = register("backrooms:level.2.music");
	public static final SoundEvent MUSIC_DISC_ITS_BEEN_SO_LONG = register("backrooms:music_disc.its_been_so_long");
	public static final SoundEvent MUSIC_DISC_OMAE_WA_MOU = register("backrooms:music_disc.omae_wa_mou");
	public static final SoundEvent MUSIC_DISC_012 = register("backrooms:music_disc.012");
	public static final SoundEvent MUSIC_DISC_GLACIAL_CAVERN = register("backrooms:music_disc.glacial_cavern");
	public static final SoundEvent MUSIC_DISC_THOSE_TORN_WALLS = register("backrooms:music_disc.those_torn_walls");
	public static final SoundEvent MUSIC_DISC_BURGERS_AND_FRIES = register("backrooms:music_disc.burgers_and_fries");
	public static final SoundEvent TONE = register("backrooms:tone");
	public static final SoundEvent LEVEL0AMBIENCE = register("backrooms:level.0.ambience");
	public static final SoundEvent GULP = register("backrooms:gulp");

	private static SoundEvent register(String id) {
		return (SoundEvent) Registry.register(Registry.SOUND_EVENT, (String) id, new SoundEvent(new Identifier(id)));
	}
}
