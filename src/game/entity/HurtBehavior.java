package game.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.inputs.AvailableKey;
import game.tiles.TileBase;
import game.tiles.WaterTile;
import game.tiles.notSolid;

public class HurtBehavior {

	private Entity entity;
	private int strength;
	private int hitRange;
	private long lastAttackTimer, attackCoolDown, attackTimer = attackCoolDown;

	public HurtBehavior( Entity entity, int strength, int hitRange, long attackCoolDown ) {
		this.strength = strength;
		this.hitRange = hitRange;
		this.entity = entity;
		this.attackCoolDown = attackCoolDown;
	}

	public void attack( int faceDirection )
	{
		int currentTileX = (int) entity.getX () + (entity.getWidth () / 2);
		int currentTileY = (int) entity.getY () + (entity.getHeight () / 2);

		attackTimer += System.currentTimeMillis () - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis ();
		if ( attackTimer < attackCoolDown )
			return;

		int arSize = hitRange;
		Rectangle cb = entity.getCollisionBounds ( 0, 0 );
		Rectangle ar = new Rectangle ();
		ar.width = entity.getWidth ();
		ar.height = entity.getHeight ();

		if ( entity.getHandler ().getWorld ().getTile ( currentTileX / TileBase.WIDTH,
		        currentTileY / TileBase.HEIGHT ) instanceof WaterTile )
		{
			return;
		}

		if ( entity.getHandler ().getKeyManager ().getPressedKeys ().contains ( AvailableKey.hit ) )
		{
			if ( faceDirection == 0 )
			{
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y - arSize;
			}
			else if ( faceDirection == 1 )
			{
				ar.x = cb.x + arSize;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			}
			else if ( faceDirection == 2 )
			{
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y + arSize;
			}
			else if ( faceDirection == 3 )
			{
				ar.x = cb.x - arSize;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			}
			else
			{
				return;
			}

		}

		for ( Entity e : entity.getHandler ().getWorld ().getEntityManager ().getEntities () )
		{
			if ( e.equals ( entity ) )
			{
				continue;
			}
			else if ( e.getCollisionBounds ( 0, 0 ).intersects ( ar ) )
			{
				e.hurt ( 1 );
			}

		}
	}

}
