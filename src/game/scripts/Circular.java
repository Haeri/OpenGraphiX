package game.scripts;

import core.GameObject;
import core.component.GXScript;

public class Circular extends GXScript {

	public float size = 600;
			
	public Circular() {
		
		//define shape of the body.
//		CircleShape cs = new CircleShape();
//		cs.m_radius = (float)radius;  

	}

	public void Update(){
		if(transform().position.getx()> size) transform().position.setx(((transform().position.getx() + size) % size) - size);
		if(transform().position.getx()< -size) transform().position.setx(((transform().position.getx() - size) % size) + size);
		if(transform().position.gety()> size) transform().position.sety(((transform().position.gety() + size) % size) - size);
		if(transform().position.gety()< -size) transform().position.sety(((transform().position.gety() - size) % size) + size);
	}
	
}
