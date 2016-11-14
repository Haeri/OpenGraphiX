package component;

import core.GraphiXObject;
import core.Vector2;
import physics.Physics;

public class Rigidbody extends Component{

	public Vector2 velocity;
	public float mass;
	
	public Rigidbody(GraphiXObject object){
		super(object);
		velocity = new Vector2(0, 0);
		Physics.addRigidbody(this);
	}
	
	
	/**
	 * Apply force to the Rigidbody
	 * @param force, THe force to be applied
	 */
	public void addForce(Vector2 force){
		velocity = velocity.add(force);
	}
	
	public void destroy(){
		Physics.removeFromRigidbody(this);
	}
}
