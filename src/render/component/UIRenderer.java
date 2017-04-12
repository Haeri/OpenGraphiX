package render.component;

import java.awt.Graphics2D;

import core.Component;
import core.GameObject;
import render.Renderer;

public abstract class UIRenderer extends Component{
		
	public int order;
	
	public UIRenderer(int order){
		this.order = order;
		Renderer.addToUIDrawCall(this, order);
	}

	public void _destroy(){
		Renderer.removeFromUIDrawCall(this);		
	}

	public abstract void draw(Graphics2D g2d);
}