package component;

import core.GraphiXObject;

public abstract class Component {

	public GraphiXObject object;
	
	public Component(GraphiXObject object){
		this.object = object;
	}
	
	public void destroy(){}
	
	public Transform transform(){
		return object.transform;
	}
}
