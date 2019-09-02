package game.entity.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.Animation;
import game.gfx.Assets;
import game.tiles.Tile;

public class PlayerSkinManager
{
	private Handler handler;
	private Tile currentTile;
	private int hitSpeed;
	private boolean playerHandStatus = false;
	private boolean playerArmourStatus = true;

	private Animation currentPlayerLeftAttack;
	private Animation currentPlayerRightAttack;
	private Animation currentPlayerUpAttack;
	private Animation currentPlayerDowntAttack;

	private Animation currentPlayerUpWalk;
	private Animation currentPlayerDownWalk;
	private Animation currentPlayerLeftWalk;
	private Animation currentPlayerRightWalk;

	private BufferedImage currentPlayerFaceUp;
	private BufferedImage currentPlayerFaceRight;
	private BufferedImage currentPlayerFaceDown;
	private BufferedImage currentPlayerFaceLeft;

	// Naked
	private Animation playerLeftAttackNaked;
	private Animation playerRightAttackNaked;
	private Animation playerUpAttackNaked;
	private Animation playerDowntAttackNaked;

	private Animation playerUpWalkNaked;
	private Animation playerDownWalkNaked;
	private Animation playerLeftWalkNaked;
	private Animation playerRightWalkNaked;

	// With Armour
	private Animation playerLeftAttackArmour;
	private Animation playerRightAttackArmour;
	private Animation playerUpAttackArmour;
	private Animation playerDowntAttackArmour;

	private Animation playerUpWalkArmour;
	private Animation playerDownWalkArmour;
	private Animation playerLeftWalkArmour;
	private Animation playerRightWalkArmour;

	public PlayerSkinManager( Handler handler, int hitSpeed )
	{
		this.handler = handler;
		this.hitSpeed = hitSpeed;

		// At beginning
		currentPlayerUpWalk = new Animation( 300, Assets.getPlayerWalkingUp() );
		currentPlayerDownWalk = new Animation( 300, Assets.getPlayerWalkingDown() );
		currentPlayerLeftWalk = new Animation( 300, Assets.getPlayerWalkingLeft() );
		currentPlayerRightWalk = new Animation( 300, Assets.getPlayerWalkingRight() );

		currentPlayerLeftAttack = new Animation( hitSpeed, Assets.getPlayerLeftAttack() );
		currentPlayerRightAttack = new Animation( hitSpeed, Assets.getPlayerRightAttack() );
		currentPlayerUpAttack = new Animation( hitSpeed, Assets.getPlayerUpAttack() );
		currentPlayerDowntAttack = new Animation( hitSpeed, Assets.getPlayerDownAttack() );

		currentPlayerFaceUp = Assets.getPlayerUpStanding();
		currentPlayerFaceRight = Assets.getPlayerRightStanding();
		currentPlayerFaceDown = Assets.getPlayerDownStanding();
		currentPlayerFaceLeft = Assets.getPlayerLeftStanding();

		// Naked
		playerUpWalkNaked = new Animation( 300, Assets.getPlayerWalkingUp() );
		playerDownWalkNaked = new Animation( 300, Assets.getPlayerWalkingDown() );
		playerLeftWalkNaked = new Animation( 300, Assets.getPlayerWalkingLeft() );
		playerRightWalkNaked = new Animation( 300, Assets.getPlayerWalkingRight() );

		playerLeftAttackNaked = new Animation( hitSpeed, Assets.getPlayerLeftAttack() );
		playerRightAttackNaked = new Animation( hitSpeed, Assets.getPlayerRightAttack() );
		playerUpAttackNaked = new Animation( hitSpeed, Assets.getPlayerUpAttack() );
		playerDowntAttackNaked = new Animation( hitSpeed, Assets.getPlayerDownAttack() );

		// With Armour
		playerUpWalkArmour = new Animation( 300, Assets.getPlayerWalkingUpArmour() );
		playerDownWalkArmour = new Animation( 300, Assets.getPlayerWalkingDownArmour() );
		playerLeftWalkArmour = new Animation( 300, Assets.getPlayerWalkingLeftArmour() );
		playerRightWalkArmour = new Animation( 300, Assets.getPlayerWalkingRightArmour() );

		playerLeftAttackArmour = new Animation( hitSpeed, Assets.getPlayerLeftAttackArmour() );
		playerRightAttackArmour = new Animation( hitSpeed, Assets.getPlayerRightAttackArmour() );
		playerUpAttackArmour = new Animation( hitSpeed, Assets.getPlayerUpAttackArmour() );
		playerDowntAttackArmour = new Animation( hitSpeed, Assets.getPlayerDownAttackArmour() );

	}

	public void tick()
	{
		currentPlayerUpWalk.tick();
		currentPlayerRightWalk.tick();
		currentPlayerDownWalk.tick();
		currentPlayerLeftWalk.tick();

		currentPlayerUpAttack.tick();
		currentPlayerRightAttack.tick();
		currentPlayerDowntAttack.tick();
		currentPlayerLeftAttack.tick();
	}

