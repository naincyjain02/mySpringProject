package com.naincy.SpringWebProject.javaProgram;

public class enhancedSwitchStatement {
	  public static void main(String[] args) {
	        String day = "MONDAY";
	        int hours = getWorkingHours(day);
	        System.out.println("Working hours on " + day + ": " + hours);
	    }

	    static int getWorkingHours(String day) {
	        return switch (day.toUpperCase()) {
	            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> 8;
	            case "SATURDAY" -> 4;
	            case "SUNDAY" -> 0;
	            default -> throw new IllegalArgumentException("Invalid day: " + day);
	        };
	    }
}
