import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * movement for pacman
 * Pacman.java
 * Jan 24 2017
 *
 */

public class Pacman extends MovingObject {
	private int length;
	private Shape shape;
	//public static BufferedImage pacman = null;
	public static Image pacman = null;
	public Pacman(double x, double y, int left, int right, int top, int bottom, Shape shape, int length) {
		super(x, y, left, right, top, bottom);
		this.length = length;
		this.shape = shape;

	}

	

	/**
	 * draws pacman
	 */
	@Override
	public void draw(Graphics g) {
		
			try {
				pacman = ImageIO.read(MainPanel.class.getResourceAsStream("Pacman.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pacman, (int) getX(), (int) getY(), null);
		}
		
	

	public int getLength() {
		return this.length;
	}

	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub

	}
}
