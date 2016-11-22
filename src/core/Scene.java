package core;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
	
	public List<GraphiXObject> objects;
	
	public Scene(){
		objects = new ArrayList<GraphiXObject>();
	}
	
	public void Start(){}
	
	public void load(){
//		for(int i = 0; i < objects.size(); i++){
//			objects.get(i).destroy();
//		}
	}
	
	public void unload(){
		for(int i = objects.size()-1; i >= 0 ; i--){
			objects.get(i).destroyGO();
			objects.remove(i);
		}
	}

}
