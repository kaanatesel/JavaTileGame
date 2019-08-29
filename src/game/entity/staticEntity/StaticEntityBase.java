package game.entity.staticEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.entity.Entity;

public class StaticEntityBase extends Entity {

	protected BufferedImage texture;

	public StaticEntityBase( float x, float y, int height, int width, Handler handler ) {
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

	}

	@Override
	public void render( Graphics g )
	{

	}

	public BufferedImage getTexture()
	{
		return texture;
	}

	public void setTexture( BufferedImage texture )
	{
		this.texture = texture;
	}

}
