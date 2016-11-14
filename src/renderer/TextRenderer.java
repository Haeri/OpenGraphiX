package renderer;

import java.awt.Color;
import java.awt.Graphics;

import component.ObjectRenderer;
import core.GraphiXObject;
import core.Text;
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
	public void draw(Graphics g) {
		g.setColor(((GO_Text)object).color);
		g.drawString(text.text, (int)object.transform.position.x, (int)object.transform.position.y);
	}

}
