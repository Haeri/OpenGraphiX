package physics;

import component.Collider;
import core.Bounds;
import core.GraphiXObject;
import core.Vector2;

public class RectCollider extends Collider {

	public Vector2 topLeft;
	public Vector2 topRight;
	public Vector2 bottomLeft;
	public Vector2 bottomRight;
	public Vector2 pivot;
	public float width;
	public float height;

	public RectCollider(float width, float height, GraphiXObject object) {
		this(Vector2.ZERO, width, height, object);
	}
		
	public RectCollider(Vector2 pivot, float width, float height, GraphiXObject object) {
		super(object);
		this.width = width;
		this.height = height;
		this.pivot = pivot;
		
		this.topLeft = new Vector2(-width/2, -height/2);
		this.topRight = new Vector2(width/2, -height/2);
		this.bottomLeft = new Vector2(-width/2, height/2);
		this.bottomRight = new Vector2(width/2, height/2);			
		
		type = ColliderType.RECT;
	}
	
	public void drawGizmo(){
	//	Gizmo.drawRect(transform().position, width * transform().scale.x, height * transform().scale.y, Color.GREEN);
	}
	
	public Vector2 toWorld(Vector2 vec){
		return new Vector2(transform().position.x + (vec.x * transform().scale.x), transform().position.y + (vec.y * transform().scale.y));
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
	


	public Vector2 collide(Collider other) {
		Vector2 ret = null;

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
}
