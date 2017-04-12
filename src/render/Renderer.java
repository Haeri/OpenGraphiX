package render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import render.component.ObjectRenderer;
import render.component.UIRenderer;

import java.util.Set;
import java.util.TreeMap;

public class Renderer extends Canvas {
	
	public Color clearFlag;
	public static int WIDTH;
	public static int HEIGHT;
	
	public static boolean antiAliassing = true;
	
	BufferStrategy bs;
	private static TreeMap<Integer, List<ObjectRenderer>> drawCalls;
	private static TreeMap<Integer, List<UIRenderer>> uiDrawCalls;
	
	private static final long serialVersionUID = 1L;

	public Renderer(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		drawCalls = new TreeMap<Integer, List<ObjectRenderer>>();
		uiDrawCalls = new TreeMap<Integer, List<UIRenderer>>();
		
		Gizmo.init();
		setSize(WIDTH, HEIGHT);
	}

	public static void addToDrawCall(ObjectRenderer renderer, int order) {
		if (drawCalls.containsKey(order)) {
			drawCalls.get(order).add(renderer);
		} else {
			List<ObjectRenderer> tmp = new ArrayList<ObjectRenderer>();
			tmp.add(renderer);
			drawCalls.put(order, tmp);
		}
	}

	public static void removeFromDrawCall(ObjectRenderer renderer) {
		drawCalls.get(renderer.order).remove(renderer);
		if (drawCalls.get(renderer.order).size() == 0)
			drawCalls.remove(renderer.order);
	}
	
	public static void addToUIDrawCall(UIRenderer renderer, int order) {
		if (uiDrawCalls.containsKey(order)) {
			uiDrawCalls.get(order).add(renderer);
		} else {
			List<UIRenderer> tmp = new ArrayList<UIRenderer>();
			tmp.add(renderer);
			uiDrawCalls.put(order, tmp);
		}
	}

	public static void removeFromUIDrawCall(UIRenderer renderer) {
		uiDrawCalls.get(renderer.order).remove(renderer);
		if (uiDrawCalls.get(renderer.order).size() == 0)
			uiDrawCalls.remove(renderer.order);
	}

	public static int getDrawCalls() {
		return drawCalls.size() + uiDrawCalls.size();
	}

	public void render(){
		bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(clearFlag);
		g.fillRect(0,  0,  WIDTH, HEIGHT);


		Graphics2D g2d = (Graphics2D) g.create();
		if(Renderer.antiAliassing) g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw main shapes		
		Set<Entry<Integer, List<ObjectRenderer>>> set = drawCalls.entrySet();
		Iterator<Entry<Integer, List<ObjectRenderer>>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Entry<Integer, List<ObjectRenderer>> mentry = iterator.next();
			ArrayList<ObjectRenderer> rend = (ArrayList<ObjectRenderer>) mentry.getValue();

			for (int i = 0; i < rend.size(); i++) {
				rend.get(i).draw(g2d);
			}
		}		
		g2d.dispose();	
		
		
		
		// Draw Gizmos
		if(Gizmo.isEnable){
			g.drawImage(Gizmo.getFrame(), 0, 0, null);
			Gizmo.clear();		
		}
		
		
		// Draw UI		
		g2d = (Graphics2D) g.create();
		if(Renderer.antiAliassing) g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Set<Entry<Integer, List<UIRenderer>>> set2 = uiDrawCalls.entrySet();
		Iterator<Entry<Integer, List<UIRenderer>>> iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator2.next();
			ArrayList<UIRenderer> rend = (ArrayList<UIRenderer>) mentry.getValue();
			for (int i = 0; i < rend.size(); i++) {
				rend.get(i).draw(g2d);
			}
		}
		g2d.dispose();		
		
		
		g.dispose();
		bs.show();
	}
}
