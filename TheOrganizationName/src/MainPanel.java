import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import objects.Student;

public class MainPanel extends JPanel implements Runnable, KeyListener{

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
	
	int static eatPoint(pacmanPosition, ){
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

	

}
