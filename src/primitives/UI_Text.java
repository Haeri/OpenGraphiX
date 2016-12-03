package primitives;

import java.awt.Color;
import java.awt.Graphics2D;

import component.ObjectRenderer;
import core.GraphiXObject;
import render.UIRenderer;

public class UI_Text extends GraphiXObject{

	public String text;
	public Color color;
	
	public UI_Text(String text, Color color){
		super();		
		this.text = text;
		this.color = color;
		
		addComponent(new UIRenderer(this, 10) {
			@Override
			public void draw(Graphics2D g2d) {
				g2d.setColor(((UI_Text)object).color);
				g2d.drawString(UI_Text.this.text, (int)transform.position.x, (int)transform.position.y);
			}
		});
	}
}
