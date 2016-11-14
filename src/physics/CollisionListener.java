package physics;

import component.Collider;

public interface CollisionListener {

	public void onCillisionEnter(Collider collider);
	public void onCillisionExit(CollisionEvent e);
	public void onCillisionStay(CollisionEvent e);
}
