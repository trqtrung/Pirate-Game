package dev.odd.pirateworld.tiles;

import java.awt.image.BufferedImage;

import dev.odd.pirateworld.gfx.Assets;

public class Box extends Tile{

	public Box(int id) {
		super(Assets.box, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
