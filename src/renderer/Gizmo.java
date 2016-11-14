package renderer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import component.ObjectRenderer;
import core.Core;
import core.Renderer;
import core.Vector2;

public class Gizmo {

	private static Graphics g;
	private static BufferedImage bs;
	
	private final int DRAW_ORDER = 100;
//	public abstract void draw(Graphics g);
	
	public static void init(){
		bs = new BufferedImage(Renderer.WIDTH, Renderer.HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g = bs.getGraphics();
	}
	
	public static void drawLine(Vector2 a, Vector2 b, Color c){
		if(g == null) init();
		
		g.setColor(c);
		g.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
		//System.out.println("Draw");
	}
	
	public static BufferedImage getFrame(){
		return bs;
	}
}
