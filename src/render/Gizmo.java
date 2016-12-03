package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import component.Collider;
import component.ObjectRenderer;
import core.Core;
import core.Vector2;
import physics.CollisionMap;
import physics.Physics;
import primitives.Camera;

public class Gizmo {

	public static boolean isEnable;
	
	private static Graphics2D g2;
	private static BufferedImage bs;
	
	public static void init(){
//		if(!isEnable) return;
		bs = new BufferedImage(Renderer.WIDTH, Renderer.HEIGHT, BufferedImage.TYPE_INT_ARGB);
		clear();
	}
	
	public static void drawUtil(){
//		if(!isEnable) return;
		for (int i = 0; i < Physics.getColliders(); i++){
			CollisionMap.colliders.get(i).drawGizmo();
		}
	}
	
	public static void clear(){
//		if(!isEnable) return;
		g2 = bs.createGraphics();
		g2.setBackground(new Color(0, 0, 0, 0));
		g2.clearRect(0, 0, Renderer.WIDTH, Renderer.HEIGHT);
	}
	
	public static synchronized void drawLine(Vector2 a, Vector2 b, Color c){
		if(!isEnable) return;
		g2.setColor(c);
		g2.drawLine((int)(a.x - Camera.getMVP().x), (int)(a.y - Camera.getMVP().y), (int)(b.x - Camera.getMVP().x), (int)(b.y - Camera.getMVP().y));
	}

	public static void drawRect(Vector2 pos, double width, double height, Color c){
		drawRect(pos, width, height, c, false);
	}
	
	public static synchronized void drawRect(Vector2 pos, double width, double height, Color c, boolean filled){
		if(!isEnable) return;
		g2.setColor(c);
		if(filled)
			g2.fillRect((int)(pos.x-width/2 - Camera.getMVP().x), (int)(pos.y-height/2 - Camera.getMVP().y), (int)width, (int)height);
		else
			g2.drawRect((int)(pos.x-width/2 - Camera.getMVP().x), (int)(pos.y-height/2 - Camera.getMVP().y), (int)width, (int)height);
	}
	
	public static void drawCircle(Vector2 pos, double r, Color c){
		if(!isEnable) return;
		g2.setColor(c);
		g2.drawOval((int)(pos.x-r - Camera.getMVP().x), (int)(pos.y-r - Camera.getMVP().y), (int)(r*2), (int)(r*2));
	}
	
	public static void drawText(Vector2 pos, String text, Color c){
		if(!isEnable) return;
		g2.setColor(c);
		g2.drawString(text, (int)(pos.x - Camera.getMVP().x), (int)(pos.y - Camera.getMVP().y));
	}
	
	public static BufferedImage getFrame(){
		drawUtil();
		g2.dispose();
		return bs;
	}
}
