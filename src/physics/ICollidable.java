package physics;

import component.Collider;
import math.Vector2;

public interface ICollidable {

	public Vector2 collide(Collider other);
}
