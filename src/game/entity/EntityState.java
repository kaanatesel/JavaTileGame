package game.entity;

import java.awt.image.BufferedImage;

public class EntityState {

	private int height;
	private BufferedImage image;
	private float speed;
	private int width;
	private float x;
	private float y;

	public int getHeight()
	{
		return height;
	}

	public void setHeight( int height )
	{
		this.height = height;
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage( BufferedImage image )
	{
		this.image = image;
	}

	public float getSpeed()
	{
		return speed;
	}

	public void setSpeed( float speed )
	{
		this.speed = speed;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth( int width )
	{
		this.width = width;
	}

	public float getX()
	{
		return x;
	}

	public void setX( float x )
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY( float y )
	{
		this.y = y;
	}
}
