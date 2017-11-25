package physics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import component.Collider;
import component.Rigidbody;
import core.Vector2;
import render.Gizmo;

public class Physics{
	
	public static final Vector2 EARTH = new Vector2(0, 9.81);
	public static final Vector2 SPACE = new Vector2(0, 0);
	
	public static Vector2 gravity;
	
	private static List<Rigidbody> bodies;
	public static CollisionMap collisionMap;
	
	public Physics(){
		bodies = new ArrayList<Rigidbody>();
		collisionMap = new CollisionMap(4000, 4000, 40);
	}
	
	public static void addRigidbody(Rigidbody rb){
		bodies.add(rb);
	}
	
	public static void addCollider(Collider col){
		collisionMap.add(col);
	}
	
	public static void removeFromRigidbody(Rigidbody rb){
		bodies.remove(rb);
	}
	
	public static void removeFromCollider(Collider col){
		collisionMap.remove(col);
	}
	
	public static int getBodies(){
		return bodies.size();
	}
	
	public static int getColliders(){
		return collisionMap.getSize();
	}
	
	public static void setGravity(Vector2 g){
		gravity = g;
	}
	
	public void update() {
		collisionMap.update();

//		ExecutorService executor = Executors.newFixedThreadPool(1);
//		for (int i = 0; i < CollisionMap.colliders.size(); i++){
//			Runnable worker = new WorkerThread(i);
//		    executor.execute(worker);
//		}
//		executor.shutdown();
//		
//		while (!executor.isTerminated()) {
//		}
		
		
		
		for(Map.Entry<Integer, List<Collider>> entry : CollisionMap.map.entrySet()){
			List<Collider> cols = entry.getValue();
			
			for(int i = 0; i < cols.size()-1; i++){
				for(int j = i+1; j < cols.size(); j++){
			
					Vector2 ret = (cols.get(i).collide(cols.get(j)));
					Rigidbody rb1 = cols.get(i).getComponent(Rigidbody.class);
					Rigidbody rb2 = cols.get(j).getComponent(Rigidbody.class);

					if (ret != null) {
//						System.out.println(rb1.object.getID() + " <> " + rb2.object.getID());
						if (cols.get(i).isTrigger || cols.get(j).isTrigger) {
							cols.get(i).fire(cols.get(j));
							cols.get(j).fire(cols.get(i));
						} else {
							if (rb1 != null) {
								rb1.velocity = Vector2.reflect(rb1.velocity, ret);
							}
							if (rb2 != null) {
								rb2.velocity = Vector2.reflect(rb2.velocity, ret.invert());
							}
						}
						Gizmo.drawLine(cols.get(i).transform().position, cols.get(j).transform().position, Color.RED);
					}else
						Gizmo.drawLine(cols.get(i).transform().position, cols.get(j).transform().position, new Color(255, 230, 0, 100));
				}	
			}			
		}
		
		
		
		
		/*
		for (int index = 0; index < CollisionMap.colliders.size(); index++){
			List<Collider> cols = Physics.collisionMap.getNeighbours(CollisionMap.colliders.get(index));
			System.out.println("Thread: " + index);
			for (Collider other : cols) {
				System.out.println(" " + other.object.getID());
				if (other.object.getID() == CollisionMap.colliders.get(index).object.getID())
					continue;
				Vector2 ret = (CollisionMap.colliders.get(index).collide(other));
				Rigidbody rb1 = CollisionMap.colliders.get(index).getComponent(Rigidbody.class);
				Rigidbody rb2 = other.getComponent(Rigidbody.class);

				if (ret != null) {
					System.out.println(rb1.object.getID() + " <> " + rb2.object.getID());
					if (CollisionMap.colliders.get(index).isTrigger || other.isTrigger) {
						CollisionMap.colliders.get(index).fire(other);
						other.fire(CollisionMap.colliders.get(index));
					} else {
						if (rb1 != null) {
							rb1.velocity = Vector2.reflect(rb1.velocity, ret);
						}
						if (rb2 != null) {
							rb2.velocity = Vector2.reflect(rb2.velocity, ret.invert());
						}
					}
				}
				Gizmo.drawLine(other.transform().position, CollisionMap.colliders.get(index).transform().position,
						new Color(255, 230, 0, 100));
			}
			System.out.println();
		}
	        
		*/

		// Check collision		
		
		/*
		for (int i = 0; i < CollisionMap.colliders.size()-1; i++){
			for (int j = i+1; j < CollisionMap.colliders.size(); j++){
				
				Vector2 ret = (CollisionMap.colliders.get(i).collide(CollisionMap.colliders.get(j)));
				Rigidbody rb1 = CollisionMap.colliders.get(i).getComponent(Rigidbody.class);
				Rigidbody rb2 = CollisionMap.colliders.get(j).getComponent(Rigidbody.class);
				
				
				if(ret != null){
					if(CollisionMap.colliders.get(i).isTrigger || CollisionMap.colliders.get(j).isTrigger){
						CollisionMap.colliders.get(i).fire(CollisionMap.colliders.get(j));
						CollisionMap.colliders.get(j).fire(CollisionMap.colliders.get(i));
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
		
		*/
		
		// Move the Rigidbodies
		for (int i = 0; i < bodies.size(); i++){
			bodies.get(i).addForce(gravity.mul(bodies.get(i).mass));
			bodies.get(i).transform().position = bodies.get(i).transform().position.add(bodies.get(i).velocity);
		}
	}
}
