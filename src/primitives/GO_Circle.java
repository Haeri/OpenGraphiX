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

import core.GameObject;
import physics.Physics;
import physics.component.CircleCollider;
import physics.component.Rigidbody;
import render.Renderer;
import render.component.ObjectRenderer;
import game.scripts.Circular;

public class GO_Circle extends GameObject{

	public Color color;
	public double radius;
	
	public GO_Circle(float radius, Color color){
		super();
		
		this.color = color;
		this.radius = radius;
		
		addComponent(new CircleCollider(radius, false));
		addComponent(new Rigidbody());
		addComponent(new ObjectRenderer(10){
			@Override
			public void draw(Graphics2D g2d) {
				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.getx() - Camera.getMVP().getx(), transform.position.gety() - Camera.getMVP().gety());
//				tx1.rotate(transform.rotation);
//				tx1.scale(transform.scale.x, transform.scale.y);

				g2d.setTransform(tx1);
				g2d.setColor(GO_Circle.this.color);
				g2d.fillOval(-(int)(radius * transform.scale.getx()), -(int)(radius * transform.scale.getx()), (int)(radius*2* transform.scale.getx()), (int)(radius*2* transform.scale.getx()));
			}
		});
		addComponent(new Circular());
	}
}
