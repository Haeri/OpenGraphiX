package primitives;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import core.GraphiXObject;
import physics.RectCollider;

public class GO_Rect extends GraphiXObject{
	public double width;
	public double height;
	
	public Color color;

	public GO_Rect(double width, double height, Color color){
		super();
		this.width = width;
		this.height = height;
		this.color = color;
		
		//addComponent(new Rigidbody(this));		
		addComponent(new RectCollider(width, height, this));
		addComponent(new ObjectRenderer(this, 0) {
			public void draw(Graphics g) {
				g.setColor(color);
				g.fillRect((int)(transform.position.x - width/2), (int)(transform.position.y - height/2), (int)(width * transform.scale.x), (int)(height * transform.scale.y));
			}	
		});	
	}
}