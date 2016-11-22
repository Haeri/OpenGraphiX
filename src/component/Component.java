package component;

import core.GraphiXObject;

public abstract class Component {

	public GraphiXObject object;
	
	public Component(GraphiXObject object){
		this.object = object;
	}
	
	public Transform transform(){
		return object.transform;
	}
	
	/**
	 * Get a component by Class
	 * @param c, The Class to be returned
	 * @return returns the Component if it exists else null
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<?> c){
		return (T) object.getComponent(c);
	}

	public void _destroy(){}
}
