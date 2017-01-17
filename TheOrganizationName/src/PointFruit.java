
import java.awt.image.BufferedImage;



public class PointFruit implements Runnable {

	public static BufferedImage strawberriePic = null;// making strawbery picture a variable
	public static BufferedImage watermelonPic = null;// making cherry picture a variable
	public static BufferedImage cherryPic = null;// making watermelon picture a variable

	/**
	 * The x location of the object.
	 */
	private double x1;
	/**
	 * The y location of the object.
	 */
	private double y1;
	/**
	 * The x location of the object.
	 */
	private double x;
	/**
	 * The y location of the object.
	 */
	private double y;
	/**
	 * The x speed of the object.
	 */
	private int left;
	/**
	 * The right edge for showing.
	 */
	private int right;
	/**
	 * The top edge for showing.
	 */
	private int top;
	/**
	 * The bottom edge for showing.
	 */
	private int bottom;

	/**
	 * Set to false to stop the thread.
	 */
	private boolean moving;
	/**
	 * Sets width of the food image.
	 */
	int width;
	/**
	 * Sets height of the food image.
	 */
	int height; 





	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x
	 *            The x location of fruit.
	 * @param y
	 *            The y location of fruit.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 */
	public void pointFruit(double x, double y, int left, int right, int top,
			int bottom) {

		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		startThread();
	}

	/**
	 * keeps it in place.
	 * 
	 * @return
	 *            the current y position
	 */
	public void startThread() {
		moving = false;
		Thread t = new Thread(this);
		t.start();
	}

	/**
	 * Returns the x location.
	 * 
	 * @return
	 *            the current x position
	 */

	public double getX() {
		return x;
	}

	/**
	 * Returns the y location.
	 * 
	 * @return
	 *            the current y position
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the x location.
	 * 
	 * @param x
	 *            New x location.
	 */
	public void setX(int x) {
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

	public double getRandomX() {
		return x1;
	}

	/**
	 * Returns a random y location.
	 * 
	 * @return
	 *            the current y position
	 */
	public double getRandomY() {
		return y1;
	}

	/**
	 * Sets a random x location.
	 * 
	 * @param x
	 *            New x location.
	 */
	public void setRandomX(int x) {
		this.x1 = Math.random()*1000;
	}

	/**
	 * Sets a random y location.
	 * 
	 * @param y
	 *            New y location.
	 */
	public void setrandomY(int y) {
		this.y1 = Math.random()*1000;
	}
	
	public void draw(Graphics g) {
		try{
			bananaPic = ImageIO.read(PointFruit.class.getResourceAsStream("/resource/banana.jpg"));// getting banana picture
			strawberriePic = ImageIO.read(PointFruit.class.getResourceAsStream("/resource/banana.jpg"));// getting strawberrie picture
			watermelonPic = ImageIO.read(PointFruit.class.getResourceAsStream("/resource/banana.jpg"));// getting cherry picture
			cherryPic = ImageIO.read(PointFruit.class.getResourceAsStream("/resource/banana.jpg"));// getting watermelon picture
		}Catch (IOException e){
			g.print("Error");
		}
		int [] bananas = new int [10000];

		for(i = 0, i < 950, i++){
			for(j = 0, j < 1275, j++){

				setX(i);
				setY(j);
				g.drawImage(bananaPic, x, y, null);// banana

			}
		}
	}

}




