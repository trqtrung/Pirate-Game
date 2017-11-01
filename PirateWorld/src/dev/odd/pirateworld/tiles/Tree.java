package dev.odd.pirateworld.tiles;

import java.awt.image.BufferedImage;

import dev.odd.pirateworld.gfx.Assets;

public class Tree extends Tile{

	public Tree(int id) {
		super(Assets.tree, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
