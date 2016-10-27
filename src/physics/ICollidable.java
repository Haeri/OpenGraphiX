package physics;

import component.Collider;
import core.Vector2;

public interface ICollidable {

	public Vector2 collide(Collider other);
}
