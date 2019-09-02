package game.gfx;

import java.awt.image.BufferedImage;

public class Assets
{

	private final static int CROP_WIDTH = 50, CROP_HEIGHT = 50;

	private static BufferedImage inventory;
	private static BufferedImage craftTableBackGround;

	private static BufferedImage water;
	private static BufferedImage tree;
	private static BufferedImage dust;
	private static BufferedImage rock;
	private static BufferedImage sand;
	private static BufferedImage stone;
	private static BufferedImage woodItem;
	private static BufferedImage stoneItem;
	private static BufferedImage craftTable;
	private static BufferedImage sword;
	private static BufferedImage armour;

	// Player Animations swim
	private static BufferedImage playerDownStandSwimming;
	private static BufferedImage playerUpStandSwimming;
	private static BufferedImage playerLeftStandSwimming;
	private static BufferedImage playerRightStandSwimming;
	private static BufferedImage[] playerSwimmingDown;
	private static BufferedImage[] playerSwimmingUp;
	private static BufferedImage[] playerSwimmingRight;
	private static BufferedImage[] playerSwimmingLeft;

	// Player Animations normal
	private static BufferedImage playerLeftStanding;
	private static BufferedImage playerUpStanding;
	private static BufferedImage playerRightStanding;
	private static BufferedImage playerDownStanding;
	private static BufferedImage[] playerWalkingDown;
	private static BufferedImage[] playerWalkingLeft;
	private static BufferedImage[] playerWalkingRight;
	private static BufferedImage[] playerWalkingUp;
	private static BufferedImage[] playerLeftAttack;
	private static BufferedImage[] playerRightAttack;
	private static BufferedImage[] playerDownAttack;
	private static BufferedImage[] playerUpAttack;
	// Player Animations with Armour
	private static BufferedImage playerLeftStandingArmour;
	private static BufferedImage playerUpStandingArmour;
	private static BufferedImage playerRightStandingArmour;
	private static BufferedImage playerDownStandingArmour;
	private static BufferedImage[] playerWalkingDownArmour;
	private static BufferedImage[] playerWalkingLeftArmour;
	private static BufferedImage[] playerWalkingRightArmour;
	private static BufferedImage[] playerWalkingUpArmour;
	private static BufferedImage[] playerLeftAttackArmour;
	private static BufferedImage[] playerRightAttackArmour;
	private static BufferedImage[] playerDownAttackArmour;
	private static BufferedImage[] playerUpAttackArmour;
	// Player Animations with Sword
	private static BufferedImage playerLeftStandingSword;
	private static BufferedImage playerUpStandingSword;
	private static BufferedImage playerRightStandingSword;
	private static BufferedImage playerDownStandingSword;
	private static BufferedImage[] playerWalkingDownSword;
	private static BufferedImage[] playerWalkingLeftSword;
	private static BufferedImage[] playerWalkingRightSword;
	private static BufferedImage[] playerWalkingUpSword;
	private static BufferedImage[] playerLeftAttackSword;
	private static BufferedImage[] playerRightAttackSword;
	private static BufferedImage[] playerDownAttackSword;
	private static BufferedImage[] playerUpAttackSword;
	// Player Animations with Sword and Armour
	private static BufferedImage playerLeftStandingSwordAndArmour;
	private static BufferedImage playerUpStandingSwordAndArmour;
	private static BufferedImage playerRightStandingSwordAndArmour;
	private static BufferedImage playerDownStandingSwordAndArmour;
	private static BufferedImage[] playerWalkingDownSwordAndArmour;
	private static BufferedImage[] playerWalkingLeftSwordAndArmour;
	private static BufferedImage[] playerWalkingRightSwordAndArmour;
	private static BufferedImage[] playerWalkingUpSwordAndArmour;
	private static BufferedImage[] playerLeftAttackSwordAndArmour;
	private static BufferedImage[] playerRightAttackSwordAndArmour;
	private static BufferedImage[] playerDownAttackSwordAndArmour;
	private static BufferedImage[] playerUpAttackSwordAndArmour;

	public static BufferedImage[] getPlayerDownAttackArmour()
	{
		return playerDownAttackArmour;
	}

