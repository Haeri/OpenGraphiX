package render.component;

import java.awt.Graphics;
import java.awt.Graphics2D;

import primitives.GO_Rect;

public class RectRenderer extends ObjectRenderer {

	private GO_Rect rect;
	
	public RectRenderer(GO_Rect rect, int order) {
		super(order);
		this.rect = rect;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(rect.color);
		g2d.fillRect((int)(rect.transform.position.getx() - rect.width/2), (int)(rect.transform.position.gety() - rect.height/2), (int)(rect.width * rect.transform.scale.getx()), (int)(rect.height * rect.transform.scale.gety()));
	}	
}
