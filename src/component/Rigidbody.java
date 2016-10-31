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
	
	public void destroy(){
		Physics.removeFromRigidbody(this);
	}
}
