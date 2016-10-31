package primitives;

import core.Vector2;

public class Rect{
	public Vector2 topLeft;
	public Vector2 topRight;
	public Vector2 bottomLeft;
	public Vector2 bottomRight;
	public Vector2 position;
	public double width;
	public double height;

	public Rect(Vector2 position, double width, double height){		
		this.width = width;
		this.height = height;
		
		topLeft = new Vector2(position.x - width/2, position.y - height/2);
		topRight = new Vector2(topLeft.x + width, topLeft.y);
		bottomLeft = new Vector2(topLeft.x, topLeft.y + height);
		bottomRight = new Vector2(topLeft.x + width, topLeft.y + height);
	}
}