package org.usfirst.frc.team1350.robot.commands.shooter.autoaim;

import org.usfirst.frc.team1350.robot.Log;

public class AutoAimCalculations {
	
	public static double calculateAngle(double currentDistanceInMM, double velocityInMMPerSecond, double heightOfGoalInMM) {
		Log.info("CurrentDistanceInMM: " + currentDistanceInMM);
		Log.info("VelocityInMMPerSecond" + velocityInMMPerSecond);
		Log.info("HeightOfGoalInMM" + heightOfGoalInMM);
		
		double aTerm = calculateA(currentDistanceInMM, velocityInMMPerSecond);
		Log.info("ATerm: " + aTerm);
		double bTerm = currentDistanceInMM;
		Log.info("BTerm: " + bTerm);
		double cTerm = aTerm - heightOfGoalInMM;
		Log.info("CTerm: " + cTerm);
		
		double positiveQuad = quadratic(aTerm, bTerm, cTerm, true);
		double negativeQuad = quadratic(aTerm, bTerm, cTerm, false);
		Log.info("PositiveQuad: " + positiveQuad);
		Log.info("NegativeQuad: " + negativeQuad);
		
		double positiveInRads = Math.atan(positiveQuad);
		double positiveInDegrees = Math.toDegrees(positiveInRads);
		
		double negativeInRads = Math.atan(negativeQuad);
		double negativeInDegrees = Math.toDegrees(negativeInRads);
		
		Log.info("PositiveRads: " + positiveInRads);
		Log.info("NegativeRads: " + negativeInRads);
		
		Log.info("Positive Angle: " + positiveInDegrees);
		Log.info("Negative Angle: " + negativeInDegrees);
		
		return Math.abs(negativeInDegrees);
	}
	
	private static double calculateA(double distanceToGoal, double ballVelocity) {
		double top = calculateTopTerm(distanceToGoal, ballVelocity);
		
		return top/ballVelocity;
	}
	
	private static double calculateTopTerm(double distanceToGoal, double ballVelocity) {
		double xSquared = (double) Math.pow(distanceToGoal, 2);
		double top = (double) ((-4.9) * xSquared);
		
		return top;
	}
	
	private static double quadratic(double a, double b, double c, boolean positive) {
		double squareRtAC = 4 * a * c;
		squareRtAC = (double) Math.sqrt(squareRtAC);
		
		double current = (-b);
		
		if(positive) {
			current += squareRtAC;
		} else {
			current -= squareRtAC;
		}
		
		current = current / (2*a);
		
		return current;
	}
	
	
}
