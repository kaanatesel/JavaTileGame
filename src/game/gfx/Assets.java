package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private final static int CROP_WIDTH = 50, CROP_HEIGHT = 50;

	private static BufferedImage water;
	private static BufferedImage tree;
	private static BufferedImage dust;
	private static BufferedImage rock;

	// Player Animations
	private static BufferedImage playerStanding;
	private static BufferedImage[] playerWalkingLeft;
	private static BufferedImage[] playerWalkingRight;
	public static BufferedImage[] playerWalkingUp;
	private static BufferedImage[] playerWalkingDown;
	private static BufferedImage[] playerSwimmingDown;
	private static BufferedImage[] playerSwimmingUp;
	private static BufferedImage[] playerSwimmingRight;
	private static BufferedImage[] playerSwimmingLeft;

	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet ( ImageLoader.loadImage ( "/images/Assets2.png" ) );

		water = sheet.crop ( CROP_WIDTH, 0, CROP_WIDTH, CROP_HEIGHT );
		dust = sheet.crop ( CROP_WIDTH * 2, 0, CROP_WIDTH, CROP_HEIGHT );
		rock = sheet.crop ( 0, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		tree = sheet.crop ( CROP_WIDTH * 3, 0, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingDown = new BufferedImage[2];
		playerWalkingUp = new BufferedImage[2];
		playerWalkingRight = new BufferedImage[2];
		playerWalkingLeft = new BufferedImage[2];
		
		playerSwimmingDown = new BufferedImage[2];
		playerSwimmingUp = new BufferedImage[2];
		playerSwimmingRight = new BufferedImage[2];
		playerSwimmingLeft = new BufferedImage[2];

		// Player
		playerStanding = sheet.crop ( 0, 0, CROP_WIDTH, CROP_HEIGHT );
		// Player walking
		playerWalkingDown[0] = sheet.crop ( CROP_WIDTH, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingDown[1] = sheet.crop ( CROP_WIDTH * 2, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingUp[0] = sheet.crop ( CROP_WIDTH * 3, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingUp[1] = sheet.crop ( 0, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingRight[0] = sheet.crop ( CROP_WIDTH, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingRight[1] = sheet.crop ( CROP_WIDTH * 2, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingLeft[0] = sheet.crop ( CROP_WIDTH * 3, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingLeft[1] = sheet.crop ( 0, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );
		// Player Swimming
		playerSwimmingDown[0] = sheet.crop ( CROP_WIDTH * 5, 0, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingDown[1] = sheet.crop ( CROP_WIDTH * 5, CROP_HEIGHT , CROP_WIDTH, CROP_HEIGHT );

		playerSwimmingUp[0] = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingUp[1] = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );
		
		playerSwimmingRight[0] = sheet.crop ( CROP_WIDTH * 5, CROP_HEIGHT * 2, CROP_WIDTH , CROP_HEIGHT );
		playerSwimmingRight[1] = sheet.crop ( CROP_WIDTH * 5, CROP_HEIGHT * 3, CROP_WIDTH , CROP_HEIGHT );
		
		playerSwimmingLeft[0] = sheet.crop ( CROP_WIDTH * 6, 0, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingLeft[1] = sheet.crop ( CROP_WIDTH * 6, CROP_HEIGHT , CROP_WIDTH, CROP_HEIGHT );

	}

	// GETTERS AND SETTERS

	public static BufferedImage getPlayer()
	{
		return playerStanding;
	}

	public static void setPlayer( BufferedImage player )
	{
		Assets.playerStanding = player;
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

	public static BufferedImage[] getPlayerWalkingLeft()
	{
		return playerWalkingLeft;
	}

	public static void setPlayerWalkingLeft( BufferedImage[] playerWalkingLeft )
	{
		Assets.playerWalkingLeft = playerWalkingLeft;
	}

	public static BufferedImage[] getPlayerWalkingRight()
	{
		return playerWalkingRight;
	}

	public static void setPlayerWalkingRight( BufferedImage[] playerWalkingRight )
	{
		Assets.playerWalkingRight = playerWalkingRight;
	}

	public static BufferedImage[] getPlayerWalkingUp()
	{
		return playerWalkingUp;
	}

	public static void setPlayerWalkingUp( BufferedImage[] playerWalkingUp )
	{
		Assets.playerWalkingUp = playerWalkingUp;
	}

	public static BufferedImage[] getPlayerWalkingDown()
	{
		return playerWalkingDown;
	}

	public static void setPlayerWalkingDown( BufferedImage[] playerWalkingDown )
	{
		Assets.playerWalkingDown = playerWalkingDown;
	}

	public static BufferedImage[] getPlayerSwimmingDown()
	{
		return playerSwimmingDown;
	}

	public static void setPlayerSwimmingDown( BufferedImage[] playerSwimmingDown )
	{
		Assets.playerSwimmingDown = playerSwimmingDown;
	}

	public static BufferedImage[] getPlayerSwimmingUp()
	{
		return playerSwimmingUp;
	}

	public static void setPlayerSwimmingUp( BufferedImage[] playerSwimmingUp )
	{
		Assets.playerSwimmingUp = playerSwimmingUp;
	}

	public static BufferedImage[] getPlayerSwimmingRight()
	{
		return playerSwimmingRight;
	}

	public static void setPlayerSwimmingRight( BufferedImage[] playerSwimmingRight )
	{
		Assets.playerSwimmingRight = playerSwimmingRight;
	}

	public static BufferedImage[] getPlayerSwimmingLeft()
	{
		return playerSwimmingLeft;
	}

	public static void setPlayerSwimmingLeft( BufferedImage[] playerSwimmingLeft )
	{
		Assets.playerSwimmingLeft = playerSwimmingLeft;
	}

}
