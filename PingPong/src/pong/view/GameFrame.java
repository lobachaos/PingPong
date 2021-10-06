package pong.view;

import javax.swing.JFrame;

import pong.model.GamePanel;

@SuppressWarnings("serial")

public class GameFrame extends JFrame {
	
	 GamePanel panel;
	
	public GameFrame() {
		panel = new GamePanel();
		add(panel);
		setVisible(true);
		setTitle("Ping Pong Game");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	

	
}
