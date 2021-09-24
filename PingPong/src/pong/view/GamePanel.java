package pong.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

import pong.model.Ball;
import pong.model.Paddles;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) GAME_WIDTH * (5/9);
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLES_WIDHT = 25;
	static final int PADDLES_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddles paddle1;
	Paddles paddle2;
	Ball ball;
	Score score;
	
	 public GamePanel() {
		// TODO Auto-generated constructor stub
	}
	 
	 public void draw() {
		// TODO
	 }
	 public void paint() {
		// TODO
	 }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
