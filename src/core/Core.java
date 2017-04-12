package core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import core.component.GXScript;
import physics.Physics;
import primitives.Camera;
import primitives.UI_Text;
import render.Renderer;

public class Core{

	public static boolean running;

	public int TARGET_FPS = 600;
	public int FPS = 0;
	
	public Renderer renderer;
	public Physics physics;
	public Time time;
	public InputManager inputManager;

	public static final String TITLE = "GraphiX";

	private static List<GXScript> scripts;

	public UI_Text deltaString;
	public UI_Text drawCallString;
	public UI_Text physicsString;

	public Camera mouse;
	
	public Core(Scene scene){
		this(scene, 1000, 600);
	}
	
	public Core(Scene scene, int width, int height) {
		renderer = new Renderer(width, height);
		renderer.clearFlag = new Color(30, 30, 30);

		physics = new Physics();
		Physics.setGravity(Physics.EARTH);
		
		time = new Time();
		
		inputManager = new InputManager();

		new Console().start();
		
		scripts = new ArrayList<GXScript>();

		running = true;

		deltaString = new UI_Text("Delta!", Color.WHITE);
		deltaString.transform.position = new Vector2f(10, 15);

		drawCallString = new UI_Text("DrawCalls", Color.WHITE);
		drawCallString.transform.position = new Vector2f(10, 30);
		
		physicsString = new UI_Text("Physics", Color.WHITE);
		physicsString.transform.position = new Vector2f(10, 45);
		
		scene.Start();
	}

	public static void addToUpdate(GXScript gx) {
		scripts.add(gx);
	}

	public static void removeFromUpdate(GXScript gx) {
		scripts.remove(gx);
	}

	public void runGameLoop(){
		 Thread loop = new Thread()
	      {
	         public void run()
	         {
	            gameLoop();
	         }
	      };
	      loop.start();		
	}
	
	// Main Loop
	public void gameLoop() {
		
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
			mouse.transform.position.setx(renderer.getMousePosition().x);
			mouse.transform.position.sety(renderer.getMousePosition().y);
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
		
		GameObject.finalDestroy();
	}

	public void render() {
		renderer.render();
	}

}



/*

double t = 0.0;
double dt = 0.01;

double currentTime = hires_time_in_seconds();
double accumulator = 0.0;

State previous;
State current;

while ( !quit )
{
    double newTime = time();
    double frameTime = newTime - currentTime;
    if ( frameTime > 0.25 )
        frameTime = 0.25;
    currentTime = newTime;

    accumulator += frameTime;

    while ( accumulator >= dt )
    {
        previousState = currentState;
        integrate( currentState, t, dt );
        t += dt;
        accumulator -= dt;
    }

    const double alpha = accumulator / dt;

    State state = currentState * alpha + 
        previousState * ( 1.0 - alpha );

    render( state );
}
*/