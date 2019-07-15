package game;

import game.helper.GameCamera;
import game.inputs.KeyManager;
import game.item.ItemManager;
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

}
