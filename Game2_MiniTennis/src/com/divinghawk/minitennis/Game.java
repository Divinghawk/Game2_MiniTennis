package com.divinghawk.minitennis;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{
	
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);

	public Game() {
		addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
				}

				@Override
				public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}
	
	@Override
	public void paint (Graphics g) {
		super.paint(g); // Clean Screen every action of the Ball for fluent Movement in Screen
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
								RenderingHints.VALUE_ANTIALIAS_ON);
		// Makes the circle smother in graphic on the borders
//		g2d.fillOval(x, y, 30, 30);
		ball.paint(g2d);
		racquet.paint(g2d);
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	public static void main(String[] args) throws InterruptedException{
			JFrame frame = new JFrame ("Mini Tennis"); // 1. Frame initializing Object
			Game game = new Game(); // 6. Game initializing
			frame.add(game);
			//frame.add(new Game2()); // 5. add Class Game2 for configuration Objects
			frame.setSize(300, 400); // 2. Framesize
			frame.setVisible(true); // 3. Framesight
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 4. Frame exit
			
			while (true) {
				game.move();
				game.repaint(); // Object paint every movement
				Thread.sleep(10);
			}
	}
}
