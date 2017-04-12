package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import core.Core;
import core.Vector2f;
import physics.Physics;
import physics.component.Collider;
import primitives.Camera;
import render.component.ObjectRenderer;

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

	}
	
	public static void clear(){
//		if(!isEnable) return;
		g2 = bs.createGraphics();
		g2.setBackground(new Color(0, 0, 0, 0));
		g2.clearRect(0, 0, Renderer.WIDTH, Renderer.HEIGHT);
	}
	
	public static synchronized void drawLine(Vector2f a, Vector2f b, Color c){
		if(!isEnable) return;
		g2.setColor(c);
		g2.drawLine((int)(a.getx()- Camera.getMVP().getx()), (int)(a.gety() - Camera.getMVP().gety()), (int)(b.getx()- Camera.getMVP().getx()), (int)(b.gety() - Camera.getMVP().gety()));
	}

	public static void drawRect(Vector2f pos, double width, double height, Color c){
		drawRect(pos, width, height, c, false);
	}
	
	public static synchronized void drawRect(Vector2f pos, double width, double height, Color c, boolean filled){
		if(!isEnable) return;
		g2.setColor(c);
		if(filled)
			g2.fillRect((int)(pos.getx()-width/2 - Camera.getMVP().getx()), (int)(pos.gety()-height/2 - Camera.getMVP().gety()), (int)width, (int)height);
		else
			g2.drawRect((int)(pos.getx()-width/2 - Camera.getMVP().getx()), (int)(pos.gety()-height/2 - Camera.getMVP().gety()), (int)width, (int)height);
	}
	
	public static void drawCircle(Vector2f pos, double r, Color c){
		if(!isEnable) return;
		g2.setColor(c);
		g2.drawOval((int)(pos.getx()-r - Camera.getMVP().getx()), (int)(pos.gety()-r - Camera.getMVP().gety()), (int)(r*2), (int)(r*2));
	}
	
	public static void drawText(Vector2f pos, String text, Color c){
		if(!isEnable) return;
		g2.setColor(c);
		g2.drawString(text, (int)(pos.getx()- Camera.getMVP().getx()), (int)(pos.gety() - Camera.getMVP().gety()));
	}
	
	public static BufferedImage getFrame(){
		drawUtil();
		g2.dispose();
		return bs;
	}
}
