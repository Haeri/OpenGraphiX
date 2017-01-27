package game.scripts;

import component.GraphiXScript;
import core.GraphiXObject;
import core.InputManager;
import core.Vector2;

public class CameraController extends GraphiXScript{

	public float speed = 3;
	private Vector2 direction = new Vector2(0f, 0f);
	
	
	public CameraController(GraphiXObject object) {
		super(object);
	}
	
	public void Update(){
		direction.x = 0;
		direction.y = 0;
		
		if(InputManager.KEY_UP) direction.y = -1;
		if(InputManager.KEY_DOWN) direction.y = 1;
		if(InputManager.KEY_LEFT) direction.x = -1;
		if(InputManager.KEY_RIGHT) direction.x = 1;
		
		transform().position = transform().position.add(direction.normalize().mul(speed));
	}

}
