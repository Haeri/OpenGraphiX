package render.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import core.GameObject;
import core.Vector2f;

public class CircleRenderer extends ObjectRenderer{

	private double radius;
	private Color color;
	
	public CircleRenderer(double radius, Color color, int order){
		super(order);
		this.radius = radius;
		this.color = color;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		Vector2f pos = object.transform.getTransformation().getTranslation();
		g2d.fillOval((int)(pos.getx() - radius), (int)(pos.gety() - radius), (int)(radius * 2 * object.transform.scale.getx()), (int)(radius * 2 * object.transform.scale.gety()));
	}
}
