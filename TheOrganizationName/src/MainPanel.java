import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.File;
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
/**
 * Modified pacman where the ghosts are in there own box and pacman can go anywhere 
 * @author 
 *MainPanel.java
 *  Jan 17 2017 
 *   
 */
public class MainPanel extends JPanel implements Runnable, KeyListener , MouseMotionListener {
	 int mouseX = 0;
	 int mouseY = 0;
	// , MouseMotionListener
	public int score = 0;
	public int lives = 3;
	int width = 1275;
	int height = 975;
	int item = 100;

	final int numFood = 1000;

	int numGhosts = 3;
	final int pauseDuration = 10;
	

	double x;
	double y;
	int left;
    ArrayList<Ghosts> ghost = new ArrayList<Ghosts>();
	static ArrayList<Point> points = new ArrayList<Point>();
	static ArrayList<Point> wallpoints = new ArrayList<Point>();
	ArrayList<PointItem> items = new ArrayList<PointItem>();

	int key = 0;
	int right;
	int top;
	int bottom;
	public static BufferedImage map = null;
	public static BufferedImage life = null;
	Pacman pacman = new Pacman(50, 50, 0, width, 0, height, Shape.PACMAN, 10);
/**
 * Creates the Jframe
 * @param args
 */
	public static void main(String args[]) {

		JFrame frame = new JFrame("Pacman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		frame.setBackground(Color.BLACK);
		pointsLocation();
		c.add(new MainPanel());
		frame.pack();

	}
/**
 * displays the location of the food and the coins 
 */
	public static void pointsLocation() {

		// Coordinates por points
		points.add(new Point(970, 50));
		points.add(new Point(555, 50));
		points.add(new Point(715, 50));
		points.add(new Point(1180, 50));

		points.add(new Point(970, 175));
		points.add(new Point(555, 175));
		points.add(new Point(715, 175));
		points.add(new Point(1180, 175));

		points.add(new Point(970, 250));
		points.add(new Point(555, 250));
		points.add(new Point(715, 250));
		points.add(new Point(1180, 250));

		points.add(new Point(970, 348));
		points.add(new Point(555, 348));
		points.add(new Point(715, 348));
		points.add(new Point(1180, 348));

		points.add(new Point(970, 425));
		points.add(new Point(555, 425));
		points.add(new Point(715, 425));
		points.add(new Point(1180, 425));

		// coordinates of walls
		wallpoints.add(new Point());

	}

	public void pacmanPosition() {
		// TODO Auto-generated method stub

	}

	public void pacmanStatus() {
		// TODO Auto-generated method stub

	}
/**
 * creates the ghosts and the item locations 
 */
	public MainPanel() {

		// Start the ghosts bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));

		pacman.setXSpeed(0);
		pacman.setYSpeed(0);
		pacman.setColor(new Color(0, 0, 0));
		for (int i = 0; i < numGhosts; i++) {
			ghost.add (new Ghosts(270, 39, 270, 348, 39, 686));
			ghost.get(i).setXSpeed(5);
			ghost.add(new Ghosts(411,148,411,849,148,514));
			ghost.get(i).setYSpeed(5);
			ghost.get(i).setColor(Color.WHITE);

		}

		// Creating locations for the fruits
		for (int i = 0; i < points.size(); i++) {
			double random = Math.random() * 10;
			if (random <= 4) {
				items.add(new PointFruit((int) points.get(i).getX(), (int) points.get(i).getY()));
				items.get(i).setHeight(30);
				items.get(i).setWidth(25);
			} else {
				items.add(new PointCoin((int) points.get(i).getX(), (int) points.get(i).getY()));
				items.get(i).setHeight(10);
				items.get(i).setWidth(10);
			}
		}

		addKeyListener(this);
		addMouseMotionListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();
//		class Sound {
//			private Clip clip;
//
//			public Sound(String fileName) {
//				// specify the sound to play
//				// (assuming the sound can be played by the audio system)
//				// from a wave File
//				try {
//					File file = new File(fileName);
//					if (file.exists()) {
//						AudioInputStream sound = AudioSystem.getAudioInputStream(file);
//						// load the sound into memory (a Clip)
//						clip = AudioSystem.getClip();
//						clip.open(sound);
//					} else {
//						throw new RuntimeException("Sound: file not found: " + fileName);
//					}
//				} catch (MalformedURLException e) {
//					e.printStackTrace();
//					throw new RuntimeException("Sound: Malformed URL: " + e);
//				} catch (UnsupportedAudioFileException e) {
//					e.printStackTrace();
//					throw new RuntimeException("Sound: Unsupported Audio File: " + e);
//				} catch (IOException e) {
//					e.printStackTrace();
//					throw new RuntimeException("Sound: Input/Output Error: " + e);
//				} catch (LineUnavailableException e) {
//					e.printStackTrace();
//					throw new RuntimeException("Sound: Line Unavailable Exception Error:" + e);
//				}
//
//				// play, stop, loop the sound clip
//			}
//		}

	}
/**
 * runs the game and sets the speed when the arrow keys are pressed 
 */
	public void run() {

		while (true) {

			this.requestFocus();
			
			/**
			 * up
			 */
			if (key == 38) {
				pacman.setYSpeed(-5);
				pacman.setXSpeed(0);

			}
			/**
			 * down
			 */
			else if (key == 40) {
				pacman.setYSpeed(5);
				pacman.setXSpeed(0);

			}
			/**
			 * left
			 */
			else if (key == 37) {
				pacman.setXSpeed(-5);
				pacman.setYSpeed(0);

			}
			/**
			 * right
			 */
			else if (key == 39) {
				pacman.setXSpeed(5);
				pacman.setYSpeed(0);

			}
//			 for (int i = 0; i < ghost.size(); i++) {
//						 if (hit(ghost.get(i))) {
//						 lives--;
//						 }
//			 }
			repaint();
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	
//	public boolean hit(Ghosts ghost){
//		int radius = ( ghost).getRadius();
//		 double xDistance = x - ghost.getX();
//		 double yDistance = y- ghost.getY();
//		 double hyp = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
//		
//		 return hyp <= radius;
//		 }
		
		
	
	
	
	/**
	 * displays the map, ghosts ,lives, and items to the screen 
	 */
	public void paintComponent(Graphics g) {

		super.paintComponents(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		repaint();
		try {
			map = ImageIO.read(MainPanel.class.getResourceAsStream("PacmanMaze.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(map, 0, 0, 1275, 900, null);
		// need to fix ghosts
		for (int i = 0; i < numGhosts; i++) {
			ghost.get(i).draw(g);
		}
		pacman.draw(g);
		g.setColor(Color.WHITE);
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		g.setFont(newFont);

		//g.drawString("counter: " + score, 0, 70);
		g.drawString("Lives :", 0, 20);
		g.drawString ("Last Known Location: (" + mouseX+ "," + mouseY + ")", 0,70);
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
			for (int i = 0; i < items.size(); i++) {
				items.remove(i);
			}

			for (int i = 0; i < items.size(); i++) {
				items.remove(i);
			}

		}
		for (int i = 0; i < items.size(); i++) {
			items.get(i).draw(g);
		}

	}
	/*
	 * used for finding the x and y of walls
	 * 
	 */
//	 public void mouseDragged(MouseEvent arg0) {
//	 repaint();
//	 }
//
	/**
	 * used for finding the x and y of walls
	 */
//	 public void mouseMoved(MouseEvent arg0) {
//	
//	 mouseX = arg0.getX();
//	 mouseY = arg0.getY();
//	 repaint();
//	 }
/**
 * checks what key is pressed and checks if pacman hits an enemy 
 */
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

		for (int i = 0; i < ghost.size(); i++) {
			z = (int) ghost.get(i).getX();
			k = (int) ghost.get(i).getY();
			r = (int) ghost.get(i).getRadius();

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

		for (int i = 0; i < items.size(); i++) {
			int z1 = items.get(i).getX();
			int k1 = items.get(i).getY();
			int r1 = items.get(i).getRadius();

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
				items.remove(i);
			}

			for (int j = 0; j < items.size(); j++) {
				int z11 = items.get(j).getX();
				int k11 = items.get(j).getY();
				int r11 = items.get(j).getRadius();

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
					items.remove(i);
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