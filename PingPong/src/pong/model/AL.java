package pong.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import pong.view.GamePanel;

public class AL extends KeyAdapter{

	public void keyPressed(KeyEvent e) {
		GamePanel.paddle1.keyPressed(e);
		GamePanel.paddle2.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		GamePanel.paddle1.keyReleased(e);
		GamePanel.paddle2.keyReleased(e);
	}
}
