package dev.odd.pirateworld.enties.creatures;

import dev.odd.pirateworld.Game;
import dev.odd.pirateworld.Handler;
import dev.odd.pirateworld.enties.Entity;
import dev.odd.pirateworld.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 64,
							DEFAULT_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected int xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0 ) {//Moving Right
			int tx = (int) (x + bounds.x + xMove + bounds.width) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && 
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
				
		}else if(xMove < 0) {//Moving Left
			int tx = (int) (x + bounds.x + xMove) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && 
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
		
	}
	
	public void moveY() {
		if(yMove < 0) {//Moving Up
			int ty = (int) (y + bounds.y + yMove) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
		}else if(yMove > 0) {//Moving down
			int ty = (int) (y + bounds.y + yMove + bounds.height) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height -1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
