package component;
import core.GraphiXObject;
import core.Vector2;

public class Transform extends Component {

	public Vector2 position;
	public Vector2 rotation;
	public Vector2 scale;

	public Transform(Vector2 position, Vector2 rotation, Vector2 scale, GraphiXObject object) {
		super(object);
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
}
