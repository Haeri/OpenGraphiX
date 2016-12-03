package component;

import java.awt.Graphics;
import java.awt.Graphics2D;

import core.GraphiXObject;
import render.Renderer;

public abstract class ObjectRenderer extends Component{
	
	public int order;
	
	public ObjectRenderer(GraphiXObject object, int order){
		super(object);
		this.order = order;
		Renderer.addToDrawCall(this, order);
	}

	public void _destroy(){
		Renderer.removeFromDrawCall(this);		
	}

	public abstract void draw(Graphics2D g2d);
}