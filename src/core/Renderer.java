package core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import component.ObjectRenderer;
import renderer.Gizmo;

public class Renderer extends Canvas {
	
	public Color clearFlag;
	public static int WIDTH;
	public static int HEIGHT;
	
	BufferStrategy bs;
	private static TreeMap<Integer, List<ObjectRenderer>> drawCalls;
	
	private static final long serialVersionUID = 1L;

	public Renderer(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		drawCalls = new TreeMap<Integer, List<ObjectRenderer>>();
		
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

	public static int getDrawCalls() {
		return drawCalls.size();
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

		Set<Entry<Integer, List<ObjectRenderer>>> set = drawCalls.entrySet();
		Iterator<Entry<Integer, List<ObjectRenderer>>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			ArrayList<ObjectRenderer> rend = (ArrayList<ObjectRenderer>) mentry.getValue();

			for (int i = 0; i < rend.size(); i++) {
				rend.get(i).draw(g);
			}
		}
		
		if(Gizmo.isEnable){
			g.drawImage(Gizmo.getFrame(), 0, 0, null);
			Gizmo.clear();		
		}
		
		g.dispose();
		bs.show();
	}
}
