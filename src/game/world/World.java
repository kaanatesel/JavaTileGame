package game.world;

import java.awt.Graphics;

import game.Handler;
import game.entity.EntityManager;
import game.entity.player.Player;
import game.entity.staticEntity.Stone;
import game.entity.staticEntity.Tree;
import game.gfx.LoadFileAsString;
import game.tiles.TileBase;

public class World {

	private int[][] tiles;
	public int width, heigth;
	private Handler handler;
	private int spawnX, spawnY;
	private Player player;

	private EntityManager entityManager;

	public World( Handler handler, String path ) {
		this.handler = handler;
		loadWorld ( path );

		player = new Player ( spawnX, spawnY, TileBase.WIDTH, TileBase.HEIGHT, handler );

		entityManager = new EntityManager ( handler, player );

		entityManager.addEntity ( new Tree ( 200, 200, TileBase.HEIGHT * 2, TileBase.WIDTH * 2, handler ) );
		entityManager.addEntity ( new Stone ( 400, 100, TileBase.HEIGHT, TileBase.WIDTH, handler ) );

		entityManager.getPlayer ().setX ( spawnX );
		entityManager.getPlayer ().setY ( spawnY );

	}

	public void tick()
	{
		entityManager.tick ();
	}

	public void render( Graphics g )
	{
		for ( int x = 0; x < width; x++ )
		{
			for ( int y = 0; y < heigth; y++ )
			{
				getTile ( x, y ).render ( g, (int) (x * TileBase.WIDTH - handler.getGameCamera ().getxOffset ()),
				        (int) (y * TileBase.HEIGHT - handler.getGameCamera ().getyOffset ()) );
			}
		}
		entityManager.render ( g );
		// collisionDetection.render ( g );

	}

	public TileBase getTile( int x, int y )
	{
		if ( x < 0 || y < 0 || x >= width || y >= heigth )
			return TileBase.getDustTile ();

		TileBase t = TileBase.tiles[tiles[x][y]];
		if ( t == null )
			return TileBase.getDustTile ();
		else
			return t;
	}

	private void loadWorld( String path )
	{
		String file = LoadFileAsString.loadAsString ( path );
		String[] tokens = file.split ( "\\s+" );
		width = LoadFileAsString.parseInt ( tokens[0] );
		heigth = LoadFileAsString.parseInt ( tokens[1] );
		spawnX = LoadFileAsString.parseInt ( tokens[2] );
		spawnY = LoadFileAsString.parseInt ( tokens[3] );

		tiles = new int[width][heigth];
		for ( int y = 0; y < heigth; y++ )
		{
			for ( int x = 0; x < width; x++ )
			{
				tiles[x][y] = LoadFileAsString.parseInt ( tokens[(x + y * width + 4)] );
			}
		}
	}

	// Getters and Setters

	public int getWidth()
	{
		return width;
	}
	

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer( Player player )
	{
		this.player = player;
	}

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public void setEntityManager( EntityManager entityManager )
	{
		this.entityManager = entityManager;
	}

	public void setWidth( int width )
	{
		this.width = width;
	}

	public int getHeigth()
	{
		return heigth;
	}

	public void setHeigth( int heigth )
	{
		this.heigth = heigth;
	}

	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler( Handler handler )
	{
		this.handler = handler;
	}

	public int getSpawnX()
	{
		return spawnX;
	}

	public void setSpawnX( int spawnX )
	{
		this.spawnX = spawnX;
	}

	public int getSpawnY()
	{
		return spawnY;
	}

	public void setSpawnY( int spawnY )
	{
		this.spawnY = spawnY;
	}

}
