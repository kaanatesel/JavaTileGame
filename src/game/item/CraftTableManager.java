package game.item;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import game.Handler;

public class CraftTableManager {
	private ArrayList<UseAble> itemArray;
	private Handler handler;

	public CraftTableManager( Handler handler ) {
		this.handler = handler;
		itemArray = new ArrayList<UseAble> ();
	}

	public void tick()
	{
		Iterator<UseAble> it = itemArray.iterator ();

		while ( it.hasNext () )
		{
			UseAble i = it.next ();
			i.tick ();
		}

	}

	public void render( Graphics g, int x, int y )
	{
		int ty = y;

		for ( UseAble item : itemArray )
		{
			item.renderInCraftTable ( g, x, ty );
			ty += 205;
		}
	}

	public void addItem( UseAble i )
	{
		itemArray.add ( i );
	}

}
