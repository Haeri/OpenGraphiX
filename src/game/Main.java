package game;

import javax.swing.JFrame;

import core.Core;
import game.scene.Scene_1;

public class Main {
	public static void main(String[] args) {
		Core main = new Core(new Scene_1());
		JFrame frame = new JFrame(Core.TITLE);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(main.renderer);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		main.run();
	}
}
