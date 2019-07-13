package game.entity.staticEntity;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.entity.Entity;
import game.gfx.Assets;

public class Stone extends Entity {
	public Stone( float x, float y, int height, int width, Handler handler ) {
		super ( x, y, height, width, handler );

		bounds.x = (int) 8;
		bounds.y = (int) (height / 2);
		bounds.width = width - 8;
		bounds.height = (int) (height - height / 2f);
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
		g.drawImage ( Assets.getStone (), (int) (x - handler.getGameCamera ().getxOffset ()),
		        (int) (y - handler.getGameCamera ().getyOffset ()), width, height, null );

//		g.setColor ( Color.RED );
//
//		g.fillRect ( (int) (x + bounds.x + -handler.getGameCamera ().getxOffset ()),
//		        (int) (y + bounds.y - handler.getGameCamera ().getyOffset ()), bounds.width, bounds.height );
	}

}
