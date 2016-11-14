package primitives;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;

public class GO_Circle extends GraphiXObject{

	public Color color;
	public double radius;
	
	public GO_Circle(Double radius, Color color){
		super();
		
		this.color = color;
		this.radius = radius;
		
		addComponent(new Rigidbody(this));
		addComponent(new ObjectRenderer(this, 1){
			@Override
			public void draw(Graphics g) {
				g.setColor(GO_Circle.this.color);
				g.fillOval((int)(object.transform.position.x - GO_Circle.this.radius* object.transform.scale.x),
						(int)(object.transform.position.y -  GO_Circle.this.radius* object.transform.scale.y),
						(int)( GO_Circle.this.radius * 2 * object.transform.scale.x),
						(int)( GO_Circle.this.radius * 2 * object.transform.scale.y));
			}
		});
	}
}
