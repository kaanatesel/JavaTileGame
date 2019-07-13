package game.entity;

import java.awt.Rectangle;

import game.Handler;

public interface EntityBase {

	int getHealth();

	void setHealth( int health );

	float getX();

	void setX( float x );

	float getY();

	void setY( float x );

	int getHeight();

	int getWidth();

	Handler getHandler();

	Rectangle getBounds();

	Rectangle getCollisionBounds( float xOffset, float yOffset );

	boolean checkEntityCollision( float xOffset, float yOffsett );

}
