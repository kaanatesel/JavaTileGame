package game.entity.player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
import game.entity.Entity;
import game.entity.MoveAble;
import game.helper.MoveBehaviour;
import game.inputs.AvailableKey;
import game.inputs.KeyManager;

public class Player extends Entity implements MoveAble {

	private final int DEFAULT_SPEED = 5;

	private float speed;

	private MoveBehaviour moveBehaviour;

	// key listener
	private KeyManager keyManager;

	public Player( float x, float y, int height, int width, Game game ) {
		super ( x, y, height, width, game );
		speed = DEFAULT_SPEED;
		moveBehaviour = new MoveBehaviour ( this, speed );

		this.keyManager = game.getKeyManager ();
	}

	@Override
	public void move( float speed )
	{
		if ( game.getKeyManager ().up )
			moveBehaviour.moveUp ();
		if ( game.getKeyManager ().down )
			moveBehaviour.moveDown ();
		if ( game.getKeyManager ().right )
			moveBehaviour.moveRight ();
		if ( game.getKeyManager ().left )
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
		g.fillOval ( (int) x, (int) y, width, height );
	}

}
