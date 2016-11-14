package game.scene;

import java.awt.Color;

import core.Renderer;
import core.Scene;
import core.Vector2;
import primitives.GO_Circle;

public class Scene_1 extends Scene {


	public void Start() {
		
		for(int i = 0; i < 30; i++){
			GO_Circle c1 = new GO_Circle(Math.random() * 20, Color.RED);
			c1.transform.position = new Vector2(Math.random() * Renderer.WIDTH, Math.random() * Renderer.HEIGHT);
		}
		
		
//		Rigidbody rb1 = c1.getComponent(Rigidbody.class);
//		rb1.velocity = new Vector2(1, 1);
		
//		
//		RectangleObject qtop = new RectangleObject(900, 20.0, Color.DARK_GRAY);
//		qtop.transform.position = new Vector2(Core.X_WINDOW_SIZE / 2, 10);
//
//		RectangleObject qbot = new RectangleObject(900, 20.0, Color.DARK_GRAY);
//		qbot.transform.position = new Vector2(Core.X_WINDOW_SIZE / 2, Core.Y_WINDOW_SIZE - 40);
//
//		RectangleObject qleft = new RectangleObject(20, 900.0, Color.DARK_GRAY);
//		qleft.transform.position = new Vector2(10, Core.Y_WINDOW_SIZE / 2);
//
//		RectangleObject qright = new RectangleObject(20, 900.0, Color.DARK_GRAY);
//		qright.transform.position = new Vector2(Core.X_WINDOW_SIZE - 20, Core.Y_WINDOW_SIZE / 2);
	}
}
