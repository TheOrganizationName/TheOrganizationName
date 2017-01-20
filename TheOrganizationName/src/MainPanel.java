import java.util.ArrayList;
import java.awt.Color;
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

public class MainPanel extends JFrame implements Runnable, KeyListener {
	
	public int score = 0;
	public int lives = 3;
	int width = 1275;
	int height = 975;

	final int numFood = 1000;

	int numGhosts = 3;
	final int pauseDuration = 50;
	Ghosts[] ghost = new Ghosts[numGhosts];

	double x;
	double y;
	int left;
	private ImageIcon image1;
	private JLabel label1;

	private ImageIcon image4;
	private JLabel label4;
	private ImageIcon image2;
	private JLabel label2;
	private ImageIcon image3;
	private JLabel label3;
	int key = 0;
	int right;
	int top;
	int bottom;
			
	Pacman pacman=new Pacman( x,  y,left, right,  top,  bottom);


	public static ArrayList <PointFruit> listOfFruit= new ArrayList<PointFruit>();
	public static ArrayList <PointCoin> listOfCoins= new ArrayList<PointCoin>();
	PointCoin coins = new PointCoin();
	PointFruit bananas = new PointFruit();

	public void pacmanPosition() {
		// TODO Auto-generated method stub

	}

	public void pacmanStatus() {
		// TODO Auto-generated method stub

	}

	public MainPanel() {
		
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource("map.jpg"));

		label1 = new JLabel(image1);
		add(label1);
		   
		
		
		
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
					throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
				}

				// play, stop, loop the sound clip
			}
		}
		
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.black);


		

		this.setPreferredSize(new Dimension(width, height));

		for (int i = 0; i < numGhosts; i++) {
			ghost[i] = new Ghosts(50, 50, 0, width, 0, height);
			ghost[i].setXSpeed(5);
			ghost[i].setXSpeed(5);
			ghost[i].setColor(
					new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

		}
		pacman.setXSpeed(0);
		pacman.setYSpeed(0);
		pacman.setColor(new Color(0,0,0));
		addKeyListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();
	}	
	
	public void run() {

		while (true) {
			repaint();
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
			
			
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponents(g);
	
		for (int i = 0; i < numGhosts; i++) {
			ghost[i].draw(g);
		}
		g.setColor(Color.WHITE);
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		g.setFont(newFont);

		g.drawString("counter: "+score,100,  100);
		g.drawString("Lives",60,60);


		image2 = new ImageIcon(getClass().getResource("Life.jpg"));
		label2 = new JLabel(image2);
		add(label2);


		if(lives==2)
		{
			image4 = new ImageIcon(getClass().getResource("Life.jpg"));
			label4 = new JLabel(image4);
			add(label4);
		}
		if(lives==1)
		{
			image3 = new ImageIcon(getClass().getResource("Life.jpg"));
			label3 = new JLabel(image3);
			add(label3);
		}
		if(lives==0)
		{
			Font Fonts = g.getFont();
			Font newFonts = Fonts.deriveFont(Fonts.getSize() * 6.7F);
			g.setFont(newFont);
			g.drawString("You lose "+score,45,  45);
			for(int i=0; i<listOfFruit.size();i++ )
			{
				listOfFruit.remove(i);
			}

			//for(int i=0; i<listOfCoins.size();i++)
			{
				//coins[i]=listOfCoins.remove(i);
			}
       pacman.draw(g);
		}
	}	


	public void keyPressed (KeyEvent e)
	{
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

		int x = (int)pacman.getX();
		int y = (int)pacman.getY ();

		for( int i=0; i<ghost.length;i++)
		{
			z=(int)ghost[i].getX();
			k=(int)ghost[i].getY();
			r=(int)ghost[i].getRadius();

			differenceY= x-z;
			differenceX=y-k;

			if(differenceY<0|| differenceX<0)
			{
				differenceY=differenceY*-1;
				differenceX= differenceX*-1;

			}
			p= differenceY;
			q= differenceX;
			hypoteneuse=(int) Math.pow((p*p+q*q), 0.5);
			if(hypoteneuse<(r+1))
			{

				lives=lives-1;


			}

		}
		if (lives == 0) {

			for( int i=0; i<listOfFruit.size();i++)
			{
				int z1=listOfFruit.get(i).getX();
				int k1=listOfFruit.get(i).getY();
				int r1=listOfFruit.get(i).getRadius();

				differenceY= x-z1;
				differenceX=y-k1;

				if(differenceY<0|| differenceX<0)
				{
					differenceY=differenceY*-1;
					differenceX= differenceX*-1;

				}
				p= differenceY;
				q= differenceX;
				hypoteneuse=(int) Math.pow((p*p+q*q), 0.5);
				if(hypoteneuse<(r1+1))
				{

					score= score+5;
					listOfFruit.remove(i);
				}



				//for( int i=0; i<coins.length;i++)
				{
					//z1=(int)coin[i].getX();
					//k1=(int)coin[i].getY();
					//r1=(int)coin[i].getRadius();

					//differenceY= x-z1;
					//differenceX=y-k1;

					//if(differenceY<0|| differenceX<0)
					{
						//differenceY=differenceY*-1;
						//differenceX= differenceX*-1;

					}
					//p= differenceY;
					//q= differenceX;
					//hypoteneuse=(int) Math.pow((p*p+q*q), 0.5);
					//if(hypoteneuse<(r1+1))
					{

						score= score+5;
						//coin[i]=listOfCoins.remove(i);
					}
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
	
	public static void main(String args[]) {
		MainPanel gui = new MainPanel();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setTitle("Image Program");
	}
}