package game.entity.player;

import java.awt.Graphics;
import game.Handler;
import game.entity.Entity;
import game.entity.MoveAble;
import game.entity.MoveBehaviour;
import game.gfx.Assets;
import game.inputs.AvailableKey;

public class Player extends Entity implements MoveAble {

	private final int DEFAULT_SPEED = 5;
	private float speed;

	// Behaviors
	private MoveBehaviour moveBehaviour;

	public Player( float x, float y, int height, int width, Handler handler ) {
		super ( x, y, height, width, handler );
		speed = DEFAULT_SPEED;
		moveBehaviour = new MoveBehaviour ( this, speed );
	}

	@Override
	public void move( float speed )
	{

		// System.out.println ( handler.getKeyManager () );
		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.up ) )
			moveBehaviour.moveUp ();
		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.down ) )
			moveBehaviour.moveDown ();
		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.right ) )
			moveBehaviour.moveRight ();
		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.left ) )
			moveBehaviour.moveLeft ();
	}

	@Override
	public void tick()
	{
		move ( speed );
		System.out.println ( handler );
		handler.getGameCamera ().centerOnEntity ( this );
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( Assets.getPlayer (), (int) (x - handler.getGameCamera ().getxOffset ()),
		        (int) (y - handler.getGameCamera ().getyOffset ()), width, height, null );
	}

}
