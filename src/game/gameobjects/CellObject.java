package game.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import component.ObjectRenderer;
import component.Rigidbody;
import core.GraphiXObject;
import core.Time;
import physics.CircleCollider;
import game.scripts.Cell;
import game.scripts.Rotator;

public class CellObject extends GraphiXObject{

	public double radius;
	public Color color;
	
	public CellObject(double radius, Color color){
		super();
		this.radius = radius;
		this.color = color;
		
		addComponent(new CircleCollider(radius, true, this));
		addComponent(new Rigidbody(this));
		addComponent(new Cell(radius, this));
		addComponent(new ObjectRenderer(this, 1) {			
			@Override
			public void draw(Graphics g) {

				Graphics2D g2d = (Graphics2D) g.create();

				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.x, transform.position.y);
				tx1.rotate(transform.rotation);
				g2d.setTransform(tx1);

				g2d.setColor(CellObject.this.color);
				g2d.fillOval(-(int)(radius * transform.scale.x), -(int)(radius * transform.scale.x), (int)(radius*2* transform.scale.x), (int)(radius*2* transform.scale.x));
				
//				g2d.setColor(Color.GREEN);
//				g2d.drawLine(0, 0, (int)radius, 0);
				
				g2d.setColor(Color.WHITE);
				g2d.drawString((int)((Cell)(CellObject.this.getComponent(Cell.class))).mass + "", -5, 5);
				
				g2d.dispose();
			}
		});
	}
}
