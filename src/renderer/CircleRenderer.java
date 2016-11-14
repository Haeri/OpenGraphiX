package renderer;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import core.GraphiXObject;

public class CircleRenderer extends ObjectRenderer{

	private double radius;
	private Color color;
	
	public CircleRenderer(double radius, Color color, GraphiXObject object, int order){
		super(object, order);
		this.radius = radius;
		this.color = color;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(object.transform.position.x - radius), (int)(object.transform.position.y - radius), (int)(radius * 2 * object.transform.scale.x), (int)(radius * 2 * object.transform.scale.y));
	}
}
