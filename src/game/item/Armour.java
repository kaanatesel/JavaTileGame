package game.item;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.Handler;
import game.entity.player.PlayerSkinManager;
import game.gfx.Assets;
import game.gfx.DrawString;
import game.inventory.Inventory;

public class Armour extends Item implements ItemBase , UseAble
{

	private boolean created = false;
	private boolean equiped = false;
	private int value;
	private BufferedImage valueTypeImg;
	private String valueTypeName;
	private final int craftTableWidth, craftTableHeight;

	private BufferedImage[] createBtn;
	private BufferedImage[] useBtn;
	private Rectangle createBtnBounds;
	private Rectangle useBtnBounds;

	public Armour( BufferedImage texture, String name, int id, Handler handler )
	{
		super( texture, name, id );

		this.setHandler( handler );

		value = 20;
		valueTypeName = "Wood";
		valueTypeImg = Assets.getSword();

		craftTableWidth = 128;
		craftTableHeight = 128;

		createBtn = Assets.getCreateButton();
		useBtn = Assets.getUseButton();
		createBtnBounds = new Rectangle( 0, 0, 0, 0 );
		useBtnBounds = new Rectangle( 0, 0, 0, 0 );
	}

	public void tick()
	{

		onClick();
	}

	private BufferedImage checkEquiped()
	{
		if ( equiped )
			return useBtn[1];
		else
			return useBtn[0];
	}

	// render in inventory
	public void render( Graphics g, int x, int y )
	{
		g.drawImage( texture, x - 210, y - 55, 80, 80, null );
		DrawString.drawText( g, "> " + name + " <", x, y, 30 );
		DrawString.drawText( g, String.valueOf( countInInventory ), x + 300, y, 30 );

		if ( equiped )
		{
			useBtnBounds.x = x + 380 + 60;
		}
		if ( !equiped )
		{
			useBtnBounds.x = x + 380;
		}
		useBtnBounds.width = 60;
		useBtnBounds.y = y - 55;
		useBtnBounds.height = 60;
		g.drawImage( checkEquiped(), useBtnBounds.x, y - 55, 60, 60, null );
	}

	public void renderInCraftTable( Graphics g, int x, int y )
	{
		g.drawImage( texture, x, y, craftTableWidth, craftTableHeight, null );
		DrawString.drawText( g, name, x + 185, y + 10 + ( craftTableHeight / 2 ), 25 );

		g.drawImage( Assets.getstoneItem(), x + 340, y - 10 + ( craftTableHeight / 2 ), 25, 25, null );
		DrawString.drawText( g, String.valueOf( value ), x + 370, y + 10 + ( craftTableHeight / 2 ), 20 );

		g.drawImage( getCreateBtnCurrnetAnimation(), x + 400, y + 34, 60, 60, null );
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

		if ( createBtnBounds.contains( handler.getMouseEventListener().getMouseX(),
				handler.getMouseEventListener().getMouseY() ) && handler.getMouseEventListener().isLeftButton()
				&& checkPlayerInvantory() && !created )
		{
			created = true;
			handler.getWorld().getPlayer().getInventory().addUsableItem( this );
			setInventoryCount();

		}

		if ( useBtnBounds.contains( handler.getMouseEventListener().getMouseX(),
				handler.getMouseEventListener().getMouseY() ) && handler.getMouseEventListener().isLeftButton()
				&& !equiped )
		{
			equiped = true;
			use();
			return;
		}
		
		if ( useBtnBounds.contains( handler.getMouseEventListener().getMouseX(),
				handler.getMouseEventListener().getMouseY() ) && handler.getMouseEventListener().isLeftButton()
				&& equiped )
		{
			equiped = false;
			takeoff();
			return;
		}

	}

	private void setInventoryCount()
	{
		for ( Item item : handler.getWorld().getPlayer().getInventory().getInventoryItems() )
		{
			if ( item.getId() == 1 )
			{
				item.setCountInInventory( item.getCountInInventory() - value );
			}
		}
	}

	private boolean checkPlayerInvantory()
	{
		for ( Item item : handler.getWorld().getPlayer().getInventory().getInventoryItems() )
		{
			if ( item.getId() == 1 )
				return item.getCountInInventory() >= value;
		}
		return false;
	}

	@Override
	public void use()
	{
		handler.getWorld().getPlayer().getPlayerSkinManager().setPlayerArmourStatus( true );
		handler.getWorld().getPlayer().getPlayerSkinManager().setPlayerEquipmentStatus();
	}

	@Override
	public void takeoff()
	{
		handler.getWorld().getPlayer().getPlayerSkinManager().setPlayerArmourStatus( false );
		handler.getWorld().getPlayer().getPlayerSkinManager().setPlayerEquipmentStatus();		
	}

}
