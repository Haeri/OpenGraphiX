package game.scene;

import java.awt.Color;

import org.jbox2d.common.Vec2;

import core.Scene;
import game.scripts.CameraController;
import physics.component.Rigidbody;
import primitives.Camera;
import primitives.GO_Circle;
import primitives.GO_Rect;
import render.Gizmo;
import render.Renderer;

public class Scene_2 extends Scene {


	public void Start() {
		
		Camera cam = new Camera();
		cam.addComponent(new CameraController());
				
		Gizmo.isEnable = false;
		
		for(int i = 0; i < 3000; i++){
			GO_Circle c1 = new GO_Circle(1, Color.RED);
			((Rigidbody)c1.getComponent(Rigidbody.class)).body.setTransform(new Vec2((float)(Math.random() * Renderer.WIDTH-200)+100, (float)(Math.random() * Renderer.HEIGHT-200) + 100), 0);
		}
		
		
		GO_Rect qbot = new GO_Rect(Renderer.WIDTH, 50.0f, Color.DARK_GRAY);
		qbot.body.setTransform(new Vec2(400, 600), 0);
		qbot.transform.position.setVector(qbot.body.getPosition());
		
		GO_Rect qbot2 = new GO_Rect(200, 50.0f, Color.DARK_GRAY);
		qbot2.body.setTransform(new Vec2(100, 400), 0);
		qbot2.transform.position.setVector(qbot2.body.getPosition());
		
		GO_Rect qbot3 = new GO_Rect(200, 50.0f, Color.DARK_GRAY);
		qbot3.body.setTransform(new Vec2(200, 500), 0);
		qbot3.transform.position.setVector(qbot3.body.getPosition());
	}
}
