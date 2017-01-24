
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class PointFruit extends PointItem{
	/**
	 * Makes picture a variable
	 */
	
	public static Image pic = null;
	public PointFruit(int x, int y) {
		super(x, y);
		try{
			pic = ImageIO.read(new File("resource/banana.png"));// getting banana picture
		}catch (IOException e){
			System.err.println(e.getMessage());
		}
	}
	
	
	
	public void draw(Graphics g) {

		g.drawImage(pic, x, y, width, height, null);// banana
	}

	
	

}




