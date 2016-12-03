package physics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import component.Collider;
import core.Bounds;
import core.Vector2;
import render.Gizmo;

public class CollisionMap {
	
	private int width, height, cellSize;
	private double cellWidth, cellHeight;
	public static TreeMap<Integer, List<Collider>> map;
	public static List<Collider> colliders;
	
	public CollisionMap(int width, int height, int cellAmmount){
		cellSize = cellAmmount;
		this.width = width;
		this.height = height;
		cellWidth = width / cellAmmount;
		cellHeight = height / cellAmmount;
		map = new TreeMap<Integer, List<Collider>>();
		colliders = new ArrayList<Collider>();
	}
	
	private List<Integer> worldToMapID(Collider c){
		List<Integer> retList = new ArrayList<Integer>();
		Bounds b = c.getBounds();
		Gizmo.drawRect(b.center, b.width, b.height, Color.ORANGE);
		Vector2 ret = new Vector2(posToCell(b.min), posToCell(b.max));
		if(ret.x == ret.y){
				retList.add((int)ret.x);
		}else{
			int xMin = (int) ((ret.x) % cellSize);
			int xMax = (int) ((ret.y) % cellSize);
			int yMin = (int) ((ret.x) / cellSize);
			int yMax = (int) ((ret.y) / cellSize);
			for(int j = yMin; j <= yMax; j++){
				for(int i = xMin; i <= xMax; i++){
					retList.add(j * cellSize + i);
				}
			}
		}
		return retList;
	}
	
	private int posToCell(Vector2 pos){
		return cellSize * (int)((pos.y+height/2) /cellHeight) + (int)((pos.x+width/2) /cellWidth);
	}
	
	public void addToTree(Collider c){
		List<Integer> range = worldToMapID(c);
		for(int i : range){
			Vector2 tile = new Vector2((i%cellSize)*cellWidth+(cellWidth/2) - width/2, (i/cellSize)*cellHeight+(cellHeight/2) - height/2);
			Gizmo.drawRect(tile, cellWidth, cellHeight, new Color(0, 255, 0, 60), true);
			if (map.containsKey(i)) {
				map.get(i).add(c);
			} else {
				List<Collider> tmp = new ArrayList<Collider>();
				tmp.add(c);
				map.put(i, tmp);
			}
		}
	}
	
	public void add(Collider c){
		colliders.add(c);
	}
	
	public void remove(Collider c){
		colliders.remove(c);
	}
	
	private void drawGrid(){
		for(int i = 0; i <= (int)(width / cellWidth); i++){
			Gizmo.drawLine(new Vector2(i * cellWidth - width/2, -height/2), new Vector2(i * cellWidth - width/2, height/2), Color.DARK_GRAY);
		}
		for(int j = 0; j <= (int)(height / cellHeight); j++){				
			Gizmo.drawLine(new Vector2(-width/2, j * cellHeight-height/2), new Vector2(width/2, j * cellHeight-height/2), Color.DARK_GRAY);
		}
		
		for(int j = 0; j < (int)(height / cellHeight); j++){				
			for(int i = 0; i < (int)(width / cellWidth); i++){
				Gizmo.drawText(new Vector2(i*cellWidth+2-width/2, j*cellHeight+14-height/2), j * cellSize + i + "", Color.DARK_GRAY);
			}
		}
	}
	
	public void update(){
		drawGrid();

		map.clear();
		for(Collider c : colliders){
			addToTree(c);
		}
		
//		System.out.println(map);
	}
	
	public List<Collider> getNeighbours(Collider c){
		List<Collider> ret = new ArrayList<Collider>();
		List<Integer> range = worldToMapID(c);
		for(int i : range){
			if(map.get(i) != null) ret.addAll(map.get(i));
		}
		
		return ret;
	}

	public int getSize() {
		return colliders.size();
	}

}
