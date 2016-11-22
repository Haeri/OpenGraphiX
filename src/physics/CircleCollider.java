package physics;

import java.awt.Color;

import com.sun.prism.Graphics;

import component.Collider;
import core.GraphiXObject;
import core.Vector2;
import renderer.Gizmo;

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
//					double dx = Math.min(object.transform.position.x - rectCol.toWorld(rectCol.topLeft).x, rectCol.toWorld(rectCol.topRight).x- object.transform.position.x);
//					double dy = Math.min(object.transform.position.y - rectCol.toWorld(rectCol.topLeft).y, rectCol.toWorld(rectCol.bottomLeft).y- object.transform.position.y);
//					
//					
//					
//					if(object.transform.position.x <= rectCol.toWorld(rectCol.topRight.sub(rectCol.topLeft)).x+getRadius()*2)
//						test.x = rectCol.toWorld(rectCol.topLeft).x;
//					else
//						test.x =rectCol.toWorld(rectCol.topRight).x;
//						
//					if(object.transform.position.y <= rectCol.toWorld(rectCol.topLeft.sub(rectCol.bottomLeft)).y+getRadius()*2)
//						test.y = rectCol.toWorld(rectCol.topLeft).y;
//					else
//						test.y =rectCol.toWorld(rectCol.bottomLeft).y;
					
					
					
					
					
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
				
//				Gizmo.drawCircle(test, 3, Color.BLUE);
//				if(isInsideX && isInsideY){
//					System.out.println("INSIDE");
////					test = rectCol.transform().position.clone();
//					ret = object.transform.position.sub(test).normalize();
//				}else 
//				System.out.println(test);
				
				if(getRadius() * getRadius() >= cdist && (isInsideX && isInsideY)){
//					Gizmo.drawCircle(test, 6, Color.orange);
//					System.out.println(object.transform.position + " " + test);
					ret = object.transform.position.sub(test).normalize();
//					System.out.println("CONTACT " + ret);
					
//					Gizmo.drawLine(test, test.add(ret).mul(3), Color.YELLOW);
					try {
						Thread.sleep(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
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
