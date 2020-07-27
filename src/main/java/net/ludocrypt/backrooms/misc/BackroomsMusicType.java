package net.ludocrypt.backrooms.misc;

import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;

public class BackroomsMusicType {
	public static final MusicSound LEVEL0MUSIC;
	public static final MusicSound LEVEL1MUSIC;
	public static final MusicSound LEVEL2MUSIC;
	public static final MusicSound LEVEL3MUSIC;
	public static final MusicSound LEVEL0MENU;
	public static final MusicSound LEVEL1MENU;
	public static final MusicSound LEVEL2MENU;
	public static final MusicSound LEVEL3MENU;

	public static MusicSound method_27283(SoundEvent soundEvent) {
		return new MusicSound(soundEvent, 12000, 24000, false);
	}

	static {
		LEVEL0MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL0MUSIC, 500, 1000, true);
		LEVEL1MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL1MUSIC, 500, 1000, true);
		LEVEL2MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL2MUSIC, 500, 1000, true);
		LEVEL3MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL3MUSIC, 500, 1000, true);
		LEVEL0MENU = new MusicSound(BackroomsSoundEvents.LEVEL0MUSIC, 20, 600, true);
		LEVEL1MENU = new MusicSound(BackroomsSoundEvents.LEVEL1MUSIC, 20, 600, true);
		LEVEL2MENU = new MusicSound(BackroomsSoundEvents.LEVEL2MUSIC, 20, 600, true);
		LEVEL3MENU = new MusicSound(BackroomsSoundEvents.LEVEL3MUSIC, 20, 600, true);
		
	}
}
