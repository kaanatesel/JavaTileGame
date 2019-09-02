package game.entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
import game.item.Item;
import game.tiles.TileBase;
import game.tiles.WaterTile;

public class Player extends Entity implements MoveAble , HurtAble
{

	private final int DEFAULT_SPEED = 5;
	private final int DEFAULT_POWER = 2;
	private final int DEFAULT_HIT_SPEED = 300;
	private float speed;
	private int power;
	// Behaviors
	private MoveBehaviour moveBehaviour;
	private HurtBehavior hurtBehavior;
	private Inventory inventory;
	private PlayerSkinManager playerSkinManager;
	// Animations
	private BufferedImage playerStanding;

	BufferedImage oldImg = playerStanding;

	private Animation playerUpSwim;
	private Animation playerDownSwim;
	private Animation playerLeftSwim;
	private Animation playerRightSwim;

	public Player( float x, float y, int height, int width, Handler handler )
	{
		super( x, y, height, width, handler );
		speed = DEFAULT_SPEED;
		power = DEFAULT_POWER;
		moveBehaviour = new MoveBehaviour( this, speed );
		hurtBehavior = new HurtBehavior( this, power, 20, 300 );
		inventory = new Inventory( handler );
		playerSkinManager = new PlayerSkinManager( handler, DEFAULT_HIT_SPEED );

		bounds = new Rectangle();

		bounds.x = 18;
		bounds.y = 16;
		bounds.width = 28;
		bounds.height = 48;
		// Player Animations
		playerStanding = Assets.getPlayerDownStanding();

		playerUpSwim = new Animation( 300, Assets.getPlayerSwimmingUp() );
		playerDownSwim = new Animation( 300, Assets.getPlayerSwimmingDown() );
		playerLeftSwim = new Animation( 300, Assets.getPlayerSwimmingLeft() );
		playerRightSwim = new Animation( 300, Assets.getPlayerSwimmingRight() );

	}

	@Override
	public void attack()
	{

		int currentTileX = ( int ) getX() + ( getWidth() / 2 );
		int currentTileY = ( int ) getY() + ( getHeight() / 2 );

		if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.hit ) && !( handler.getWorld()
				.getTile( currentTileX / TileBase.WIDTH, currentTileY / TileBase.HEIGHT ) instanceof WaterTile ) )
		{
			if ( getFaceDirection() == 0 )
				playerStanding = playerSkinManager.getCurrentPlayerUpAttack().getCurrentFrame();
			if ( getFaceDirection() == 1 )
				playerStanding = playerSkinManager.getCurrentPlayerRightAttack().getCurrentFrame();
			if ( getFaceDirection() == 2 )
				playerStanding = playerSkinManager.getCurrentPlayerDowntAttack().getCurrentFrame();
			if ( getFaceDirection() == 3 )
				playerStanding = playerSkinManager.getCurrentPlayerLeftAttack().getCurrentFrame();
		}
		hurtBehavior.attack( getFaceDirection() );
	}

	@Override
	public int getFaceDirection()
	{
		return moveBehaviour.getEntityFace();
	}

	@Override
	public void move( float speed )
	{
		if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.right ) )
		{
			moveBehaviour.moveRight();
		}

		if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.left ) )
		{
			moveBehaviour.moveLeft();
		}

		if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.up ) )
		{
			moveBehaviour.moveUp();
		}

		if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.down ) )
		{
			moveBehaviour.moveDown();
		}
	}

	private BufferedImage getCurrentAnimation()
	{

		if ( handler.getWorld().getTile( ( int ) ( x + bounds.x + bounds.width ) / TileBase.WIDTH,
				( int ) ( y + bounds.height + bounds.y ) / TileBase.HEIGHT ) instanceof WaterTile )
		{
			if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.right ) )
			{
				playerStanding = Assets.getPlayerRightStandSwimming();
				return playerRightSwim.getCurrentFrame();
			} else if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.left ) )
			{
				playerStanding = Assets.getPlayerLeftStandSwimming();
				return playerLeftSwim.getCurrentFrame();
			} else if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.up ) )
			{
				playerStanding = Assets.getPlayerUpStandSwimming();
				return playerUpSwim.getCurrentFrame();
			} else if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.down ) )
			{
				playerStanding = Assets.getPlayerDownStandSwimming();
				return playerDownSwim.getCurrentFrame();
			} else
			{
				return playerStanding;
			}

		} else
		{
			if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.right ) )
			{
				playerStanding = playerSkinManager.getCurrentPlayerFaceRight();
				return playerSkinManager.getCurrentPlayerRightWalk().getCurrentFrame();
			} else if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.left ) )
			{
				playerStanding = playerSkinManager.getCurrentPlayerFaceLeft();
				return playerSkinManager.getCurrentPlayerLeftWalk().getCurrentFrame();
			} else if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.up ) )
			{
				playerStanding = playerSkinManager.getCurrentPlayerFaceUp();
				return playerSkinManager.getCurrentPlayerUpWalk().getCurrentFrame();
			} else if ( handler.getKeyManager().getPressedKeys().contains( AvailableKey.down ) )
			{
				playerStanding = playerSkinManager.getCurrentPlayerFaceDown();
				return playerSkinManager.getCurrentPlayerDownWalk().getCurrentFrame();
			} else
			{
				return playerStanding;
			}
		}
	}

	@Override
	public void tick()
	{

		move( speed );
		attack();
		handler.getGameCamera().centerOnEntity( this );
		inventory.tick();
		playerDownSwim.tick();
		playerUpSwim.tick();
		playerLeftSwim.tick();
		playerRightSwim.tick();
		playerSkinManager.tick();
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage( getCurrentAnimation(), ( int ) ( x - handler.getGameCamera().getxOffset() ),
				( int ) ( y - handler.getGameCamera().getyOffset() ), width, height, null );
	}

	public void postRender( Graphics g )
	{
		inventory.render( g );
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

	public PlayerSkinManager getPlayerSkinManager()
	{
		return playerSkinManager;
	}

	public void setPlayerSkinManager( PlayerSkinManager playerSkinManager )
	{
		this.playerSkinManager = playerSkinManager;
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
