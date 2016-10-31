package renderer;

import java.awt.Graphics;

import component.ObjectRenderer;
import game.RectangleObject;

public class RectRenderer extends ObjectRenderer {

	private RectangleObject rect;
	
	public RectRenderer(RectangleObject rect, int order) {
		super(rect, order);
		this.rect = rect;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(rect.color);
		g.fillRect((int)(rect.transform.position.x - rect.width/2), (int)(rect.transform.position.y - rect.height/2), (int)(rect.width * rect.transform.scale.x), (int)(rect.height * rect.transform.scale.y));
	}	
}
