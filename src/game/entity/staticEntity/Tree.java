package game.entity.staticEntity;

import java.awt.Graphics;

import game.Handler;
import game.entity.Entity;
import game.gfx.Assets;

public class Tree extends Entity {

	public Tree( float x, float y, int height, int width, Handler handler ) {
		super ( x, y, height, width, handler );
	}

	@Override
	public Handler getHandler()
	{
		return handler;
	}

	@Override
	public void tick()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( Assets.getTree (), (int) (x - handler.getGameCamera ().getxOffset ()),
		        (int) (y - handler.getGameCamera ().getyOffset ()), width, height, null );

	}

}
