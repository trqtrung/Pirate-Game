package dev.odd.pirateworld;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.odd.pirateworld.display.Display;
import dev.odd.pirateworld.gfx.Assets;
import dev.odd.pirateworld.gfx.GameCamera;
import dev.odd.pirateworld.gfx.ImageLoader;
import dev.odd.pirateworld.gfx.SpriteSheet;
import dev.odd.pirateworld.input.KeyManager;
import dev.odd.pirateworld.states.GameState;
import dev.odd.pirateworld.states.MenuState;
import dev.odd.pirateworld.states.State;

public class Game implements Runnable {
	//display
	private Display display;
	
	//game circle
	private Thread thread;
	
	private String title;
	private int width, height;
	private boolean running = false;
	
	//render
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState;
	
	//input
	private KeyManager keyManager;
	
	//camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}
	
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
			State.getState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			
			now = System.nanoTime();
			delta += ( now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
			
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		 try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
