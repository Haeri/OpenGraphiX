package render.component;

import java.awt.Graphics2D;

import core.Component;
import core.GameObject;
import render.Renderer;

public abstract class ObjectRenderer extends Component{
	
	public int order;
	
	public ObjectRenderer(int order){
		this.order = order;
		Renderer.addToDrawCall(this, order);
	}

	public void _destroy(){
		Renderer.removeFromDrawCall(this);		
	}

	public abstract void draw(Graphics2D g2d);
}