package physics.component;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import core.Component;
import core.GameObject;
import core.Vector2f;
import physics.Physics;

public class Rigidbody extends Component{

	public Vector2f velocity = Vector2f.ZERO;
	public float mass = 1;
	
	public Vector2f oldVeclocity = Vector2f.ZERO;
	public BodyDef bodyDef;
	public Body body;
	
	public Rigidbody(){}
	
	public void init(){
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DYNAMIC;
		 
		//define fixture of the body.
		FixtureDef fd = new FixtureDef();
		fd.shape = ((Collider) object.getComponent(Collider.class)).getShape();
		fd.density = 0.5f;
		fd.friction = 0.3f;        
		fd.restitution = 0.5f;
		 
		//create the body and add fixture to it
		body =  Physics.world.createBody(bodyDef);
		body.createFixture(fd);		
		
		transform().position.setVector(body.getPosition());
		
		Physics.addRigidbody(this);
	}
	
	
	/**
	 * Apply force to the Rigidbody
	 * @param force, The force to be applied
	 */
	public void addForce(Vector2f force){
		Vector2f acceleration = force.div(mass);
		velocity = velocity.add(acceleration);
	}
	
	public void _destroy(){
		Physics.removeFromRigidbody(this);
	}
}
