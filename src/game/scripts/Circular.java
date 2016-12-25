package game.scripts;

import component.GraphiXScript;
import core.GraphiXObject;

public class Circular extends GraphiXScript {

	public double size = 600;
			
	public Circular(GraphiXObject object) {
		super(object);
	}

	public void Update(){
		if(transform().position.x > size) transform().position.x = ((transform().position.x + size) % size) - size;
		if(transform().position.x < -size) transform().position.x = ((transform().position.x - size) % size) + size;
		if(transform().position.y > size) transform().position.y = ((transform().position.y + size) % size) - size;
		if(transform().position.y < -size) transform().position.y = ((transform().position.y - size) % size) + size;
	}
	
}
