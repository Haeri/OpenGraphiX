package core.component;

import java.awt.Color;

import core.GameObject;
import core.Vector2f;
import physics.component.Rigidbody;
import primitives.GO_Circle;

public class ParticleSystem extends GXScript{

	public int spawnRate;
	private GO_Circle[] particles;
	
	private int cnt = 0;
	private int ammount = 1000;
	
	public ParticleSystem(int spawnRate) {
		this.spawnRate = spawnRate;
		particles = new GO_Circle[ammount];
	}
	
	public void create(){}
	
	public void Update(){
		for(int i = 0; i < spawnRate; i++){
			if(particles[cnt+i] == null){
				GO_Circle cX = new GO_Circle((float)Math.random() * 3, new Color((int)(Math.random() * 0x1000000)));
				cX.transform.position = (Vector2f) object.transform.position.clone();
				Rigidbody rb1 = cX.getComponent(Rigidbody.class);
				rb1.velocity = new Vector2f((float)Math.random()-0.5f, (float)Math.random()-0.5f).normalize().mul(2);
				particles[cnt+i] = cX;
			}else{
				particles[cnt+i].transform.position = (Vector2f) object.transform.position.clone();
			}
			if(cnt++ >= (ammount-spawnRate)) cnt = 0;
		}
	}	
}
