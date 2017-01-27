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
			CellObject c1 = new CellObject((float)(Math.random()+2.0f), Color.RED);
			c1.transform.position = new Vector2((float)(Math.random() * Renderer.WIDTH - Renderer.WIDTH/2.0f), (float)(Math.random() * Renderer.HEIGHT - Renderer.HEIGHT/2.0f));
		}
		
	}
}
