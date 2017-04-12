package primitives;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import core.GameObject;
import render.component.ObjectRenderer;

public class GO_Text extends GameObject{

	public String text;
	public Color color;
	
	public GO_Text(String text, Color color){
		super();		
		this.text = text;
		this.color = color;
		
//		addComponent(new TextRenderer(text, color, this, 1));
		addComponent(new ObjectRenderer(10) {
			@Override
			public void draw(Graphics2D g2d) {
				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform().position.getx() - Camera.getMVP().getx(), transform().position.gety() - Camera.getMVP().gety());
				tx1.rotate(transform().rotation);
				tx1.scale(transform().scale.getx(), transform().scale.gety());
				
				g2d.setColor(((GO_Text)object).color);
				g2d.drawString(GO_Text.this.text, (int)object.transform.position.getx(), (int)object.transform.position.gety());
			}
		});
	}
}
