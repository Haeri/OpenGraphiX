package game.scripts;

import component.GraphiXScript;
import core.GraphiXObject;
import core.InputManager;

public class CameraController extends GraphiXScript{

	public CameraController(GraphiXObject object) {
		super(object);
	}
	
	public void Update(){
		if(InputManager.KEY_UP) transform().position.y -= 3;
		if(InputManager.KEY_DOWN) transform().position.y += 3;
		if(InputManager.KEY_LEFT) transform().position.x -= 3;
		if(InputManager.KEY_RIGHT) transform().position.x += 3;
	}

}
