package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.Display;
import game.gfx.Assets;
import game.helper.GameCamera;
import game.inputs.KeyManager;
import game.inputs.MouseEventListener;
import game.state.GameState;
import game.state.MenuState;
import game.state.State;

public class Game implements Runnable {

	private BufferStrategy bs;
	private Graphics g;

	private boolean running = false;
	private Thread thread;

	private Display display;

	private int width, height;
	private String title;

	private KeyManager keyManager;
	private MouseEventListener mouseEventListener;
	private GameCamera gameCamera;

	private GameState gameState;
	private MenuState menuState;

	private Handler handler;

	public Game( String title, int width, int heigth ) {
		this.height = heigth;
		this.width = width;
		this.title = title;

		keyManager = new KeyManager ();
		mouseEventListener = new MouseEventListener ();
		gameCamera = new GameCamera ( 0, 0, handler );
	}

	private void init()
	{
		display = new Display ( title, width, height );

		display.getJFrame ().addKeyListener ( keyManager );
		display.getJFrame ().addMouseListener ( mouseEventListener );
		display.getJFrame ().addMouseMotionListener ( mouseEventListener );

		display.getCanvas ().addMouseListener ( mouseEventListener );
		display.getCanvas ().addMouseMotionListener ( mouseEventListener );

		Assets.init ();

		handler = new Handler ( this );
		gameCamera = new GameCamera ( 0, 0, handler );
		// States
		gameState = new GameState ( handler );
		menuState = new MenuState ( handler );

		State.setCurrentState ( menuState );

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

	public GameCamera getGameCamera()
	{
		return gameCamera;
	}

	public void setGameCamera( GameCamera gameCamera )
	{
		this.gameCamera = gameCamera;
	}

	public MouseEventListener getMouseEventListener()
	{
		return mouseEventListener;
	}

	public State getGameState()
	{
		return gameState;
	}

	public State getMenuState()
	{
		return menuState;
	}

}
