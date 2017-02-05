package core;

public class Bounds {
	
	public Vector2 min, max, center;
	public float width, height;
	
	public Bounds(Vector2 _min, Vector2 _max){
		min = _min;
		max = _max;
		
		width = _max.getx() -_min.getx();
		height = _max.gety() -_min.gety();
		center = new Vector2(_min.getx() + width/2, _min.gety() + height/2);
	}

}
