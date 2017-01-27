package primitives;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import component.ObjectRenderer;
import core.GraphiXObject;
import javafx.scene.transform.MatrixType;
import physics.Physics;
import physics.RectCollider;
import render.Renderer;

public class GO_Rect extends GraphiXObject {
	public float width;
	public float height;

	public Color color;
	
	public Body body;
	public BodyDef aboutFloor;

	public GO_Rect(float width, float height, Color color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;

		// addComponent(new Rigidbody(this));
//		addComponent(new RectCollider(width, height, this));
		addComponent(new ObjectRenderer(this, 0) {
			public void draw(Graphics2D g2d) {

				
				transform.position.x = body.getPosition().x; 
				transform.position.y = body.getPosition().y;

				
				AffineTransform tx1 = new AffineTransform();
				tx1.translate(transform.position.x - Camera.getMVP().x, transform.position.y - Camera.getMVP().y);
				tx1.rotate(transform.rotation);
				tx1.scale(transform.scale.x, transform.scale.y);

				g2d.setTransform(tx1);
				g2d.setColor(color);
				g2d.fillRect(-(int)width/2, -(int)height/2, (int) (width), (int) (height));
				
			}
		});

	
		
	
    //Create Floor
    aboutFloor = new BodyDef();
//    aboutFloor.position.set(0.0f, 500.0f); //-8 instead of -10 so I can see it
    PolygonShape groundBox = new PolygonShape();
    groundBox.setAsBox(width/2, height/2); // top lands at 0 aka floor

    body = Physics.world.createBody(aboutFloor);
    body.createFixture(groundBox, 0.0f);

	}
}