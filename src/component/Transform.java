package component;
import org.jbox2d.common.Vec2;

import core.GraphiXObject;
import core.Vector2;

public class Transform extends Component {

	public Vector2 position;
	public float rotation;
	public Vector2 scale;

	public Transform(Vector2 position, float rotation, Vector2 scale, GraphiXObject object) {
		super(object);
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	
	public Vector2 forward(){
		return new Vector2((float)Math.cos(rotation), (float)Math.sin(rotation));
	}
	
	public void translate(Vector2 position){}
	public void rotate(float rotation){}
	public void scale(Vector2 scale){}
}
