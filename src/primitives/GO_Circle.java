package primitives;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;
import physics.CircleCollider;
import game.scripts.Rotator;
import javafx.scene.transform.Rotate;

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
			public void draw(Graphics g) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(GO_Circle.this.color);

				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.x, transform.position.y);
//				tx1.rotate(transform.rotation);
//				tx1.scale(transform.scale.x, transform.scale.y);

				g2d.setTransform(tx1);
				g2d.fillOval(-(int)(radius * transform.scale.x), -(int)(radius * transform.scale.x), (int)(radius*2* transform.scale.x), (int)(radius*2* transform.scale.x));

				g2d.dispose();
			}
		});
//		addComponent(new Rotator(this));
	}
}
