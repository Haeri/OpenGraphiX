package primitives;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;

public class Rect extends GraphiXObject{
	public double width;
	public double height;
	public Color color;

	public Rect(double width, double height, Color color){
		super();		
		addComponent(new Rigidbody(this));
		addComponent(new ObjectRenderer(this) {
			public void draw(Graphics g, int order) {
				g.setColor(color);
				g.fillRect((int)(transform.position.x - width/2), (int)(transform.position.y - height/2), (int)(width * transform.scale.x), (int)(height * transform.scale.y));
			}		
		});
		
		this.width = width;
		this.height = height;
		this.color = color;
	}
}