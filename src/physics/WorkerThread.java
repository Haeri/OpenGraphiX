package physics;

import java.awt.Color;
import java.util.List;

import component.Collider;
import component.Rigidbody;
import core.Vector2;
import render.Gizmo;

public class WorkerThread implements Runnable {

	private int index;

	public WorkerThread(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		processCommand();
	}

	private void processCommand() {
		List<Collider> cols = Physics.collisionMap.getNeighbours(CollisionMap.colliders.get(index));
		System.out.println("Thread: " + index);
		for (Collider other : cols) {
			System.out.println(" " + other.object.getID());
			if (other.object.getID() == CollisionMap.colliders.get(index).object.getID())
				return;
			Vector2 ret = (CollisionMap.colliders.get(index).collide(other));
			Rigidbody rb1 = CollisionMap.colliders.get(index).getComponent(Rigidbody.class);
			Rigidbody rb2 = other.getComponent(Rigidbody.class);

			if (ret != null) {
				System.out.println(rb1.object.getID() + " <> " + rb2.object.getID());
				if (CollisionMap.colliders.get(index).isTrigger || other.isTrigger) {
					CollisionMap.colliders.get(index).fire(other);
					other.fire(CollisionMap.colliders.get(index));
				} else {
					if (rb1 != null) {
						rb1.velocity = Vector2.reflect(rb1.velocity, ret);
					}
					if (rb2 != null) {
						rb2.velocity = Vector2.reflect(rb2.velocity, ret.invert());
					}
				}
			}
			Gizmo.drawLine(other.transform().position, CollisionMap.colliders.get(index).transform().position,
					new Color(255, 230, 0, 100));
		}
		System.out.println();
	}
}