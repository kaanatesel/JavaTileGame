package game.tiles;

import game.gfx.Assets;

public class SandTile extends TileBase implements notSolid
{
	private int moveResistance;

	public SandTile( int id, int resistance  )
	{
		super( Assets.getSand(), id );
		this.moveResistance = moveResistance;
	}

	@Override
	public int getMoveResistance()
	{
		return moveResistance;
	}

	@Override
	public void setMoveResistance( int moveResistance )
	{
		this.moveResistance = moveResistance;
	}

}
