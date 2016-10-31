package physics;

import component.Collider;
import core.GraphiXObject;
import core.Vector2;

public class RectCollider extends Collider {

	public Vector2 topLeft;
	public Vector2 topRight;
	public Vector2 bottomLeft;
	public Vector2 bottomRight;
	public double width;
	public double height;

	public RectCollider(double width, double height, GraphiXObject object) {
		super(object);
		this.width = width;
		this.height = height;
		type = ColliderType.RECT;
		
		topLeft = new Vector2(transform().position.x - width/2, transform().position.y - height/2);
		topRight = new Vector2(topLeft.x + width, topLeft.y);
		bottomLeft = new Vector2(topLeft.x, topLeft.y + height);
		bottomRight = new Vector2(topLeft.x + width, topLeft.y + height);	
		
		System.out.println(topLeft + " " + topRight + " " + bottomLeft + " " + bottomRight);
	}
	
	public Vector2 topLeft(){
		return new Vector2(transform().position.x - width/2, transform().position.y - height/2);
	}
	
	public Vector2 topRight(){
		return new Vector2(topLeft().x + width, topLeft().y);
	}
	
	public Vector2 bottomLeft(){
		return new Vector2(topLeft().x, topLeft().y + height);
	}
	
	public Vector2 bottomRight(){
		return new Vector2(topLeft().x + width, topLeft().y + height);
	}
	


	public Vector2 collide(Collider other) {
		Vector2 ret = null;

		switch (other.type) {
		case CIRCLE:
			CircleCollider circleCol = (CircleCollider)other;
		
		Vector2 test = new Vector2(transform().position.x, transform().position.y);
		
		boolean isInsideX = false;
		boolean isInsideY = false;
		
		if(object.transform.position.x <= topLeft().x-circleCol.getRadius()) {
			test.x = topLeft().x;
		}else if(object.transform.position.x >= topRight().x+circleCol.getRadius()) {
			test.x = topRight().x;
		}else{
			test.x = object.transform.position.x;
			isInsideX = true;
		}
		
		if(object.transform.position.y <= topLeft().y-circleCol.getRadius()){
			test.y = topLeft().y;
		}else if(object.transform.position.y >= bottomLeft().y+circleCol.getRadius()) {
			test.y = bottomLeft().y;
		}else{
			test.y = object.transform.position.y;
			isInsideY = true;
		}
		
		double cdist = test.sub(object.transform.position).squareMagnitude();
		
		if(circleCol.getRadius() * circleCol.getRadius() >= cdist || (isInsideX && isInsideY)){
			ret = object.transform.position.sub(test).normalize();
			System.out.println("Yes");
		}
			
			
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
}
