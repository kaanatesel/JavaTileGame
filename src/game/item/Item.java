package game.item;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.Assets;

public class Item implements ItemBase {

	public static Item[] items = new Item[256];
	public static Item woodItem = new Item ( Assets.getWoodItem (), "Wood", 0 );
	public static Item stoneItem = new Item ( Assets.getstoneItem (), "Stone", 1 );

	private BufferedImage texture;
	private int x, y;
	private Rectangle bounds;
	private Handler handler;
	private boolean isPickedUp = false;
	private String name;
	private int id;
	private int countInInventory;

	public Item( BufferedImage texture, String name, int id ) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		this.countInInventory = 1;
		bounds = new Rectangle ( x, y, ITEM_WIDTH, ITEM_HEIGHT );
	}

	@Override
	public void tick()
	{
		if ( handler.getWorld ().getEntityManager ().getPlayer ().getCollisionBounds ( 0f, 0f ).intersects ( bounds ) )
		{
			isPickedUp = true;
			handler.getWorld ().getEntityManager ().getPlayer ().getInventory ().addItem ( this );
		}
	}

	@Override
	public void render( Graphics g )
	{
		if ( handler != null )
		{
			g.drawImage ( texture, (int) (x - handler.getGameCamera ().getxOffset ()),
			        (int) (y - handler.getGameCamera ().getyOffset ()), ITEM_WIDTH, ITEM_HEIGHT, null );
		}
	}

	public Item createNew( int x, int y )
	{
		Item i = new Item ( texture, name, id );
		i.setPosition ( x, y );

		return i;
	}

	public void setPosition( int x, int y )
	{
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}

	public void setHandler( Handler handler )
	{
		this.handler = handler;
	}

	public static Item[] getItems()
	{
		return items;
	}

	public static void setItems( Item[] items )
	{
		Item.items = items;
	}

	public static Item getWoodItem()
	{
		return woodItem;
	}

	public static void setWoodItem( Item woodItem )
	{
		Item.woodItem = woodItem;
	}

	public static Item getStoneItem()
	{
		return stoneItem;
	}

	public static void setStoneItem( Item stoneItem )
	{
		Item.stoneItem = stoneItem;
	}

	public BufferedImage getTexture()
	{
		return texture;
	}

	public void setTexture( BufferedImage texture )
	{
		this.texture = texture;
	}

	public int getX()
	{
		return x;
	}

	public void setX( int x )
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY( int y )
	{
		this.y = y;
	}

	public Rectangle getBounds()
	{
		return bounds;
	}

	public void setBounds( Rectangle bounds )
	{
		this.bounds = bounds;
	}

	public boolean isPickedUp()
	{
		return isPickedUp;
	}

	public void setPickedUp( boolean isPickedUp )
	{
		this.isPickedUp = isPickedUp;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public int getCountInInventory()
	{
		return countInInventory;
	}

	public void setCountInInventory( int countInInventory )
	{
		this.countInInventory = countInInventory;
	}

	public Handler getHandler()
	{
		return handler;
	}

	public int getId()
	{
		return id;
	}

}
