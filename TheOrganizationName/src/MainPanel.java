import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainPanel extends JPanel implements Runnable, KeyListener {
	public int score = 0;
	public int lives = 3;
	int width = 1275;
	int height = 975;
	final int numFood = 1000;
	int numGhosts = 3;
	final int pauseDuration = 50;
	Pacman pacman = new Pacman(x, y, left, right, top, bottom);
	{

	}
	public static ArrayList<PointFruit> listOfFruit = new ArrayList<PointFruit>(numFood);
	Ghosts[] ghost = new Ghosts[numGhosts];


	 
	 	
	public void pacmanPosition() {
		// TODO Auto-generated method stub

	}

	public void pacmanStatus() {
		// TODO Auto-generated method stub

	}

	public MainPanel() {
		this.setPreferredSize(new Dimension(width, height));

		for (int i = 0; i < numGhosts; i++) {
			ghost[i] = new Ghosts(50, 50, 0, width, 0, height);
			ghost[i].setXSpeed(5);
			ghost[i].setXSpeed(5);
			ghost[i].setColor(
					new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

		}
		Thread gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		while (true) {
			repaint();
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		for (int i = 0; i < numGhosts; i++) {
			ghost[i].draw(g);
		}
		g.setColor(Color.WHITE);
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		g.setFont(newFont);
		g.drawString("counter: " + score, 45, 45);
		g.drawString("Lives", 60, 60);
		repaint();
		if (lives == 2) {

		}
		if (lives == 1) {

		}
		if (lives == 0) {

		}

	}

	public void keyPressed(KeyEvent e) {
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
		for (int i = 0; i < fruits.length; i++) {
			z = (int) fruit[i].getX();
			k = (int) fruit[i].getY();
			r = (int) fruit[i].getRadius();

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

				score = score + 5;
				fruit[i] = listOfFruit.remove(i);
			}

		}

		for (int i = 0; i < coins.length; i++) {
			z = (int) coin[i].getX();
			k = (int) coin[i].getY();
			r = (int) coin[i].getRadius();

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

				score = score + 5;
				coin[i] = listOfCoins.remove(i);
			}

		}

	}

	public void keyReleased(KeyEvent e) {

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
	// EventListenerDemo class
}
