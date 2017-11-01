package dev.odd.pirateworld.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int TILE_SIZE = 64;
	public static BufferedImage ship, sea, islandBig, cannonBall, dinghyLarge1, 
								water1, water2, water3, water4, water5, water6,
								water7, water8, water9, pirate1, grass, tree, topTree,
								box;
	public static BufferedImage[] player_up, player_down, player_left, player_right;
	
	public static void init() {
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles_sheet.png"));
		sea = tileSheet.crop(TILE_SIZE * 8, TILE_SIZE * 4, TILE_SIZE, TILE_SIZE);
		islandBig = tileSheet.crop(TILE_SIZE * 5, TILE_SIZE * 0, TILE_SIZE * 4, TILE_SIZE * 4);
		water1 = tileSheet.crop(TILE_SIZE * 9, TILE_SIZE * 0, TILE_SIZE, TILE_SIZE);
		water2 = tileSheet.crop(TILE_SIZE * 10, TILE_SIZE * 0, TILE_SIZE, TILE_SIZE);
		water3 = tileSheet.crop(TILE_SIZE * 11, TILE_SIZE * 0, TILE_SIZE, TILE_SIZE);
		water4 = tileSheet.crop(TILE_SIZE * 9, TILE_SIZE * 1, TILE_SIZE, TILE_SIZE);
		water5 = tileSheet.crop(TILE_SIZE * 10, TILE_SIZE * 1, TILE_SIZE, TILE_SIZE);
		water6 = tileSheet.crop(TILE_SIZE * 11, TILE_SIZE * 1, TILE_SIZE, TILE_SIZE);
		water7 = tileSheet.crop(TILE_SIZE * 9, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE);
		water8 = tileSheet.crop(TILE_SIZE * 10, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE);
		water9 = tileSheet.crop(TILE_SIZE * 11, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE);
		grass = tileSheet.crop(TILE_SIZE * 6, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE);
		
		SpriteSheet shipSheet = new SpriteSheet(ImageLoader.loadImage("/textures/ships_sheet.png"));
		ship = shipSheet.crop(408, 0, 66, 113);
		cannonBall = shipSheet.crop(120, 29, 10, 10);
		dinghyLarge1 = shipSheet.crop(606, 145, 20, 38);
		
		SpriteSheet pirate1Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pirate_m2.png"));
		pirate1 = pirate1Sheet.crop(0, 0, 32, 48);
		
		SpriteSheet rpgSheet = new SpriteSheet(ImageLoader.loadImage("/textures/RPGpack_sheet.png"));
		tree = rpgSheet.crop(TILE_SIZE * 4, TILE_SIZE * 11, TILE_SIZE, TILE_SIZE);
		topTree = rpgSheet.crop(TILE_SIZE * 4, TILE_SIZE * 10, TILE_SIZE, TILE_SIZE);
		box = rpgSheet.crop(TILE_SIZE * 8, TILE_SIZE * 9, TILE_SIZE, TILE_SIZE);
	}
	
}
