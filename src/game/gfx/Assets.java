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
	// Player Animations with armour
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
		playerUpAttackArmour[1] = sheet.crop( CROP_WIDTH * 3, CROP_HEIGHT * 13, CROP_WIDTH, CROP_HEIGHT );

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
