package primitives;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;
import physics.CircleCollider;

public class Circle extends GraphiXObject {
	public double radius;
	public Color color;

	public Circle(double radius, Color color){
		super();		
		addComponent(new CircleCollider(radius, this));
		addComponent(new Rigidbody(this));
		addComponent(new ObjectRenderer(this) {
			public void draw(Graphics g, int order) {
				g.setColor(color);
				g.fillOval((int)(transform.position.x - radius), (int)(transform.position.y - radius), (int)(radius * 2 * transform.scale.x), (int)(radius * 2 * transform.scale.y));
			}
		});
		
		this.radius = radius;
		this.color = color;
	}
}
