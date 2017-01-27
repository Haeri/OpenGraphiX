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

	public Body body;
	public BodyDef bd;
	
	public GO_Circle(double radius, Color color){
		super();
		
		this.color = color;
		this.radius = radius;
		
//		addComponent(new Rigidbody(this));
//		addComponent(new CircleCollider(radius, false, this));
		addComponent(new ObjectRenderer(this, 1){
			@Override
			public void draw(Graphics2D g2d) {
				
				transform.position.x = body.getPosition().x; 
				transform.position.y = body.getPosition().y;

				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.x - Camera.getMVP().x, transform.position.y - Camera.getMVP().y);
//				tx1.rotate(transform.rotation);
//				tx1.scale(transform.scale.x, transform.scale.y);

				g2d.setTransform(tx1);
				g2d.setColor(GO_Circle.this.color);
				g2d.fillOval(-(int)(radius * transform.scale.x), -(int)(radius * transform.scale.x), (int)(radius*2* transform.scale.x), (int)(radius*2* transform.scale.x));
			}
		});
		addComponent(new Circular(this));
		
		
		
		
		
		
		

		bd = new BodyDef();
		bd.type = BodyType.DYNAMIC;
		bd.setPosition(new Vec2((float)(Math.random() * Renderer.WIDTH-200)+100, (float)(Math.random() * Renderer.HEIGHT-200) + 100));

		//define shape of the body.
		CircleShape cs = new CircleShape();
		cs.m_radius = (float)radius;  
		 
		//define fixture of the body.
		FixtureDef fd = new FixtureDef();
		fd.shape = cs;
		fd.density = 0.5f;
		fd.friction = 0.3f;        
		fd.restitution = 0.5f;
		 
		//create the body and add fixture to it
		body =  Physics.world.createBody(bd);
		body.createFixture(fd);
	}
}
