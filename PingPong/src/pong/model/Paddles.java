package pong.model;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Paddles extends Rectangle {

	int id;
	int yVelocity;
	int speed = 10;
	
	
	public Paddles(int x, int y, int PADDLES_WIDHT, int PADDLES_HEIGHT, int id) {
		super(x, y, PADDLES_WIDHT, PADDLES_HEIGHT);
		this.id = id;

	}

	

	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-speed);
				move();
			}else if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-speed);
				move();
			}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(speed);
				move();
			}
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(0);
				move();
			}else if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
				move();
			}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
			}
			break;
		}
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y = y+ yVelocity;
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
