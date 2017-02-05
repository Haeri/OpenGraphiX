package component;

import java.util.ArrayList;
import java.util.List;

import core.Bounds;
import core.GraphiXObject;
import core.Vector2;
import physics.CollisionListener;
import physics.Physics;

public abstract class Collider extends Component{

	public enum ColliderType {CIRCLE, RECT, LINE, POLLY, POINT};
	public ColliderType type;
	public boolean isTrigger;
	public boolean processed = false;

	private List<CollisionListener> listeners = new ArrayList<CollisionListener>();
	
	public Collider(GraphiXObject object) {
		super(object);
		Physics.addCollider(this);
	}

	public void _destroy(){
		Physics.removeFromCollider(this);
	}
	
	public Collider getCollider() {
		return this;
	}
	
	public abstract Bounds getBounds();
	
	public abstract Vector2 collide(Collider other);

	public abstract void drawGizmo();

    public void addListener(CollisionListener toAdd) {
        listeners.add(toAdd);
    }

    public void fire(Collider other) {
        for (CollisionListener hl : listeners)
            hl.onCollisionEnter(other);
    }
}
