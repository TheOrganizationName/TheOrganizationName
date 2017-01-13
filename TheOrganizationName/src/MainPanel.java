import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import objects.Student;

public class MainPanel extends JPanel implements Runnable, KeyListener{
	public int score=0;
	int width = 1275;
	int height = 975;
	
	final int numFood = 1000;
	public static ArrayList <PointFruit> listOfStudents= new ArrayList<PointFruit>(numFood);
	
	public void pacmanPosition() {
		// TODO Auto-generated method stub
		
	}
	
	

	 
	public void pacmanStatus() {
		// TODO Auto-generated method stub

}
	
	public static void eatPoint(pacmanPosition,){
		if (pacman.X == pointFruit.X && pacman.Y ==pointFruit){
			
		}
		foodNum = numFood-1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
    	
		int x = pacman.getX ();
		int y = pacman.getY ();
		
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

	


