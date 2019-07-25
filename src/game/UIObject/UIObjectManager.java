package game.UIObject;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Handler;
import game.gfx.Assets;

public class UIObjectManager {

	private Handler handler;
	private ArrayList<UIObjectBase> uiObjects;

	private StartBtn startBtn;
	private ExitBtn exitBtn;
	private OptionBtn optionBtn;

	public UIObjectManager( Handler handler ) {
		this.handler = handler;

		uiObjects = new ArrayList<UIObjectBase> ();

		init ();
	}

	private void init()
	{
		startBtn = new StartBtn ( handler, Assets.getStartBtn (), 450, 225, 300, 150 );
		optionBtn = new OptionBtn ( handler, Assets.getOptionsBtn (), 450, 350, 300, 150 );
		exitBtn = new ExitBtn ( handler, Assets.getExitBtn (), 450, 475, 300, 150 );

		uiObjects.add ( startBtn );
		uiObjects.add ( optionBtn );
		uiObjects.add ( exitBtn );

	}

	public void tick()
	{
		for ( UIObjectBase uiObject : uiObjects )
		{
			uiObject.tick ();
		}

	}

	public void render( Graphics g )
	{
		for ( UIObjectBase uiObject : uiObjects )
		{
			uiObject.render ( g );
		}

		optionBtn.postRender ( g );
	}

}
