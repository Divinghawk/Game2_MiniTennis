package com.divinghawk.minitennis;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyboardListener extends JPanel{
			
		public static void main(String[] args) {
				JFrame frame = new JFrame("Mini Tennis");
				KeyboardListener keyboardListener= new KeyboardListener();
				frame.add(keyboardListener);
				frame.setSize(200, 200);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public KeyboardListener() {
			KeyListener listener = new MyKeyListener();
			addKeyListener(listener);
			setFocusable(true);
		}
		
		public class MyKeyListener implements KeyListener {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			}
		}
}
