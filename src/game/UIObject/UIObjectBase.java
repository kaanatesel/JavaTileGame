package game.UIObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;

public abstract class UIObjectBase {

	protected Handler handler;

	public UIObjectBase( Handler handler ) {
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render( Graphics g );

}
