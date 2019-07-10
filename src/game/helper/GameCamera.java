package game.helper;

import game.Handler;
import game.entity.player.Player;
import game.tiles.TileBase;

public class GameCamera {

	private float xOffset, yOffset;
	private Handler handler;

	public GameCamera( float xOffset, float yOffset, Handler handler ) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	private void checkBlankSpaces( Player player )
	{
		if ( xOffset < 0 )
			xOffset = 0;
		else if ( xOffset > handler.getWorld ().getWidth () * TileBase.WIDTH - handler.getWidth () )
			xOffset = handler.getWorld ().getWidth () * TileBase.WIDTH - handler.getWidth ();
		;

		if ( yOffset < 0 )
			yOffset = 0;
		else if (  yOffset > handler.getWorld ().getHeigth () * TileBase.HEIGHT - handler.getHeight () )
			yOffset = handler.getWorld ().getHeigth () * TileBase.HEIGHT - handler.getHeight ();;
	}

	public void centerOnEntity( Player player )
	{
		xOffset = player.getX () - handler.getWidth () / 2 - player.getWidth ();
		yOffset = player.getY () - handler.getHeight () / 2 - player.getHeight ();
		checkBlankSpaces ( player );
	}

	private void moveCamara( float xAmt, float yAmt )
	{
		xOffset += xAmt;
		yOffset += yAmt;
	}

	// Getters and Setters

	public float getxOffset()
	{
		return xOffset;
	}

	public void setxOffset( float xOffset )
	{
		this.xOffset = xOffset;
	}

	public float getyOffset()
	{
		return yOffset;
	}

	public void setyOffset( float yOffset )
	{
		this.yOffset = yOffset;
	}

}