	public void setPlayerEquipmentStatus()
	{
		// Naked
		if ( !playerArmourStatus && !playerHandStatus )
		{
			currentPlayerUpWalk = playerUpWalkNaked;
			currentPlayerRightWalk = playerRightWalkNaked;
			currentPlayerDownWalk = playerDownWalkNaked;
			currentPlayerLeftWalk = playerLeftWalkNaked;

			currentPlayerUpAttack = playerUpAttackNaked;
			currentPlayerRightAttack = playerRightAttackNaked;
			currentPlayerDowntAttack = playerDowntAttackNaked;
			currentPlayerLeftAttack = playerLeftAttackNaked;

			currentPlayerFaceUp = Assets.getPlayerUpStanding();
			currentPlayerFaceRight = Assets.getPlayerRightStanding();
			currentPlayerFaceDown = Assets.getPlayerDownStanding();
			currentPlayerFaceLeft = Assets.getPlayerLeftStanding();

		}
		// with Armour
		if ( playerArmourStatus && !playerHandStatus )
		{
			currentPlayerUpWalk = playerUpWalkArmour;
			currentPlayerRightWalk = playerRightWalkArmour;
			currentPlayerDownWalk = playerDownWalkArmour;
			currentPlayerLeftWalk = playerLeftWalkArmour;

			currentPlayerUpAttack = playerUpAttackArmour;
			currentPlayerRightAttack = playerRightAttackArmour;
			currentPlayerDowntAttack = playerDowntAttackArmour;
			currentPlayerLeftAttack = playerLeftAttackArmour;

			currentPlayerFaceUp = Assets.getPlayerUpStandingArmour();
			currentPlayerFaceRight = Assets.getPlayerRightStandingArmour();
			currentPlayerFaceDown = Assets.getPlayerDownStandingArmour();
			currentPlayerFaceLeft = Assets.getPlayerLeftStandingArmour();
		}
	}

	public Animation getCurrentPlayerLeftAttack()
	{
		return currentPlayerLeftAttack;
	}

	public Animation getCurrentPlayerRightAttack()
	{
		return currentPlayerRightAttack;
	}

	public Animation getCurrentPlayerUpAttack()
	{
		return currentPlayerUpAttack;
	}

	public Animation getCurrentPlayerDowntAttack()
	{
		return currentPlayerDowntAttack;
	}

	public Animation getCurrentPlayerUpWalk()
	{
		return currentPlayerUpWalk;
	}

	public Animation getCurrentPlayerDownWalk()
	{
		return currentPlayerDownWalk;
	}

	public Animation getCurrentPlayerLeftWalk()
	{
		return currentPlayerLeftWalk;
	}

	public Animation getCurrentPlayerRightWalk()
	{
		return currentPlayerRightWalk;
	}

	public boolean isPlayerHandStatus()
	{
		return playerHandStatus;
	}

	public void setPlayerHandStatus( boolean playerHandStatus )
	{
		this.playerHandStatus = playerHandStatus;
	}

	public boolean isPlayerArmourStatus()
	{
		return playerArmourStatus;
	}

	public BufferedImage getCurrentPlayerFaceUp()
	{
		return currentPlayerFaceUp;
	}

	public void setCurrentPlayerFaceUp( BufferedImage currentPlayerFaceUp )
	{
		this.currentPlayerFaceUp = currentPlayerFaceUp;
	}

	public BufferedImage getCurrentPlayerFaceRight()
	{
		return currentPlayerFaceRight;
	}

	public void setCurrentPlayerFaceRight( BufferedImage currentPlayerFaceRight )
	{
		this.currentPlayerFaceRight = currentPlayerFaceRight;
	}

	public BufferedImage getCurrentPlayerFaceDown()
	{
		return currentPlayerFaceDown;
	}

	public void setCurrentPlayerFaceDown( BufferedImage currentPlayerFaceDown )
	{
		this.currentPlayerFaceDown = currentPlayerFaceDown;
	}

	public BufferedImage getCurrentPlayerFaceLeft()
	{
		return currentPlayerFaceLeft;
	}

	public void setCurrentPlayerFaceLeft( BufferedImage currentPlayerFaceLeft )
	{
		this.currentPlayerFaceLeft = currentPlayerFaceLeft;
	}

	public void setCurrentPlayerLeftAttack( Animation currentPlayerLeftAttack )
	{
		this.currentPlayerLeftAttack = currentPlayerLeftAttack;
	}

	public void setCurrentPlayerRightAttack( Animation currentPlayerRightAttack )
	{
		this.currentPlayerRightAttack = currentPlayerRightAttack;
	}

	public void setCurrentPlayerUpAttack( Animation currentPlayerUpAttack )
	{
		this.currentPlayerUpAttack = currentPlayerUpAttack;
	}

	public void setCurrentPlayerDowntAttack( Animation currentPlayerDowntAttack )
	{
		this.currentPlayerDowntAttack = currentPlayerDowntAttack;
	}

	public void setCurrentPlayerUpWalk( Animation currentPlayerUpWalk )
	{
		this.currentPlayerUpWalk = currentPlayerUpWalk;
	}

	public void setCurrentPlayerDownWalk( Animation currentPlayerDownWalk )
	{
		this.currentPlayerDownWalk = currentPlayerDownWalk;
	}

	public void setCurrentPlayerLeftWalk( Animation currentPlayerLeftWalk )
	{
		this.currentPlayerLeftWalk = currentPlayerLeftWalk;
	}

	public void setCurrentPlayerRightWalk( Animation currentPlayerRightWalk )
	{
		this.currentPlayerRightWalk = currentPlayerRightWalk;
	}

	public void setPlayerArmourStatus( boolean playerArmourStatus )
	{
		this.playerArmourStatus = playerArmourStatus;
	}

}
