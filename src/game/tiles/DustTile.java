package game.tiles;

import game.gfx.Assets;

public class DustTile extends TileBase implements notSolid {

	private int moveResistance;

	public DustTile( int id, int resistance ) {
		super ( Assets.getDust (), id );
		this.moveResistance = moveResistance;
	}

	// Getters and Setters
	
	public int getMoveResistance()
	{
		return moveResistance;
	}
	
	public void setMoveResistance( int moveResistance )
	{
		this.moveResistance = moveResistance;
	}

}
