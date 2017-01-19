
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics;


	public class Enemies extends MovingObject {
		/**
		 * The radius of the ball.
		 */
		private int radius;
		/**
		 * Counts the frames between flash on/off.
		 */
		private int counter;
		/**
		 * The number of frames to wait before toggling the flash.
		 */
		private int flashSpeed;
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
		public Enemies(double x, double y, int left, int right, int top, int bottom) {
			super(x, y, left + 10, right - 10, top + 10, bottom - 10);
			// numbers above must match the radius
			radius = (int)(Math.random()*25+5);
		}

		/**
		 * Controls the animation parameters. (Called once every time the ball
		 * position is updated.)
		 */

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
			g.fillRect(drawX, drawY, radius * 2, radius * 2);
			if (!filledIn) {
				g.setColor(Color.black);
				g.fillRect(drawX + radius / 2, drawY + radius / 2, radius, radius);
			}

		}
		public int getRadius ()
		{
			return this.radius;
		}

		@Override
		public void animateOneStep() {
			// TODO Auto-generated method stub
			
		}
		

	}


