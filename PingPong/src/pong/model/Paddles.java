package pong.model;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Paddles extends Rectangle {

	int id;
	int yVelocity;
	
	
	public Paddles(int x, int y, int PADDLES_WIDHT, int PADDLES_HEIGHT, int id) {
		super(x, y, PADDLES_WIDHT, PADDLES_HEIGHT);
		this.id = id;

	}

	

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}
	
	public void setYDirection(int y) {
		
	}
	public void move() {
		
	}
	
	public void draw(Graphics g) {
		if(id == 1) {
			g.setColor(Color.blue);
		}
		else {
			g.setColor(Color.red);
		}
		
		g.fillRect(x, y, width, height);
	}

}
