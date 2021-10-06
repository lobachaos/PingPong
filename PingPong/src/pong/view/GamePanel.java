package pong.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

import pong.model.AL;
import pong.model.Ball;
import pong.model.Paddles;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLES_WIDHT = 25;
	static final int PADDLES_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	public static Paddles paddle1;
	public static Paddles paddle2;
	Ball ball;
	Score score;
	
	 public GamePanel() {
		 newPaddlesG();
		 newBall();
		 score = new Score(GAME_WIDTH,GAME_HEIGHT);
		 setFocusable(true);
		 this.addKeyListener(new AL());
		 setPreferredSize(SCREEN_SIZE);
		 gameThread = new Thread(this);
		 gameThread.start();
	}
	 
	 public void  newPaddlesG() {
			paddle1 = new Paddles(0,(GAME_HEIGHT/2) - (PADDLES_HEIGHT / 2),PADDLES_WIDHT, PADDLES_HEIGHT,1);
			paddle2 = new Paddles(GAME_WIDTH - PADDLES_WIDHT,(GAME_HEIGHT/2) - (PADDLES_HEIGHT / 2),PADDLES_WIDHT, PADDLES_HEIGHT,2);
		}
	
	 
	 public void draw(Graphics g) {
		 paddle1.draw(g);
		 paddle2.draw(g);
	 }
	 public void paint(Graphics g) {
		 image = createImage(getWidth(),getHeight());
		 graphics = image.getGraphics();
		 draw(graphics);
		 g.drawImage(image,0,0,this);
	 }

	private void checkCollision() {
		// TODO Auto-generated method stub
		
	}

	private void move() {
		// TODO Auto-generated method stub
		
	}
	
	public void newBall() {
		
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amoutOfTicks = 60.0;
		double ns = 1000000000 / amoutOfTicks;
		double delta = 0;
		
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns ;
			lastTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
			
		}
		
	}
}


