package net.ludocrypt.backrooms.misc;

import net.minecraft.sound.MusicSound;

public class BackroomsMusicType {
	public static final MusicSound LEVEL0MUSIC;
	public static final MusicSound LEVEL1MUSIC;
	public static final MusicSound LEVEL2MUSIC;
	public static final MusicSound LEVEL3MUSIC;
	public static final MusicSound LEVEL0MENU;
	public static final MusicSound LEVEL1MENU;
	public static final MusicSound LEVEL2MENU;
	public static final MusicSound LEVEL3MENU;

	static {
		LEVEL0MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL0MUSIC, 1000, 5000, true);
		LEVEL1MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL1ONMUSIC, 1000, 5000, true);
		LEVEL2MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL2MUSIC, 1000, 5000, true);
		LEVEL3MUSIC = new MusicSound(BackroomsSoundEvents.LEVEL3MUSIC, 1000, 5000, true);
		LEVEL0MENU = new MusicSound(BackroomsSoundEvents.LEVEL0MUSIC, 20, 600, true);
		LEVEL1MENU = new MusicSound(BackroomsSoundEvents.LEVEL1ONMUSIC, 20, 600, true);
		LEVEL2MENU = new MusicSound(BackroomsSoundEvents.LEVEL2LONGMUSIC, 20, 600, true);
		LEVEL3MENU = new MusicSound(BackroomsSoundEvents.LEVEL3MUSIC, 20, 600, true);

	}
}
