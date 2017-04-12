package game.scripts;

import core.GameObject;
import core.InputManager;
import core.component.GXScript;

public class Rotator extends GXScript{
	
	public Rotator() {
	}

	public void Update(){
//		object.transform.rotation += 0.01; 
//		object.transform.scale.x += 0.01;
//		object.transform.scale.y += 0.01;
//		object.transform.position.y += 0.01;
		
		if(InputManager.KEY_UP) transform().position.sety(transform().position.gety() -1);
		if(InputManager.KEY_DOWN) transform().position.sety(transform().position.gety() + 1);
		if(InputManager.KEY_LEFT) transform().position.setx(transform().position.getx() - 1);
		if(InputManager.KEY_RIGHT) transform().position.setx(transform().position.getx() + 1);
	}

}
