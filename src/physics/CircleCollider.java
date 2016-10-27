package physics;

import component.Collider;
import core.GraphiXObject;
import math.Vector2;

public class CircleCollider extends Collider implements ICollidable{

	public double radius;
	
	public CircleCollider(double radius, GraphiXObject object){
		super(object);
		
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
				CircleCollider col = (CircleCollider)other;
				double radDist = getRadius() + col.getRadius();
				double dist = col.object.transform.position.sub(object.transform.position).squareMagnitude();
				if(radDist * radDist >= dist)
					ret = object.transform.position.sub(col.object.transform.position).normalize();
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
