package core.component;

import core.Component;
import core.Core;

public abstract class GXScript extends Component {

	private boolean notImplemented = false;
	
	public GXScript() {
		try{Update();}catch(Exception e){}
		if(!notImplemented)
			Core.addToUpdate(this);
	}
	
	public void init(){
		Awake();
		Start();
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
	public void Destroy(){}
	
	/**
	 * Start gets called at the beginning of the runtime and before the Start method
	 */
	public void Awake(){}
	
	/**
	 * Start gets called at the beginning of the runtime
	 */
	public void Start(){}
	

	protected final void _destroy(){
		Destroy();
		if(!notImplemented)
			Core.removeFromUpdate(this);
	}
}
