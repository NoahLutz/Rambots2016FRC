package org.usfirst.frc.team1350.robot.utils;

public class Utils {
	
	
	public static boolean rangeCheck(float expected, float input, float precision) {
		float distance = expected-input;
		distance = Math.abs(distance);
		
		if(distance <= precision) {
			return true;
		}
		
		return false;
	}
	
	public static float remap(float value, float low1, float high1, float low2, float high2) {
		float output = low2 + (value - low1) * (high2 - low2) / (high1 - low1);
		
		return output;
	}

	public static double remap(double value, double low1, double high1, double low2, double high2) {
		double output = low2 + (value - low1) * (high2 - low2) / (high1 - low1);
		
		return output;
	}
}
