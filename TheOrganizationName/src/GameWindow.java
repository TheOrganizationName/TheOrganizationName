import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameWindow extends JFrame{
	private ImageIcon image1;
	private JLabel label1;

	GameWindow(){
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource("map.jpg"));
		
		label1 = new JLabel(image1);
		add(label1);
	}
	
	public static void main (String args[]){
		GameWindow gui = new GameWindow();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setTitle("Image Program");
	}
}