package renderer;

import java.awt.Graphics;

import component.ObjectRenderer;
import primitives.GO_Rect;

public class RectRenderer extends ObjectRenderer {

	private GO_Rect rect;
	
	public RectRenderer(GO_Rect rect, int order) {
		super(rect, order);
		this.rect = rect;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(rect.color);
		g.fillRect((int)(rect.transform.position.x - rect.width/2), (int)(rect.transform.position.y - rect.height/2), (int)(rect.width * rect.transform.scale.x), (int)(rect.height * rect.transform.scale.y));
	}	
}
