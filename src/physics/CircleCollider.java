package physics;

import java.awt.Color;

import javax.xml.soap.Text;

import component.Collider;
import core.GraphiXObject;
import core.Vector2;
import game.CircleObject;
import game.GizmoCitcle;

public class CircleCollider extends Collider{

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
				
////				
//				GizmoCitcle gl = new GizmoCitcle(3, Color.BLUE);
//				gl.transform.position = rectCol.topLeft();
//				
//				GizmoCitcle g2 = new GizmoCitcle(3, Color.BLUE);
//				g2.transform.position = rectCol.topRight();
//				
//				GizmoCitcle g3 = new GizmoCitcle(3, Color.BLUE);
//				g3.transform.position = rectCol.bottomLeft();
//				
//				GizmoCitcle g4 = new GizmoCitcle(3, Color.BLUE);
//				g4.transform.position = rectCol.bottomRight();
				
				Vector2 test = new Vector2(rectCol.transform().position.x, rectCol.transform().position.y);
//				Vector2 norm = Vector2.ONE;
				
				boolean isInsideX = false;
				boolean isInsideY = false;
				
				if(object.transform.position.x <= rectCol.topLeft().x-getRadius()) {
					test.x = rectCol.topLeft().x;
//					test.y = object.transform.position.y;
				}else if(object.transform.position.x >= rectCol.topRight().x+getRadius()) {
					test.x = rectCol.topRight().x;
				}else{
					test.x = object.transform.position.x;
					isInsideX = true;
				}
				
				if(object.transform.position.y <= rectCol.topLeft().y-getRadius()){
					test.y = rectCol.topLeft().y;
//					test.x = object.transform.position.x;
				}else if(object.transform.position.y >= rectCol.bottomLeft().y+getRadius()) {
					test.y = rectCol.bottomLeft().y;
				}else{
					test.y = object.transform.position.y;
					isInsideY = true;
				}
				
				double cdist = test.sub(object.transform.position).squareMagnitude();
				
//				GizmoCitcle cl = new GizmoCitcle(3, Color.RED);
//				cl.transform.position = test;
							
				
				if(getRadius() * getRadius() >= cdist || (isInsideX && isInsideY)){
					ret = object.transform.position.sub(test).normalize();
					System.out.println("Yes");
				}
				break;
			default:
				ret = null;
				break;
		}
		
		return ret;
	}
}
