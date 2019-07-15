package game.entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.nio.channels.GatheringByteChannel;

import game.Handler;
import game.entity.Entity;
import game.entity.HurtAble;
import game.entity.HurtBehavior;
import game.entity.MoveAble;
import game.entity.MoveBehaviour;
import game.gfx.Animation;
import game.gfx.Assets;
import game.inputs.AvailableKey;
import game.inventory.Inventory;
import game.tiles.TileBase;
import game.tiles.WaterTile;

public class Player extends Entity implements MoveAble, HurtAble {

	private final int DEFAULT_SPEED = 5;
	private final int DEFAULT_POWER = 2;
	private final int DEFAULT_HIT_SPEED = 300;
	private float speed;
	private int power;
	// Behaviors
	private MoveBehaviour moveBehaviour;
	private HurtBehavior hurtBehavior;
	private Inventory inventory;
	// Animations
	private BufferedImage playerStanding;

	private Animation playerLeftAttack;
	private Animation playerRightAttack;
	private Animation playerUpAttack;
	private Animation playerDowntAttack;

	private Animation playerUpWalk;
	private Animation playerDownWalk;
	private Animation playerLeftWalk;
	private Animation playerRightWalk;
	private Animation playerUpSwim;
	private Animation playerDownSwim;
	private Animation playerLeftSwim;
	private Animation playerRightSwim;

	BufferedImage oldImg = playerStanding;

	public Player( float x, float y, int height, int width, Handler handler ) {
		super ( x, y, height, width, handler );
		speed = DEFAULT_SPEED;
		power = DEFAULT_POWER;
		moveBehaviour = new MoveBehaviour ( this, speed );
		hurtBehavior = new HurtBehavior ( this, power, 20, 300 );
		inventory = new Inventory ( handler );

		bounds = new Rectangle ();

		bounds.x = 18;
		bounds.y = 16;
		bounds.width = 28;
		bounds.height = 48;
		// Player Animations
		playerStanding = Assets.getPlayerDownStanding ();

		playerUpWalk = new Animation ( 300, Assets.playerWalkingUp );
		playerDownWalk = new Animation ( 300, Assets.getPlayerWalkingDown () );
		playerLeftWalk = new Animation ( 300, Assets.getPlayerWalkingLeft () );
		playerRightWalk = new Animation ( 300, Assets.getPlayerWalkingRight () );

		playerUpSwim = new Animation ( 300, Assets.getPlayerSwimmingUp () );
		playerDownSwim = new Animation ( 300, Assets.getPlayerSwimmingDown () );
		playerLeftSwim = new Animation ( 300, Assets.getPlayerSwimmingLeft () );
		playerRightSwim = new Animation ( 300, Assets.getPlayerSwimmingRight () );

		playerLeftAttack = new Animation ( 300, Assets.getPlayerLeftAttack () );
		playerRightAttack = new Animation ( 300, Assets.getPlayerRightAttack () );
		playerUpAttack = new Animation ( 300, Assets.getPlayerUpAttack () );
		playerDowntAttack = new Animation ( 300, Assets.getPlayerDownAttack () );
	}

	@Override
	public void attack()
	{

		int currentTileX = (int) getX () + (getWidth () / 2);
		int currentTileY = (int) getY () + (getHeight () / 2);

		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.hit ) && !(handler.getWorld ()
		        .getTile ( currentTileX / TileBase.WIDTH, currentTileY / TileBase.HEIGHT ) instanceof WaterTile) )
		{
			if ( getFaceDirection () == 0 )
				playerStanding = playerUpAttack.getCurrentFrame ();
			if ( getFaceDirection () == 1 )
				playerStanding = playerRightAttack.getCurrentFrame ();
			if ( getFaceDirection () == 2 )
				playerStanding = playerDowntAttack.getCurrentFrame ();
			if ( getFaceDirection () == 3 )
				playerStanding = playerLeftAttack.getCurrentFrame ();
		}
		hurtBehavior.attack ( getFaceDirection () );
	}

	@Override
	public int getFaceDirection()
	{
		return moveBehaviour.getEntityFace ();
	}

	@Override
	public void move( float speed )
	{
		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.right ) )
		{
			moveBehaviour.moveRight ();
		}

		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.left ) )
		{
			moveBehaviour.moveLeft ();
		}

		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.up ) )
		{
			moveBehaviour.moveUp ();
		}

		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.down ) )
		{
			moveBehaviour.moveDown ();
		}
	}

	private BufferedImage getCurrentAnimation()
	{

		if ( handler.getWorld ().getTile ( (int) (x + bounds.x + bounds.width) / TileBase.WIDTH,
		        (int) (y + bounds.height + bounds.y) / TileBase.HEIGHT ) instanceof WaterTile )
		{
			if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.right ) )
			{
				playerStanding = Assets.getPlayerRightStandSwimming ();
				return playerRightSwim.getCurrentFrame ();
			}
			else if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.left ) )
			{
				playerStanding = Assets.getPlayerLeftStandSwimming ();
				return playerLeftSwim.getCurrentFrame ();
			}
			else if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.up ) )
			{
				playerStanding = Assets.getPlayerUpStandSwimming ();
				return playerUpSwim.getCurrentFrame ();
			}
			else if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.down ) )
			{
				playerStanding = Assets.getPlayerDownStandSwimming ();
				return playerDownSwim.getCurrentFrame ();
			}
			else
			{
				return playerStanding;
			}
		}
		else
		{
			if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.right ) )
			{
				playerStanding = Assets.getPlayerRightStanding ();
				return playerRightWalk.getCurrentFrame ();
			}
			else if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.left ) )
			{
				playerStanding = Assets.getPlayerLeftStanding ();
				return playerLeftWalk.getCurrentFrame ();
			}
			else if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.up ) )
			{
				playerStanding = Assets.getPlayerUpStanding ();
				return playerUpWalk.getCurrentFrame ();
			}
			else if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.down ) )
			{
				playerStanding = Assets.getPlayerDownStanding ();
				return playerDownWalk.getCurrentFrame ();
			}
			else
			{
				return playerStanding;
			}
		}
	}

	@Override
	public void tick()
	{

		move ( speed );
		attack ();
		handler.getGameCamera ().centerOnEntity ( this );
		inventory.tick ();
		playerDownSwim.tick ();
		playerUpSwim.tick ();
		playerLeftSwim.tick ();
		playerRightSwim.tick ();
		playerDownWalk.tick ();
		playerUpWalk.tick ();
		playerLeftWalk.tick ();
		playerRightWalk.tick ();
		playerLeftAttack.tick ();
		playerRightAttack.tick ();
		playerUpAttack.tick ();
		playerDowntAttack.tick ();
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( getCurrentAnimation (), (int) (x - handler.getGameCamera ().getxOffset ()),
		        (int) (y - handler.getGameCamera ().getyOffset ()), width, height, null );
	}

	public Rectangle getBounds()
	{
		return bounds;
	}

	@Override
	public Handler getHandler()
	{
		return handler;
	}

	@Override
	public float getSpeed()
	{
		return speed;
	}

	public BufferedImage getPlayerStanding()
	{
		return playerStanding;
	}

	public void setPlayerStanding( BufferedImage playerStanding )
	{
		this.playerStanding = playerStanding;
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public void setInventory( Inventory inventory )
	{
		this.inventory = inventory;
	}

}
