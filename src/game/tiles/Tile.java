package game.tiles;

import java.awt.Graphics;

public interface Tile {

	final int WIDTH = 64;
	final int HEIGHT = 64;

	public void tick();

	public void render( Graphics g, int x, int y );

	public boolean isSolid();

	public int getId();
}
