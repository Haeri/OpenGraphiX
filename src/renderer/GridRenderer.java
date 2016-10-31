package renderer;

import java.awt.Graphics;

import component.ObjectRenderer;
import core.Renderer;
import game.GridObject;

public class GridRenderer extends ObjectRenderer{

	private GridObject grid;
	
	public GridRenderer(GridObject grid, int order) {
		super(grid, order);
		this.grid = grid;
	}

	@Override
	public void draw(Graphics g) {
	    int k;
		int width = (int) Renderer.getRect().width*100;
		int height = (int) Renderer.getRect().height*100;
		
		int wdOfRow = (int) (width / (grid.xSpace));
		int htOfRow = (int) (height / (grid.ySpace));
		
		//System.out.println(width + " " + height + " " + wdOfRow + " " + htOfRow);
		
		g.setColor(grid.color);
		
		for (k = 0; k < wdOfRow; k++)
			g.drawLine((int)(k*grid.xSpace), 0, (int)(k*grid.xSpace), height);
		
		for (k = 0; k < htOfRow; k++)
			g.drawLine(0, (int)(k*grid.ySpace), width, (int)(k*grid.ySpace));
	      
	}

}
