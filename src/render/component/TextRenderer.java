package render.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import core.GameObject;
import primitives.Camera;
import primitives.GO_Text;

public class TextRenderer extends ObjectRenderer{

	public String text;
	private Color color;
	
	public TextRenderer(String text, Color color, int order) {
		super(order);
		this.text = text;
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g2d) {
		AffineTransform tx1 = new AffineTransform();
		tx1.translate(transform().position.getx() - Camera.getMVP().getx(), transform().position.gety() - Camera.getMVP().gety());
		tx1.rotate(transform().rotation);
		tx1.scale(transform().scale.getx(), transform().scale.gety());
		
		g2d.setTransform(tx1);
		g2d.setColor(((GO_Text)object).color);
		g2d.drawString(text, (int)object.transform.position.getx(), (int)object.transform.position.gety());
	}

}
