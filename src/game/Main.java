package game;

import javax.swing.JFrame;

import core.Core;
import game.scene.Scene_1;
import game.scene.Scene_2;

public class Main {
	public static void main(String[] args) {

		JFrame frame = new JFrame("My Game");
		Core main = new Core(new Scene_2());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(main.renderer);		
		frame.setResizable(false);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		main.start();
	}
}
