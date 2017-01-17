
/**
 * 
 * movement for pacman
 *
 */
public class Pacman extends MovingObjects {

	public static void main(String[] args) throws InterruptedException {
	}

	private double x;
	private double y;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
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
}
