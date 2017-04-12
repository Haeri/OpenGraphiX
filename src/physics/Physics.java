package physics;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import core.Vector2f;
import physics.component.Collider;
import physics.component.Rigidbody;

public class Physics{
	
	public static final Vector2f EARTH = new Vector2f(0, 9.81f);
	public static final Vector2f SPACE = new Vector2f(0, 0);
	
	public static Vector2f gravity = Vector2f.ZERO;
	
	private static List<Rigidbody> bodies;
	public static List<Collider> colliders;
	
	public static World world;
	
	public Physics(){
		bodies = new ArrayList<Rigidbody>();
		colliders = new ArrayList<Collider>();
		
		world = new World(new Vec2(gravity.getx(), gravity.gety()));
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
	
	public static void setGravity(Vector2f g){
		gravity = g;
		world.setGravity(new Vec2(gravity.getx(), gravity.gety()));
	}
	
	public void update() {
		float step = 1.0f/60f;
		world.step(step, 6, 2);				
	}
}
