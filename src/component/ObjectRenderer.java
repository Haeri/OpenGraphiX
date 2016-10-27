package component;

import java.awt.Graphics;

import core.GraphiXObject;
import core.Renderer;

public abstract class ObjectRenderer extends Component{
	
	public ObjectRenderer(GraphiXObject object){
		super(object);
		Renderer.addToDrawCall(this);
	}

	public void destroy(){
		Renderer.removeFromDrawCall(this);		
	}

	public abstract void draw(Graphics g, int order);
}