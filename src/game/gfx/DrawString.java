package game.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DrawString {

	private static final String font = "Jazz LET";

	public static void drawText( Graphics g, String str, int x, int y, int fontSize )
	{
		g.setFont ( new Font ( font, Font.PLAIN, fontSize ) );

		g.setColor ( Color.WHITE );

		g.drawString ( str, x, y );
	}
}
