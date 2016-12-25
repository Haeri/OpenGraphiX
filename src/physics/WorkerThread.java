package physics;

import java.awt.Color;
import java.util.List;

import component.Collider;
import component.Rigidbody;
import core.Vector2;
import render.Gizmo;

public class WorkerThread implements Runnable {

	private List<Collider> cols;
	
	public WorkerThread(List<Collider> cols) {
		this.cols = cols;
	}

	@Override
	public void run() {
		processCommand();
	}

	private void processCommand() {
		for(int i = 0; i < cols.size()-1; i++){
			for(int j = i+1; j < cols.size(); j++){
		
				Vector2 ret = (cols.get(i).collide(cols.get(j)));
				Rigidbody rb1 = cols.get(i).getComponent(Rigidbody.class);
				Rigidbody rb2 = cols.get(j).getComponent(Rigidbody.class);

				if (ret != null) {
					if (cols.get(i).isTrigger || cols.get(j).isTrigger) {
						cols.get(i).fire(cols.get(j));
						cols.get(j).fire(cols.get(i));
					} else {
						if (rb1 != null){
							rb1.velocity = Physics.reflect(rb1.velocity, ret, cols.get(i).elasticity);
							rb1.object.transform.position = rb1.object.transform.position.sub(rb1.oldVeclocity);
						}
						if (rb2 != null) {
							rb2.velocity = Physics.reflect(rb2.velocity, ret.invert(), cols.get(j).elasticity);
							rb2.object.transform.position = rb2.object.transform.position.sub(rb2.oldVeclocity);
						}
					}
					Gizmo.drawLine(cols.get(i).transform().position, cols.get(j).transform().position, Color.RED);
				}else
					Gizmo.drawLine(cols.get(i).transform().position, cols.get(j).transform().position, new Color(255, 230, 0, 100));
			}	
		}			
	}
}