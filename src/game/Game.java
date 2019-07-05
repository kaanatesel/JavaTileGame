package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.Display;
import game.entity.player.Player;
import game.gfx.Assets;
import game.inputs.KeyManager;
import game.state.GameState;
import game.state.State;

public class Game implements Runnable {

	private BufferStrategy bs;
	private Graphics g;

	private boolean running = false;
	private Thread thread;

	private Display display;

	private int width, height;
	private String title;

	private Player player;
	private KeyManager keyManager;

	private GameState gameState;

	// THIS SHOULD NOT BE HERE JUST FOR NOW
	private Handler handler;

	public Game( String title, int width, int heigth ) {
		this.height = heigth;
		this.width = width;
		this.title = title;

		keyManager = new KeyManager ();

	}

	private void init()
	{
		display = new Display ( title, width, height );

		display.getJFrame ().addKeyListener ( keyManager );

		handler = new Handler ( this );

		// States
		gameState = new GameState ( handler );

		State.setCurrentState ( gameState );

		Assets.init ();
	}

	@Override
	public void run()
	{
		init ();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime ();
		long timer = 0;
		int ticks = 0;

		while ( running )
		{
			now = System.nanoTime ();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if ( delta >= 1 )
			{
				tick ();
				render ();
				ticks++;
				delta--;
			}

			if ( timer >= 1000000000 )
			{
				System.out.println ( "Tick and Frames: " + ticks );
				ticks = 0;
				timer = 0;
			}

		}
	}

	public void tick()
	{
		if ( State.getCurrentState () != null )
		{
			State.getCurrentState ().tick ();
		}
	}

	public void render()
	{
		bs = display.getCanvas ().getBufferStrategy ();
		if ( bs == null )
		{
			display.getCanvas ().createBufferStrategy ( 3 );
			return;
		}
		g = bs.getDrawGraphics ();
		// Clean
		g.clearRect ( 0, 0, width, height );
		// Draw here

		if ( State.getCurrentState () != null )
		{
			State.getCurrentState ().render ( g );
		}

		// End drawing
		bs.show ();
		g.dispose ();
	}

	public synchronized void start()
	{
		if ( running )
			return;
		running = true;
		thread = new Thread ( this );
		thread.start ();

	}

	public synchronized void stop()
	{
		if ( !running )
			return;
		running = false;
		try
		{
			thread.join ();
		}
		catch ( InterruptedException e )
		{
			e.printStackTrace ();
		}
	}

	public KeyManager getKeyManager()
	{
		return keyManager;
	}

	public void setKeyManager( KeyManager keyManager )
	{
		this.keyManager = keyManager;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth( int width )
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight( int height )
	{
		this.height = height;
	}

}
