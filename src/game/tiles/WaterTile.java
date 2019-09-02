package game.tiles;

import game.gfx.Assets;

public class WaterTile extends TileBase implements notSolid{

	private int moveResistance;

	public WaterTile(int id , int resistance) {
		super ( Assets.getWater (), id );
		this.moveResistance = resistance;
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
