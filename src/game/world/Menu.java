package game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.cert.PKIXRevocationChecker.Option;

import game.Handler;
import game.UIObject.StartBtn;
import game.gfx.Assets;

public class Menu {

	private Handler handler;
	private BufferedImage background;
	private StartBtn startBtn;

	public Menu( Handler handler ) {
		this.handler = handler;
		startBtn = new StartBtn ( handler, Assets.getStartBtn (), 450, 350, 300, 150 );
		init ();
	}

	private void init()
	{
		background = Assets.getBackground ();
	}

	public void tick()
	{
		startBtn.tick ();
	}

	public void render( Graphics g )
	{
		g.drawImage ( background, -20, 0, 1020, 1020, null );
		startBtn.render ( g );
	}

}
