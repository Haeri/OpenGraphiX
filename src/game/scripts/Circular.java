package game.scripts;

import component.GraphiXScript;
import core.GraphiXObject;

public class Circular extends GraphiXScript {

	public float size = 600;
			
	public Circular(GraphiXObject object) {
		
		//define shape of the body.
//		CircleShape cs = new CircleShape();
//		cs.m_radius = (float)radius;  
		
		super(object);
	}

	public void Update(){
		if(transform().position.getx()> size) transform().position.setx(((transform().position.getx() + size) % size) - size);
		if(transform().position.getx()< -size) transform().position.setx(((transform().position.getx() - size) % size) + size);
		if(transform().position.gety()> size) transform().position.sety(((transform().position.gety() + size) % size) - size);
		if(transform().position.gety()< -size) transform().position.sety(((transform().position.gety() - size) % size) + size);
	}
	
}
