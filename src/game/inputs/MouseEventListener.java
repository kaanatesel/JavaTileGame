package game.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEventListener implements MouseListener, MouseMotionListener {

	private int mouseX, mouseY;
	private boolean leftButton, rightButton;

	// Getters
	public int getMouseX()
	{
		return mouseX;
	}

	public int getMouseY()
	{
		return mouseY;
	}

	public boolean isLeftButton()
	{
		return leftButton;
	}

	public boolean isRightButton()
	{
		return rightButton;
	}

	@Override
	public void mousePressed( MouseEvent e )
	{
		if ( e.getButton () == MouseEvent.BUTTON1 )
			leftButton = true;
		else if ( e.getButton () == MouseEvent.BUTTON3 )
			rightButton = true;
	}

	@Override
	public void mouseReleased( MouseEvent e )
	{
		if ( e.getButton () == MouseEvent.BUTTON1 )
			leftButton = true;
		else if ( e.getButton () == MouseEvent.BUTTON3 )
			rightButton = true;
	}

	@Override
	public void mouseMoved( MouseEvent e )
	{
		mouseX = e.getX ();
		mouseY = e.getY ();
	}

	@Override
	public void mouseDragged( MouseEvent e )
	{

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
	public void mouseClicked( MouseEvent arg0 )
	{
		// TODO Auto-generated method stub

	}

}
