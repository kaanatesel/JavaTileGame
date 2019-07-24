package game;

import game.helper.GameCamera;
import game.inputs.KeyManager;
import game.inputs.MouseEventListener;
import game.world.Menu;
import game.world.World;

public class Handler {

	private World world;
	private Game game;
	private Menu menu;

	public Handler( Game game ) {
		this.game = game;
	}

	public int getWidth()
	{
		return game.getWidth ();
	}

	public int getHeight()
	{
		return game.getHeight ();
	}

	public KeyManager getKeyManager()
	{
		return game.getKeyManager ();
	}

	public Game getGame()
	{
		return game;
	}

	public World getWorld()
	{
		return world;
	}

	public GameCamera getGameCamera()
	{
		return game.getGameCamera ();
	}

	public void setWorld( World world )
	{
		this.world = world;
	}

	public void setGame( Game game )
	{
		this.game = game;
	}

	public MouseEventListener getMouseEventListener()
	{
		return game.getMouseEventListener ();
	}

	public Menu getMenu()
	{
		return menu;
	}

	public void setMenu( Menu menu )
	{
		this.menu = menu;
	}

}
