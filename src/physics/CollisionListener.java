package physics;

import component.Collider;

public interface CollisionListener {

	public void onCollisionEnter(Collider collider);
	public void onCollisionExit(CollisionEvent e);
	public void onCollisionStay(CollisionEvent e);
}
