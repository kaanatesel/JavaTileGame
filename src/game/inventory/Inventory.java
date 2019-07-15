package game.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import game.Handler;
import game.inputs.AvailableKey;
import game.item.Item;

public class Inventory {

	private boolean active = false;
	private Handler handler;
	private int renderX, renderY, width, height;
	private ArrayList<Item> inventoryItems;

	public Inventory( Handler handler ) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item> ();
	}

	public void tick()
	{
		if ( handler.getKeyManager ().getPressedKeys ().contains ( AvailableKey.inventory ) )
			active = !active;
		if ( !active )
			return;

		System.out.println ( "INVENTORY" );
		for ( Item item : inventoryItems )
		{
			System.out.println ( item.getName () + "   " + item.getCountInInventory () );
		}
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
	}

}
