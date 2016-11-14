package core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import component.GraphiXScript;
import physics.Physics;
import primitives.GO_ParticleSystem;
import primitives.GO_Text;

public class Core {

	public static boolean running;

	public int TARGET_FPS = 60;
	public int FPS = 0;
	
	public Renderer renderer;
	public Physics physics;
	public Time time;

	public static final String TITLE = "GraphiX";

	private static List<GraphiXScript> scripts;

	public GO_Text deltaString;
	public GO_Text drawCallString;
	public GO_Text physicsString;

//	public GizmoCircle mouse;
	public GO_ParticleSystem mouse;
//	public CircleObject mouse;
	
	public Core(Scene scene) {
		renderer = new Renderer();
		renderer.clearFlag = Color.BLACK;

		physics = new Physics();

		time = new Time();

		new Console().start();
		
		scripts = new ArrayList<GraphiXScript>();

		running = true;

		deltaString = new GO_Text("Delta!", Color.WHITE);
		deltaString.transform.position = new Vector2(10, 15);

		drawCallString = new GO_Text("DrawCalls", Color.WHITE);
		drawCallString.transform.position = new Vector2(10, 30);
		
		physicsString = new GO_Text("Physics", Color.WHITE);
		physicsString.transform.position = new Vector2(10, 45);

//		mouse = new GizmoCircle(3, Color.GREEN);
//		mouse = new ParticleSystemObject(1);
//		mouse = new CircleObject(20, Color.GREEN);
		
		
		scene.Start();
	}

	public static void addToUpdate(GraphiXScript gx) {
		scripts.add(gx);
	}

	public static void removeFromUpdate(GraphiXScript gx) {
		scripts.remove(gx);
	}

	// Main Loop
	public void run() {
		
		long lastFpsTime = 0;
		int frameCount = 0;
		long lastLoopTime = System.nanoTime();
		double OPTIMAL_TIME = 1000000000.0 / TARGET_FPS;

		while (running) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);

			time.setDeltaTime(delta);

			input();

			update();

			render();

			// update the frame counter
			lastFpsTime += updateLength;
			frameCount++;

			// update FPS
			if (lastFpsTime >= 1000000000) {
//				 System.out.println("FPS: " + FPS + ", Delta: " + delta);
//				frame.setTitle(TITLE + "  -  FPS: " + FPS);
				FPS = frameCount;
				lastFpsTime = 0;
				frameCount = 0;
			}

			// wait for present
			try {
				Thread.sleep((long) ((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000));
			} catch (Exception e) {
			}
		}
	}

	public void input() {
		if(renderer.getMousePosition() != null && mouse != null){
			mouse.transform.position.x = renderer.getMousePosition().x;
			mouse.transform.position.y = renderer.getMousePosition().y;
		}
	}

	public void update() {
		deltaString.text = "FPS: " + FPS + " | Delta: " + String.format("%.3f", Time.deltaTime());
		drawCallString.text = "Draw Calls: " + Renderer.getDrawCalls();
		physicsString.text = "Rigidbodies: " + Physics.getBodies() + " | Collider: " + Physics.getColliders();

		for (int i = 0; i < scripts.size(); i++) {
			scripts.get(i).Update();
		}
		
		physics.update();
		
		GraphiXObject.finalDestroy();
	}

	public void render() {
		renderer.render();
	}

}
