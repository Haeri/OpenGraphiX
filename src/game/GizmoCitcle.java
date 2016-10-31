package game;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import core.GraphiXObject;

public class GizmoCitcle extends GraphiXObject {
	public double radius;
	public Color color;

	public GizmoCitcle(double radius, Color color){
		super();		
		addComponent(new ObjectRenderer(this, 1) {			
			@Override
			public void draw(Graphics g) {
				g.setColor(color);
				g.fillOval((int)(object.transform.position.x - radius), (int)(object.transform.position.y - radius), (int)(radius * 2 * object.transform.scale.x), (int)(radius * 2 * object.transform.scale.y));
			}
		});
		
		this.radius = radius;
		this.color = color;
	}
}
