package game.helper;

import game.entity.Entity;

public class MoveBehaviour {

	private final Entity entity;
	private float speed;

	public MoveBehaviour( Entity entity, float speed ) {
		this.speed = speed;
		this.entity = entity;
	}

	public void moveDown()
	{

		entity.setY ( entity.getY () + speed );
	}

	public void moveLeft()
	{

		entity.setX ( entity.getX () - speed );
	}

	public void moveRight()
	{

		entity.setX ( entity.getX () + speed );
	}

	public void moveUp()
	{

		entity.setY ( entity.getY () - speed );
	}

	// Getters and Setters
	public float getSpeed()
	{
		return speed;
	}

	public void setSpeed( float speed )
	{
		this.speed = speed;
	}

}
