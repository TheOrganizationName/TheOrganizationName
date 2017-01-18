import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import objects.Student;


public class MainPanel extends JPanel implements Runnable, KeyListener{
	public int score=0;
	public int lives=3;
	int width = 1275;
	int height = 975;
	final int numFood = 1000;
	double x;
	double y;
	int left;
	private ImageIcon image1;
	private JLabel label1;
	private ImageIcon image2;
	private JLabel label2;
	private ImageIcon image3;
	private JLabel label3;
	int right;
	int top;
	int bottom;
	Pacman pacman=new Pacman( x,  y,left, right,  top,  bottom);
	{
		
	}
	public static ArrayList <PointFruit> listOfFruit= new ArrayList<PointFruit>(numFood);

	public void pacmanPosition() {
		// TODO Auto-generated method stub
		
	}
	public GamePanel(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.black);
		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(50, 50, 0, width, 0, height);
			ball[i].setXSpeed(Math.random() * fast-8);
			ball[i].setYSpeed(Math.random() * fast-8);
			ball[i].setColor(new Color((int) (Math.random() * 256), (int) (Math
					.random() * 256), (int) (Math.random() * 256)));
			square[i] = new Square(50, 50, 0, width, 0, height);
			square[i].setXSpeed(Math.random() * fast-8);
			square[i].setYSpeed(Math.random() * fast-8);
			square[i].setColor(new Color((int) (Math.random() * 256), (int) (Math
					.random() * 256), (int) (Math.random() * 256)));
			// sets the speed and color of the balls and squares
		}
		
		Thread gameThread = new Thread(this);
		gameThread.start();

	}
	

	 
	public void pacmanStatus() {
		// TODO Auto-generated method stub

}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void paintComponent(Graphics g) {
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		g.setFont(newFont);
			g.drawString("counter: "+score,100,  100);
			g.drawString("Lives",60,60);
			

			image2 = new ImageIcon(getClass().getResource("Life.png"));
			label2 = new JLabel(image2);
			add(label2);
			
			
			if(lives==2)
			{
				image1 = new ImageIcon(getClass().getResource("Life.png"));
				label1 = new JLabel(image1);
				add(label1);
			}
			if(lives==1)
			{
				image3 = new ImageIcon(getClass().getResource("Life.png"));
				label3 = new JLabel(image3);
				add(label3);
			}
			if(lives==0)
			{
				Font Fonts = g.getFont();
				Font newFonts = Fonts.deriveFont(Fonts.getSize() * 6.7F);
				g.setFont(newFont);
				g.drawString("You lose "+score,45,  45);
				for(int i=0; i<fruits.length;i++ )
				{
				fruit[i]=listOfFruit.remove(i);
				}
				
				for(int i=0; i<coins.length;i++)
				{
				 coin[i]=listOfFruit.remove(i);
				}
				
			}
		
		}
    
    public void keyPressed (KeyEvent e)
    {
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
		
		for( int i=0; i<ghosts.length;i++)
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
		for( int i=0; i<fruits.length;i++)
		{
			z=(int)fruit[i].getX();
			k=(int)fruit[i].getY();
			r=(int)fruit[i].getRadius();
			
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
				
				score= score+5;
				fruit[i]=listOfFruit.remove(i);
			}
			
		}
		
		for( int i=0; i<coins.length;i++)
		{
			z=(int)coin[i].getX();
			k=(int)coin[i].getY();
			r=(int)coin[i].getRadius();
			
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
				
				score= score+5;
				coin[i]=listOfCoins.remove(i);
			}
			
		}

		}

		
	
  
    

    public void keyReleased (KeyEvent e)
     {
 
    }
 
 
     /**
    * called when a character is entered (could be multiple key presses
     * @param e Thekeyboard event
    **/public void keyTyped (KeyEvent e)
    {
    // this space intentionally left blank
    }
     // EventListenerDemo class
  }

	


