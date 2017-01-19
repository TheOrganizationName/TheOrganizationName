import java.awt.Graphics;

/**
 * 
 * movement for pacman
 *
 */
public class Pacman extends MovingObject {

	public Pacman(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left, right, top, bottom);
		
	}

public double x;

/**
 * The y location of the object.
 */
public double y;

public void  setX(int x) {
	this.x = x;
}

/**
 * Sets the y location.
 * 
 * @param y
 *            New y location.
 */
public void setY(int y) {
	this.y = y;
}
public double getX() {
	return x;
}

/**
 * Returns the y location.
 * 
 * @return
 *            the current y position
 */
public  double getY() {
	return y;
}
	int key = 0;

	public void pacmanMove() {
		/**
		 * up
		 */
		if (key == 38) {
			cursor.setYSpeed(-7);
			cursor.setXSpeed(0);
		}
		/**
		 * down
		 */
		else if (key == 40) {
			cursor.setYSpeed(7);
			cursor.setXSpeed(0);
		}
		/**
		 * left
		 */
		else if (key == 37) {
			cursor.setXSpeed(-7);
			cursor.setYSpeed(0);
		}
		/**
		 * right
		 */
		else if (key == 39) {
			cursor.setXSpeed(7);
			cursor.setYSpeed(0);
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub
		
	}
}
