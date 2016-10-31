package component;

import java.awt.Graphics;

import core.GraphiXObject;
import core.Renderer;

public abstract class ObjectRenderer extends Component{
	
	public int order;
	
	public ObjectRenderer(GraphiXObject object, int order){
		super(object);
		this.order = order;
		Renderer.addToDrawCall(this, order);
	}

	public void destroy(){
		Renderer.removeFromDrawCall(this);		
	}

	public abstract void draw(Graphics g);
}