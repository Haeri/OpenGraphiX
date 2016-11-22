package renderer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import component.Collider;
import component.ObjectRenderer;
import core.Core;
import core.Renderer;
import core.Vector2;
import physics.Physics;

public class Gizmo {

	public static boolean isEnable = false;
	
	private static Graphics2D g2;
	private static BufferedImage bs;
	
	public static void init(){
		bs = new BufferedImage(Renderer.WIDTH, Renderer.HEIGHT, BufferedImage.TYPE_INT_ARGB);
		clear();
	}
	
	public static void drawUtil(){
		for (int i = 0; i < Physics.getColliders(); i++){
			Physics.colliders.get(i).drawGizmo();
		}
	}
	
	public static void clear(){
		g2 = bs.createGraphics();
		g2.setBackground(new Color(0, 0, 0, 0));
		g2.clearRect(0, 0, Renderer.WIDTH, Renderer.HEIGHT);
	}
	
	public static void drawLine(Vector2 a, Vector2 b, Color c){
		g2.setColor(c);
		g2.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
	}
	
	public static void drawRect(Vector2 pos, double width, double height, Color c){
		g2.setColor(c);
		g2.drawRect((int)(pos.x-width/2), (int)(pos.y-height/2), (int)width, (int)height);
	}
	
	public static void drawCircle(Vector2 pos, double r, Color c){
		g2.setColor(c);
		g2.drawOval((int)(pos.x-r), (int)(pos.y-r), (int)(r*2), (int)(r*2));
	}
	
	public static BufferedImage getFrame(){
		drawUtil();
		g2.dispose();
		return bs;
	}
}
