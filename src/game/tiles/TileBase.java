package game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TileBase implements Tile {

	public static TileBase[] tiles = new TileBase[256];

	protected BufferedImage texture;
	protected int id;

	// Tiles
	public static RockTile rockTile = new RockTile ( 0 );
	public static WaterTile waterTile = new WaterTile ( 1, 10 );
	public static DustTile dustTile = new DustTile ( 2, 0 );

	private int xLoc, yLoc;

	public TileBase( BufferedImage texture, int id ) {

		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	@Override
	public void tick()
	{

	}

	@Override
	public void render( Graphics g, int x, int y )
	{
		g.drawImage ( texture, x, y, WIDTH, HEIGHT, null );
		xLoc = x;
		yLoc = y;

	}

	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

	// Getters and Setters

	public static Tile[] getTiles()
	{
		return tiles;
	}

	public BufferedImage getTexture()
	{
		return texture;
	}

	public void setTexture( BufferedImage texture )
	{
		this.texture = texture;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public static DustTile getDustTile()
	{
		return dustTile;
	}

	public static WaterTile getWaterTile()
	{
		return waterTile;
	}

	public static RockTile getRockTile()
	{
		return rockTile;
	}

	public int getxLoc()
	{
		return xLoc;
	}

	public void setxLoc( int xLoc )
	{
		this.xLoc = xLoc;
	}

	public int getyLoc()
	{
		return yLoc;
	}

	public void setyLoc( int yLoc )
	{
		this.yLoc = yLoc;
	}
}
