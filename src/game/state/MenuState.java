package game.state;

import java.awt.Graphics;

import game.Handler;
import game.world.Menu;

public class MenuState extends State {

	private Menu menu;

	public MenuState( Handler handler ) {
		super ( handler );

		menu = new Menu ( handler );
		handler.setMenu ( menu );
	}

	@Override
	public void tick()
	{
		menu.tick ();
	}

	@Override
	public void render( Graphics g )
	{
		menu.render ( g );
	}

}
