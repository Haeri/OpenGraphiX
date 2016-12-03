package game.scripts;

import java.awt.Color;

import component.GraphiXScript;
import core.GraphiXObject;
import core.InputManager;
import core.Vector2;
import render.Gizmo;

public class Rotator extends GraphiXScript{
	
	public Rotator(GraphiXObject object) {
		super(object);
	}

	public void Update(){
//		object.transform.rotation += 0.01; 
//		object.transform.scale.x += 0.01;
//		object.transform.scale.y += 0.01;
//		object.transform.position.y += 0.01;
		
		if(InputManager.KEY_UP) transform().position.y -= 1;
		if(InputManager.KEY_DOWN) transform().position.y += 1;
		if(InputManager.KEY_LEFT) transform().position.x -= 1;
		if(InputManager.KEY_RIGHT) transform().position.x += 1;
		
	}

}
