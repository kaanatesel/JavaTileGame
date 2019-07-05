package game;

import game.inputs.KeyManager;
import game.world.World;

public class Handler {

	private World world;
	private Game game;

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

	public void setWorld( World world )
	{
		this.world = world;
	}

	public void setGame( Game game )
	{
		this.game = game;
	}

}
