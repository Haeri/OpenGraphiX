package physics.component;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;

import core.Bounds;
import core.GameObject;
import core.Vector2f;

public class RectCollider extends Collider {

	public Vector2f topLeft;
	public Vector2f topRight;
	public Vector2f bottomLeft;
	public Vector2f bottomRight;
	public Vector2f pivot;
	public float width;
	public float height;
	
	public PolygonShape ps;

	public RectCollider(float width, float height) {
		this(Vector2f.ZERO, width, height);
	}
		
	public RectCollider(Vector2f pivot, float width, float height) {
		this.width = width;
		this.height = height;
		this.pivot = pivot;
		
		this.topLeft = new Vector2f(-width/2, -height/2);
		this.topRight = new Vector2f(width/2, -height/2);
		this.bottomLeft = new Vector2f(-width/2, height/2);
		this.bottomRight = new Vector2f(width/2, height/2);			
		
		type = ColliderType.RECT;
	}
	
	public void drawGizmo(){
	//	Gizmo.drawRect(transform().position, width * transform().scale.x, height * transform().scale.y, Color.GREEN);
	}
	
	public Vector2f toWorld(Vector2f vec){
		return new Vector2f(transform().position.getx() + (vec.getx() * transform().scale.getx()), transform().position.gety() + (vec.gety() * transform().scale.gety()));
	}
//	
//	public Vector2 topLeft(){
//		return new Vector2(transform().position.x - width/2, transform().position.y - height/2);
//	}
//	
//	public Vector2 topRight(){
//		return new Vector2(topLeft().x + width, topLeft().y);
//	}
//	
//	public Vector2 bottomLeft(){
//		return new Vector2(topLeft().x, topLeft().y + height);
//	}
//	
//	public Vector2 bottomRight(){
//		return new Vector2(topLeft().x + width, topLeft().y + height);
//	}
	


	public Vector2f collide(Collider other) {
		Vector2f ret = null;

		switch (other.type) {
		case CIRCLE:
	//		CircleCollider circleCol = (CircleCollider)other;
	//		
	//		Vector2 test = new Vector2(transform().position.x, transform().position.y);
	//		
	//		boolean isInsideX = false;
	//		boolean isInsideY = false;
	//		
	//		if(object.transform.position.x <= toWorld(topLeft).x-circleCol.getRadius()) {
	//			test.x = toWorld(topLeft).x;
	//		}else if(object.transform.position.x >= toWorld(topRight).x+circleCol.getRadius()) {
	//			test.x = toWorld(topRight).x;
	//		}else{
	//			test.x = object.transform.position.x;
	//			isInsideX = true;
	//		}
	//		
	//		if(object.transform.position.y <= toWorld(topLeft).y-circleCol.getRadius()){
	//			test.y = toWorld(topLeft).y;
	//		}else if(object.transform.position.y >= toWorld(bottomLeft).y+circleCol.getRadius()) {
	//			test.y = toWorld(bottomLeft).y;
	//		}else{
	//			test.y = object.transform.position.y;
	//			isInsideY = true;
	//		}
	//		
	//		float cdist = test.sub(object.transform.position).squareMagnitude();
	//		
	//		if(circleCol.getRadius() * circleCol.getRadius() >= cdist || (isInsideX && isInsideY)){
	//			ret = object.transform.position.sub(test).normalize();
	//			System.out.println("Yes");
	//		}
	//			
			
			break;
		case LINE:

			break;
		case POINT:
			break;
		case POLLY:
			break;
		case RECT:
			
			
			break;
		default:
			ret = null;
			break;
		}

		return ret;
	}

	@Override
	public Bounds getBounds() {
		return new Bounds(toWorld(topLeft), toWorld(bottomRight));
	}

	@Override
	public Shape getShape() {
		return ps;
	}
}
