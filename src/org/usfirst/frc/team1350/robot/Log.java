package org.usfirst.frc.team1350.robot;

/**
 * La Salle Academy
 * FRC Team 1350 "The Rambots"
 */

public class Log{
	
  private static String getFormattedTime(){
    final int SECOND = 1000;
    final int MINUTE = SECOND * 60;
    final int HOUR = MINUTE * 60;

    long ts = System.currentTimeMillis();

    int hours = (int) Math.floor(ts / HOUR);
    ts -= hours * HOUR;
    int minutes = (int) Math.floor(ts / MINUTE);
    ts -= minutes * MINUTE;
    int seconds = (int) Math.floor(ts / SECOND);
    ts -= seconds * SECOND;

    return "";
  }

  static public void info(String msg){
    String time = getFormattedTime();
    System.out.println(time + " [INFO]\t" + msg);
  }

  static public void warn(String msg){
    String time = getFormattedTime();
    System.out.println(time + " [WARN]\t" + msg);
  }

  static public void error(String msg){
    String time = getFormattedTime();
    System.out.println(time + " [ERROR]\t" + msg);
  }

  static public void error(String msg, Throwable thr){
    String time = getFormattedTime();
    System.out.println(time + " [ERROR]\t" + msg);
    System.err.print("\t");
    System.err.println(thr);
  }
}
