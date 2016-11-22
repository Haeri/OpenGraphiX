package primitives;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import component.ObjectRenderer;
import core.GraphiXObject;
import physics.RectCollider;
import game.scripts.Rotator;

public class GO_Rect extends GraphiXObject {
	public double width;
	public double height;

	public Color color;

	public GO_Rect(double width, double height, Color color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;

		// addComponent(new Rigidbody(this));
		addComponent(new RectCollider(width, height, this));
		addComponent(new ObjectRenderer(this, 0) {
			public void draw(Graphics g) {

				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(color);

				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.x, transform.position.y);
				tx1.rotate(transform.rotation);
				tx1.scale(transform.scale.x, transform.scale.y);

				g2d.setTransform(tx1);
				g2d.fillRect(-(int)width/2, -(int)height/2, (int) (width), (int) (height));
				g2d.dispose();
				
			}
		});
	}
}