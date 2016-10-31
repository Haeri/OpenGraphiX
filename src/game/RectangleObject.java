package game;
import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;
import core.Vector2;
import physics.RectCollider;
import renderer.RectRenderer;


public class RectangleObject extends GraphiXObject{
	public double width;
	public double height;
	
	public Color color;

	public RectangleObject(double width, double height, Color color){
		super();
		
		//addComponent(new Rigidbody(this));		
		addComponent(new RectCollider(width, height, this));
		addComponent(new ObjectRenderer(this, 0) {
			public void draw(Graphics g) {
				g.setColor(color);
				g.fillRect((int)(transform.position.x - width/2), (int)(transform.position.y - height/2), (int)(width * transform.scale.x), (int)(height * transform.scale.y));
			}	
		});
		
		this.width = width;
		this.height = height;
		this.color = color;
	}
}