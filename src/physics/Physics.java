package physics;

import java.util.ArrayList;
import java.util.List;

import component.Collider;
import component.Rigidbody;
import math.Vector2;

public class Physics{
	
	private static List<Rigidbody> bodies;
	private static List<Collider> colliders;
	
	public Physics(){
		bodies = new ArrayList<Rigidbody>();
		colliders = new ArrayList<Collider>();
	}
	
	public static void addRigidbody(Rigidbody rb){
		bodies.add(rb);
	}
	
	public static void addCollider(Collider col){
		colliders.add(col);
	}
	
	public static void removeFromRigidbody(Rigidbody rb){
		bodies.remove(rb);
	}
	
	public static void removeFromCollider(Collider col){
		colliders.remove(col);
	}
	
	public void update() {
		// Check collision
		for (int i = 0; i < colliders.size(); i++){
			for (int j = i+1; j < colliders.size(); j++){
				
				Vector2 ret = (colliders.get(i).collide(colliders.get(j)));
				Rigidbody rb1 = colliders.get(i).object.getComponent(Rigidbody.class);
				Rigidbody rb2 = colliders.get(j).object.getComponent(Rigidbody.class);
				
				if(ret != null){
					if(rb1 != null)
						rb1.velocitay = Vector2.reflect(rb1.velocitay, ret); 
					if(rb2 != null)
						rb2.velocitay = Vector2.reflect(rb2.velocitay, ret.invert());
				}
			}	
		}
		
		// Move the Rigidbodies
		for (int i = 0; i < bodies.size(); i++){
			bodies.get(i).transform().position = bodies.get(i).transform().position.add(bodies.get(i).velocitay);
		}
	}
}
