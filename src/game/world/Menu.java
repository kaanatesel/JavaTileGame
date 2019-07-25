package game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.UIObject.UIObjectManager;
import game.gfx.Assets;
import game.state.State;

public class Menu extends State {

	private BufferedImage background;
	private UIObjectManager uiObjectManager;

	public Menu( Handler handler ) {
		super ( handler );
		background = Assets.getBackground ();

		uiObjectManager = new UIObjectManager ( handler );
	}

	@Override
	public void tick()
	{
		uiObjectManager.tick ();
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( background, -20, 0, 1020, 1020, null );
		uiObjectManager.render ( g );
	}

}
