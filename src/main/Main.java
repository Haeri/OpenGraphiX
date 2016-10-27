package main;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;

import component.Rigidbody;
import core.Renderer;
import core.Time;
import core.Vector2;
import physics.Physics;
import primitives.Circle;

public class Main {

	/* Define global constants, e.g. the window size (in pixels). */
	final static int X_WINDOW_SIZE = 800;
	final static int Y_WINDOW_SIZE = 600;

	/* Upper left corner of the window on our screen. */
	final static int X_WINDOW_LOCATION = 100;
	final static int Y_WINDOW_LOCATION = 100;

	final long PHYSICS_TICKRATE = 10;
	final long DRAW_TICKRATE = 10;

	public static boolean running;

	Renderer renderer;
	Physics physics;
	Time time;

	static JFrame frame;
	static Scanner inputReader;

	public static final String TITLE = "GraphiX";

	static Circle c1;	
	
	public static void main(String[] args) {
		frame = new JFrame(TITLE);
		Main main = new Main();

		frame.setBounds(X_WINDOW_LOCATION, Y_WINDOW_LOCATION, X_WINDOW_SIZE, Y_WINDOW_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(main.renderer);
		frame.setVisible(true);
		
		acceptInput();

		main.run();
	}

	private static void acceptInput() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				inputReader = new Scanner(System.in); 
				while (true) {
					System.out.println("Waiting for input...");
					if (inputReader.hasNext()) {
						String input = inputReader.next();
						if (input.equalsIgnoreCase("pause")) {
							System.out.println("pause");
							running = false;
						} else if (input.equalsIgnoreCase("play")) {
							System.out.println("play");
							running = true;
						} else if (input.equalsIgnoreCase("Q")) {
							System.exit(0);
						}else if(input.equalsIgnoreCase("d")){
							System.out.println("Remove");
							c1.destroy();
						}
					}
				}
			}
		});
		
		t.start();
	}

	public Main() {
		renderer = new Renderer();
		renderer.clearFlag = Color.BLACK;

		physics = new Physics();

		time = new Time();

		running = true;

		init();
	}

	public void init() {

		for (int i = 0; i < 50; i++) {
			Circle cX = new Circle(10, new Color((int) (Math.random() * 0x1000000)));
			cX.transform.position = new Vector2(Math.random() * X_WINDOW_SIZE, Math.random() * Y_WINDOW_SIZE);
			Rigidbody rb = cX.getComponent(Rigidbody.class);
			rb.velocitay = new Vector2(Math.random() - 0.5, Math.random() - 0.5).normalize();
		}

		c1 = new Circle(30, Color.RED);
		c1.transform.position = new Vector2(X_WINDOW_SIZE / 2 - 200, Y_WINDOW_SIZE / 2 - 30);
		Rigidbody rb1 = c1.getComponent(Rigidbody.class);
		rb1.velocitay = new Vector2(1, 0);

		// Circle c2 = new Circle(30, Color.GREEN);
		// c2.transform.position = new Vector2(X_WINDOW_SIZE / 2 + 200,
		// Y_WINDOW_SIZE / 2);
		// c2.rigidbody.velocitay = new Vector2(-1, 0);
		//
		// Circle c3 = new Circle(30, Color.BLUE);
		// c3.transform.position = new Vector2(X_WINDOW_SIZE / 2 - 130,
		// Y_WINDOW_SIZE / 2 -130);
		// c3.rigidbody.velocitay = new Vector2(1, 1);
	}

	// Main Loop
	public void run() {
		int fps = 0;
		long lastFpsTime = 0;

		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

		while (running) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);

			time.setDeltaTime(delta);

			input();

			update();
			physics.update();

			render();

			// update the frame counter
			lastFpsTime += updateLength;
			fps++;

			// update FPS
			if (lastFpsTime >= 1000000000) {
				// System.out.println("FPS: " + fps + ", Delta: " + delta);
				frame.setTitle(TITLE + "  -  FPS: " + fps);

				lastFpsTime = 0;
				fps = 0;
			}

			// wait for present
			try {
				Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
			} catch (Exception e) {
			}
		}
	}

	public void input() {

	}

	public void update() {
		// for (int i = 0; i < 50; i++) {
		// if (Math.random() > 0.5) {
		// Circle cX = new Circle(Math.random() * 3, new Color((int)
		// (Math.random() * 0x1000000)));
		// cX.transform.position = new Vector2(X_WINDOW_SIZE / 2, Y_WINDOW_SIZE
		// / 2);
		// Rigidbody rb1 = cX.getComponent(Rigidbody.class);
		// rb1.velocitay = new Vector2(Math.random() - 0.5, Math.random() -
		// 0.5).normalize();
		// } else {
		// double dim = Math.random() * 3;
		// Rect qX = new Rect(dim, dim, new Color((int) (Math.random() *
		// 0x1000000)));
		// qX.transform.position = new Vector2(X_WINDOW_SIZE / 2, Y_WINDOW_SIZE
		// / 2);
		// qX.rigidbody.velocitay = new Vector2(Math.random() - 0.5,
		// Math.random() - 0.5).normalize();
		// }
		// }
	}

	public void render() {
		renderer.repaint();
	}

}
