package pong.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

@SuppressWarnings("serial")
public class Ball extends Rectangle {

	Random random;
	int xVelocity;
	int yVelocity;
	int speed = 3;
	Color color = new Color(255,153,51);

	public Ball(int x, int y, int height, int width) {
		super(x,y,height,width);
		random = new Random();
		int randomX = random.nextInt(2);
			if(randomX == 0) {
				randomX--;
				setXDirection(randomX*speed);
			}
		int randomY = random.nextInt(2);
		if(randomY == 0) {
			randomY--;
			setYDirection(randomY*speed);
		}
		
	}

	public void setYDirection(int randomY) {
		yVelocity = randomY;
	}

	public void setXDirection(int randomX) {
		xVelocity = randomX;
	}

	public void move() {
		x += xVelocity;
		y +=yVelocity;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, height, width);
	}

}
