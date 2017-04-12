package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import core.component.Transform;

public class GameObject {
	
	public boolean toDestroy = false;
	public Transform transform;

	private boolean enabled = false;
	private Map<Class<?>, Object> components;
	private static List<GameObject> objs = new ArrayList<GameObject>();
	private int OBJECT_ID;
	private static int objectCnt = 0;
			
	
	public GameObject(){
		OBJECT_ID = objectCnt++;
		components = new HashMap<>();
		objs.add(this);
		
		transform = new Transform(new Vector2f(0, 0), 0,  new Vector2f(1.0f, 1.0f));
		addComponent(transform);
	}
	
	/**
	 * Unique ID of this GameObject
	 * @return returns the ID
	 */
	public int getID(){
		return OBJECT_ID;
	}

	/**
	 * Add a component to the GameObject
	 * @param c, Component to be added
	 */
	public void addComponent(Component c){
		c.object = this;
		c.init();
		components.put(c.getClass(), c);
	}
	
	/**
	 * Get a component by Class
	 * @param classType, The Class to be returned
	 * @return returns the Component if it exists else null
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<?> classType){
	    Iterator<Entry<Class<?>, Object>> it = components.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry<Class<?>, Object> pair = (Map.Entry<Class<?>, Object>)it.next();
	    	if(classType.isAssignableFrom(pair.getKey()))
	    		return (T) pair.getValue();
	    }
	    return null;
	}
	
	/*
	 * Destroy the GameObject
	 */
	public void destroyGO(){
		toDestroy = true;
	}
	
	protected static void finalDestroy(){
		for(int i = objs.size()-1; i >= 0 ; i--){
			if(objs.get(i).toDestroy){
				for (Object comp : objs.get(i).components.values()) {
					((Component)comp)._destroy();
				}			
				objs.remove(i);
			}
		}
	}
}
