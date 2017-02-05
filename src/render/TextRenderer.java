package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import component.ObjectRenderer;
import core.GraphiXObject;
import core.Text;
import primitives.Camera;
import primitives.GO_Text;

public class TextRenderer extends ObjectRenderer{

	private Text text;
	private Color color;
	
	public TextRenderer(Text text, Color color, GraphiXObject object, int order) {
		super(object, order);
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
		g2d.drawString(text.text, (int)object.transform.position.getx(), (int)object.transform.position.gety());
	}

}
