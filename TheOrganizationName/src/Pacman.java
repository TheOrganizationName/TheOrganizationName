import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * movement for pacman
 *
 */

public class Pacman extends MovingObject {
	private int length;
	private Shape shape;
	public static BufferedImage pacman = null;

	public Pacman(double x, double y, int left, int right, int top, int bottom, Shape shape, int length) {
		super(x, y, left, right, top, bottom);
		this.length = length;
		this.shape = shape;

	}

	// public double x;
	//
	/// **
	// * The y location of the object.
	// */
	// public double y;
	//
	// public void setX(int x) {
	// this.x = x;
	// }
	//
	/// **
	// * Sets the y location.
	// *
	// * @param y
	// * New y location.
	// */
	// public void setY(int y) {
	// this.y = y;
	// }
	// public double getX() {
	// return x;
	// }
	//
	/// **
	// * Returns the y location.
	// *
	// * @return
	// * the current y position
	// */
	// public double getY() {
	// return y;
	// }
	// int key = 0;
	//
	// public void pacmanMove() {
	//
	// }

	
	@Override
	public void draw(Graphics g) {
		
			try {
				pacman = ImageIO.read(MainPanel.class.getResourceAsStream("pacman.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pacman, (int) getX(), (int) getY(), 50, 50, null);
		}
		
	

	public int getLength() {
		return this.length;
	}

	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub

	}
}
