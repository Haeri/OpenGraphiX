package editor;

import javax.swing.JFrame;

import core.Core;
import game.scene.Scene_2;
import render.Gizmo;

import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainEditor {
	
	public static Console console;
	
	public static void main(String[] args) {

		console = new Console("OpenGraphiX");
		
		JFrame frame = new JFrame(Core.TITLE);
		// Style
		// Changes to System Look and Feel
		try {
			String os = System.getProperty("os.name").toLowerCase();
			if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0) {
				// Special Linux style
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
				UIManager.getLookAndFeelDefaults().put("ScrollPaneUI", "javax.swing.plaf.basic.BasicScrollPaneUI");
			} else {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {}
		
		Core main = new Core(new Scene_2());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
				
				JButton btnPause = new JButton("Pause");
				panel.add(btnPause);
				
				
				JButton btnGizmo = new JButton("Gizmo");
				panel.add(btnGizmo);
	
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(main.renderer);
		splitPane.setLeftComponent(panel);
		frame.getContentPane().add(splitPane, BorderLayout.WEST);				

		
		// Listener
		
		
		// Exit
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				btnPause.setText(Core.running ? "Play" : "Pause");
				Core.running = !Core.running;
				if(Core.running)main.runGameLoop();
			}
		});
		
		// Exit
		btnGizmo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Gizmo.isEnable = !Gizmo.isEnable;
			}
		});
		
		
		frame.setResizable(false);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		main.runGameLoop();
	}
}
