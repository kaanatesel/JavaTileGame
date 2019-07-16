package game.inventory;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Handler;
import game.gfx.Assets;
import game.inputs.AvailableKey;
import game.item.Item;

public class Inventory {

	private boolean active = false;
	private Handler handler;
	private int renderX, renderY;
	private ArrayList<Item> inventoryItems;

	public Inventory( Handler handler ) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item> ();
		renderX = 100;
		renderY = 100;
	}

	public void tick()
	{
		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.inventory ) )
			active = !active;
		if ( !active )
			return;
	}

	public void addItem( Item i )
	{
		for ( Item item : inventoryItems )
		{
			if ( item.getId () == i.getId () )
			{
				item.setCountInInventory ( i.getCountInInventory () + item.getCountInInventory () );
				return;
			}
		}

		inventoryItems.add ( i );
	}

	public void render( Graphics g )
	{
		if ( !active )
			return;

		g.drawImage ( Assets.getInventory (), renderX, renderY, 800, 800, null );

		int y = 300;

		for ( Item item : inventoryItems )
		{
			item.render ( g, 370, y );
			y += 100;
		}
	}

}
