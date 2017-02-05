package primitives;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;
import physics.CircleCollider;
import render.Renderer;
import game.scripts.Circular;

public class GO_Circle extends GraphiXObject{

	public Color color;
	public double radius;
	
	public GO_Circle(double radius, Color color){
		super();
		
		this.color = color;
		this.radius = radius;
		
		addComponent(new Rigidbody(this));
		addComponent(new CircleCollider(radius, false, this));
		addComponent(new ObjectRenderer(this, 1){
			@Override
			public void draw(Graphics2D g2d) {

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
	}
}
