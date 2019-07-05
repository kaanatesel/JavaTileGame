package game.state;

import java.awt.Graphics;

import game.Handler;
import game.world.World;

public class GameState extends State{
	
	private World world;
	
	public GameState( Handler handler ) {
		super ( handler );
		world = new World ( handler, "res/Worlds/world1.txt" );
		handler.setWorld ( world );
	}

	@Override
	public void tick()
	{
		world.tick ();
	}

	@Override
	public void render( Graphics g )
	{
		world.render ( g );
	}
	
}
