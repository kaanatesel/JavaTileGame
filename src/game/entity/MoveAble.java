package game.entity;

public interface MoveAble extends EntityBase{
	void move( float speed );
	float getSpeed();
}
