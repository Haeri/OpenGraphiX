package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import component.Component;
import component.Transform;

public class GraphiXObject {
	
	public boolean enabled;
	public Transform transform;

	private boolean toDestroy = false;
	private Map<Class<?>, Object> components;
	private static List<GraphiXObject> objs = new ArrayList<GraphiXObject>();
	private int OBJECT_ID;
	private static int objectCnt = 0;
			
	
	public GraphiXObject(){
		OBJECT_ID = objectCnt++;
		components = new HashMap<>();
		objs.add(this);
		
		transform = new Transform(new Vector2(0, 0), new Vector2(0, 0),  new Vector2(1.0, 1.0), this);
		addComponent(transform);
	}
	
	/**
	 * Unique ID of this GraphiXObject
	 * @return returns the ID
	 */
	public int getID(){
		return OBJECT_ID;
	}
	
	/**
	 * Add a component to the GraphiXObject
	 * @param c, Component to be added
	 */
	protected void addComponent(Component c){
		components.put(c.getClass(), c);
	}
	
	/**
	 * Get a component by Class
	 * @param c, The Class to be returned
	 * @return returns the Component if it exists else null
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<?> c){
		return (T) components.get(c);
	}
	
	/*
	 * Destroy the GraphiXObject
	 */
	public void destroy(){
		toDestroy = true;
	}
	
	protected static void finalDestroy(){
		for(int i = objs.size()-1; i >= 0 ; i--){
			if(objs.get(i).toDestroy){
				for (Object comp : objs.get(i).components.values()) {
					((Component)comp).destroy();
				}			
				objs.remove(i);
			}
		}
	}
}
