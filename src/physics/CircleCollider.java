package physics;

import component.Collider;
import core.GraphiXObject;
import core.Vector2;

public class CircleCollider extends Collider{

	public double radius;
		
	public CircleCollider(double radius, boolean isTrigger, GraphiXObject object){
		super(object);
		super.isTrigger = isTrigger;
		
		this.radius = radius;
		type = ColliderType.CIRCLE;
	}
	
	public double getRadius(){
		return radius * object.transform.scale.x;
	}
	
	public Vector2 collide(Collider other){
		Vector2 ret = null;
		
		switch (other.type){
			case CIRCLE:
				CircleCollider circleCol = (CircleCollider)other;
				double radDist = getRadius() + circleCol.getRadius();
				double dist = circleCol.object.transform.position.sub(object.transform.position).squareMagnitude();
				if(radDist * radDist >= dist)
					ret = object.transform.position.sub(circleCol.object.transform.position).normalize();
				break;
			case LINE:
				
				break;
			case POINT:
				break;
			case POLLY:
				break;
			case RECT:
				RectCollider rectCol = (RectCollider)other;
				Vector2 test = rectCol.transform().position.clone();
				
				boolean isInsideX = false;
				boolean isInsideY = false;
				
				if(object.transform.position.x <= rectCol.toWorld(rectCol.topLeft).x-getRadius()) {
					test.x = rectCol.toWorld(rectCol.topLeft).x;
				}else if(object.transform.position.x >= rectCol.toWorld(rectCol.topRight).x+getRadius()) {
					test.x = rectCol.toWorld(rectCol.topRight).x;
				}else{
					test.x = object.transform.position.x;
					isInsideX = true;
				}
				
				if(object.transform.position.y <= rectCol.toWorld(rectCol.topLeft).y-getRadius()){
					test.y = rectCol.toWorld(rectCol.topLeft).y;
				}else if(object.transform.position.y >= rectCol.toWorld(rectCol.bottomLeft).y+getRadius()) {
					test.y = rectCol.toWorld(rectCol.bottomLeft).y;
				}else{
					test.y = object.transform.position.y;
					isInsideY = true;
				}
				
				double cdist = test.sub(object.transform.position).squareMagnitude();
				
//				if(isInsideX && isInsideY){
//					System.out.println("INSIDE");
////					test = rectCol.transform().position.clone();
//					ret = object.transform.position.sub(test).normalize();
//				}else 
				if(getRadius() * getRadius() >= cdist && (isInsideX && isInsideY)){
					System.out.println(object.transform.position + " " + test);
					ret = object.transform.position.sub(test).normalize();
					System.out.println("CONTACT " + ret);
				}
				
				break;
			default:
				ret = null;
				break;
		}
		
		return ret;
	}
}
