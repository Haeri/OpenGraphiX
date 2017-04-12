package physics.component;

import java.awt.Color;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;

import core.Bounds;
import core.GameObject;
import core.Vector2f;
import render.Gizmo;

public class CircleCollider extends Collider{

	public CircleShape cs;
	public float radius;
		
	public CircleCollider(float radius, boolean isTrigge){
		super.isTrigger = isTrigger;
		this.radius = radius;
		type = ColliderType.CIRCLE;
	}
	
	public void init(){
		cs = new CircleShape();
		cs.m_radius = radius;  		
	}
	
	public float getRadius(){
		return radius * object.transform.scale.getx();
	}
	
	public void drawGizmo(){
		Gizmo.drawCircle(transform().position, getRadius(), Color.GREEN);
	}
	
	public Bounds getBounds(){
		return new Bounds(new Vector2f(-getRadius()+ transform().position.getx(), -getRadius()+ transform().position.gety()), new Vector2f(getRadius()+ transform().position.getx(), getRadius()+ transform().position.gety()));
	}
	
	public Shape getShape(){
		return cs;
	}

	
//	public Vector2 collide(Collider other){
//		Vector2 ret = null;
//		
//		switch (other.type){
//			case CIRCLE:
//				CircleCollider circleCol = (CircleCollider)other;
//				float radDist = getRadius() + circleCol.getRadius();
//				float dist = circleCol.object.transform.position.sub(object.transform.position).squareMagnitude();
//				if(radDist * radDist >= dist)
//					ret = object.transform.position.sub(circleCol.object.transform.position).normalize();
//				break;
//			case LINE:
//				
//				break;
//			case POINT:
//				break;
//			case POLLY:
//				break;
//			case RECT:
//				RectCollider rectCol = (RectCollider)other;
//				Vector2 test = rectCol.transform().position.clone();
//				
//				boolean isInsideX = false;
//				boolean isInsideY = false;
//				
//			
//				if(object.transform.position.x <= rectCol.toWorld(rectCol.topLeft).x-getRadius()) {
//					test.x = rectCol.toWorld(rectCol.topLeft).x;
//				}else if(object.transform.position.x >= rectCol.toWorld(rectCol.topRight).x+getRadius()) {
//					test.x = rectCol.toWorld(rectCol.topRight).x;
//				}else{
//					isInsideX = true;
//					test.x = object.transform.position.x;
//				}
//				
//				if(object.transform.position.y <= rectCol.toWorld(rectCol.topLeft).y-getRadius()){
//					test.y = rectCol.toWorld(rectCol.topLeft).y;
//				}else if(object.transform.position.y >= rectCol.toWorld(rectCol.bottomLeft).y+getRadius()) {
//					test.y = rectCol.toWorld(rectCol.bottomLeft).y;
//				}else{
//					isInsideY = true;
//					test.y = object.transform.position.y;					
//				}
//				
//				if(isInsideX && isInsideY){					
//					if(object.transform.position.x <= rectCol.toWorld(rectCol.topLeft).x) {
//						test.x = rectCol.toWorld(rectCol.topLeft).x;
//					}else if(object.transform.position.x >= rectCol.toWorld(rectCol.topRight).x) {
//						test.x = rectCol.toWorld(rectCol.topRight).x;
//					}else{
//						isInsideX = true;
//						test.x = object.transform.position.x;
//					}
//					
//					if(object.transform.position.y <= rectCol.toWorld(rectCol.topLeft).y){
//						test.y = rectCol.toWorld(rectCol.topLeft).y;
//					}else if(object.transform.position.y >= rectCol.toWorld(rectCol.bottomLeft).y) {
//						test.y = rectCol.toWorld(rectCol.bottomLeft).y;
//					}else{
//						isInsideY = true;
//						test.y = object.transform.position.y;					
//					}
//				}
//				
//				float cdist = test.sub(object.transform.position).squareMagnitude();
//				
//				if(getRadius() * getRadius() >= cdist && (isInsideX && isInsideY)){
//					ret = object.transform.position.sub(test).normalize();
//					try {
//						Thread.sleep(0);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				
//				break;
//			default:
//				ret = null;
//				break;
//		}
//		
//		return ret;
//	}
}
