package game.scripts;

import java.awt.Color;

import component.Collider;
import component.GraphiXScript;
import component.Rigidbody;
import core.GraphiXObject;
import core.Vector2;
import physics.CircleCollider;
import physics.CollisionEvent;
import physics.CollisionListener;
import render.Gizmo;
import game.gameobjects.CellObject;

public class CellBehaviour extends GraphiXScript{
	
	public double mass = 0;
	public double speed = 1;
	public Vector2 direction = Vector2.ONE;
	
	private Rigidbody rb;
	private CircleCollider cc;
	
	public CellBehaviour(double mass, GraphiXObject object) {
		super(object);
		
		this.mass = mass;
		
		rb = getComponent(Rigidbody.class);
		cc = getComponent(CircleCollider.class);
		
		cc.addListener(new CollisionListener() {
			
			@Override
			public void onCollisionStay(CollisionEvent e) {}
			
			@Override
			public void onCollisionExit(CollisionEvent e) {}
			
			@Override
			public void onCollisionEnter(Collider collider) {
				CellBehaviour other = collider.object.getComponent(CellBehaviour.class);
				
				if(other != null && CellBehaviour.this.mass > other.mass){
					Gizmo.drawLine(CellBehaviour.this.transform().position, other.transform().position, Color.WHITE);
					if(Vector2.distance(CellBehaviour.this.transform().position, other.transform().position) < (((CellObject)CellBehaviour.this.object).radius) * CellBehaviour.this.object.transform.scale.x)
						eat(other);
				}
			}
		});
	}
	
	public void Update(){
		transform().scale = new Vector2(Math.sqrt(mass), Math.sqrt(mass));
		speed = Math.random() * 0.1;
		direction = new Vector2(Math.random()*2 -1, Math.random()*2 -1);
		
		if(rb.velocity != Vector2.ZERO)
			rb.addForce(rb.velocity.invert().mul(0.01));
		rb.addForce(direction.mul(speed));
		Gizmo.drawLine(transform().position, transform().position.add(rb.velocity.mul(10)), Color.GREEN);
	}
	
	public synchronized void eat(CellBehaviour other){
		mass += other.mass;
		rb.mass = mass;
		other.getEaten();
		
		int c = Math.min(255,(int)(Math.sqrt(mass)/50*255));
		((CellObject)object).color = new Color(255-c, 0, c);
	}
	
	public void getEaten(){
		mass = 0;
		object.destroyGO();
	}
}
