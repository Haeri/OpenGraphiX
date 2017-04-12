package core;

import org.jbox2d.common.Vec2;

public class Vector2f{
	private Vec2 vec;
	
	public static final Vector2f ZERO = new Vector2f(0, 0);
	public static final Vector2f ONE = new Vector2f(1, 1);
	
	public static final Vector2f UP = new Vector2f(0, -1); 
	public static final Vector2f DOWN = new Vector2f(0, 1); 
	public static final Vector2f LEFT = new Vector2f(-1, 0); 
	public static final Vector2f RIGHT = new Vector2f(1, 0); 
	
	public Vector2f(float x, float y) {
		vec = new Vec2();
		this.vec.x = x;
		this.vec.y = y;
	}
	
	public Vector2f (Vec2 vec){
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
	
	public static float distance(Vector2f a, Vector2f b){
		return a.sub(b).magnitude();
	}
	
	public static float sqareDistance(Vector2f a, Vector2f b){
		return a.sub(b).squareMagnitude();
	}
	
	public Vector2f normalize() {
		float tmp = this.magnitude();
		if(tmp == 0) return Vector2f.ZERO;
		vec.x /= tmp;
		vec.y /= tmp;
		return this;
	}
	
	public Vector2f invert(){
		return this.mul(-1);
	}
	
	public Vector2f leftNormal(){
		return new Vector2f(-vec.y, -vec.x);
	}

	public Vector2f rightNormal(){
		return new Vector2f(vec.y, -vec.x);
	}
	
	public static Vector2f reflect(Vector2f in, Vector2f surfaceNormal){
		// Reflection
		// V-2*(V dot N)*N
		return surfaceNormal.mul(-2 * (Vector2f.dot(in, surfaceNormal))).add(in);
	}

	
	public static float dot(Vector2f a, Vector2f b){
		return (a.vec.x * b.vec.x + a.vec.y * b.vec.y);
	}
	
	public Vector2f mul(float m){
		return new Vector2f(vec.x * m, vec.y * m);
	}
	
	public Vector2f mul(Vector2f other){
		return new Vector2f(other.vec.x * vec.x, other.vec.y * vec.y);
	}
	
	public Vector2f div(float m){
		return new Vector2f(vec.x / m, vec.y / m);
	}
	
	public Vector2f add(Vector2f other){
		return new Vector2f(vec.x + other.vec.x, vec.y + other.vec.y);
	}
	
	public Vector2f sub(Vector2f other){
		return new Vector2f(vec.x - other.vec.x, vec.y - other.vec.y);
	}
	
	@Override
	public String toString() {
		return "Vector2 [x=" + vec.x + ", y=" + vec.y + "]";
	}
	
	public Vector2f clone(){
		return new Vector2f(vec.x, vec.y);
	}
	
}