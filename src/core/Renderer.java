package core;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import component.ObjectRenderer;

public class Renderer extends JPanel {	
	public Color clearFlag;
	
	private static List<ObjectRenderer> drawCalls;
	private static final long serialVersionUID = 1L;
	
	public Renderer(){
		drawCalls = new ArrayList<ObjectRenderer>();
	}
	
	public static void addToDrawCall(ObjectRenderer renderer){
		drawCalls.add(renderer);
	}
	
	public static void removeFromDrawCall(ObjectRenderer renderer){
		drawCalls.remove(renderer);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(clearFlag);
		
		for (int i = 0; i < drawCalls.size(); i++){
			drawCalls.get(i).draw(g, 1);
		}
	}
}
