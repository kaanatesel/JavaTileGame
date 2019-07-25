package game.world;

import java.awt.Graphics;

import game.Handler;
import game.entity.EntityManager;
import game.entity.player.Player;
import game.entity.staticEntity.Stone;
import game.entity.staticEntity.Tree;
import game.gfx.LoadFileAsString;
import game.item.ItemManager;
import game.tiles.DustTile;
import game.tiles.TileBase;

public class World {

	private int[][] tiles;
	public int width, heigth;
	private Handler handler;
	private int spawnX, spawnY;
	private Player player;

	private EntityManager entityManager;
	private ItemManager itemManager;

	public World( Handler handler, String path ) {
		this.handler = handler;
		loadWorld ( path );

		player = new Player ( spawnX, spawnY, TileBase.WIDTH, TileBase.HEIGHT, handler );

		entityManager = new EntityManager ( handler, player );
		itemManager = new ItemManager ( handler );

		int staticEntityNumber = (int) ((Math.random () * 120) + 60);

		for ( int i = 0; i < staticEntityNumber; i++ )
		{
			int randomX = (int) ((Math.random () * TileBase.WIDTH * 37) + TileBase.WIDTH);
			int randomY = (int) ((Math.random () * TileBase.HEIGHT * 37) + TileBase.HEIGHT);

			if ( (getTile ( randomX / TileBase.WIDTH + 2, randomY / TileBase.HEIGHT + 2 ) instanceof DustTile)
			        && (getTile ( randomX / TileBase.WIDTH, randomY / TileBase.HEIGHT + 2 ) instanceof DustTile) )
			{
				entityManager
				        .addEntity ( new Tree ( randomX, randomY, TileBase.HEIGHT * 2, TileBase.WIDTH * 2, handler ) );

			}
		}

		for ( int i = 0; i < staticEntityNumber; i++ )
		{
			int randomX = (int) ((Math.random () * TileBase.WIDTH * 39) + TileBase.WIDTH);
			int randomY = (int) ((Math.random () * TileBase.HEIGHT * 39) + TileBase.HEIGHT);

			if ( (getTile ( randomX / TileBase.WIDTH, randomY / TileBase.HEIGHT ) instanceof DustTile)
			        && (getTile ( randomX / TileBase.WIDTH + 1, randomY / TileBase.HEIGHT + 1 ) instanceof DustTile) )
			{
				entityManager.addEntity ( new Stone ( randomX, randomY, TileBase.HEIGHT, TileBase.WIDTH, handler ) );
			}
		}

		entityManager.getPlayer ().setX ( spawnX );
		entityManager.getPlayer ().setY ( spawnY );

	}

	public void tick()
	{
		entityManager.tick ();
		itemManager.tick ();
	}

	public void render( Graphics g )
	{

		int xStart = (int) Math.max ( 0, handler.getGameCamera ().getxOffset () / TileBase.HEIGHT );
		int xEnd = (int) Math.min ( width,
		        (handler.getGameCamera ().getxOffset () + handler.getWidth ()) / TileBase.WIDTH + 1 );
		int yStart = (int) Math.max ( 0, handler.getGameCamera ().getyOffset () / TileBase.HEIGHT );

		int yEnd = (int) Math.min ( width,
		        (handler.getGameCamera ().getyOffset () + handler.getHeight ()) / TileBase.HEIGHT + 1 );

		for ( int y = yStart; y < yEnd; y++ )
		{
			for ( int x = xStart; x < xEnd; x++ )
			{
				getTile ( x, y ).render ( g, (int) (x * TileBase.WIDTH - handler.getGameCamera ().getxOffset ()),
				        (int) (y * TileBase.HEIGHT - handler.getGameCamera ().getyOffset ()) );
			}
		}

		itemManager.render ( g );

		entityManager.render ( g );

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

	public ItemManager getItemManager()
	{
		return itemManager;
	}

	public void setItemManager( ItemManager itemManager )
	{
		this.itemManager = itemManager;
	}

	public void setSpawnY( int spawnY )
	{
		this.spawnY = spawnY;
	}

}
