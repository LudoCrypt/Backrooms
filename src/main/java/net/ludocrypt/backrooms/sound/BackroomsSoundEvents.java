package net.ludocrypt.backrooms.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsSoundEvents {

	public static final SoundEvent LEVEL0MUSIC = register("backrooms:level.0.music");
	public static final SoundEvent BACKROOMSMENU = register("backrooms:music.general");
	public static final SoundEvent MUSIC_DISC_ITS_BEEN_SO_LONG = register("backrooms:music_disc.its_been_so_long");
	public static final SoundEvent MUSIC_DISC_OMAE_WA_MOU = register("backrooms:music_disc.omae_wa_mou");
	public static final SoundEvent MUSIC_DISC_012 = register("backrooms:music_disc.012");
	public static final SoundEvent MUSIC_DISC_GLACIAL_CAVERN = register("backrooms:music_disc.glacial_cavern");
	public static final SoundEvent MUSIC_DISC_THOSE_TORN_WALLS = register("backrooms:music_disc.those_torn_walls");
	public static final SoundEvent GULP = register("backrooms:gulp");
	public static final SoundEvent TONE = register("backrooms:tone");

	private static SoundEvent register(String id) {
		return (SoundEvent) Registry.register(Registry.SOUND_EVENT, (String) id, new SoundEvent(new Identifier(id)));
	}
}
