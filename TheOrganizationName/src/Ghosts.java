
import java.awt.Graphics;

public class Ghosts extends MovingObject {
	/**
	 * The radius of the ball.
	 */
	private int radius;

	/**
	 * Controls the flash - true if the ball is filled in, false if it is an
	 * outline.
	 */
	private boolean filledIn;


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
		radius = 10;;
		
		
		filledIn = true;
	}

	/**
	 * Controls the animation parameters. (Called once every time the ball
	 * position is updated.)
	 */
	public void animateOneStep() {
		
	}

	/**
	 * Draws the ball
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
	 * Returns true if the ball is filled in.
	 * 
	 * @return true if the ball is filled in, false otherwise.
	 */
	public boolean isFilled(){
		return filledIn;
	}
	
	/**
	 * Fills the circle.
	 */
	public void fillCircle(){
		filledIn = true;
	}
	
	/**
	 * Gives the radius of the ball.
	 * 
	 * @return the radius of the ball.
	 */
	public int getRadius(){
		return this.radius;
	}
}




































