package game.entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.entity.Entity;
import game.entity.MoveAble;
import game.entity.MoveBehaviour;
import game.gfx.Animation;
import game.gfx.Assets;
import game.inputs.AvailableKey;
import game.tiles.TileBase;
import game.tiles.WaterTile;

public class Player extends Entity implements MoveAble {

	private final int DEFAULT_SPEED = 5;
	private float speed;
	// Behaviors
	private MoveBehaviour moveBehaviour;
	private BufferedImage playerStanding;
	// Animations
	private Animation playerUpWalk;
	private Animation playerDownWalk;
	private Animation playerLeftWalk;
	private Animation playerRightWalk;
	private Animation playerUpSwim;
	private Animation playerDownSwim;
	private Animation playerLeftSwim;
	private Animation playerRightSwim;

	public BufferedImage[] a;

	public Player( float x, float y, int height, int width, Handler handler ) {
		super ( x, y, height, width, handler );
		speed = DEFAULT_SPEED;
		moveBehaviour = new MoveBehaviour ( this, speed );
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

	}

	@Override
	public void move( float speed )
	{
		System.out.println ( moveBehaviour.getEntityFace () );

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
		handler.getGameCamera ().centerOnEntity ( this );
		playerDownSwim.tick ();
		playerUpSwim.tick ();
		playerLeftSwim.tick ();
		playerRightSwim.tick ();
		playerDownWalk.tick ();
		playerUpWalk.tick ();
		playerLeftWalk.tick ();
		playerRightWalk.tick ();
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
}
