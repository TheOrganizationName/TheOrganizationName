import java.awt.Graphics;

/**
 * 
 * movement for pacman
 *
 */

public class Pacman extends MovingObject {
	private int length; 
	
	public Pacman(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left, right, top, bottom);
		this.length = length;
		
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
	
	}

	@Override
	public void draw(Graphics g) {
		int radius = length/2;
		int drawX = (int) getX() - radius;
		int drawY = (int) getY() - radius;

		g.setColor(color);
		g.fillOval(drawX, drawY, length, length);
	}
		
	public int getLength(){
		return this.length;
	}

	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub
		
	}
}
