package game.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import game.Handler;
import game.entity.player.Player;

public class EntityManager {

	private ArrayList<Entity> entities;
	private Handler handler;
	private Player player;
	private Comparator<Entity> renderSorter = new Comparator<Entity> ()
	{

		@Override
		public int compare( Entity a, Entity b )
		{
			if ( a.getY () + a.getHeight () < b.getY () + b.getHeight () )
				return -1;
			return 1;
		}
	};

	public EntityManager( Handler handler, Player player ) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity> ();

		addEntity ( player );
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
		Iterator<Entity> it = entities.iterator ();
		while ( it.hasNext () )
		{
			Entity e = it.next ();
			e.tick ();
			if ( !e.active )
				it.remove ();
		}
		entities.sort ( renderSorter );
	}

	public void render( Graphics g )
	{
		for ( Entity entity : entities )
		{
			entity.render ( g );
		}
	}

	// Getters and Setter
	public ArrayList<Entity> getEntities()
	{
		return entities;
	}

	public void setEntities( ArrayList<Entity> entities )
	{
		this.entities = entities;
	}

	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler( Handler handler )
	{
		this.handler = handler;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer( Player player )
	{
		this.player = player;
	}
}
