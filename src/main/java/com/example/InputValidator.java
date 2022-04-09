package com.example;

import java.util.ArrayList;

public class InputValidator {
    public static boolean validateHour(int hour) {
        if ((hour > 12) || (hour < 1)) {
            System.out.println("Invalid Hour Value.");
            return false;
        }

        return true;
    }

    public static boolean validateMinute(int minute) {
        if ((minute < 0) || (minute > 45)) {
            System.out.println("Invalid Minute Value.r");
            return false;
        }

        if (minute % 15 != 0) {
            System.out.println("Invalid Minute Value.b");
            return false;
        }

        return true;

    }

    public static boolean validateDay(String userInput) {
        ArrayList<String> days = new ArrayList<String>();
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");

        for (String day : days) {
            if (userInput.equalsIgnoreCase(day)) {
                return true;
            }
        }

        System.out.println("Invalid Day Entry.");
        return false;

    }
}
