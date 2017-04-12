package primitives;

import core.GameObject;
import core.Vector2f;
import game.scripts.CameraController;
import render.Renderer;

public class Camera extends GameObject {

	public static Camera main;

	public Camera() {
		super();
		if (main == null)
			main = this;
	}

	public static Vector2f getMVP() {
		if (main == null)
			try {
				throw new NoMainCameraException("There is no main camera in the scene");
			} catch (NoMainCameraException e) {
				e.printStackTrace();
			}
		return new Vector2f(main.transform.position.getx() - Renderer.WIDTH / 2,
				main.transform.position.gety() - Renderer.HEIGHT / 2);
	}
}

class NoMainCameraException extends Exception {
	private static final long serialVersionUID = 1L;

	// Parameterless Constructor
	public NoMainCameraException() {
	}

	// Constructor that accepts a message
	public NoMainCameraException(String message) {
		super(message);
	}
}