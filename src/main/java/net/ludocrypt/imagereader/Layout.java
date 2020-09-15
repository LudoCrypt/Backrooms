package net.ludocrypt.imagereader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.annotation.Nullable;

public class Layout {

	public static Integer[][] getLayout(String room, int blackBlock, int whiteBlock, Layout layout) {

		BufferedImage image;
		try {
			image = ImageIO.read(layout.getClass().getResourceAsStream("/data/backrooms/layouts/" + room + ".png"));
			if (image.getHeight() != 16 && image.getWidth() != 16) {
				return null;
			} else {
				return Layout.compileList(image, blackBlock, whiteBlock);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	private static Integer[][] compileList(BufferedImage image, int blackBlock, int whiteBlock) {
		List<Integer> intList1 = new ArrayList<Integer>();
		List<Integer> intList2 = new ArrayList<Integer>();
		List<Integer> intList3 = new ArrayList<Integer>();
		List<Integer> intList4 = new ArrayList<Integer>();
		List<Integer> intList5 = new ArrayList<Integer>();
		List<Integer> intList6 = new ArrayList<Integer>();
		List<Integer> intList7 = new ArrayList<Integer>();
		List<Integer> intList8 = new ArrayList<Integer>();
		List<Integer> intList9 = new ArrayList<Integer>();
		List<Integer> intList10 = new ArrayList<Integer>();
		List<Integer> intList11 = new ArrayList<Integer>();
		List<Integer> intList12 = new ArrayList<Integer>();
		List<Integer> intList13 = new ArrayList<Integer>();
		List<Integer> intList14 = new ArrayList<Integer>();
		List<Integer> intList15 = new ArrayList<Integer>();
		List<Integer> intList16 = new ArrayList<Integer>();
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color c = new Color(image.getRGB(x, y));
				if (y == 0) {
					Layout.colorChecker(c, intList1, blackBlock, whiteBlock);
				} else if (y == 1) {
					Layout.colorChecker(c, intList2, blackBlock, whiteBlock);
				} else if (y == 2) {
					Layout.colorChecker(c, intList3, blackBlock, whiteBlock);
				} else if (y == 3) {
					Layout.colorChecker(c, intList4, blackBlock, whiteBlock);
				} else if (y == 4) {
					Layout.colorChecker(c, intList5, blackBlock, whiteBlock);
				} else if (y == 5) {
					Layout.colorChecker(c, intList6, blackBlock, whiteBlock);
				} else if (y == 6) {
					Layout.colorChecker(c, intList7, blackBlock, whiteBlock);
				} else if (y == 7) {
					Layout.colorChecker(c, intList8, blackBlock, whiteBlock);
				} else if (y == 8) {
					Layout.colorChecker(c, intList9, blackBlock, whiteBlock);
				} else if (y == 9) {
					Layout.colorChecker(c, intList10, blackBlock, whiteBlock);
				} else if (y == 10) {
					Layout.colorChecker(c, intList11, blackBlock, whiteBlock);
				} else if (y == 11) {
					Layout.colorChecker(c, intList12, blackBlock, whiteBlock);
				} else if (y == 12) {
					Layout.colorChecker(c, intList13, blackBlock, whiteBlock);
				} else if (y == 13) {
					Layout.colorChecker(c, intList14, blackBlock, whiteBlock);
				} else if (y == 14) {
					Layout.colorChecker(c, intList15, blackBlock, whiteBlock);
				} else if (y == 15) {
					Layout.colorChecker(c, intList16, blackBlock, whiteBlock);
				}
			}
		}
		Integer[][] layout = {
				{ intList1.get(1 - 1), intList1.get(2 - 1), intList1.get(3 - 1), intList1.get(4 - 1),
						intList1.get(5 - 1), intList1.get(6 - 1), intList1.get(7 - 1), intList1.get(8 - 1),
						intList1.get(9 - 1), intList1.get(10 - 1), intList1.get(11 - 1), intList1.get(12 - 1),
						intList1.get(13 - 1), intList1.get(14 - 1), intList1.get(15 - 1), intList1.get(16 - 1) },
				{ intList2.get(1 - 1), intList2.get(2 - 1), intList2.get(3 - 1), intList2.get(4 - 1),
						intList2.get(5 - 1), intList2.get(6 - 1), intList2.get(7 - 1), intList2.get(8 - 1),
						intList2.get(9 - 1), intList2.get(10 - 1), intList2.get(11 - 1), intList2.get(12 - 1),
						intList2.get(13 - 1), intList2.get(14 - 1), intList2.get(15 - 1), intList2.get(16 - 1) },
				{ intList3.get(1 - 1), intList3.get(2 - 1), intList3.get(3 - 1), intList3.get(4 - 1),
						intList3.get(5 - 1), intList3.get(6 - 1), intList3.get(7 - 1), intList3.get(8 - 1),
						intList3.get(9 - 1), intList3.get(10 - 1), intList3.get(11 - 1), intList3.get(12 - 1),
						intList3.get(13 - 1), intList3.get(14 - 1), intList3.get(15 - 1), intList3.get(16 - 1) },
				{ intList4.get(1 - 1), intList4.get(2 - 1), intList4.get(3 - 1), intList4.get(4 - 1),
						intList4.get(5 - 1), intList4.get(6 - 1), intList4.get(7 - 1), intList4.get(8 - 1),
						intList4.get(9 - 1), intList4.get(10 - 1), intList4.get(11 - 1), intList4.get(12 - 1),
						intList4.get(13 - 1), intList4.get(14 - 1), intList4.get(15 - 1), intList4.get(16 - 1) },
				{ intList5.get(1 - 1), intList5.get(2 - 1), intList5.get(3 - 1), intList5.get(4 - 1),
						intList5.get(5 - 1), intList5.get(6 - 1), intList5.get(7 - 1), intList5.get(8 - 1),
						intList5.get(9 - 1), intList5.get(10 - 1), intList5.get(11 - 1), intList5.get(12 - 1),
						intList5.get(13 - 1), intList5.get(14 - 1), intList5.get(15 - 1), intList5.get(16 - 1) },
				{ intList6.get(1 - 1), intList6.get(2 - 1), intList6.get(3 - 1), intList6.get(4 - 1),
						intList6.get(5 - 1), intList6.get(6 - 1), intList6.get(7 - 1), intList6.get(8 - 1),
						intList6.get(9 - 1), intList6.get(10 - 1), intList6.get(11 - 1), intList6.get(12 - 1),
						intList6.get(13 - 1), intList6.get(14 - 1), intList6.get(15 - 1), intList6.get(16 - 1) },
				{ intList7.get(1 - 1), intList7.get(2 - 1), intList7.get(3 - 1), intList7.get(4 - 1),
						intList7.get(5 - 1), intList7.get(6 - 1), intList7.get(7 - 1), intList7.get(8 - 1),
						intList7.get(9 - 1), intList7.get(10 - 1), intList7.get(11 - 1), intList7.get(12 - 1),
						intList7.get(13 - 1), intList7.get(14 - 1), intList7.get(15 - 1), intList7.get(16 - 1) },
				{ intList8.get(1 - 1), intList8.get(2 - 1), intList8.get(3 - 1), intList8.get(4 - 1),
						intList8.get(5 - 1), intList8.get(6 - 1), intList8.get(7 - 1), intList8.get(8 - 1),
						intList8.get(9 - 1), intList8.get(10 - 1), intList8.get(11 - 1), intList8.get(12 - 1),
						intList8.get(13 - 1), intList8.get(14 - 1), intList8.get(15 - 1), intList8.get(16 - 1) },
				{ intList9.get(1 - 1), intList9.get(2 - 1), intList9.get(3 - 1), intList9.get(4 - 1),
						intList9.get(5 - 1), intList9.get(6 - 1), intList9.get(7 - 1), intList9.get(8 - 1),
						intList9.get(9 - 1), intList9.get(10 - 1), intList9.get(11 - 1), intList9.get(12 - 1),
						intList9.get(13 - 1), intList9.get(14 - 1), intList9.get(15 - 1), intList9.get(16 - 1) },
				{ intList10.get(1 - 1), intList10.get(2 - 1), intList10.get(3 - 1), intList10.get(4 - 1),
						intList10.get(5 - 1), intList10.get(6 - 1), intList10.get(7 - 1), intList10.get(8 - 1),
						intList10.get(9 - 1), intList10.get(10 - 1), intList10.get(11 - 1), intList10.get(12 - 1),
						intList10.get(13 - 1), intList10.get(14 - 1), intList10.get(15 - 1), intList10.get(16 - 1) },
				{ intList11.get(1 - 1), intList11.get(2 - 1), intList11.get(3 - 1), intList11.get(4 - 1),
						intList11.get(5 - 1), intList11.get(6 - 1), intList11.get(7 - 1), intList11.get(8 - 1),
						intList11.get(9 - 1), intList11.get(10 - 1), intList11.get(11 - 1), intList11.get(12 - 1),
						intList11.get(13 - 1), intList11.get(14 - 1), intList11.get(15 - 1), intList11.get(16 - 1) },
				{ intList12.get(1 - 1), intList12.get(2 - 1), intList12.get(3 - 1), intList12.get(4 - 1),
						intList12.get(5 - 1), intList12.get(6 - 1), intList12.get(7 - 1), intList12.get(8 - 1),
						intList12.get(9 - 1), intList12.get(10 - 1), intList12.get(11 - 1), intList12.get(12 - 1),
						intList12.get(13 - 1), intList12.get(14 - 1), intList12.get(15 - 1), intList12.get(16 - 1) },
				{ intList13.get(1 - 1), intList13.get(2 - 1), intList13.get(3 - 1), intList13.get(4 - 1),
						intList13.get(5 - 1), intList13.get(6 - 1), intList13.get(7 - 1), intList13.get(8 - 1),
						intList13.get(9 - 1), intList13.get(10 - 1), intList13.get(11 - 1), intList13.get(12 - 1),
						intList13.get(13 - 1), intList13.get(14 - 1), intList13.get(15 - 1), intList13.get(16 - 1) },
				{ intList14.get(1 - 1), intList14.get(2 - 1), intList14.get(3 - 1), intList14.get(4 - 1),
						intList14.get(5 - 1), intList14.get(6 - 1), intList14.get(7 - 1), intList14.get(8 - 1),
						intList14.get(9 - 1), intList14.get(10 - 1), intList14.get(11 - 1), intList14.get(12 - 1),
						intList14.get(13 - 1), intList14.get(14 - 1), intList14.get(15 - 1), intList14.get(16 - 1) },
				{ intList15.get(1 - 1), intList15.get(2 - 1), intList15.get(3 - 1), intList15.get(4 - 1),
						intList15.get(5 - 1), intList15.get(6 - 1), intList15.get(7 - 1), intList15.get(8 - 1),
						intList15.get(9 - 1), intList15.get(10 - 1), intList15.get(11 - 1), intList15.get(12 - 1),
						intList15.get(13 - 1), intList15.get(14 - 1), intList15.get(15 - 1), intList15.get(16 - 1) },
				{ intList16.get(1 - 1), intList16.get(2 - 1), intList16.get(3 - 1), intList16.get(4 - 1),
						intList16.get(5 - 1), intList16.get(6 - 1), intList16.get(7 - 1), intList16.get(8 - 1),
						intList16.get(9 - 1), intList16.get(10 - 1), intList16.get(11 - 1), intList16.get(12 - 1),
						intList16.get(13 - 1), intList16.get(14 - 1), intList16.get(15 - 1), intList16.get(16 - 1) } };

		return layout;
	}

	public static List<Integer[][]> listLayouts(int max, String room, int blackBlock, int whiteBlock, Layout layout) {
		List<Integer[][]> intListList = new ArrayList<Integer[][]>();
		for (int m = 0; m <= max; m++) {
			Integer[][] intList = Layout.getLayout(room + '_' + m, blackBlock, whiteBlock, layout);
			intListList.add(intList);
		}
		return intListList;
	}

	private static void colorChecker(Color c, List<Integer> list, int black, int white) {
		if (c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0) {
			list.add(black);
		} else {
			list.add(white);
		}
	}

	// Colored

	public static Integer[][] getColoredLayout(String room, int blackBlock, int whiteBlock, @Nullable int red,
			@Nullable int red2, @Nullable int green, @Nullable int green2, @Nullable int blue, @Nullable int blue2,
			@Nullable int purple, @Nullable int purple2, Layout layout) {

		BufferedImage image;
		try {
			image = ImageIO.read(layout.getClass().getResourceAsStream("/data/backrooms/layouts/" + room + ".png"));
			if (image.getHeight() != 16 && image.getWidth() != 16) {
				return null;
			} else {
				return Layout.compileColoredList(image, blackBlock, whiteBlock, red, red2, green, green2, blue, blue2,
						purple, purple2);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	private static Integer[][] compileColoredList(BufferedImage image, int blackBlock, int whiteBlock,
			@Nullable int red, @Nullable int red2, @Nullable int green, @Nullable int green2, @Nullable int blue,
			@Nullable int blue2, @Nullable int purple, @Nullable int purple2) {
		List<Integer> intList1 = new ArrayList<Integer>();
		List<Integer> intList2 = new ArrayList<Integer>();
		List<Integer> intList3 = new ArrayList<Integer>();
		List<Integer> intList4 = new ArrayList<Integer>();
		List<Integer> intList5 = new ArrayList<Integer>();
		List<Integer> intList6 = new ArrayList<Integer>();
		List<Integer> intList7 = new ArrayList<Integer>();
		List<Integer> intList8 = new ArrayList<Integer>();
		List<Integer> intList9 = new ArrayList<Integer>();
		List<Integer> intList10 = new ArrayList<Integer>();
		List<Integer> intList11 = new ArrayList<Integer>();
		List<Integer> intList12 = new ArrayList<Integer>();
		List<Integer> intList13 = new ArrayList<Integer>();
		List<Integer> intList14 = new ArrayList<Integer>();
		List<Integer> intList15 = new ArrayList<Integer>();
		List<Integer> intList16 = new ArrayList<Integer>();
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color c = new Color(image.getRGB(x, y));
				if (y == 0) {
					Layout.coloredcolorChecker(c, intList1, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 1) {
					Layout.coloredcolorChecker(c, intList2, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 2) {
					Layout.coloredcolorChecker(c, intList3, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 3) {
					Layout.coloredcolorChecker(c, intList4, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 4) {
					Layout.coloredcolorChecker(c, intList5, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 5) {
					Layout.coloredcolorChecker(c, intList6, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 6) {
					Layout.coloredcolorChecker(c, intList7, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 7) {
					Layout.coloredcolorChecker(c, intList8, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 8) {
					Layout.coloredcolorChecker(c, intList9, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 9) {
					Layout.coloredcolorChecker(c, intList10, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 10) {
					Layout.coloredcolorChecker(c, intList11, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 11) {
					Layout.coloredcolorChecker(c, intList12, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 12) {
					Layout.coloredcolorChecker(c, intList13, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 13) {
					Layout.coloredcolorChecker(c, intList14, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 14) {
					Layout.coloredcolorChecker(c, intList15, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				} else if (y == 15) {
					Layout.coloredcolorChecker(c, intList16, blackBlock, whiteBlock, red, red2, green, green2, blue,
							blue2, purple, purple2);
				}
			}
		}
		Integer[][] layout = {
				{ intList1.get(1 - 1), intList1.get(2 - 1), intList1.get(3 - 1), intList1.get(4 - 1),
						intList1.get(5 - 1), intList1.get(6 - 1), intList1.get(7 - 1), intList1.get(8 - 1),
						intList1.get(9 - 1), intList1.get(10 - 1), intList1.get(11 - 1), intList1.get(12 - 1),
						intList1.get(13 - 1), intList1.get(14 - 1), intList1.get(15 - 1), intList1.get(16 - 1) },
				{ intList2.get(1 - 1), intList2.get(2 - 1), intList2.get(3 - 1), intList2.get(4 - 1),
						intList2.get(5 - 1), intList2.get(6 - 1), intList2.get(7 - 1), intList2.get(8 - 1),
						intList2.get(9 - 1), intList2.get(10 - 1), intList2.get(11 - 1), intList2.get(12 - 1),
						intList2.get(13 - 1), intList2.get(14 - 1), intList2.get(15 - 1), intList2.get(16 - 1) },
				{ intList3.get(1 - 1), intList3.get(2 - 1), intList3.get(3 - 1), intList3.get(4 - 1),
						intList3.get(5 - 1), intList3.get(6 - 1), intList3.get(7 - 1), intList3.get(8 - 1),
						intList3.get(9 - 1), intList3.get(10 - 1), intList3.get(11 - 1), intList3.get(12 - 1),
						intList3.get(13 - 1), intList3.get(14 - 1), intList3.get(15 - 1), intList3.get(16 - 1) },
				{ intList4.get(1 - 1), intList4.get(2 - 1), intList4.get(3 - 1), intList4.get(4 - 1),
						intList4.get(5 - 1), intList4.get(6 - 1), intList4.get(7 - 1), intList4.get(8 - 1),
						intList4.get(9 - 1), intList4.get(10 - 1), intList4.get(11 - 1), intList4.get(12 - 1),
						intList4.get(13 - 1), intList4.get(14 - 1), intList4.get(15 - 1), intList4.get(16 - 1) },
				{ intList5.get(1 - 1), intList5.get(2 - 1), intList5.get(3 - 1), intList5.get(4 - 1),
						intList5.get(5 - 1), intList5.get(6 - 1), intList5.get(7 - 1), intList5.get(8 - 1),
						intList5.get(9 - 1), intList5.get(10 - 1), intList5.get(11 - 1), intList5.get(12 - 1),
						intList5.get(13 - 1), intList5.get(14 - 1), intList5.get(15 - 1), intList5.get(16 - 1) },
				{ intList6.get(1 - 1), intList6.get(2 - 1), intList6.get(3 - 1), intList6.get(4 - 1),
						intList6.get(5 - 1), intList6.get(6 - 1), intList6.get(7 - 1), intList6.get(8 - 1),
						intList6.get(9 - 1), intList6.get(10 - 1), intList6.get(11 - 1), intList6.get(12 - 1),
						intList6.get(13 - 1), intList6.get(14 - 1), intList6.get(15 - 1), intList6.get(16 - 1) },
				{ intList7.get(1 - 1), intList7.get(2 - 1), intList7.get(3 - 1), intList7.get(4 - 1),
						intList7.get(5 - 1), intList7.get(6 - 1), intList7.get(7 - 1), intList7.get(8 - 1),
						intList7.get(9 - 1), intList7.get(10 - 1), intList7.get(11 - 1), intList7.get(12 - 1),
						intList7.get(13 - 1), intList7.get(14 - 1), intList7.get(15 - 1), intList7.get(16 - 1) },
				{ intList8.get(1 - 1), intList8.get(2 - 1), intList8.get(3 - 1), intList8.get(4 - 1),
						intList8.get(5 - 1), intList8.get(6 - 1), intList8.get(7 - 1), intList8.get(8 - 1),
						intList8.get(9 - 1), intList8.get(10 - 1), intList8.get(11 - 1), intList8.get(12 - 1),
						intList8.get(13 - 1), intList8.get(14 - 1), intList8.get(15 - 1), intList8.get(16 - 1) },
				{ intList9.get(1 - 1), intList9.get(2 - 1), intList9.get(3 - 1), intList9.get(4 - 1),
						intList9.get(5 - 1), intList9.get(6 - 1), intList9.get(7 - 1), intList9.get(8 - 1),
						intList9.get(9 - 1), intList9.get(10 - 1), intList9.get(11 - 1), intList9.get(12 - 1),
						intList9.get(13 - 1), intList9.get(14 - 1), intList9.get(15 - 1), intList9.get(16 - 1) },
				{ intList10.get(1 - 1), intList10.get(2 - 1), intList10.get(3 - 1), intList10.get(4 - 1),
						intList10.get(5 - 1), intList10.get(6 - 1), intList10.get(7 - 1), intList10.get(8 - 1),
						intList10.get(9 - 1), intList10.get(10 - 1), intList10.get(11 - 1), intList10.get(12 - 1),
						intList10.get(13 - 1), intList10.get(14 - 1), intList10.get(15 - 1), intList10.get(16 - 1) },
				{ intList11.get(1 - 1), intList11.get(2 - 1), intList11.get(3 - 1), intList11.get(4 - 1),
						intList11.get(5 - 1), intList11.get(6 - 1), intList11.get(7 - 1), intList11.get(8 - 1),
						intList11.get(9 - 1), intList11.get(10 - 1), intList11.get(11 - 1), intList11.get(12 - 1),
						intList11.get(13 - 1), intList11.get(14 - 1), intList11.get(15 - 1), intList11.get(16 - 1) },
				{ intList12.get(1 - 1), intList12.get(2 - 1), intList12.get(3 - 1), intList12.get(4 - 1),
						intList12.get(5 - 1), intList12.get(6 - 1), intList12.get(7 - 1), intList12.get(8 - 1),
						intList12.get(9 - 1), intList12.get(10 - 1), intList12.get(11 - 1), intList12.get(12 - 1),
						intList12.get(13 - 1), intList12.get(14 - 1), intList12.get(15 - 1), intList12.get(16 - 1) },
				{ intList13.get(1 - 1), intList13.get(2 - 1), intList13.get(3 - 1), intList13.get(4 - 1),
						intList13.get(5 - 1), intList13.get(6 - 1), intList13.get(7 - 1), intList13.get(8 - 1),
						intList13.get(9 - 1), intList13.get(10 - 1), intList13.get(11 - 1), intList13.get(12 - 1),
						intList13.get(13 - 1), intList13.get(14 - 1), intList13.get(15 - 1), intList13.get(16 - 1) },
				{ intList14.get(1 - 1), intList14.get(2 - 1), intList14.get(3 - 1), intList14.get(4 - 1),
						intList14.get(5 - 1), intList14.get(6 - 1), intList14.get(7 - 1), intList14.get(8 - 1),
						intList14.get(9 - 1), intList14.get(10 - 1), intList14.get(11 - 1), intList14.get(12 - 1),
						intList14.get(13 - 1), intList14.get(14 - 1), intList14.get(15 - 1), intList14.get(16 - 1) },
				{ intList15.get(1 - 1), intList15.get(2 - 1), intList15.get(3 - 1), intList15.get(4 - 1),
						intList15.get(5 - 1), intList15.get(6 - 1), intList15.get(7 - 1), intList15.get(8 - 1),
						intList15.get(9 - 1), intList15.get(10 - 1), intList15.get(11 - 1), intList15.get(12 - 1),
						intList15.get(13 - 1), intList15.get(14 - 1), intList15.get(15 - 1), intList15.get(16 - 1) },
				{ intList16.get(1 - 1), intList16.get(2 - 1), intList16.get(3 - 1), intList16.get(4 - 1),
						intList16.get(5 - 1), intList16.get(6 - 1), intList16.get(7 - 1), intList16.get(8 - 1),
						intList16.get(9 - 1), intList16.get(10 - 1), intList16.get(11 - 1), intList16.get(12 - 1),
						intList16.get(13 - 1), intList16.get(14 - 1), intList16.get(15 - 1), intList16.get(16 - 1) } };

		return layout;
	}

	public static List<Integer[][]> listColoredLayouts(int max, String room, int blackBlock, int whiteBlock,
			@Nullable int red, @Nullable int red2, @Nullable int green, @Nullable int green2, @Nullable int blue,
			@Nullable int blue2, @Nullable int purple, @Nullable int purple2, Layout layout) {
		List<Integer[][]> intListList = new ArrayList<Integer[][]>();
		for (int m = 0; m <= max; m++) {
			Integer[][] intList = Layout.getColoredLayout(room + '_' + m, blackBlock, whiteBlock, red, red2, green,
					green2, blue, blue2, purple, purple2, layout);
			intListList.add(intList);
		}
		return intListList;
	}

	private static void coloredcolorChecker(Color c, List<Integer> list, int black, int white, @Nullable int red,
			@Nullable int red2, @Nullable int green, @Nullable int green2, @Nullable int blue, @Nullable int blue2,
			@Nullable int purple, @Nullable int purple2) {
		if (c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 255) {
			list.add(blue);
		} else if (c.getRed() == 0 && c.getGreen() == 255 && c.getBlue() == 255) {
			list.add(blue2);
		} else if (c.getRed() == 255 && c.getGreen() == 0 && c.getBlue() == 0) {
			list.add(red);
		} else if (c.getRed() == 255 && c.getGreen() == 123 && c.getBlue() == 0) {
			list.add(red2);
		} else if (c.getRed() == 0 && c.getGreen() == 255 && c.getBlue() == 0) {
			list.add(green);
		} else if (c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 0) {
			list.add(green2);
		} else if (c.getRed() == 255 && c.getGreen() == 0 && c.getBlue() == 255) {
			list.add(purple);
		} else if (c.getRed() == 144 && c.getGreen() == 0 && c.getBlue() == 255) {
			list.add(purple2);
		} else if (c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0) {
			list.add(black);
		} else {
			list.add(white);
		}
	}

}
