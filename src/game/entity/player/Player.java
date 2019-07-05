package game.entity.player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import game.Game;
import game.Handler;
import game.entity.Entity;
import game.entity.MoveAble;
import game.gfx.Assets;
import game.helper.MoveBehaviour;
import game.inputs.AvailableKey;
import game.inputs.KeyManager;

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

		//System.out.println ( handler.getKeyManager () );
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
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( Assets.getPlayer (), (int) x, (int) y, 100, 100, null );
	}

}
