package core;

public class Bounds {
	
	public Vector2f min, max, center;
	public float width, height;
	
	public Bounds(Vector2f _min, Vector2f _max){
		min = _min;
		max = _max;
		
		width = _max.getx() -_min.getx();
		height = _max.gety() -_min.gety();
		center = new Vector2f(_min.getx() + width/2, _min.gety() + height/2);
	}

}
