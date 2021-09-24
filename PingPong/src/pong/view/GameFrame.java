package pong.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	final GamePanel panel;
	
	public GameFrame() {
		panel = new GamePanel();
		add(panel);
		setVisible(true);
		setTitle("Ping Pong Game");
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	

	
}
