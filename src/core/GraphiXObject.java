package core;

import java.util.HashMap;
import java.util.Map;

import component.Component;
import component.Transform;
import math.Vector2;

public class GraphiXObject {
	public static int objectCnt = 0;
	
	public Transform transform;

	private Map<Class<?>, Object> components;
	private int OBJECT_ID;
			
	public GraphiXObject(){
		OBJECT_ID = objectCnt++;
		components = new HashMap<>();
		
		transform = new Transform(new Vector2(0, 0), new Vector2(0, 0),  new Vector2(1.0, 1.0), this);
		addComponent(transform);
	}

	public int getID(){
		return OBJECT_ID;
	}
	
	protected void addComponent(Component c){
		components.put(c.getClass(), c);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<?> c){
		return (T) components.get(c);
	}
	
	public void destroy(){
		for (Object comp : components.values()) {
			((Component)comp).destroy();
		}
	}
}
