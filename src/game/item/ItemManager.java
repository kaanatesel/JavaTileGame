package game.item;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import game.Handler;

public class ItemManager {

	private ArrayList<Item> itemArray;
	private Handler handler;

	public ItemManager( Handler handler ) {
		this.handler = handler;
		itemArray = new ArrayList<Item> ();
	}

	public void tick()
	{
		Iterator<Item> it = itemArray.iterator ();

		while ( it.hasNext () )
		{
			Item i = it.next ();
			i.tick ();
			if ( i.isPickedUp () )
				it.remove ();
		}

	}

	public void render( Graphics g )
	{
		for ( Item item : itemArray )
		{
			item.render ( g );
		}
	}

	public void addItem( Item i )
	{
		i.setHandler ( handler );
		itemArray.add ( i );
	}

}
