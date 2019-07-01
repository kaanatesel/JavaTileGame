package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.Display;
import game.entity.player.Player;
import game.inputs.KeyManager;

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

	public Game( String title, int width, int heigth ) {
		this.height = heigth;
		this.width = width;
		this.title = title;
		player = new Player ( 30, 30, 50, 50, this );

		keyManager = new KeyManager ();
	}

	private void init()
	{
		display = new Display ( title, width, height );

		display.getJFrame ().addKeyListener ( keyManager );
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
		keyManager.tick ();
		
		player.tick ();
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

		player.render ( g );

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

}