	public static void setPlayerDownAttackArmour( BufferedImage[] playerDownAttackArmour )
	{
		Assets.playerDownAttackArmour = playerDownAttackArmour;
	}

	// Craft Table Buttons
	private static BufferedImage[] createButton;
	private static BufferedImage[] useButton;
	// Menu
	private static BufferedImage background;
	private static BufferedImage[] startBtn;
	private static BufferedImage[] exitBtn;
	private static BufferedImage[] optionsBtn;

	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet( ImageLoader.loadImage( "/images/Assets2.png" ) );

		water = sheet.crop( CROP_WIDTH, 0, CROP_WIDTH, CROP_HEIGHT );
		dust = sheet.crop( CROP_WIDTH * 2, 0, CROP_WIDTH, CROP_HEIGHT );
		rock = sheet.crop( 0, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		tree = sheet.crop( CROP_WIDTH * 3, 0, CROP_WIDTH, CROP_HEIGHT );
		stone = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );
		craftTable = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 6, CROP_WIDTH, CROP_HEIGHT );
		sword = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 6, CROP_WIDTH, CROP_HEIGHT );
		armour = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 6, CROP_WIDTH, CROP_HEIGHT );
		sand = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 7, CROP_WIDTH, CROP_HEIGHT );

		craftTableBackGround = sheet.crop( CROP_WIDTH * 12, 0, CROP_WIDTH * 4, CROP_HEIGHT * 2 );
		inventory = sheet.crop( 0, CROP_HEIGHT * 5, CROP_WIDTH * 4, CROP_HEIGHT * 3 );

		playerWalkingDown = new BufferedImage[2];
		playerWalkingUp = new BufferedImage[2];
		playerWalkingRight = new BufferedImage[2];
		playerWalkingLeft = new BufferedImage[2];

		playerWalkingDownArmour = new BufferedImage[2];
		playerWalkingUpArmour = new BufferedImage[2];
		playerWalkingRightArmour = new BufferedImage[2];
		playerWalkingLeftArmour = new BufferedImage[2];

		playerLeftAttackArmour = new BufferedImage[2];
		playerRightAttackArmour = new BufferedImage[2];
		playerDownAttackArmour = new BufferedImage[2];
		playerUpAttackArmour = new BufferedImage[2];

		playerWalkingDownSword = new BufferedImage[2];
		playerWalkingUpSword = new BufferedImage[2];
		playerWalkingRightSword = new BufferedImage[2];
		playerWalkingLeftSword = new BufferedImage[2];

		playerLeftAttackSword = new BufferedImage[2];
		playerRightAttackSword = new BufferedImage[2];
		playerDownAttackSword = new BufferedImage[2];
		playerUpAttackSword = new BufferedImage[2];

		playerWalkingDownSwordAndArmour = new BufferedImage[2];
		playerWalkingUpSwordAndArmour = new BufferedImage[2];
		playerWalkingRightSwordAndArmour = new BufferedImage[2];
		playerWalkingLeftSwordAndArmour = new BufferedImage[2];

		playerLeftAttackSwordAndArmour = new BufferedImage[2];
		playerRightAttackSwordAndArmour = new BufferedImage[2];
		playerDownAttackSwordAndArmour = new BufferedImage[2];
		playerUpAttackSwordAndArmour = new BufferedImage[2];

		playerSwimmingDown = new BufferedImage[2];
		playerSwimmingUp = new BufferedImage[2];
		playerSwimmingRight = new BufferedImage[2];
		playerSwimmingLeft = new BufferedImage[2];

		playerLeftAttack = new BufferedImage[2];
		playerRightAttack = new BufferedImage[2];
		playerDownAttack = new BufferedImage[2];
		playerUpAttack = new BufferedImage[2];

		playerLeftAttackArmour = new BufferedImage[2];
		playerRightAttackArmour = new BufferedImage[2];
		playerDownAttackArmour = new BufferedImage[2];
		playerUpAttackArmour = new BufferedImage[2];

		// Menu
		startBtn = new BufferedImage[2];
		exitBtn = new BufferedImage[2];
		optionsBtn = new BufferedImage[2];

		// Craft Table
		createButton = new BufferedImage[2];
		useButton = new BufferedImage[2];

		background = sheet.crop( CROP_WIDTH * 7, 0, CROP_WIDTH * 5, CROP_HEIGHT * 4 );

		startBtn[0] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 4, CROP_WIDTH * 2, CROP_HEIGHT );
		startBtn[1] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 5, CROP_WIDTH * 2, CROP_HEIGHT );

		optionsBtn[0] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 4, CROP_WIDTH * 2, CROP_HEIGHT );
		optionsBtn[1] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 5, CROP_WIDTH * 2, CROP_HEIGHT );

		exitBtn[0] = sheet.crop( CROP_WIDTH * 8, CROP_HEIGHT * 4, CROP_WIDTH * 2, CROP_HEIGHT );
		exitBtn[1] = sheet.crop( CROP_WIDTH * 8, CROP_HEIGHT * 5, CROP_WIDTH * 2, CROP_HEIGHT );

		createButton[0] = sheet.crop( CROP_WIDTH * 12, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		createButton[1] = sheet.crop( CROP_WIDTH * 13, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		useButton[0] = sheet.crop( CROP_WIDTH * 12, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );
		useButton[1] = sheet.crop( CROP_WIDTH * 13, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		// Items
		stoneItem = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		woodItem = sheet.crop( CROP_WIDTH * 4, 0, CROP_WIDTH, CROP_HEIGHT );

		// Player
		playerRightStanding = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerLeftStanding = sheet.crop( 0, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );
		playerDownStanding = sheet.crop( 0, 0, CROP_WIDTH, CROP_HEIGHT );
		playerUpStanding = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerRightStandingArmour = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 13, CROP_WIDTH, CROP_HEIGHT );
		playerLeftStandingArmour = sheet.crop( 0, CROP_HEIGHT * 15, CROP_WIDTH, CROP_HEIGHT );
		playerDownStandingArmour = sheet.crop( 0, CROP_HEIGHT * 12, CROP_WIDTH, CROP_HEIGHT );
		playerUpStandingArmour = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 15, CROP_WIDTH, CROP_HEIGHT );

		playerRightStandingSword = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerLeftStandingSword = sheet.crop( 0, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerDownStandingSword = sheet.crop( 0, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );
		playerUpStandingSword = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );

		playerRightStandingSwordAndArmour = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerLeftStandingSwordAndArmour = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerDownStandingSwordAndArmour = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );
		playerUpStandingSwordAndArmour = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );

		playerLeftStandSwimming = sheet.crop( CROP_WIDTH * 6, 0, CROP_WIDTH, CROP_HEIGHT );
		playerRightStandSwimming = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerDownStandSwimming = sheet.crop( CROP_WIDTH * 5, 0, CROP_WIDTH, CROP_HEIGHT );
		playerUpStandSwimming = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		// Player walking Armour
		playerWalkingDownArmour[0] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 12, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingDownArmour[1] = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 12, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingUpArmour[0] = sheet.crop( 0, CROP_HEIGHT * 13, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingUpArmour[1] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 12, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingRightArmour[0] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 13, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingRightArmour[1] = sheet.crop( CROP_WIDTH * 1, CROP_HEIGHT * 13, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingLeftArmour[0] = sheet.crop( 0, CROP_HEIGHT * 15, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingLeftArmour[1] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 13, CROP_WIDTH, CROP_HEIGHT );

		// Player Attack Armour
		playerLeftAttackArmour[0] = sheet.crop( 0, CROP_HEIGHT * 15, CROP_WIDTH, CROP_HEIGHT );
		playerLeftAttackArmour[1] = sheet.crop( 0, CROP_HEIGHT * 14, CROP_WIDTH, CROP_HEIGHT );

		playerRightAttackArmour[0] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 13, CROP_WIDTH, CROP_HEIGHT );
		playerRightAttackArmour[1] = sheet.crop( CROP_WIDTH * 1, CROP_HEIGHT * 14, CROP_WIDTH, CROP_HEIGHT );

		playerDownAttackArmour[0] = sheet.crop( 0, CROP_HEIGHT * 12, CROP_WIDTH, CROP_HEIGHT );
		playerDownAttackArmour[1] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 14, CROP_WIDTH, CROP_HEIGHT );

		playerUpAttackArmour[0] = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 15, CROP_WIDTH, CROP_HEIGHT );
		playerUpAttackArmour[1] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 14, CROP_WIDTH, CROP_HEIGHT );

		// Player walking Sword
		playerWalkingDownSword[0] = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingDownSword[1] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingUpSword[0] = sheet.crop( 0, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingUpSword[1] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingRightSword[0] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingRightSword[1] = sheet.crop( CROP_WIDTH * 1, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingLeftSword[0] = sheet.crop( 0, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingLeftSword[1] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );

		// Player Attack Sword
		playerLeftAttackSword[0] = sheet.crop( 0, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerLeftAttackSword[1] = sheet.crop( 0, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		playerRightAttackSword[0] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerRightAttackSword[1] = sheet.crop( CROP_WIDTH * 1, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		playerDownAttackSword[0] = sheet.crop( 0, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );
		playerDownAttackSword[1] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		playerUpAttackSword[0] = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerUpAttackSword[1] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		// Player walking Sword And Armour
		playerWalkingDownSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingDownSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingUpSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingUpSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 7, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingRightSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingRightSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingLeftSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingLeftSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 7, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );

		// Player Attack Sword And Armour
		playerLeftAttackSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerLeftAttackSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		playerRightAttackSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 9, CROP_WIDTH, CROP_HEIGHT );
		playerRightAttackSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		playerDownAttackSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 8, CROP_WIDTH, CROP_HEIGHT );
		playerDownAttackSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		playerUpAttackSwordAndArmour[0] = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 11, CROP_WIDTH, CROP_HEIGHT );
		playerUpAttackSwordAndArmour[1] = sheet.crop( CROP_WIDTH * 7, CROP_HEIGHT * 10, CROP_WIDTH, CROP_HEIGHT );

		// Player walking
		playerWalkingDown[0] = sheet.crop( CROP_WIDTH, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingDown[1] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingUp[0] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingUp[1] = sheet.crop( 0, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingRight[0] = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingRight[1] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerWalkingLeft[0] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerWalkingLeft[1] = sheet.crop( 0, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		// Player Swimming
		playerSwimmingDown[0] = sheet.crop( CROP_WIDTH * 5, 0, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingDown[1] = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );

		playerSwimmingUp[0] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingUp[1] = sheet.crop( CROP_WIDTH * 4, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		playerSwimmingRight[0] = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingRight[1] = sheet.crop( CROP_WIDTH * 5, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		playerSwimmingLeft[0] = sheet.crop( CROP_WIDTH * 6, 0, CROP_WIDTH, CROP_HEIGHT );
		playerSwimmingLeft[1] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT, CROP_WIDTH, CROP_HEIGHT );

		// Player Attack
		playerLeftAttack[0] = sheet.crop( 0, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerLeftAttack[1] = sheet.crop( 0, CROP_HEIGHT * 3, CROP_WIDTH, CROP_HEIGHT );

		playerRightAttack[0] = sheet.crop( CROP_WIDTH, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerRightAttack[1] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

		playerDownAttack[0] = sheet.crop( CROP_WIDTH * 2, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerDownAttack[1] = sheet.crop( 0, 0, CROP_WIDTH, CROP_HEIGHT );

		playerUpAttack[0] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 4, CROP_WIDTH, CROP_HEIGHT );
		playerUpAttack[1] = sheet.crop( CROP_WIDTH * 6, CROP_HEIGHT * 2, CROP_WIDTH, CROP_HEIGHT );

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

	public static BufferedImage getCraftTableBackGround()
	{
		return craftTableBackGround;
	}

	public static BufferedImage getStoneItem()
	{
		return stoneItem;
	}

	public static BufferedImage getSword()
	{
		return sword;
	}

	public static BufferedImage getArmour()
	{
		return armour;
	}

	public static BufferedImage[] getCreateButton()
	{
		return createButton;
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

	public static BufferedImage getPlayerLeftStandingSword()
	{
		return playerLeftStandingSword;
	}

	public static void setPlayerLeftStandingSword( BufferedImage playerLeftStandingSword )
	{
		Assets.playerLeftStandingSword = playerLeftStandingSword;
	}

	public static BufferedImage getPlayerUpStandingSword()
	{
		return playerUpStandingSword;
	}

	public static void setPlayerUpStandingSword( BufferedImage playerUpStandingSword )
	{
		Assets.playerUpStandingSword = playerUpStandingSword;
	}

	public static BufferedImage getPlayerLeftStandingSwordAndArmour()
	{
		return playerLeftStandingSwordAndArmour;
	}

	public static void setPlayerLeftStandingSwordAndArmour( BufferedImage playerLeftStandingSwordAndArmour )
	{
		Assets.playerLeftStandingSwordAndArmour = playerLeftStandingSwordAndArmour;
	}

	public static BufferedImage getPlayerUpStandingSwordAndArmour()
	{
		return playerUpStandingSwordAndArmour;
	}

	public static void setPlayerUpStandingSwordAndArmour( BufferedImage playerUpStandingSwordAndArmour )
	{
		Assets.playerUpStandingSwordAndArmour = playerUpStandingSwordAndArmour;
	}

	public static BufferedImage getPlayerRightStandingSwordAndArmour()
	{
		return playerRightStandingSwordAndArmour;
	}

	public static void setPlayerRightStandingSwordAndArmour( BufferedImage playerRightStandingSwordAndArmour )
	{
		Assets.playerRightStandingSwordAndArmour = playerRightStandingSwordAndArmour;
	}

	public static BufferedImage getPlayerDownStandingSwordAndArmour()
	{
		return playerDownStandingSwordAndArmour;
	}

	public static void setPlayerDownStandingSwordAndArmour( BufferedImage playerDownStandingSwordAndArmour )
	{
		Assets.playerDownStandingSwordAndArmour = playerDownStandingSwordAndArmour;
	}

	public static BufferedImage getSand()
	{
		return sand;
	}

	public static void setSand( BufferedImage sand )
	{
		Assets.sand = sand;
	}

	public static BufferedImage[] getPlayerWalkingDownSwordAndArmour()
	{
		return playerWalkingDownSwordAndArmour;
	}

	public static void setPlayerWalkingDownSwordAndArmour( BufferedImage[] playerWalkingDownSwordAndArmour )
	{
		Assets.playerWalkingDownSwordAndArmour = playerWalkingDownSwordAndArmour;
	}

	public static BufferedImage[] getPlayerWalkingLeftSwordAndArmour()
	{
		return playerWalkingLeftSwordAndArmour;
	}

	public static void setPlayerWalkingLeftSwordAndArmour( BufferedImage[] playerWalkingLeftSwordAndArmour )
	{
		Assets.playerWalkingLeftSwordAndArmour = playerWalkingLeftSwordAndArmour;
	}

	public static BufferedImage[] getPlayerWalkingRightSwordAndArmour()
	{
		return playerWalkingRightSwordAndArmour;
	}

	public static void setPlayerWalkingRightSwordAndArmour( BufferedImage[] playerWalkingRightSwordAndArmour )
	{
		Assets.playerWalkingRightSwordAndArmour = playerWalkingRightSwordAndArmour;
	}

	public static BufferedImage[] getPlayerWalkingUpSwordAndArmour()
	{
		return playerWalkingUpSwordAndArmour;
	}

	public static void setPlayerWalkingUpSwordAndArmour( BufferedImage[] playerWalkingUpSwordAndArmour )
	{
		Assets.playerWalkingUpSwordAndArmour = playerWalkingUpSwordAndArmour;
	}

	public static BufferedImage[] getPlayerLeftAttackSwordAndArmour()
	{
		return playerLeftAttackSwordAndArmour;
	}

	public static void setPlayerLeftAttackSwordAndArmour( BufferedImage[] playerLeftAttackSwordAndArmour )
	{
		Assets.playerLeftAttackSwordAndArmour = playerLeftAttackSwordAndArmour;
	}

	public static BufferedImage[] getPlayerRightAttackSwordAndArmour()
	{
		return playerRightAttackSwordAndArmour;
	}

	public static void setPlayerRightAttackSwordAndArmour( BufferedImage[] playerRightAttackSwordAndArmour )
	{
		Assets.playerRightAttackSwordAndArmour = playerRightAttackSwordAndArmour;
	}

	public static BufferedImage[] getPlayerDownAttackSwordAndArmour()
	{
		return playerDownAttackSwordAndArmour;
	}

	public static void setPlayerDownAttackSwordAndArmour( BufferedImage[] playerDownAttackSwordAndArmour )
	{
		Assets.playerDownAttackSwordAndArmour = playerDownAttackSwordAndArmour;
	}

	public static BufferedImage[] getPlayerUpAttackSwordAndArmour()
	{
		return playerUpAttackSwordAndArmour;
	}

	public static void setPlayerUpAttackSwordAndArmour( BufferedImage[] playerUpAttackSwordAndArmour )
	{
		Assets.playerUpAttackSwordAndArmour = playerUpAttackSwordAndArmour;
	}

	public static BufferedImage getPlayerRightStandingSword()
	{
		return playerRightStandingSword;
	}

	public static void setPlayerRightStandingSword( BufferedImage playerRightStandingSword )
	{
		Assets.playerRightStandingSword = playerRightStandingSword;
	}

	public static BufferedImage getPlayerDownStandingSword()
	{
		return playerDownStandingSword;
	}

	public static void setPlayerDownStandingSword( BufferedImage playerDownStandingSword )
	{
		Assets.playerDownStandingSword = playerDownStandingSword;
	}

	public static BufferedImage[] getPlayerWalkingDownSword()
	{
		return playerWalkingDownSword;
	}

	public static void setPlayerWalkingDownSword( BufferedImage[] playerWalkingDownSword )
	{
		Assets.playerWalkingDownSword = playerWalkingDownSword;
	}

	public static BufferedImage[] getPlayerWalkingLeftSword()
	{
		return playerWalkingLeftSword;
	}

	public static void setPlayerWalkingLeftSword( BufferedImage[] playerWalkingLeftSword )
	{
		Assets.playerWalkingLeftSword = playerWalkingLeftSword;
	}

	public static BufferedImage[] getPlayerWalkingRightSword()
	{
		return playerWalkingRightSword;
	}

	public static void setPlayerWalkingRightSword( BufferedImage[] playerWalkingRightSword )
	{
		Assets.playerWalkingRightSword = playerWalkingRightSword;
	}

	public static BufferedImage[] getPlayerWalkingUpSword()
	{
		return playerWalkingUpSword;
	}

	public static void setPlayerWalkingUpSword( BufferedImage[] playerWalkingUpSword )
	{
		Assets.playerWalkingUpSword = playerWalkingUpSword;
	}

	public static BufferedImage[] getPlayerLeftAttackSword()
	{
		return playerLeftAttackSword;
	}

	public static void setPlayerLeftAttackSword( BufferedImage[] playerLeftAttackSword )
	{
		Assets.playerLeftAttackSword = playerLeftAttackSword;
	}

	public static BufferedImage[] getPlayerRightAttackSword()
	{
		return playerRightAttackSword;
	}

	public static void setPlayerRightAttackSword( BufferedImage[] playerRightAttackSword )
	{
		Assets.playerRightAttackSword = playerRightAttackSword;
	}

	public static BufferedImage[] getPlayerDownAttackSword()
	{
		return playerDownAttackSword;
	}

	public static void setPlayerDownAttackSword( BufferedImage[] playerDownAttackSword )
	{
		Assets.playerDownAttackSword = playerDownAttackSword;
	}

	public static BufferedImage[] getPlayerUpAttackSword()
	{
		return playerUpAttackSword;
	}

	public static void setPlayerUpAttackSword( BufferedImage[] playerUpAttackSword )
	{
		Assets.playerUpAttackSword = playerUpAttackSword;
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

	public static BufferedImage[] getUseButton()
	{
		return useButton;
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

	public static BufferedImage getPlayerLeftStandingArmour()
	{
		return playerLeftStandingArmour;
	}

	public static void setPlayerLeftStandingArmour( BufferedImage playerLeftStandingArmour )
	{
		Assets.playerLeftStandingArmour = playerLeftStandingArmour;
	}

	public static BufferedImage getPlayerUpStandingArmour()
	{
		return playerUpStandingArmour;
	}

	public static void setPlayerUpStandingArmour( BufferedImage playerUpStandingArmour )
	{
		Assets.playerUpStandingArmour = playerUpStandingArmour;
	}

	public static BufferedImage getPlayerRightStandingArmour()
	{
		return playerRightStandingArmour;
	}

	public static void setPlayerRightStandingArmour( BufferedImage playerRightStandingArmour )
	{
		Assets.playerRightStandingArmour = playerRightStandingArmour;
	}

	public static BufferedImage getPlayerDownStandingArmour()
	{
		return playerDownStandingArmour;
	}

	public static void setPlayerDownStandingArmour( BufferedImage playerDownStandingArmour )
	{
		Assets.playerDownStandingArmour = playerDownStandingArmour;
	}

	public static BufferedImage[] getPlayerWalkingDownArmour()
	{
		return playerWalkingDownArmour;
	}

	public static void setPlayerWalkingDownArmour( BufferedImage[] playerWalkingDownArmour )
	{
		Assets.playerWalkingDownArmour = playerWalkingDownArmour;
	}

	public static BufferedImage[] getPlayerWalkingLeftArmour()
	{
		return playerWalkingLeftArmour;
	}

	public static void setPlayerWalkingLeftArmour( BufferedImage[] playerWalkingLeftArmour )
	{
		Assets.playerWalkingLeftArmour = playerWalkingLeftArmour;
	}

	public static BufferedImage[] getPlayerWalkingRightArmour()
	{
		return playerWalkingRightArmour;
	}

	public static void setPlayerWalkingRightArmour( BufferedImage[] playerWalkingRightArmour )
	{
		Assets.playerWalkingRightArmour = playerWalkingRightArmour;
	}

	public static BufferedImage[] getPlayerWalkingUpArmour()
	{
		return playerWalkingUpArmour;
	}

	public static void setPlayerWalkingUpArmour( BufferedImage[] playerWalkingUpArmour )
	{
		Assets.playerWalkingUpArmour = playerWalkingUpArmour;
	}

	public static BufferedImage[] getPlayerLeftAttackArmour()
	{
		return playerLeftAttackArmour;
	}

	public static void setPlayerLeftAttackArmour( BufferedImage[] playerLeftAttackArmour )
	{
		Assets.playerLeftAttackArmour = playerLeftAttackArmour;
	}

	public static BufferedImage[] getPlayerRightAttackArmour()
	{
		return playerRightAttackArmour;
	}

	public static void setPlayerRightAttackArmour( BufferedImage[] playerRightAttackArmour )
	{
		Assets.playerRightAttackArmour = playerRightAttackArmour;
	}

	public static BufferedImage[] getPlayerUpAttackArmour()
	{
		return playerUpAttackArmour;
	}

	public static void setPlayerUpAttackArmour( BufferedImage[] playerUpAttackArmour )
	{
		Assets.playerUpAttackArmour = playerUpAttackArmour;
	}

	public static int getCropWidth()
	{
		return CROP_WIDTH;
	}

	public static int getCropHeight()
	{
		return CROP_HEIGHT;
	}

	public static void setCraftTableBackGround( BufferedImage craftTableBackGround )
	{
		Assets.craftTableBackGround = craftTableBackGround;
	}

	public static void setStoneItem( BufferedImage stoneItem )
	{
		Assets.stoneItem = stoneItem;
	}

	public static void setCraftTable( BufferedImage craftTable )
	{
		Assets.craftTable = craftTable;
	}

	public static void setSword( BufferedImage sword )
	{
		Assets.sword = sword;
	}

	public static void setArmour( BufferedImage armour )
	{
		Assets.armour = armour;
	}

	public static void setCreateButton( BufferedImage[] createButton )
	{
		Assets.createButton = createButton;
	}

	public static void setUseButton( BufferedImage[] useButton )
	{
		Assets.useButton = useButton;
	}

	public static void setBackground( BufferedImage background )
	{
		Assets.background = background;
	}

	public static void setStartBtn( BufferedImage[] startBtn )
	{
		Assets.startBtn = startBtn;
	}

	public static void setExitBtn( BufferedImage[] exitBtn )
	{
		Assets.exitBtn = exitBtn;
	}

	public static void setOptionsBtn( BufferedImage[] optionsBtn )
	{
		Assets.optionsBtn = optionsBtn;
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

	public static BufferedImage getCraftTable()
	{
		return craftTable;
	}

}
