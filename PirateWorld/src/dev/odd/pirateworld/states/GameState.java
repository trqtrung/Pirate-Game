package dev.odd.pirateworld.states;

import java.awt.Graphics;

import dev.odd.pirateworld.Game;
import dev.odd.pirateworld.Handler;
import dev.odd.pirateworld.enties.creatures.Player;
import dev.odd.pirateworld.gfx.Assets;
import dev.odd.pirateworld.tiles.Tile;
import dev.odd.pirateworld.worlds.World;

public class GameState extends State{
	int move = 0;
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "resource/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);

	}
	
	@Override
	public void tick() {
		move++;
		player.tick();
		handler.getGameCamera().move(1, 1);
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
