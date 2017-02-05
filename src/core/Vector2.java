package core;

import org.jbox2d.common.Vec2;

public class Vector2{
	private Vec2 vec;
	
	public static final Vector2 ZERO = new Vector2(0, 0);
	public static final Vector2 ONE = new Vector2(1, 1);
	
	public static final Vector2 UP = new Vector2(0, -1); 
	public static final Vector2 DOWN = new Vector2(0, 1); 
	public static final Vector2 LEFT = new Vector2(-1, 0); 
	public static final Vector2 RIGHT = new Vector2(1, 0); 
	
	public Vector2(float x, float y) {
		vec = new Vec2();
		this.vec.x = x;
		this.vec.y = y;
	}
	
	public Vector2 (Vec2 vec){
		this(vec.x, vec.y);
	}
	
	public Vec2 getVec(){
		return vec;
	}
	
	public float getx(){
		return vec.x;
	}
	
	public float gety(){
		return vec.y;
	}
	
	public void setx(float x){
		vec.x = x;
	}

	public void sety(float y){
		vec.y = y;
	}
	
	public void setVector(Vec2 vec){
		this.vec = vec;
	}
	
	public float squareMagnitude() {
		return (vec.x * vec.x + vec.y * vec.y);
	}
	
	public float magnitude() {
		return (float)Math.sqrt(vec.x * vec.x + vec.y * vec.y);
	}
	
	public static float distance(Vector2 a, Vector2 b){
		return a.sub(b).magnitude();
	}
	
	public static float sqareDistance(Vector2 a, Vector2 b){
		return a.sub(b).squareMagnitude();
	}
	
	public Vector2 normalize() {
		float tmp = this.magnitude();
		if(tmp == 0) return Vector2.ZERO;
		vec.x /= tmp;
		vec.y /= tmp;
		return this;
	}
	
	public Vector2 invert(){
		return this.mul(-1);
	}
	
	public Vector2 leftNormal(){
		return new Vector2(-vec.y, -vec.x);
	}

	public Vector2 rightNormal(){
		return new Vector2(vec.y, -vec.x);
	}
	
	public static Vector2 reflect(Vector2 in, Vector2 surfaceNormal){
		// Reflection
		// V-2*(V dot N)*N
		return surfaceNormal.mul(-2 * (Vector2.dot(in, surfaceNormal))).add(in);
	}

	
	public static float dot(Vector2 a, Vector2 b){
		return (a.vec.x * b.vec.x + a.vec.y * b.vec.y);
	}
	
	public Vector2 mul(float m){
		return new Vector2(vec.x * m, vec.y * m);
	}
	
	public Vector2 mul(Vector2 other){
		return new Vector2(other.vec.x * vec.x, other.vec.y * vec.y);
	}
	
	public Vector2 div(float m){
		return new Vector2(vec.x / m, vec.y / m);
	}
	
	public Vector2 add(Vector2 other){
		return new Vector2(vec.x + other.vec.x, vec.y + other.vec.y);
	}
	
	public Vector2 sub(Vector2 other){
		return new Vector2(vec.x - other.vec.x, vec.y - other.vec.y);
	}
	
	@Override
	public String toString() {
		return "Vector2 [x=" + vec.x + ", y=" + vec.y + "]";
	}
	
	public Vector2 clone(){
		return new Vector2(vec.x, vec.y);
	}
	
}