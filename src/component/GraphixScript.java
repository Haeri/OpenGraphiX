package component;

import core.GraphiXObject;
import core.Core;

public abstract class GraphiXScript extends Component {

	private boolean notImplemented = false;
	
	public GraphiXScript(GraphiXObject object) {
		super(object);
		try{Update();}catch(Exception e){}
		if(!notImplemented)
			Core.addToUpdate(this);
	}
	
	/**
	 * Update gets called once per frame. Put your code here that needs to get updated.
	 */
	public void Update(){
		notImplemented = true;
	}
	
	/**
	 * Destroys the component
	 */
	public void destroy(){
		if(!notImplemented)
			Core.removeFromUpdate(this);
	}
}
