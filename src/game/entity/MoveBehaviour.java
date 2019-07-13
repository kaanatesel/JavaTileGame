package game.entity;

import game.tiles.Solid;
import game.tiles.TileBase;
import game.tiles.notSolid;

public class MoveBehaviour {

	private final MoveAble entity;
	private float speed;
	private int entityFace;
	// 0 = to up
	// 1 = to right
	// 2 = to down
	// 3 = to left

	public MoveBehaviour( MoveAble entity, float speed ) {
		this.speed = speed;
		this.entity = entity;
		entityFace = 0;
	}

	public void moveUp()
	{
		entityFace = 0;
		int ty = (int) ((entity.getY () + entity.getBounds ().y - speed) / TileBase.HEIGHT);

		if ( entity.getHandler ().getWorld ()
		        .getTile ( (int) ((entity.getX () + entity.getBounds ().x) / TileBase.WIDTH), ty ) instanceof Solid
		        || entity.getHandler ().getWorld ().getTile (
		                (int) ((entity.getX () + entity.getBounds ().x + entity.getBounds ().width) / TileBase.WIDTH),
		                ty ) instanceof Solid )
		{
		}
		else if ( entity.checkEntityCollision ( 0f, -speed ) )
		{
		}
		else
		{

			speed = entity.getSpeed () - checkNotSolidTile ();
			entity.setY ( entity.getY () - speed );
		}
	}

	public void moveRight()
	{

		entityFace = 1;

		int tx = (int) (entity.getX () + speed + entity.getBounds ().x + entity.getBounds ().width) / TileBase.WIDTH;

		if ( entity.getHandler ().getWorld ().getTile ( tx,
		        (int) ((entity.getY () + entity.getBounds ().y) / TileBase.HEIGHT) ) instanceof Solid
		        || entity.getHandler ().getWorld ().getTile ( tx,
		                (int) ((entity.getY () + entity.getBounds ().y + entity.getBounds ().height)
		                        / TileBase.HEIGHT) ) instanceof Solid )
		{
		}
		else if ( entity.checkEntityCollision ( speed, 0f ) )
		{
		}
		else
		{
			speed = entity.getSpeed () - checkNotSolidTile ();
			entity.setX ( entity.getX () + speed );
		}

	}

	public void moveDown()
	{
		entityFace = 2;
		int ty = (int) ((entity.getY () + entity.getBounds ().y + speed + entity.getBounds ().height)
		        / TileBase.HEIGHT);
		if ( entity.getHandler ().getWorld ()
		        .getTile ( (int) ((entity.getX () + entity.getBounds ().x) / TileBase.WIDTH), ty ) instanceof Solid
		        || entity.getHandler ().getWorld ().getTile (
		                (int) ((entity.getX () + entity.getBounds ().x + entity.getBounds ().width) / TileBase.WIDTH),
		                ty ) instanceof Solid )
		{
		}
		else if ( entity.checkEntityCollision ( 0f, speed ) )
		{
		}
		else
		{
			speed = entity.getSpeed () - checkNotSolidTile ();
			entity.setY ( entity.getY () + speed );
		}
	}

	public void moveLeft()
	{

		entityFace = 3;
		int tx = (int) (entity.getX () - speed + entity.getBounds ().x) / TileBase.WIDTH;

		if ( entity.getHandler ().getWorld ().getTile ( tx,
		        (int) ((entity.getY () + entity.getBounds ().y) / TileBase.HEIGHT) ) instanceof Solid
		        || entity.getHandler ().getWorld ().getTile ( tx,
		                (int) ((entity.getY () + +entity.getBounds ().y + entity.getBounds ().height)
		                        / TileBase.HEIGHT) ) instanceof Solid )
		{
		}
		else if ( entity.checkEntityCollision ( -speed, 0f ) )
		{
		}
		else
		{
			speed = entity.getSpeed () - checkNotSolidTile ();
			entity.setX ( entity.getX () - speed );
		}
	}

	public int getEntityFace()
	{
		return entityFace;
	}

	private int checkNotSolidTile()
	{
		int currentTileX = (int) entity.getX () + (entity.getWidth () / 2);
		int currentTileY = (int) entity.getY () + (entity.getHeight () / 2);
		if ( entity.getHandler ().getWorld ().getTile ( currentTileX, currentTileY ) instanceof notSolid )
		{
			notSolid currentTile = (notSolid) entity.getHandler ().getWorld ().getTile ( currentTileX / TileBase.WIDTH,
			        currentTileY / TileBase.HEIGHT );
			return currentTile.moveResistance ();
		}
		return -1;
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
