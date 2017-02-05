package primitives;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;
import physics.CircleCollider;
import physics.Physics;
import render.Renderer;
import game.scripts.Circular;

public class GO_Circle extends GraphiXObject{

	public Color color;
	public double radius;

	//public Body body;
	//public BodyDef bd;
	
	public GO_Circle(float radius, Color color){
		super();
		
		this.color = color;
		this.radius = radius;
		
		addComponent(new CircleCollider(radius, false, this));
		addComponent(new Rigidbody(this));
		addComponent(new ObjectRenderer(this, 10){
			@Override
			public void draw(Graphics2D g2d) {
//				
				
//				transform.position.x = ((Rigidbody)this.getComponent(Rigidbody.class)).body.getPosition().x; 
//				transform.position.y = ((Rigidbody)this.getComponent(Rigidbody.class)).body.getPosition().y; 
//				transform.position.x = body.getPosition().x; 
//				transform.position.y = body.getPosition().y;

				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.getx() - Camera.getMVP().getx(), transform.position.gety() - Camera.getMVP().gety());
//				tx1.rotate(transform.rotation);
//				tx1.scale(transform.scale.x, transform.scale.y);

				g2d.setTransform(tx1);
				g2d.setColor(GO_Circle.this.color);
				g2d.fillOval(-(int)(radius * transform.scale.getx()), -(int)(radius * transform.scale.getx()), (int)(radius*2* transform.scale.getx()), (int)(radius*2* transform.scale.getx()));
			}
		});
		addComponent(new Circular(this));

	}
}
