package physics;

import component.Collider;
import core.GraphiXObject;
import core.Vector2;

public class LineCollider extends Collider {

	public Vector2 a;
	public Vector2 b;
	
	public LineCollider(Vector2 a, Vector2 b, GraphiXObject object){
		super(object);
		this.a = a;
		this.b = b;
		type = ColliderType.LINE;
	}
	
	public Vector2 getA(){
		return a;
	}
	
	public Vector2 getB(){
		return b;
	}
	
	public Vector2 collide(Collider other){
		Vector2 ret = null;
		
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
					ret = Vector2.ONE;
				
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
