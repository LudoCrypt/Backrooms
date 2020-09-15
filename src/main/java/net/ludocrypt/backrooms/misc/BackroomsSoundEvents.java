package net.ludocrypt.backrooms.misc;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsSoundEvents {

	public static final SoundEvent LEVEL0MUSIC = register("backrooms:level.0.music");
	public static final SoundEvent LEVEL0WEIGHTEDMUSIC = register("backrooms:level.0weighted.music");
	public static final SoundEvent LEVEL1OFFMUSIC = register("backrooms:level.1off.music");
	public static final SoundEvent LEVEL1ONMUSIC = register("backrooms:level.1on.music");
	public static final SoundEvent LEVEL2MUSIC = register("backrooms:level.2.music");
	public static final SoundEvent LEVEL2LONGMUSIC = register("backrooms:level.2long.music");
	public static final SoundEvent LEVEL2MESSYMUSIC = register("backrooms:level.2messy.music");
	public static final SoundEvent LEVEL3MUSIC = register("backrooms:level.3.music");
	public static final SoundEvent MUSIC_DISC_ITS_BEEN_SO_LONG = register("backrooms:music_disc.its_been_so_long");
	public static final SoundEvent MUSIC_DISC_OMAE_WA_MOU = register("backrooms:music_disc.omae_wa_mou");
	public static final SoundEvent MUSIC_DISC_012 = register("backrooms:music_disc.012");
	public static final SoundEvent MUSIC_DISC_GLACIAL_CAVERN = register("backrooms:music_disc.glacial_cavern");
	public static final SoundEvent MUSIC_DISC_THOSE_TORN_WALLS = register("backrooms:music_disc.those_torn_walls");
	public static final SoundEvent MUSIC_DISC_BURGERS_AND_FRIES = register("backrooms:music_disc.burgers_and_fries");
	public static final SoundEvent MUSIC_DISC_PRETZELS_AND_CHEESE = register("backrooms:music_disc.pretzels_and_cheese");
	public static final SoundEvent TONE = register("backrooms:tone");
	public static final SoundEvent GULP = register("backrooms:gulp");
	public static final SoundEvent TEAR = register("backrooms:tear");
	public static final SoundEvent VENT = register("backrooms:vent");
	public static final SoundEvent SIZZLE = register("backrooms:sizzle");
	public static final SoundEvent HUMM_BUZZ_AROUND = register("backrooms:humm_buzz_around");
	public static final SoundEvent HUMM_BUZZ = register("backrooms:humm_buzz");

	private static SoundEvent register(String id) {
		return (SoundEvent) Registry.register(Registry.SOUND_EVENT, (String) id, new SoundEvent(new Identifier(id)));
	}
}
