package primitives;

import core.GameObject;
import core.component.ParticleSystem;
import physics.component.CircleCollider;
import physics.component.Rigidbody;

public class GO_ParticleSystem extends GameObject{

	public GO_ParticleSystem(int spawnRate){
		addComponent(new ParticleSystem(spawnRate));
		addComponent(new Rigidbody());
		addComponent(new CircleCollider(10, false));
	}
}
