package component;
import core.GraphiXObject;
import core.Vector2;

public class Transform extends Component {

	public Vector2 position;
	public double rotation;
	public Vector2 scale;

	public Transform(Vector2 position, double rotation, Vector2 scale, GraphiXObject object) {
		super(object);
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	
	public Vector2 forward(){
		return new Vector2(Math.cos(rotation), Math.sin(rotation));
	}
}
