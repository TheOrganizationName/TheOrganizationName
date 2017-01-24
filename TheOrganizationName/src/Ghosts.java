
import java.awt.Graphics;
/**
 * creates the ghost 
 * @author 
 * Ghosts.java
 * Jan 24 2017 
 *
 */
public class Ghosts extends MovingObject {
	/**
	 * The radius of the ghost.
	 */
	private int radius;

	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x
	 *            The x location.
	 * @param y
	 *            The y location.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 */
	public Ghosts(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		// numbers above must match the radius
		radius = 10;

	}

	/**
	 * Controls the animation parameters. (Called once every time the ghost
	 * position is updated.)
	 */
	public void animateOneStep() {

	}

	/**
	 * Draws the ghost
	 * 
	 * @param g
	 *            The graphics context.
	 */
	public void draw(Graphics g) {
		int drawX = (int) getX() - radius;
		int drawY = (int) getY() - radius;

		g.setColor(color);
		g.fillOval(drawX, drawY, radius * 2, radius * 2);

	}

	/**
	 * Gives the radius of the ghost.
	 * 
	 * @return the radius of the ghost.
	 */
	public int getRadius() {
		return this.radius;
	}
}
