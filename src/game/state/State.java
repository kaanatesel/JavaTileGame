package game.state;

import java.awt.Graphics;

import game.Game;
import game.Handler;

public abstract class State {

	public static State currentState = null;

	private Handler handler;

	public State( Handler handler ) {
		this.handler = handler;
	}

	public static void setCurrentState( State newState )
	{
		currentState = newState;
	}
	
	public static State getCurrentState()
	{
		return currentState;
	}

	public abstract void tick();

	public abstract void render( Graphics g );

}
