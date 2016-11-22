package core;
public class Vector2 {

	public double x;
	public double y;
	
	public static final Vector2 ZERO = new Vector2(0, 0);
	public static final Vector2 ONE = new Vector2(1, 1);
	
	public static final Vector2 UP = new Vector2(0, -1); 
	public static final Vector2 DOWN = new Vector2(0, 1); 
	public static final Vector2 LEFT = new Vector2(-1, 0); 
	public static final Vector2 RIGHT = new Vector2(1, 0); 
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double squareMagnitude() {
		return (x * x + y * y);
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	public static double distance(Vector2 a, Vector2 b){
		return a.sub(b).magnitude();
	}
	
	public static double sqareDistance(Vector2 a, Vector2 b){
		return a.sub(b).squareMagnitude();
	}
	
	public Vector2 normalize() {
		double tmp = this.magnitude();
		if(tmp == 0) return Vector2.ZERO;
		x /= tmp;
		y /= tmp;
		return this;
	}
	
	public Vector2 invert(){
		return this.mul(-1);
	}
	
	public Vector2 leftNormal(){
		return new Vector2(-y, -x);
	}

	public Vector2 rightNormal(){
		return new Vector2(y, -x);
	}
	
	public static Vector2 reflect(Vector2 in, Vector2 surfaceNormal){
		 // Reflection -2*(V dot N)*N + V
		
		Vector2 ret = surfaceNormal.mul(-2 * (Vector2.dot(in, surfaceNormal))).add(in);
		return ret;
	}

	
	public static double dot(Vector2 a, Vector2 b){
		return (a.x * b.x + a.y * b.y);
	}
	
	public Vector2 mul(double m){
		return new Vector2(x * m, y * m);
	}
	
	public Vector2 mul(Vector2 other){
		return new Vector2(other.x * x, other.y * y);
	}
	
	public Vector2 div(double m){
		return new Vector2(x / m, y / m);
	}
	
	public Vector2 add(Vector2 other){
		return new Vector2(x + other.x, y + other.y);
	}
	
	public Vector2 sub(Vector2 other){
		return new Vector2(x - other.x, y - other.y);
	}
	
	@Override
	public String toString() {
		return "Vector2 [x=" + x + ", y=" + y + "]";
	}
	
	public Vector2 clone(){
		return new Vector2(x, y);
	}
	
}