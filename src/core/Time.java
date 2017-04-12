package core;

public class Time {

	private static double deltaTime = 0;
	
	public void setDeltaTime(double delta){
		deltaTime = delta;
	}
	
	public static double deltaTime(){
		return deltaTime;
	}
	
	public static float deltaTimef(){
		return (float)deltaTime;
	}
}
