package component;

import core.GraphiXObject;
import core.Vector2;
import physics.Physics;

public class Rigidbody extends Component{

	public Vector2 velocity = Vector2.ZERO;
	public float mass = 1;
	
	public Vector2 oldVeclocity = Vector2.ZERO;
	
	public Rigidbody(GraphiXObject object){
		super(object);
		Physics.addRigidbody(this);
	}
	
	
	/**
	 * Apply force to the Rigidbody
	 * @param force, THe force to be applied
	 */
	public void addForce(Vector2 force){
		Vector2 acceleration = force.div(mass);
		velocity = velocity.add(acceleration);
	}
	
	public void _destroy(){
		Physics.removeFromRigidbody(this);
	}
}
