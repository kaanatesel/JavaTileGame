package game.entity.staticEntity;

import java.awt.Graphics;

import game.Handler;
import game.entity.Entity;
import game.gfx.Assets;

public class Tree extends Entity {

	public Tree( float x, float y, int height, int width, Handler handler ) {
		super ( x, y, height, width, handler );

		System.out.println ( bounds );

		bounds.x = 48;
		bounds.y = (int) (height / 2);
		bounds.width = (width / 2) - 30;
		bounds.height = (int) (height / 2);
	}

	@Override
	public Handler getHandler()
	{
		return handler;
	}

	@Override
	public void tick()
	{
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( Assets.getTree (), (int) (x - handler.getGameCamera ().getxOffset ()),
		        (int) (y - handler.getGameCamera ().getyOffset ()), width, height, null );

//		g.setColor ( Color.BLACK );
//		g.fillRect ( (int) (x + bounds.x + -handler.getGameCamera ().getxOffset ()),
//		        (int) (y + bounds.y - handler.getGameCamera ().getyOffset ()), bounds.width, bounds.height );
	}

}
