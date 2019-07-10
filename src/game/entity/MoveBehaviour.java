package game.entity;

import game.tiles.Solid;
import game.tiles.TileBase;

public class MoveBehaviour {

	private final Entity entity;
	private float speed;

	public MoveBehaviour( Entity entity, float speed ) {
		this.speed = speed;
		this.entity = entity;
	}

	public void moveUp()
	{

		int ty = (int) ((entity.y + entity.getBounds ().y - speed) / TileBase.HEIGHT);

		if ( entity.handler.getWorld ().getTile ( (int) ((entity.x + entity.getBounds ().x) / TileBase.WIDTH),
		        ty ) instanceof Solid
		        || entity.handler.getWorld ().getTile (
		                (int) ((entity.x + entity.getBounds ().x + entity.getBounds ().width) / TileBase.WIDTH),
		                ty ) instanceof Solid )
		{
		}
		else
		{
			entity.setY ( entity.getY () - speed );
		}
	}

	public void moveLeft()
	{
		int tx = (int) (entity.x - speed + entity.getBounds ().x) / TileBase.WIDTH;

		if ( entity.handler.getWorld ().getTile ( tx,
		        (int) ((entity.y + entity.getBounds ().y) / TileBase.HEIGHT) ) instanceof Solid
		        || entity.handler.getWorld ().getTile ( tx,
		                (int) ((entity.y + +entity.getBounds ().y + entity.getBounds ().height)
		                        / TileBase.HEIGHT) ) instanceof Solid )
		{
		}
		else
		{

			entity.setX ( entity.getX () - speed );
		}
	}

	public void moveRight()
	{

		int tx = (int) (entity.x + speed + entity.getBounds ().x + entity.getBounds ().width) / TileBase.WIDTH;

		if ( entity.handler.getWorld ().getTile ( tx,
		        (int) ((entity.getY () + entity.getBounds ().y) / TileBase.HEIGHT) ) instanceof Solid
		        || entity.handler.getWorld ().getTile ( tx,
		                (int) ((entity.y + entity.getBounds ().y + entity.getBounds ().height)
		                        / TileBase.HEIGHT) ) instanceof Solid )
		{
		}
		else
		{
			entity.setX ( entity.getX () + speed );
		}

	}

	public void moveDown()
	{
		int ty = (int) ((entity.y + entity.getBounds ().y + speed + entity.getBounds ().height) / TileBase.HEIGHT);
		if ( entity.handler.getWorld ().getTile ( (int) ((entity.x + entity.getBounds ().x) / TileBase.WIDTH),
		        ty ) instanceof Solid
		        || entity.handler.getWorld ().getTile (
		                (int) ((entity.x + entity.getBounds ().x + entity.getBounds ().width) / TileBase.WIDTH),
		                ty ) instanceof Solid )
		{
		}
		else
		{
			entity.setY ( entity.getY () + speed );
		}
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
