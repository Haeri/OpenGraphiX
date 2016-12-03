package game.scene;

import java.awt.Color;

import core.Scene;
import core.Vector2;
import game.gameobjects.CellObject;
import primitives.Camera;
import render.Gizmo;
import render.Renderer;

public class Scene_1 extends Scene {


	public void Start() {
		Camera cam = new Camera();
		cam.transform.position.x = 0;
		
		Gizmo.isEnable = true;
		
		for(int i = 0; i < 2000; i++){
			CellObject c1 = new CellObject(Math.random()+2, Color.RED);
			c1.transform.position = new Vector2(Math.random() * Renderer.WIDTH - Renderer.WIDTH/2, Math.random() * Renderer.HEIGHT - Renderer.HEIGHT/2);
		}
		
	}
}
