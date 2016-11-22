package game.scene;

import java.awt.Color;

import core.Renderer;
import core.Scene;
import core.Vector2;
import renderer.Gizmo;
import game.gameobjects.CellObject;

public class Scene_1 extends Scene {


	public void Start() {
		
//		Gizmo.isEnable = true;
		
		for(int i = 0; i < 1500; i++){
			CellObject c1 = new CellObject(Math.random()+2, Color.RED);
			c1.transform.position = new Vector2(Math.random() * Renderer.WIDTH, Math.random() * Renderer.HEIGHT);
		}
		
	}
}
