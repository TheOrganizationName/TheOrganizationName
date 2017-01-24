
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class PointCoin extends PointItem {
	
	/**
	 * Makes picture a variable
	 */
	public static Image pic = null;

	public PointCoin(int x, int y) {
		super(x, y);
		try{
			pic = ImageIO.read(new File("resource/coin.png"));// getting banana picture
		}catch (IOException e){
			System.err.println(e.getMessage());
		}
	}

	
	
	public void draw(Graphics g) {
		g.drawImage(pic, x, y, width, height, null);// banana
	}
	
	
	
	
}




