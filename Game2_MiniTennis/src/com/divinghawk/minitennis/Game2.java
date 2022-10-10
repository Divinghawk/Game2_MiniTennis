package com.divinghawk.minitennis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game2 extends JPanel {
	
	Ball ball = new Ball(this);
	
	private void move() {
		ball.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game2 game = new Game2();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
	
	
	
//	@Override
//	public void paint(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g; 		// 1. Graphic
//		g2d.setColor(Color.RED);				// 2. Graphics Color	
//		g2d.fillOval(0, 0, 30, 30);				// 3. 1. Graphic position x + y + width + height  
//		g2d.drawOval(0, 50, 30, 30);			// 4. 1. Not filled Graphic position x + y + width + height
//		g2d.fillRect(50, 0, 30, 30);			// 5. 2. Graphic square position x + y + width + height
//		g2d.drawRect(50, 50, 30, 30);			// 6. 2. Not filled Graphic square position x + y + width + height
//		
//		g2d.draw(new Ellipse2D.Double(0,100,30,30)); // 7. 3. Graphic last circle position x + y + width + height
//
//	}
}
