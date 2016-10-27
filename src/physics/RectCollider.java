package physics;

import component.Collider;
import core.GraphiXObject;
import math.Vector2;

public class RectCollider extends Collider implements ICollidable {

	public Vector2 topLeft;
	public Vector2 topRight;
	public Vector2 bottomLeft;
	public Vector2 bottomRight;
	public double width;
	public double height;

	public RectCollider(Vector2 topLeft, double width, double height, GraphiXObject object) {
		super(object);
		this.topLeft = topLeft;
		this.width = width;
		this.height = height;
		type = ColliderType.RECT;
		
		topRight = new Vector2(topLeft.x + width, topLeft.y);
		bottomLeft = new Vector2(topLeft.x, topLeft.y + height);
		bottomRight = new Vector2(topLeft.x + width, topLeft.y + height);		
	}

	public Vector2 collide(Collider other) {
		Vector2 ret = null;

		switch (other.type) {
		case CIRCLE:
			CircleCollider col = (CircleCollider) other;
			
			// AABB
			Vector2 otherPos = col.object.transform.position;
			if(otherPos.x >= topLeft.x && otherPos.x <= topRight.x && otherPos.y >= topLeft.x && otherPos.y <= bottomLeft.y){
				ret = null;
			}
				
			
			if (false)
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
