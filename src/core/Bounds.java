package core;

public class Bounds {
	
	public Vector2 min, max, center;
	public double width, height;
	
	public Bounds(Vector2 _min, Vector2 _max){
		min = _min;
		max = _max;
		
		width = _max.x -_min.x;
		height = _max.y -_min.y;
		center = new Vector2(_min.x + width/2, _min.y + height/2);
	}

}
