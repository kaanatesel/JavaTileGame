package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private final static int CROP_WIDTH = 50, CROP_HEIGHT = 50;

	private static BufferedImage inventory;

	private static BufferedImage water;
	private static BufferedImage tree;
	private static BufferedImage dust;
	private static BufferedImage rock;
	private static BufferedImage stone;
	private static BufferedImage woodItem;
	private static BufferedImage stoneItem;
	// Player Animations
	private static BufferedImage playerLeftStanding;
	private static BufferedImage playerUpStanding;
	private static BufferedImage playerRightStanding;
	private static BufferedImage playerDownStanding;
	private static BufferedImage playerDownStandSwimming;
	private static BufferedImage playerUpStandSwimming;
	private static BufferedImage playerLeftStandSwimming;
	private static BufferedImage playerRightStandSwimming;
	private static BufferedImage[] playerWalkingLeft;
	private static BufferedImage[] playerWalkingRight;
	public static BufferedImage[] playerWalkingUp;
	private static BufferedImage[] playerWalkingDown;
	private static BufferedImage[] playerSwimmingDown;
	private static BufferedImage[] playerSwimmingUp;
	private static BufferedImage[] playerSwimmingRight;
	private static BufferedImage[] playerSwimmingLeft;
	private static BufferedImage[] playerLeftAttack;
	private static BufferedImage[] playerRightAttack;
	private static BufferedImage[] playerDownAttack;
	private static BufferedImage[] playerUpAttack;
	// Menu
	private static BufferedImage background;
	private static BufferedImage[] startBtn;
	private static BufferedImage[] exitBtn;
	private static BufferedImage[] optionsBtn;

	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet ( ImageLoader.loadImage ( "/images/Assets2.png" ) );

		water = sheet.crop ( CROP_WIDTH, 0, CROP_WIDTH, CROP_HEIGHT );
		dust = sheet.crop ( CROP_WIDTH * 2, 0, CROP_WIDTH, CROP_HEIGHT );
		rock = sheet.crop ( 0, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		tree = sheet.crop ( CROP_WIDTH * 3, 0, CROP_WIDTH, CROP_HEIGHT );
		stone = sheet.crop ( CROP_WIDTH * 3, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		inventory = sheet.crop ( 0, CROP_HEIGHT * 5, CROP_WIDTH * 4, CROP_HEIGHT * 4 );

		playerWalkingDown = new BufferedImage[2];
		playerWalkingUp = new BufferedImage[2];
		playerWalkingRight = new BufferedImage[2];
		playerWalkingLeft = new BufferedImage[2];

		playerSwimmingDown = new BufferedImage[2];
		playerSwimmingUp = new BufferedImage[2];
		playerSwimmingRight = new BufferedImage[2];
		playerSwimmingLeft = new BufferedImage[2];

		playerLeftAttack = new BufferedImage[2];
		playerRightAttack = new BufferedImage[2];
		playerDownAttack = new BufferedImage[2];
		playerUpAttack = new BufferedImage[2];

		// Menu
		startBtn = new BufferedImage[2];
		exitBtn = new BufferedImage[2];
		optionsBtn = new BufferedImage[2];

		background = sheet.crop ( CROP_WIDTH * 7, 0, CROP_WIDTH * 5, CROP_HEIGHT * 4 );

		startBtn[0] = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT * 4, CROP_WIDTH * 2, CROP_HEIGHT );
		startBtn[1] = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT * 5, CROP_WIDTH * 2, CROP_HEIGHT );

		optionsBtn[0] = sheet.crop ( CROP_WIDTH * 6, CROP_HEIGHT * 4, CROP_WIDTH * 2, CROP_HEIGHT );
		optionsBtn[1] = sheet.crop ( CROP_WIDTH * 6, CROP_HEIGHT * 5, CROP_WIDTH * 2, CROP_HEIGHT );

		exitBtn[0] = sheet.crop ( CROP_WIDTH * 8, CROP_HEIGHT * 4, CROP_WIDTH * 2, CROP_HEIGHT );
		exitBtn[1] = sheet.crop ( CROP_WIDTH * 8, CROP_HEIGHT * 5, CROP_WIDTH * 2, CROP_HEIGHT );

		// Items
		stoneItem = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		woodItem = sheet.crop ( CROP_WIDTH * 4, 0, CROP_WIDTH, CROP_HEIGHT );

		// Player
		playerRightStanding = sheet.crop ( CROP_WIDTH * 2, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerLeftStanding = sheet.crop ( 0, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );
		playerDownStanding = sheet.crop ( 0, 0, CROP_WIDTH, CROP_HEIGHT );
		playerUpStanding = sheet.crop ( CROP_WIDTH * 6, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerLeftStandSwimming = sheet.crop ( CROP_WIDTH * 6, 0, CROP_WIDTH, CROP_HEIGHT );
		playerRightStandSwimming = sheet.crop ( CROP_WIDTH * 5, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerDownStandSwimming = sheet.crop ( CROP_WIDTH * 5, 0, CROP_WIDTH, CROP_HEIGHT );
		playerUpStandSwimming = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

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
		playerSwimmingDown[1] = sheet.crop ( CROP_WIDTH * 5, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );

		playerSwimmingUp[0] = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingUp[1] = sheet.crop ( CROP_WIDTH * 4, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		playerSwimmingRight[0] = sheet.crop ( CROP_WIDTH * 5, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingRight[1] = sheet.crop ( CROP_WIDTH * 5, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		playerSwimmingLeft[0] = sheet.crop ( CROP_WIDTH * 6, 0, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingLeft[1] = sheet.crop ( CROP_WIDTH * 6, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );

		// Player Attack
		playerLeftAttack[0] = sheet.crop ( 0, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerLeftAttack[1] = sheet.crop ( 0, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		playerRightAttack[0] = sheet.crop ( CROP_WIDTH, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerRightAttack[1] = sheet.crop ( CROP_WIDTH * 2, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerDownAttack[0] = sheet.crop ( CROP_WIDTH * 2, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerDownAttack[1] = sheet.crop ( 0, 0, CROP_WIDTH, CROP_HEIGHT );

		playerUpAttack[0] = sheet.crop ( CROP_WIDTH * 3, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerUpAttack[1] = sheet.crop ( CROP_WIDTH * 6, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

	}

	// GETTERS AND SETTERS

	public static BufferedImage getWater()
	{
		return water;
	}

	public static BufferedImage[] getPlayerLeftAttack()
	{
		return playerLeftAttack;
	}

	public static void setPlayerLeftAttack( BufferedImage[] playerLeftAttack )
	{
		Assets.playerLeftAttack = playerLeftAttack;
	}

	public static BufferedImage[] getPlayerRightAttack()
	{
		return playerRightAttack;
	}

	public static void setPlayerRightAttack( BufferedImage[] playerRightAttack )
	{
		Assets.playerRightAttack = playerRightAttack;
	}

	public static BufferedImage[] getPlayerDownAttack()
	{
		return playerDownAttack;
	}

	public static void setPlayerDownAttack( BufferedImage[] playerDownAttack )
	{
		Assets.playerDownAttack = playerDownAttack;
	}

	public static BufferedImage getInventory()
	{
		return inventory;
	}

	public static void setInventory( BufferedImage inventory )
	{
		Assets.inventory = inventory;
	}

	public static BufferedImage[] getPlayerUpAttack()
	{
		return playerUpAttack;
	}

	public static void setPlayerUpAttack( BufferedImage[] playerUpAttack )
	{
		Assets.playerUpAttack = playerUpAttack;
	}

	public static void setWater( BufferedImage water )
	{
		Assets.water = water;
	}

	public static BufferedImage getPlayerDownStandSwimming()
	{
		return playerDownStandSwimming;
	}

	public static void setPlayerDownStandSwimming( BufferedImage playerDownStandSwimming )
	{
		Assets.playerDownStandSwimming = playerDownStandSwimming;
	}

	public static BufferedImage getPlayerUpStandSwimming()
	{
		return playerUpStandSwimming;
	}

	public static void setPlayerUpStandSwimming( BufferedImage playerUpStandSwimming )
	{
		Assets.playerUpStandSwimming = playerUpStandSwimming;
	}

	public static BufferedImage getPlayerLeftStandSwimming()
	{
		return playerLeftStandSwimming;
	}

	public static void setPlayerLeftStandSwimming( BufferedImage playerLeftStandSwimming )
	{
		Assets.playerLeftStandSwimming = playerLeftStandSwimming;
	}

	public static BufferedImage getPlayerRightStandSwimming()
	{
		return playerRightStandSwimming;
	}

	public static void setPlayerRightStandSwimming( BufferedImage playerRightStandSwimming )
	{
		Assets.playerRightStandSwimming = playerRightStandSwimming;
	}

	public static BufferedImage getPlayerLeftStanding()
	{
		return playerLeftStanding;
	}

	public static void setPlayerLeftStanding( BufferedImage playerLeftStanding )
	{
		Assets.playerLeftStanding = playerLeftStanding;
	}

	public static BufferedImage getPlayerUpStanding()
	{
		return playerUpStanding;
	}

	public static void setPlayerUpStanding( BufferedImage playerUpStanding )
	{
		Assets.playerUpStanding = playerUpStanding;
	}

	public static BufferedImage getPlayerRightStanding()
	{
		return playerRightStanding;
	}

	public static void setPlayerRightStanding( BufferedImage playerRightStanding )
	{
		Assets.playerRightStanding = playerRightStanding;
	}

	public static BufferedImage getPlayerDownStanding()
	{
		return playerDownStanding;
	}

	public static void setPlayerDownStanding( BufferedImage playerDownStanding )
	{
		Assets.playerDownStanding = playerDownStanding;
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

	public static BufferedImage getWoodItem()
	{
		return woodItem;
	}

	public static void setWoodItem( BufferedImage woodItem )
	{
		Assets.woodItem = woodItem;
	}

	public static BufferedImage getstoneItem()
	{
		return stoneItem;
	}

	public static void setstoneItem( BufferedImage rockItem )
	{
		Assets.stoneItem = rockItem;
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

	public static BufferedImage getStone()
	{
		return stone;
	}

	public static void setStone( BufferedImage stone )
	{
		Assets.stone = stone;
	}

	public static BufferedImage getBackground()
	{
		return background;
	}

	public static BufferedImage[] getStartBtn()
	{
		return startBtn;
	}

	public static BufferedImage[] getExitBtn()
	{
		return exitBtn;
	}

	public static BufferedImage[] getOptionsBtn()
	{
		return optionsBtn;
	}
	

}
