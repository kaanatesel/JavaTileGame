package game.entity.staticEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.gfx.Assets;
import game.gfx.DrawString;
import game.inputs.AvailableKey;
import game.item.Armour;
import game.item.CraftTableManager;
import game.item.Sword;
import game.tiles.TileBase;

public class CraftTable extends StaticEntityBase {

	private boolean playerClose = false;
	private boolean active = false;
	private Rectangle playerCloseRange;
	private int renderX, renderY;
	private CraftTableManager craftTableManager;
	private Sword sword;
	private Armour armour;

	public CraftTable( float x, float y, int height, int width, Handler handler ) {
		super ( x, y, height, width, handler );
		renderX = 100;
		renderY = 100;

		bounds.x = (int) 8;
		bounds.y = (int) (height / 2);
		bounds.width = width - 8;
		bounds.height = (int) (height - height / 2f);

		texture = Assets.getCraftTable ();
		playerCloseRange = new Rectangle ( (int) (x - 50), (int) (y - 50), (int) (width + 100), (int) (height + 100) );
		this.setHealth ( 9999 );

		craftTableManager = new CraftTableManager ( handler );

		sword = new Sword ( Assets.getSword (), "Sword", 0, handler );
		armour = new Armour ( Assets.getArmour (), "Armour", 1, handler );
		craftTableManager.addItem ( armour );
		craftTableManager.addItem ( sword );

	}

	@Override
	public void tick()
	{
		checkPlayerLocation ();
		if ( playerClose && handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.openCraftTable ) )
			active = !active;
		if ( !playerClose )
			active = false;
		if ( !active )
			return;

		craftTableManager.tick ();
	}

	@Override
	public void render( Graphics g )
	{
		g.drawImage ( texture, (int) (x - handler.getGameCamera ().getxOffset ()),
		        (int) (y - handler.getGameCamera ().getyOffset ()), width, height, null );
	}

	public void postRender( Graphics g )
	{
		if ( !active )
			return;

		g.drawImage ( Assets.getCraftTableBackGround (), renderX, renderY, 1000, 600, null );
		craftTableManager.render ( g, 120, 260 );

	}

	private void checkPlayerLocation()
	{
		if ( playerCloseRange.contains ( handler.getWorld ().getPlayer ().getX (),
		        handler.getWorld ().getPlayer ().getY () ) )
			playerClose = true;
		else
			playerClose = false;

	}

}
