package pong.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
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
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		setFocusable(true);
		this.addKeyListener(new PaddleListener());
		setPreferredSize(SCREEN_SIZE);
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2),random.nextInt(GAME_HEIGHT - BALL_DIAMETER), BALL_DIAMETER,
				BALL_DIAMETER);

	}

	public void newPaddlesG() {
		paddle1 = new Paddles(0, (GAME_HEIGHT / 2) - (PADDLES_HEIGHT / 2), PADDLES_WIDHT, PADDLES_HEIGHT, 1);
		paddle2 = new Paddles(GAME_WIDTH - PADDLES_WIDHT, (GAME_HEIGHT / 2) - (PADDLES_HEIGHT / 2), PADDLES_WIDHT,
				PADDLES_HEIGHT, 2);
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}

	private void checkCollision() {

		// bounce ball off top & bottom window edges
		if (ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		// bounce ball off paddles
		if (ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if (ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		// stops paddles at window edges
		if (paddle1.y <= 0)
			paddle1.y = 0;
		if (paddle1.y >= (GAME_HEIGHT - PADDLES_HEIGHT))
			paddle1.y = GAME_HEIGHT - PADDLES_HEIGHT;
		if (paddle2.y <= 0)
			paddle2.y = 0;
		if (paddle2.y >= (GAME_HEIGHT - PADDLES_HEIGHT))
			paddle2.y = GAME_HEIGHT - PADDLES_HEIGHT;

		// give a player 1 point and creates new paddles & ball
		if (ball.x <= 0) {
			score.player2++;
			newPaddlesG();
			newBall();
			System.out.println("Player 2: " + score.player2);
		}
		if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
			score.player1++;
			newPaddlesG();
			newBall();
			System.out.println("Player 1: " + score.player1);
		}

	}

	private void move() {
		paddle1.move();
		paddle2.move();
		ball.move();

	}

	public void run() {
		// Start do Game
		long lastTime = System.nanoTime();
		double amoutOfTicks = 60.0;
		double ns = 1000000000 / amoutOfTicks;
		double delta = 0;

		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}

		}

	}
}
