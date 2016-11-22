package game.scripts;

import java.awt.Color;

import component.GraphiXScript;
import core.GraphiXObject;
import core.Vector2;
import renderer.Gizmo;

public class Rotator extends GraphiXScript{
	
	public Rotator(GraphiXObject object) {
		super(object);
	}

	public void Update(){
//		object.transform.rotation += 0.01; 
		object.transform.scale.x += 0.01;
		object.transform.scale.y += 0.01;
	}

}
