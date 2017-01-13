
/**
 * 
 * movement for pacman
 *
 */
public class Pacman extends MovingObjects {

    
	 public static void main (String[] args) throws InterruptedException
	    {
		 image1 = new ImageIcon(getClass().getResource("map.jpg"));
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
}
