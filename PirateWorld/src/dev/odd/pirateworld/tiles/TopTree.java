package dev.odd.pirateworld.tiles;

import java.awt.image.BufferedImage;

import dev.odd.pirateworld.gfx.Assets;

public class TopTree extends Tile{

	public TopTree(int id) {
		super(Assets.topTree, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
