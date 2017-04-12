package core;

import core.component.Transform;

public abstract class Component {

	public GameObject object;
	
	public Component(){}
	
	
	/**
	 * Returns the Transform component from the current GameObject
	 * @return Transform
	 */
	public Transform transform(){
		return object.transform;
	}
	
	/**
	 * Get a component by Class
	 * @param classType, The Class to be returned
	 * @return returns the Component if it exists else null
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<?> classType){
		return (T) object.getComponent(classType);
	}
	
	protected void init(){}

	protected void _destroy(){}
}
