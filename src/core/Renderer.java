package core;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JPanel;

import component.ObjectRenderer;
import primitives.Rect;

public class Renderer extends JPanel {	
	public Color clearFlag;
	
	static TreeMap<Integer, List<ObjectRenderer>> drawCalls;

	private static Rect bounds;
	private static final long serialVersionUID = 1L;
	
	
	public Renderer(){
		Renderer.bounds = new Rect(Vector2.ZERO, getWidth(), getHeight());
		drawCalls = new TreeMap<Integer, List<ObjectRenderer>>();
		
		System.out.println(bounds.height + " " + bounds.width);
	}
	
	public static void addToDrawCall(ObjectRenderer renderer, int order){
		if(drawCalls.containsKey(order)){
			drawCalls.get(1).add(renderer);
		}else{
			List<ObjectRenderer> tmp = new ArrayList<ObjectRenderer>();
			tmp.add(renderer);
			drawCalls.put(order, tmp);	
		}	
	}
	
	//TODO fix
	public static void removeFromDrawCall(ObjectRenderer renderer){
		drawCalls.remove(renderer);
	}
	
	public static Rect getRect(){
		return bounds;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(clearFlag);
		
		
	    Set set = drawCalls.entrySet();
	    Iterator iterator = set.iterator();
	    
	    while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         
	         ArrayList<ObjectRenderer> rend = (ArrayList<ObjectRenderer>) mentry.getValue();
	         
	 		for (int i = 0; i < rend.size(); i++){
				rend.get(i).draw(g);
			}	         
	         
	      }
	}
}
