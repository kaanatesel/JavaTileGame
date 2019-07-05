package game.world;

import java.awt.Graphics;

import game.Handler;
import game.entity.player.Player;
import game.gfx.LoadFileAsString;
import game.tiles.TileBase;

public class World {

	private int[][] tiles;
	private int width, heigth;
	private Handler handler;
	private int spawnX, spawnY;
	private Player player;

	public World( Handler handler, String path ) {
		this.handler = handler;
		loadWorld ( path );
		player = new Player ( spawnX, spawnY, 100, 100, handler );
	}

	public void tick()
	{
		player.tick ();
	}

	public void render( Graphics g )
	{
		for ( int x = 0; x < width; x++ )
		{
			for ( int y = 0; y < heigth; y++ )
			{
				getTile ( x, y ).render ( g, x * TileBase.WIDTH , y * TileBase.HEIGHT);
			}
		}
		player.render ( g );
	}

	public TileBase getTile( int x, int y )
	{
		TileBase t = TileBase.tiles[tiles[x][y]];
		if ( t == null )
			return TileBase.getDustTile ();
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
}
