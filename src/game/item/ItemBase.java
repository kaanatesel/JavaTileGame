package game.item;

import java.awt.Graphics;

public interface ItemBase {

	final int ITEM_WIDTH = 32;
	final int ITEM_HEIGHT = 32;

	void tick();

	void render( Graphics g );

}
