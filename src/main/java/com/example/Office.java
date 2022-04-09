package com.example;

public class Office {

    private String officeLocation;
    private WeeklySchedule weeklySchedule;

    public Office(String officeLocation) {
        setOfficeLocation(officeLocation);
        weeklySchedule = new WeeklySchedule();
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public void viewSchedule() {
        weeklySchedule.viewSchedule();
    }

    public void setLunchStartingHour(int lunchStartingHour) {
        weeklySchedule.setLunchStartingHour(lunchStartingHour);
    }

    public void setAvailableInterviewSlotsByHourRange(String date, int startingHour, int endingHour) {
        weeklySchedule.setAvailableInterviewSlotsByHourRange(date, startingHour, endingHour);
    }

    public void setUnavailableInterviewSlotsByHourRange(String date, int startingHour, int endingHour) {
        weeklySchedule.setUnavailableInterviewSlotsByHourRange(date, startingHour, endingHour);
    }

    public WeeklySchedule getWeeklySchedule() {
        return weeklySchedule;
    }

}
