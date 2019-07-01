package game.entity;

import java.awt.Graphics;

import game.Game;

public abstract class Entity {

	private final int DEFOULT_HEALTH = 20;

	protected int health;
	protected float x, y;
	protected int height, width;
	protected Game game;

	public Entity( float x, float y, int height, int width, Game game ) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.health = DEFOULT_HEALTH;
	}

	public Entity( float x, float y, int height, int width, int health ) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.height = height;
		this.width = width;
	}

	public abstract void tick();

	public abstract void render( Graphics g );

	// Getters and Setters

	public int getHealth()
	{
		return health;
	}

	public void setHealth( int health )
	{
		this.health = health;
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

	public int getHeight()
	{
		return height;
	}

	public void setHeight( int height )
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth( int width )
	{
		this.width = width;
	}

}
