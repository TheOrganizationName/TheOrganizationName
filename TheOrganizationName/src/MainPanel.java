import java.util.ArrayList;
import java.awt.Color;
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
	Pacman pacman=new Pacman( x,  y, left,  right,top, bottom);
	{
		
	}
	public static ArrayList <PointFruit> listOfFruit= new ArrayList<PointFruit>(numFood);
	PointFruit bananas = new PointFruit();
	public void pacmanPosition() {
		// TODO Auto-generated method stub
		
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
			g.drawString("counter: "+score,45,  45);
			g.drawString("Lives",60,60);
			
			if(lives==2)
			{

			}
			if(lives==1)
			{
				
			}
			if(lives==0)
			{
				
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

	


