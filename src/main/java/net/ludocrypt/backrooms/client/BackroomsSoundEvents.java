package net.ludocrypt.backrooms.client;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class BackroomsSoundEvents {

	// Acts as a kind of local registry for sound events added by The Backrooms
	private static final Map<Identifier, SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

	public static final SoundEvent LEVEL_0_MUSIC = add(new SoundEvent(Backrooms.id("music.level0")));
	public static final SoundEvent LEVEL_0_WEIGHTED_MUSIC = add(new SoundEvent(Backrooms.id("music.level0weighted")));

	public static final SoundEvent LEVEL_1_OFF_MUSIC = add(new SoundEvent(Backrooms.id("music.level1off")));
	public static final SoundEvent LEVEL_1_ON_MUSIC = add(new SoundEvent(Backrooms.id("music.level1on")));

	public static final SoundEvent LEVEL_2_MUSIC = add(new SoundEvent(Backrooms.id("music.level2")));
	public static final SoundEvent LEVEL_2_LONG_MUSIC = add(new SoundEvent(Backrooms.id("music.level2long")));
	public static final SoundEvent LEVEL_2_MESSY_MUSIC = add(new SoundEvent(Backrooms.id("music.level2messy")));

	public static final SoundEvent LEVEL_3_MUSIC = add(new SoundEvent(Backrooms.id("music.level3")));

	public static final SoundEvent MUSIC_DISC_ITS_BEEN_SO_LONG = add(new SoundEvent(Backrooms.id("music.disc.its_been_so_long")));
	public static final SoundEvent MUSIC_DISC_OMAE_WA_MOU = add(new SoundEvent(Backrooms.id("music.disc.omae_wa_mou")));
	public static final SoundEvent MUSIC_DISC_GLACIAL_CAVERN = add(new SoundEvent(Backrooms.id("music.disc.glacial_cavern")));
	public static final SoundEvent MUSIC_DISC_THOSE_TORN_WALLS = add(new SoundEvent(Backrooms.id("music.disc.those_torn_walls")));
	public static final SoundEvent MUSIC_DISC_BURGERS_AND_FRIES = add(new SoundEvent(Backrooms.id("music.disc.burgers_and_fries")));
	public static final SoundEvent MUSIC_DISC_PRETZELS_AND_CHEESE = add(new SoundEvent(Backrooms.id("music.disc.pretzels_and_cheese")));
	public static final SoundEvent MUSIC_DISC_012 = add(new SoundEvent(Backrooms.id("music.disc.012")));

	public static final SoundEvent GULP = add(new SoundEvent(Backrooms.id("sounds.gulp")));
	public static final SoundEvent VENT = add(new SoundEvent(Backrooms.id("sounds.vent")));
	public static final SoundEvent BUZZ = add(new SoundEvent(Backrooms.id("sounds.buzz")));
	public static final SoundEvent BUZZ_BACKGROUND = add(new SoundEvent(Backrooms.id("sounds.buzz_background")));
	public static final SoundEvent RING = add(new SoundEvent(Backrooms.id("sounds.ring")));

	public static final MusicSound LEVEL_0_MUSIC_SOUND = new MusicSound(LEVEL_0_MUSIC, 12000, 24000, true);
	public static final MusicSound LEVEL_1_MUSIC_SOUND = new MusicSound(LEVEL_1_ON_MUSIC, 12000, 24000, true);
	public static final MusicSound LEVEL_2_MUSIC_SOUND = new MusicSound(LEVEL_2_MUSIC, 12000, 24000, true);
	public static final MusicSound LEVEL_3_MUSIC_SOUND = new MusicSound(LEVEL_3_MUSIC, 12000, 24000, true);
	public static final MusicSound LEVEL_0_MENU_SOUND = new MusicSound(LEVEL_0_MUSIC, 20, 600, true);
	public static final MusicSound LEVEL_1_MENU_SOUND = new MusicSound(LEVEL_1_ON_MUSIC, 20, 600, true);
	public static final MusicSound LEVEL_2_MENU_SOUND = new MusicSound(LEVEL_2_LONG_MUSIC, 20, 600, true);
	public static final MusicSound LEVEL_3_MENU_SOUND = new MusicSound(LEVEL_3_MUSIC, 20, 600, true);

	private static <S extends SoundEvent> S add(S sound_event) {
		SOUND_EVENTS.put(sound_event.getId(), sound_event);
		return sound_event;
	}

	public static void init() {
		for (Identifier id : SOUND_EVENTS.keySet()) {
			Registry.register(Registry.SOUND_EVENT, id, SOUND_EVENTS.get(id));
		}

	}

}
