package game.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEventListener implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged( MouseEvent e )
	{

	}

	@Override
	public void mouseMoved( MouseEvent e )
	{
		System.out.println ( e.getX () + "  " + e.getY () );
	}

	@Override
	public void mouseClicked( MouseEvent e )
	{
		System.out.println ( "Clicked with  " + e.getButton () + "X = " + e.getX () + " Y == " +e.getY());
	}

	@Override
	public void mouseEntered( MouseEvent e )
	{

	}

	@Override
	public void mouseExited( MouseEvent e )
	{

	}

	@Override
	public void mousePressed( MouseEvent e )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased( MouseEvent e )
	{
		// TODO Auto-generated method stub

	}

}
