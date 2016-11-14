package component;

import java.awt.Color;

import core.GraphiXObject;
import core.Vector2;
import primitives.GO_Circle;

public class ParticleSystem extends GraphiXScript{

	public int spawnRate;
	
	public ParticleSystem(int spawnRate, GraphiXObject object) {
		super(object);
		this.spawnRate = spawnRate;
	}
	
	public void Update(){
		for(int i = 0; i < spawnRate; i++){
			GO_Circle cX = new GO_Circle(Math.random() * 3, new Color((int)(Math.random() * 0x1000000)));
			cX.transform.position = object.transform.position.clone();
			Rigidbody rb1 = cX.getComponent(Rigidbody.class);
			rb1.velocity = new Vector2(Math.random() - 0.5, Math.random() - 0.5).normalize();
		}
	}	
}
