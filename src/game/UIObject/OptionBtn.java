package game.UIObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.DrawString;

public class OptionBtn extends UIObjectBase implements ClickAble {

	private BufferedImage[] texture;
	private int x, y, width, height;
	private Rectangle bounds;
	private Rectangle optionPageBounds;
	private boolean hovering = false;
	private boolean hoveringOnOptionPage = false;
	private boolean clicked = false;

	public OptionBtn( Handler handler, BufferedImage[] texture, int x, int y, int width, int height ) {
		super ( handler );
		this.texture = texture;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle ( x, y, width, height );
		optionPageBounds = new Rectangle ( 200, 200, 600, 600 );

	}

	@Override
	public void onClick()
	{
		if ( hovering && handler.getMouseEventListener ().isLeftButton () )
			clicked = true;

		if ( !hoveringOnOptionPage && handler.getMouseEventListener ().isLeftButton () )
			clicked = false;
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

	public void postRender( Graphics g )
	{
		if ( clicked )
		{
			g.setColor ( Color.GRAY );
			g.fillRect ( 200, 200, 600, 600 );
			g.setColor ( Color.BLACK );
			DrawString.drawText ( g, " move with > W A S D ", 225, 275, 40 );
			DrawString.drawText ( g, " attack with > L ", 225, 340, 40 );
			DrawString.drawText ( g, " open inventory with > E ", 225, 395, 40 );
		}
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

		if ( optionPageBounds.contains ( handler.getMouseEventListener ().getMouseX (),
		        handler.getMouseEventListener ().getMouseY () ) )
			hoveringOnOptionPage = true;
		else
			hoveringOnOptionPage = false;
	}
}
