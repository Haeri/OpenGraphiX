package game;

import java.awt.Color;

import core.GraphiXObject;
import renderer.GridRenderer;

public class GridObject extends GraphiXObject{

	public double xSpace;
	public double ySpace;
	public Color color;
	
	public GridObject(double xSpace, double ySpace, Color color) {
		super();
		addComponent(new GridRenderer(this, 3));
		
		this.xSpace = xSpace;
		this.ySpace = ySpace;
		this.color = color;
	}
}
