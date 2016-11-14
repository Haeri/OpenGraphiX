package primitives;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import core.GraphiXObject;

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
			public void draw(Graphics g) {
				g.setColor(GO_Text.this.color);
				g.drawString(GO_Text.this.text, (int)object.transform.position.x, (int)object.transform.position.y);
			}
		});
	}
}