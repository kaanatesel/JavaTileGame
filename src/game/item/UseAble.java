package game.item;

import java.awt.Graphics;

public interface UseAble {
	void tick();
	void use();
	void renderInCraftTable( Graphics g, int x, int y );
	void render( Graphics g, int x, int y );
	int getId();
	
}
