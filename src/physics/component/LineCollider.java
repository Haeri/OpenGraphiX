package physics.component;

import java.awt.Color;

import org.jbox2d.collision.shapes.Shape;

import core.Bounds;
import core.GameObject;
import core.Vector2f;
import render.Gizmo;

public class LineCollider extends Collider {

	public Vector2f a;
	public Vector2f b;
	
	public Shape line;
	
	public LineCollider(Vector2f a, Vector2f b){
		this.a = a;
		this.b = b;
		type = ColliderType.LINE;
	}
	
	public Vector2f getA(){
		return a;
	}
	
	public Vector2f getB(){
		return b;
	}
	
	public void drawGizmo(){
		Gizmo.drawLine(a, b, Color.GREEN);
	}
	
	public Vector2f collide(Collider other){
		Vector2f ret = null;
		
		switch (other.type){
			case CIRCLE:
				//hc=(2/c)sqrt[s(s-a)(s-b)(s-c)]. 
				//Darin ist s=(1/2)(a+b+c). 
				CircleCollider col = (CircleCollider)other;
				
				double _a = a.sub(b).magnitude(); 
				double _b = a.sub(col.object.transform.position).magnitude();
				double _c = b.sub(col.object.transform.position).magnitude();
				double _s = (_a+_b+_c)*0.5;
				
				double dist = (2/_c) * Math.sqrt(_s*(_s-_a)*(_s-_b)*(_s-_c));
				if(dist <= col.radius)
					ret = Vector2f.ONE;
				
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape() {
		return line;
	}
}
