package game.tiles;

import game.gfx.Assets;

public class RockTile extends TileBase implements Solid

{

	private Solid solidBehavior;

	public RockTile( int id ) {
		super ( Assets.getRock (), id );

	}

	public Solid getSolid()
	{
		return solidBehavior;
	}
}
