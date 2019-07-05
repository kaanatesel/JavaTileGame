package game.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class KeyManager implements KeyListener {
	private final java.util.Set<AvailableKey> pressedKeys = new HashSet<> ();

	public KeyManager() {

	}

	public java.util.Set<AvailableKey> getPressedKeys()
	{
		return pressedKeys;
	}

	@Override
	public void keyPressed( KeyEvent e )
	{

		pressedKeys.add ( AvailableKey.getKeyByValue ( e.getKeyCode () ) );
	}

	@Override
	public void keyReleased( KeyEvent e )
	{

		pressedKeys.remove ( AvailableKey.getKeyByValue ( e.getKeyCode () ) );
	}

	@Override
	public void keyTyped( KeyEvent e )
	{

	}

}
