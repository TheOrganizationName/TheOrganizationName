import java.util.ArrayList;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements Runnable, KeyListener {

	 public int score = 0;
	 public int lives = 3;
	int width = 1275;
	int height = 975;

	 final int numFood = 1000;

	int numGhosts = 1;
	final int pauseDuration = 10;
	Ghosts[] ghost = new Ghosts[numGhosts];

	 double x;
	 double y;
	 int left;

	int key = 0;
	 int right;
	 int top;
	 int bottom;
	public static BufferedImage map = null;
	public static BufferedImage life = null;
	Pacman pacman = new Pacman(50, 50, 0, width, 0, height, Shape.PACMAN, 10);

	 public static ArrayList<PointFruit> listOfFruit = new
	 ArrayList<PointFruit>();
	 public static ArrayList<PointCoin> listOfCoins = new
	 ArrayList<PointCoin>();
	 PointCoin coins = new PointCoin();
	 PointFruit bananas = new PointFruit();

	public static void main(String args[]) {
		// JFrame gui = new JFrame();
		// gui.setBounds(0, 0, 1350, 700);
		// gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// gui.setVisible(true);
		// gui.pack();
		// gui.setTitle("Pacman");
		// Container c = gui.getContentPane();
		// c.add(new MainPanel());
		// }
		JFrame frame = new JFrame("Pacman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		frame.setBackground(Color.BLACK);
		c.add(new MainPanel());
		frame.pack();

	}
	// public void pacmanPosition() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// public void pacmanStatus() {
	// // TODO Auto-generated method stub
	//
	// }

	public MainPanel() {
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		pacman.setXSpeed(0);
		pacman.setYSpeed(0);
		pacman.setColor(new Color(0, 0, 0));
		for (int i = 0; i < numGhosts; i++) {
			ghost[i] = new Ghosts(50, 50, 0, width, 0, height);
			ghost[i].setXSpeed(5);
			ghost[i].setXSpeed(5);
			ghost[i].setColor(
					new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		}

		addKeyListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();
		 class Sound {
		 private Clip clip;
		
		 public Sound(String fileName) {
		 // specify the sound to play
		 // (assuming the sound can be played by the audio system)
		 // from a wave File
		 try {
		 File file = new File(fileName);
		 if (file.exists()) {
		 AudioInputStream sound = AudioSystem.getAudioInputStream(file);
		 // load the sound into memory (a Clip)
		 clip = AudioSystem.getClip();
		 clip.open(sound);
		 } else {
		 throw new RuntimeException("Sound: file not found: " + fileName);
		 }
		 } catch (MalformedURLException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Sound: Malformed URL: " + e);
		 } catch (UnsupportedAudioFileException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Sound: Unsupported Audio File: " + e);
		 } catch (IOException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Sound: Input/Output Error: " + e);
		 } catch (LineUnavailableException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Sound: Line Unavailable Exception Error:" + e);
		 }
		
		 // play, stop, loop the sound clip
		 }
		 }

	}

	public void run() {

		while (true) {

			this.requestFocus();
			/**
			 * up
			 */
			if (key == 38) {
				pacman.setYSpeed(-7);
				pacman.setXSpeed(0);

			}
			/**
			 * down
			 */
			else if (key == 40) {
				pacman.setYSpeed(7);
				pacman.setXSpeed(0);

			}
			/**
			 * left
			 */
			else if (key == 37) {
				pacman.setXSpeed(-7);
				pacman.setYSpeed(0);

			}
			/**
			 * right
			 */
			else if (key == 39) {
				pacman.setXSpeed(7);
				pacman.setYSpeed(0);

			}

			repaint();
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponents(g);

		try {
			map = ImageIO.read(MainPanel.class.getResourceAsStream("map.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(map, 100, 0, height, width, null);
		// need to fix ghosts
		for (int i = 0; i < numGhosts; i++) {
			ghost[i].draw(g);
		}
		pacman.draw(g);
		 g.setColor(Color.WHITE);
		 Font currentFont = g.getFont();
		 Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		 g.setFont(newFont);
		
		 g.drawString("counter: " + score, 0, 70);
		 g.drawString("Lives :", 0, 20);
		
		 try {
		 life = ImageIO.read(MainPanel.class.getResourceAsStream("Life.jpg"));
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		 if (lives == 3) {
		 g.drawImage(life, 50, 0, 50, 50, null);
		 g.drawImage(life, 100, 0, 50, 50, null);
		 g.drawImage(life, 150, 0, 50, 50, null);
		 }
		
		 if (lives == 2) {
		
		 g.drawImage(life, 50, 0, 50, 50, null);
		 g.drawImage(life, 100, 0, 50, 50, null);
		
		 }
		 if (lives == 1) {
		
		 g.drawImage(life, 50, 0, 50, 50, null);
		
		 }
		 if (lives == 0) {
		 Font Fonts = g.getFont();
		 Font newFonts = Fonts.deriveFont(Fonts.getSize() * 6.7F);
		 g.setFont(newFont);
		 g.drawString("You lose " + score, 45, 45);
		 for (int i = 0; i < listOfFruit.size(); i++) {
		 listOfFruit.remove(i);
		 }
		
		 for (int i = 0; i < listOfCoins.size(); i++) {
		 listOfCoins.remove(i);
		 }
		
		 }
		
	}

	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		repaint();
		 int z;
		 int k;
		 int r;
		 int differenceY;
		 int differenceX;
		 int hypoteneuse;
		 int q;
		 int p;
		
		 int x = (int) pacman.getX();
		 int y = (int) pacman.getY();
		
		 for (int i = 0; i < ghost.length; i++) {
		 z = (int) ghost[i].getX();
		 k = (int) ghost[i].getY();
		 r = (int) ghost[i].getRadius();
		
		 differenceY = x - z;
		 differenceX = y - k;
		
		 if (differenceY < 0 || differenceX < 0) {
		 differenceY = differenceY * -1;
		 differenceX = differenceX * -1;
		
		 }
		 p = differenceY;
		 q = differenceX;
		 hypoteneuse = (int) Math.pow((p * p + q * q), 0.5);
		 if (hypoteneuse < (r + 1)) {
		
		 lives = lives - 1;
		
		 }
		
		 }
		
		 for (int i = 0; i < listOfFruit.size(); i++) {
		 int z1 = listOfFruit.get(i).getX();
		 int k1 = listOfFruit.get(i).getY();
		 int r1 = listOfFruit.get(i).getRadius();
		
		 differenceY = x - z1;
		 differenceX = y - k1;
		
		 if (differenceY < 0 || differenceX < 0) {
		 differenceY = differenceY * -1;
		 differenceX = differenceX * -1;
		
		 }
		 p = differenceY;
		 q = differenceX;
		 hypoteneuse = (int) Math.pow((p * p + q * q), 0.5);
		 if (hypoteneuse < (r1 + 1)) {
		
		 score = score + 5;
		 listOfFruit.remove(i);
		 }
		
		 for (int j = 0; j < listOfCoins.size(); j++) {
		 int z11 = listOfCoins.get(j).getX();
		 int k11 = listOfCoins.get(j).getY();
		 int r11 = listOfCoins.get(j).getRadius();
		
		 differenceY = x - z11;
		 differenceX = y - k11;
		
		 if (differenceY < 0 || differenceX < 0) {
		 differenceY = differenceY * -1;
		 differenceX = differenceX * -1;
		
		 }
		 p = differenceY;
		 q = differenceX;
		 hypoteneuse = (int) Math.pow((p * p + q * q), 0.5);
		 if (hypoteneuse < (r11 + 1)) {
		
		 score = score + 5;
		 listOfCoins.remove(i);
		 }
		 }
		 }
	}

	public void keyReleased(KeyEvent e) {
		key = 0;
		repaint();
	}

	/**
	 * called when a character is entered (could be multiple key presses
	 * 
	 * @param e
	 *            Thekeyboard event
	 **/
	public void keyTyped(KeyEvent e) {
		// this space intentionally left blank
	}

}