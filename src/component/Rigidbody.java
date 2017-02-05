package component;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import core.GraphiXObject;
import core.Vector2;
import physics.Physics;

public class Rigidbody extends Component{

	public Vector2 velocity = Vector2.ZERO;
	public float mass = 1;
	
	public Vector2 oldVeclocity = Vector2.ZERO;
	public BodyDef bodyDef;
	public Body body;
	
	public Rigidbody(GraphiXObject object){
		super(object);
		
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DYNAMIC;
		 
		
//		//define shape of the body.
//		CircleShape cs = new CircleShape();
//		cs.m_radius = (float)2;  
		
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
	public void addForce(Vector2 force){
		Vector2 acceleration = force.div(mass);
		velocity = velocity.add(acceleration);
	}
	
	public void _destroy(){
		Physics.removeFromRigidbody(this);
	}
}
