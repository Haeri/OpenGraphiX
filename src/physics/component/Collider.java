package physics.component;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.Shape;

import core.Bounds;
import core.Component;
import core.GameObject;
import core.Vector2f;
import physics.CollisionListener;
import physics.Physics;

public abstract class Collider extends Component{

	public enum ColliderType {CIRCLE, RECT, LINE, POLLY, POINT};
	public ColliderType type;
	public float elasticity = 1.0f;
	public boolean isTrigger;

	private List<CollisionListener> listeners = new ArrayList<CollisionListener>();
	
	public void Start() {
		Physics.addCollider(this);
	}

	public void _destroy(){
		Physics.removeFromCollider(this);
	}
	
	public Collider getCollider() {
		return this;
	}
	
	public abstract Shape getShape();
	
	public abstract Bounds getBounds();
	
	//public abstract Vector2 collide(Collider other);

	public abstract void drawGizmo();

    public void addListener(CollisionListener toAdd) {
        listeners.add(toAdd);
    }

    public void fire(Collider other) {
        for (CollisionListener hl : listeners)
            hl.onCollisionEnter(other);
    }
}
