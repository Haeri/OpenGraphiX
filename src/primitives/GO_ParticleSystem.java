package primitives;

import component.ParticleSystem;
import component.Rigidbody;
import core.GraphiXObject;
import physics.CircleCollider;

public class GO_ParticleSystem extends GraphiXObject{

	public GO_ParticleSystem(int spawnRate){
		addComponent(new ParticleSystem(spawnRate, this));
		addComponent(new Rigidbody(this));
		addComponent(new CircleCollider(10, false, this));
	}
}
