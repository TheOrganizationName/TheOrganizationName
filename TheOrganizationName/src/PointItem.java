import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
/**
 * Sets the location of the items 
 * @author 
 *PointItem.java
 *Jan 24 2017
 *
 */

public class PointItem {
	// number of point items
	static int numPoints = 100;
	// array of points 
//	public static ArrayList<PointItem> Item = new ArrayList<PointItem>(numPoints);
	// Array of cordinates
//	public static ArrayList<Point> points = new ArrayList<Point>(numPoints);

	/**
	 * The radius location of the object.
	 */
	private int radius;
	/**
	 * The x location of the object.
	 */
	private int x1;
	/**
	 * The y location of the object.
	 */
	private int y1;
	/**
	 * The x location of the object.
	 */
	protected int x;
	/**
	 * The y location of the object.
	 */
	protected int y;
	/**
	 * Sets width of the food image.
	 */
	int width;
	/**
	 * Sets height of the food image.
	 */
	int height; 

	/**
	 * Sets the radius.
	 * 
	 * @param x
	 *            New radius.
	 */
	public void setRadius(int radius) {
		radius=5;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public void setHeight(int height){
		this.height=height;
	}
	/**
	 * Returns the radius.
	 * 
	 * @param x
	 *            New radius.
	 */
	public int getRadius() {
		return this.radius;
	}

	/**
	 * Returns the x location.
	 * 
	 * @return
	 *            the current x position
	 */

	public int getX() {
		return x;
	}

	/**
	 * Returns the y location.
	 * 
	 * @return
	 *            the current y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns a random x location.
	 * 
	 * @return
	 *            the current x position
	 */
	public double getRandomX() {
		return x1;
	}

	/**
	 * Returns a random y location.
	 * 
	 * @return
	 *            the current y position
	 */
	public int getRandomY() {
		return y1;
	}

	/**
	 * Sets a random x location.
	 * 
	 * @param x
	 *            New x location.
	 */
	public void setRandomX(int x) {
		this.x1 = (int) (Math.random()*1000);
	}

	/**
	 * Sets a random y location.
	 * 
	 * @param y
	 *            New y location.
	 */
	public void setrandomY(int y) {
		this.y1 = (int) (Math.random()*1000);
	}


	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x
	 *            The x location of fruit or coin.
	 * @param y
	 *            The y location of fruit or coin.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 */
	public PointItem(int x, int y) {

		this.x = (int) x;
		this.y = (int) y;
		

	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
