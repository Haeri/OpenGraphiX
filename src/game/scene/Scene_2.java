package game.scene;

import java.awt.Color;
import java.util.Random;

import component.Rigidbody;
import core.Scene;
import core.Vector2;
import game.gameobjects.Player;
import physics.CircleCollider;
import primitives.Camera;
import primitives.GO_Circle;
import primitives.GO_Rect;
import render.Gizmo;
import render.Renderer;

public class Scene_2 extends Scene {


	public void Start() {
		
		Camera cam = new Camera();
				
		Gizmo.isEnable = false;
		
		
//		Random rand = new Random(515);
//        for(int i = 0; i < 1000; i++){
//            GO_Circle c1 = new GO_Circle(/*Math.random() * */ 1, Color.RED);
//            c1.transform.position = new Vector2((rand.nextDouble() * Renderer.WIDTH-200)+100, (rand.nextDouble() * Renderer.HEIGHT-200) + 100);
//            ((Rigidbody)c1.getComponent(Rigidbody.class)).mass = 1;
//            ((Rigidbody)c1.getComponent(Rigidbody.class)).addForce(new Vector2(rand.nextDouble()*6-3, rand.nextDouble()*6-3));
//            ((CircleCollider)c1.getComponent(CircleCollider.class)).elasticity = 1;
//        }
		
		
		for(int i = 0; i < 6; i++){
			GO_Circle c1 = new GO_Circle(/*Math.random() * */ 20, Color.RED);
			c1.transform.position = new Vector2((Math.random() * Renderer.WIDTH-200)+100, (Math.random() * Renderer.HEIGHT-200) + 100);
			((Rigidbody)c1.getComponent(Rigidbody.class)).mass = 3;
			((Rigidbody)c1.getComponent(Rigidbody.class)).addForce(new Vector2(Math.random()*3-1.5, Math.random()*3-1.5));
			   ((CircleCollider)c1.getComponent(CircleCollider.class)).elasticity = 0.87;
		}
//		
		
//		GO_ParticleSystem c1 = new GO_ParticleSystem(10);
//		c1.transform.position = new Vector2((Math.random() * Renderer.WIDTH-200)+100, (Math.random() * Renderer.HEIGHT-200) + 100);
//		((Rigidbody)c1.getComponent(Rigidbody.class)).addForce(new Vector2(Math.random()*5-2.5, Math.random()*5-2.5));
//		
//		GO_ParticleSystem c2 = new GO_ParticleSystem(10);
//		c2.transform.position = new Vector2((Math.random() * Renderer.WIDTH-200)+100, (Math.random() * Renderer.HEIGHT-200) + 100);
//		((Rigidbody)c2.getComponent(Rigidbody.class)).addForce(new Vector2(Math.random()*5-2.5, Math.random()*5-2.5));
		
//		Vector2 force = new Vector2(20, 20);
//		
//		GO_Circle c1 = new GO_Circle(40.0, Color.RED);
//		c1.transform.position = new Vector2(-100, 13);
//		((Rigidbody)c1.getComponent(Rigidbody.class)).mass = 1;
//		((CircleCollider)c1.getComponent(CircleCollider.class)).elasticity = 0.8;
//		((Rigidbody)c1.getComponent(Rigidbody.class)).addForce(new Vector2(-2.4, -20.2));
//		
		
//		GO_Circle c2 = new GO_Circle(10.0, Color.RED);
//		c2.transform.position = new Vector2(100, 13);
//		((Rigidbody)c2.getComponent(Rigidbody.class)).mass = 1;
//		((Rigidbody)c2.getComponent(Rigidbody.class)).addForce(Vector2.LEFT);
//		
//		GO_Circle c3 = new GO_Circle(10.0, Color.RED);
//		c3.transform.position = new Vector2(-100, 100);
//		((Rigidbody)c3.getComponent(Rigidbody.class)).mass = 1;
//		((Rigidbody)c3.getComponent(Rigidbody.class)).addForce(Vector2.RIGHT);
//		
//		GO_Circle c4 = new GO_Circle(10.0, Color.RED);
//		c4.transform.position = new Vector2(100, 100);
//		((Rigidbody)c4.getComponent(Rigidbody.class)).mass = 1;
//		((Rigidbody)c4.getComponent(Rigidbody.class)).addForce(Vector2.LEFT);
//		
//		
		
//		int max = 2;
//		
//		for(int i = 0; i < max; i++){
//			GO_Circle c1 = new GO_Circle(20.0, Color.RED);
//			c1.transform.position = new Vector2(-200, i*80);
//			((Rigidbody)c1.getComponent(Rigidbody.class)).mass = 1;
//			((Rigidbody)c1.getComponent(Rigidbody.class)).addForce(Vector2.RIGHT);
//			
//			GO_Circle c2 = new GO_Circle(20.0, Color.RED);
//			c2.transform.position = new Vector2(200, i*80);
//			((Rigidbody)c2.getComponent(Rigidbody.class)).mass = 1;
//			((Rigidbody)c2.getComponent(Rigidbody.class)).addForce(Vector2.LEFT);
//			((CircleCollider)c2.getComponent(CircleCollider.class)).elasticity = 0.4;
//			
			
//			GO_Circle c3 = new GO_Circle(20.0, Color.RED);
//			c3.transform.position = new Vector2(i*80, -200);
//			((Rigidbody)c3.getComponent(Rigidbody.class)).mass = 1;
//			((Rigidbody)c3.getComponent(Rigidbody.class)).addForce(Vector2.DOWN);
//			
//			GO_Circle c4 = new GO_Circle(20.0, Color.RED);
//			c4.transform.position = new Vector2(i*80, 200);
//			((Rigidbody)c4.getComponent(Rigidbody.class)).mass = 1;
//			((Rigidbody)c4.getComponent(Rigidbody.class)).addForce(Vector2.UP);
//		}
		
		
		
//		GO_Circle c3 = new GO_Circle(20.0, Color.RED);
//		c3.transform.position = new Vector2(0, 0);
//		((Rigidbody)c3.getComponent(Rigidbody.class)).mass = 1;
//		((Rigidbody)c3.getComponent(Rigidbody.class)).addForce(new Vector2(-1, -1));
//		
//		GO_Circle c4 = new GO_Circle(20.0, Color.RED);
//		c4.transform.position = new Vector2(-200, -200);
//		((Rigidbody)c4.getComponent(Rigidbody.class)).mass = 1;
//		((Rigidbody)c4.getComponent(Rigidbody.class)).addForce(Vector2.ONE);
		
		
//		
//		GO_Circle c3 = new GO_Circle(10.0, Color.RED);
//		c3.transform.position = new Vector2(500, 200);
//		((Rigidbody)c3.getComponent(Rigidbody.class)).mass = 10;
//		((Rigidbody)c3.getComponent(Rigidbody.class)).addForce(force);
//		
//		GO_Circle c4 = new GO_Circle(90.0, Color.RED);
//		c4.transform.position = new Vector2(700, 200);
//		((Rigidbody)c4.getComponent(Rigidbody.class)).mass = 90;
//		((Rigidbody)c4.getComponent(Rigidbody.class)).addForce(force);
		
		
//		GO_Rect qtop = new GO_Rect(Renderer.WIDTH, 20.0, Color.DARK_GRAY);
//		qtop.transform.position = new Vector2(Renderer.WIDTH / 2, -10);
//
        
//		Player p = new Player(20, 50.0, Color.BLUE);
//		p.transform.position = new Vector2(0, 0);
//		
		GO_Rect qbot = new GO_Rect(Renderer.WIDTH, 50.0, Color.DARK_GRAY);
		qbot.transform.position = new Vector2(0, 300);
//		
		
//		GO_Rect bot = new GO_Rect(50, 100.0, Color.DARK_GRAY);
//		bot.transform.position = new Vector2(100, -100);
//		
//
//		GO_Rect qleft = new GO_Rect(20, Renderer.HEIGHT, Color.DARK_GRAY);
//		qleft.transform.position = new Vector2(-10, Renderer.HEIGHT / 2);
//
//		GO_Rect qright = new GO_Rect(20, Renderer.HEIGHT, Color.DARK_GRAY);
//		qright.transform.position = new Vector2(Renderer.WIDTH + 10, Renderer.HEIGHT / 2);
	}
}
