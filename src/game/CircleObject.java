package game;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;
import physics.CircleCollider;
import renderer.CircleRenderer;

public class CircleObject extends GraphiXObject {
	public double radius;
	public Color color;

	public CircleObject(double radius, Color color){
		super();
		this.radius = radius;
		this.color = color;
		
		addComponent(new CircleCollider(radius, this));
		addComponent(new Rigidbody(this));
		//addComponent(new CircleRenderer(radius, color, this, 1));
		addComponent(new ObjectRenderer(this, 1) {			
			@Override
			public void draw(Graphics g) {
				g.setColor(CircleObject.this.color);
				g.fillOval((int)(object.transform.position.x - radius), (int)(object.transform.position.y - radius), (int)(radius * 2 * object.transform.scale.x), (int)(radius * 2 * object.transform.scale.y));
			}
		});
	}
}
