package dev.odd.pirateworld.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	public static Tile[] tiles = new Tile[256];
	public static Grass grass = new Grass(0);
	public static Tree tree = new Tree(1);
	public static TopTree topTree = new TopTree(2);
	public static Box box = new Box(3);
	
	public static final int TILE_WIDTH = 64,
							TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int  x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return this.id;
	}
	
}
