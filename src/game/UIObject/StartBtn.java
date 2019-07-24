package game.UIObject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.state.State;

public class StartBtn extends UIObjectBase implements ClickAble {

	private BufferedImage[] texture;
	private int x, y, width, height;
	private Rectangle bounds;
	private boolean hovering = false;

	public StartBtn( Handler handler, BufferedImage[] texture, int x, int y, int width, int height ) {
		super ( handler );
		this.texture = texture;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle ( x, y, width, height );
	}

	@Override
	public void onClick()
	{
		if ( hovering && handler.getMouseEventListener ().isLeftButton () )
			State.setCurrentState ( handler.getGame ().getGameState () );
	}

	@Override
	public void tick()
	{
		isHovering ();
		onClick ();
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( getCurrentTexture (), x, y, width, height, null );
	}

	private BufferedImage getCurrentTexture()
	{
		if ( hovering )
			return texture[1];
		else
			return texture[0];
	}

	private void isHovering()
	{
		if ( bounds.contains ( handler.getMouseEventListener ().getMouseX (),
		        handler.getMouseEventListener ().getMouseY () ) )
			hovering = true;
		else
			hovering = false;
	}

}
