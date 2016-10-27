package physics;

import component.Collider;
import component.Rigidbody;

public class SimulationBody{
	public Rigidbody rigidbody;
	public Collider collider;
	
	public SimulationBody(Rigidbody rigidbody, Collider collider){
		this.rigidbody = rigidbody;
		this.collider = collider;
	}
}