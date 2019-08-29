package game.item;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.Assets;
import game.gfx.DrawString;
import game.inventory.Inventory;

public class Armour extends Item implements ItemBase, UseAble {

	private boolean created = false;
	private boolean used = false;
	private int value;
	private BufferedImage valueTypeImg;
	private String valueTypeName;
	private final int craftTableWidth, craftTableHeight;

	private BufferedImage[] createBtn;
	private Rectangle createBtnBounds;

	public Armour( BufferedImage texture, String name, int id, Handler handler ) {
		super ( texture, name, id );

		this.setHandler ( handler );

		value = 5;
		valueTypeName = "Wood";
		valueTypeImg = Assets.getSword ();

		craftTableWidth = 128;
		craftTableHeight = 128;

		createBtn = Assets.getCreateButton ();
		createBtnBounds = new Rectangle ( 0, 0, 0, 0 );
	}

	public void tick()
	{

		onClick ();
	}

	public void render( Graphics g )
	{

	}

	// render in inventory
	public void render( Graphics g, int x, int y )
	{
		g.drawImage ( texture, x - 210, y - 55, 80, 80, null );
		DrawString.drawText ( g, "> " + name + " <", x, y, 30 );
		DrawString.drawText ( g, String.valueOf ( countInInventory ), x + 300, y, 30 );
	}

	public void renderInCraftTable( Graphics g, int x, int y )
	{
		g.drawImage ( texture, x, y, craftTableWidth, craftTableHeight, null );
		DrawString.drawText ( g, name, x + 185, y + 10 + (craftTableHeight / 2), 25 );

		g.drawImage ( Assets.getstoneItem (), x + 340, y - 10 + (craftTableHeight / 2), 25, 25, null );
		DrawString.drawText ( g, String.valueOf ( value ), x + 370, y + 10 + (craftTableHeight / 2), 20 );

		g.drawImage ( getCreateBtnCurrnetAnimation (), x + 400, y + 34, 60, 60, null );
		createBtnBounds.x = x + 400;
		createBtnBounds.width = 60;
		createBtnBounds.y = y + 34;
		createBtnBounds.height = 60;

	}

	private BufferedImage getCreateBtnCurrnetAnimation()
	{
		if ( created )
			return createBtn[1];
		else
			return createBtn[0];
	}

	private void onClick()
	{
		if ( createBtnBounds.contains ( handler.getMouseEventListener ().getMouseX (),
		        handler.getMouseEventListener ().getMouseY () ) && handler.getMouseEventListener ().isLeftButton ()
		        && checkPlayerInvantory () && !created )
		{
			created = true;
			handler.getWorld ().getPlayer ().getInventory ().addItem ( Item.getArmourItem () );
			setInventoryCount ();

		}

	}

	private void setInventoryCount()
	{
		for ( Item item : handler.getWorld ().getPlayer ().getInventory ().getInventoryItems () )
		{
			if ( item.getId () == 1 )
			{
				item.setCountInInventory ( item.getCountInInventory () - value );
			}
		}
	}

	private boolean checkPlayerInvantory()
	{
		for ( Item item : handler.getWorld ().getPlayer ().getInventory ().getInventoryItems () )
		{
			if ( item.getId () == 1 )
				return item.getCountInInventory () >= value;
		}
		return false;
	}

	@Override
	public void use()
	{

	}

}
