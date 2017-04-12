package game.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import core.GameObject;
import physics.component.RectCollider;
import physics.component.Rigidbody;
import primitives.Camera;
import render.component.ObjectRenderer;
import game.scripts.Rotator;

public class Player extends GameObject {
	public float width;
	public float height;

	public Color color;

	public Player(float width, float height, Color color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;

		addComponent(new Rigidbody());
		addComponent(new RectCollider(width, height));
		addComponent(new ObjectRenderer(0) {
			public void draw(Graphics2D g2d) {

				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.getx()- Camera.getMVP().getx(), transform.position.gety() - Camera.getMVP().gety());
				tx1.rotate(transform.rotation);
				tx1.scale(transform.scale.getx(), transform.scale.gety());

				g2d.setTransform(tx1);
				g2d.setColor(color);
				g2d.fillRect(-(int)width/2, -(int)height/2, (int) (width), (int) (height));
				
			}
		});
		addComponent(new Rotator());
	}
}