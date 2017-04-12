package core.component;

import core.Component;
import core.Matrix3f;
import core.Vector2f;

public class Transform extends Component {

	public Vector2f position;
	public float rotation;
	public Vector2f scale;
	
	public Transform parent;

	private Matrix3f cachedTransformationMatrix;
	
	public Transform(Vector2f position, float rotation, Vector2f scale) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	
	public void setParent(Transform parent){
		this.parent = parent;
	}
	
	public Matrix3f getTransformation(){
		if(parent != null)
			return parent.getTransformation().mul(getLocalTransformation());
		else
			return getLocalTransformation();
	}
	
	private Matrix3f getLocalTransformation(){
		return Matrix3f.createTranslation(position).mul(Matrix3f.createRotation(rotation).mul(Matrix3f.createScale(scale).mul(Matrix3f.IDENTITY)));
	}
	
	public Vector2f forward(){
		return new Vector2f((float)Math.cos(rotation), (float)Math.sin(rotation));
	}
	
	public void translate(Vector2f position){
		this.position = this.position.add(position);
	}
	
	public void rotate(float rotation){
		this.rotation += rotation;
	}
	
	public void scale(Vector2f scale){
		this.scale = this.scale.add(scale);
	}
}
