package component;

import core.GraphiXObject;
import core.Vector2;
import physics.Physics;

public abstract class Collider extends Component{

	public enum ColliderType {CIRCLE, RECT, LINE, POLLY, POINT};
	public ColliderType type;
	
	public Collider(GraphiXObject object) {
		super(object);
		Physics.addCollider(this);
	}

	public void destroy(){
		Physics.removeFromCollider(this);
	}
	
	public Collider getCollider() {
		return this;
	}
	
	public abstract Vector2 collide(Collider other);
}
