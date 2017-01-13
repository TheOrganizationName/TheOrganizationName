import javax.swing.JFrame;

public class GameWindow extends JFrame{
	private cImageIcon image2;
	private JLabel label1;

	GameWindow(){
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource("map.jpg"));
		
		label1 = new JLabel(image1);
		add(label1);
	}
	
	public static void main (String args[]){
		GameWindow gui = new GameWindow();
		gui.getDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
}