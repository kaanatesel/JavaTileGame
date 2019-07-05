package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private final static int CROP_WIDTH = 50, CROP_HEIGHT = 50;
	private static BufferedImage player;
	private static BufferedImage water;
	private static BufferedImage tree;
	private static BufferedImage dust;
	private static BufferedImage rock;

	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet ( ImageLoader.loadImage ( "/images/Assets2.png" ) );

		water = sheet.crop ( CROP_WIDTH, 0, CROP_WIDTH, CROP_HEIGHT );
		dust = sheet.crop ( 0, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		tree = sheet.crop ( CROP_WIDTH * 3, 0, CROP_WIDTH, CROP_HEIGHT );
		rock = sheet.crop ( CROP_WIDTH * 2, 0, CROP_WIDTH, CROP_HEIGHT );

		player = sheet.crop ( 0, 0, CROP_WIDTH, CROP_HEIGHT );

	}

	// GETTERS AND SETTERS

	public static BufferedImage getPlayer()
	{
		return player;
	}

	public static void setPlayer( BufferedImage player )
	{
		Assets.player = player;
	}

	public static BufferedImage getWater()
	{
		return water;
	}

	public static void setWater( BufferedImage water )
	{
		Assets.water = water;
	}

	public static BufferedImage getTree()
	{
		return tree;
	}

	public static void setTree( BufferedImage tree )
	{
		Assets.tree = tree;
	}

	public static BufferedImage getDust()
	{
		return dust;
	}

	public static void setDust( BufferedImage dust )
	{
		Assets.dust = dust;
	}

	public static BufferedImage getRock()
	{
		return rock;
	}

	public static void setRock( BufferedImage rock )
	{
		Assets.rock = rock;
	}

}
