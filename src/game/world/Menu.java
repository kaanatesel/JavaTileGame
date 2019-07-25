package game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.cert.PKIXRevocationChecker.Option;

import game.Handler;
import game.UIObject.StartBtn;
import game.UIObject.UIObjectManager;
import game.gfx.Assets;

public class Menu {

	private Handler handler;
	private BufferedImage background;
	private UIObjectManager uiObjectManager;

	public Menu( Handler handler ) {
		this.handler = handler;
		background = Assets.getBackground ();

		uiObjectManager = new UIObjectManager ( handler );
	}

	public void tick()
	{
		uiObjectManager.tick ();
	}

	public void render( Graphics g )
	{
		g.drawImage ( background, -20, 0, 1020, 1020, null );
		uiObjectManager.render ( g );
	}

}
