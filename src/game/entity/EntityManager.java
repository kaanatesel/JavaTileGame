package game.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Handler;
import game.entity.player.Player;

public class EntityManager {

	private ArrayList<Entity> entities;
	private Handler handler;
	private Player player;

	public EntityManager( Handler handler, Player player ) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity> ();
	}

	public void removeEntity( Entity entity )
	{
		entities.remove ( entity );
	}

	public void addEntity( Entity entity )
	{
		entities.add ( entity );
	}

	public void tick()
	{
		for ( Entity entity : entities )
		{
			entity.tick ();
		}
	}

	public void render( Graphics g )
	{
		for ( Entity entity : entities )
		{
			entity.render ( g );
		}
	}

}
