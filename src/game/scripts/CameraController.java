package game.scripts;

import core.InputManager;
import core.Time;
import core.Vector2f;
import core.component.GXScript;

public class CameraController extends GXScript{

	public float speed = 3;
	private Vector2f direction = new Vector2f(0f, 0f);
	
	
	public CameraController() {
	}
	
	public void Update(){
		direction.setx(0);
		direction.sety(0);
		
		if(InputManager.KEY_UP) direction.sety(-1);
		if(InputManager.KEY_DOWN) direction.sety(1);
		if(InputManager.KEY_LEFT) direction.setx(-1);
		if(InputManager.KEY_RIGHT) direction.setx(1);
		
		Vector2f dir = direction.normalize().mul(speed).mul((float)Time.deltaTime());
		transform().position = transform().position.add(dir);
	}

}
