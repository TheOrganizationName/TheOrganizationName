import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWindow {
	JPanel newPanel = new JPanel();
	ImageIcon image = new ImageIcon("image/map.jpg");
	JLabel label = new JLabel("", image, JLabel.CENTER);
	JPanel panel = new JPanel(new BorderLayout());
	panel.add (label, BorderLayout.CENTER );
}
