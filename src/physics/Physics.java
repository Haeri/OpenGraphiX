package physics;

import java.util.ArrayList;
import java.util.List;

import component.Collider;
import component.Rigidbody;
import core.Renderer;
import core.Vector2;

public class Physics{
	
	public static final Vector2 EARTH = new Vector2(0, 9.81);
	public static final Vector2 SPACE = new Vector2(0, 0);
	
	public static Vector2 gravity;
	
	private static List<Rigidbody> bodies;
	public static List<Collider> colliders;
	
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
	
	public static int getBodies(){
		return bodies.size();
	}
	
	public static int getColliders(){
		return colliders.size();
	}
	
	public static void setGravity(Vector2 g){
		gravity = g;
	}
	
	public void update() {
		
		// Check collision
		for (int i = 0; i < colliders.size()-1; i++){
			for (int j = i+1; j < colliders.size(); j++){
				
				Vector2 ret = (colliders.get(i).collide(colliders.get(j)));
				Rigidbody rb1 = colliders.get(i).getComponent(Rigidbody.class);
				Rigidbody rb2 = colliders.get(j).getComponent(Rigidbody.class);
				
				
				if(ret != null){
					if(colliders.get(i).isTrigger || colliders.get(j).isTrigger){
						colliders.get(i).fire(colliders.get(j));
						colliders.get(j).fire(colliders.get(i));
					}else{
						if(rb1 != null){							
							rb1.velocity = Vector2.reflect(rb1.velocity, ret);
						}
						if(rb2 != null){
							rb2.velocity = Vector2.reflect(rb2.velocity, ret.invert());							
						}
					}
				}
			}	
		}
		
		// Move the Rigidbodies
		for (int i = 0; i < bodies.size(); i++){
			bodies.get(i).addForce(gravity.mul(bodies.get(i).mass));
			bodies.get(i).transform().position = bodies.get(i).transform().position.add(bodies.get(i).velocity);
			
			bodies.get(i).transform().position.x = (bodies.get(i).transform().position.x + Renderer.WIDTH) % Renderer.WIDTH;
			bodies.get(i).transform().position.y = (bodies.get(i).transform().position.y + Renderer.HEIGHT) % Renderer.HEIGHT;
		}
	}
}
