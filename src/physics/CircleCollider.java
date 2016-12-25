package physics;

import java.awt.Color;

import component.Collider;
import core.Bounds;
import core.GraphiXObject;
import core.Vector2;
import render.Gizmo;

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
	
	public void drawGizmo(){
		Gizmo.drawCircle(transform().position, getRadius(), Color.GREEN);
	}
	
	public Bounds getBounds(){
		return new Bounds(new Vector2(-getRadius()+ transform().position.x, -getRadius()+ transform().position.y), new Vector2(getRadius()+ transform().position.x, getRadius()+ transform().position.y));
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
					isInsideX = true;
					test.x = object.transform.position.x;
				}
				
				if(object.transform.position.y <= rectCol.toWorld(rectCol.topLeft).y-getRadius()){
					test.y = rectCol.toWorld(rectCol.topLeft).y;
				}else if(object.transform.position.y >= rectCol.toWorld(rectCol.bottomLeft).y+getRadius()) {
					test.y = rectCol.toWorld(rectCol.bottomLeft).y;
				}else{
					isInsideY = true;
					test.y = object.transform.position.y;					
				}
				
				if(isInsideX && isInsideY){					
					if(object.transform.position.x <= rectCol.toWorld(rectCol.topLeft).x) {
						test.x = rectCol.toWorld(rectCol.topLeft).x;
					}else if(object.transform.position.x >= rectCol.toWorld(rectCol.topRight).x) {
						test.x = rectCol.toWorld(rectCol.topRight).x;
					}else{
						isInsideX = true;
						test.x = object.transform.position.x;
					}
					
					if(object.transform.position.y <= rectCol.toWorld(rectCol.topLeft).y){
						test.y = rectCol.toWorld(rectCol.topLeft).y;
					}else if(object.transform.position.y >= rectCol.toWorld(rectCol.bottomLeft).y) {
						test.y = rectCol.toWorld(rectCol.bottomLeft).y;
					}else{
						isInsideY = true;
						test.y = object.transform.position.y;					
					}
				}
				
				double cdist = test.sub(object.transform.position).squareMagnitude();
				
				if(getRadius() * getRadius() >= cdist && (isInsideX && isInsideY)){
					ret = object.transform.position.sub(test).normalize();
					try {
						Thread.sleep(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				break;
			default:
				ret = null;
				break;
		}
		
		return ret;
	}
}
