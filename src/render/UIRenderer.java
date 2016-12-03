package render;

import java.awt.Graphics2D;

import component.Component;
import core.GraphiXObject;
import render.Renderer;

public abstract class UIRenderer extends Component{
		
	public int order;
	
	public UIRenderer(GraphiXObject object, int order){
		super(object);
		this.order = order;
		Renderer.addToUIDrawCall(this, order);
	}

	public void _destroy(){
		Renderer.removeFromUIDrawCall(this);		
	}

	public abstract void draw(Graphics2D g2d);
}