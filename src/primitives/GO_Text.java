package primitives;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import component.ObjectRenderer;
import core.GraphiXObject;
import render.Renderer;

public class GO_Text extends GraphiXObject{

	public String text;
	public Color color;
	
	public GO_Text(String text, Color color){
		super();		
		this.text = text;
		this.color = color;
		
//		addComponent(new TextRenderer(text, color, this, 1));
		addComponent(new ObjectRenderer(this, 10) {
			@Override
			public void draw(Graphics2D g2d) {
				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform().position.x - Camera.getMVP().x, transform().position.y - Camera.getMVP().y);
				tx1.rotate(transform().rotation);
				tx1.scale(transform().scale.x, transform().scale.y);
				
				g2d.setColor(((GO_Text)object).color);
				g2d.drawString(GO_Text.this.text, (int)object.transform.position.x, (int)object.transform.position.y);
			}
		});
	}
}
