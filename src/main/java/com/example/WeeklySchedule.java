package com.example;

import java.util.ArrayList;

public class WeeklySchedule {

    private final int firstInterviewStartingHour = 8;
    private final int lastInterviewEndingHour = 4;
    private int lunchStartingHour;
    private int lunchEndingHour;
    private final int lunchDuration = 1;
    private ArrayList<InterviewSlot> interviewSlots;

    public WeeklySchedule() {
        interviewSlots = new ArrayList<InterviewSlot>();

        setLunchStartingHour(0);
        setLunchEndingHour(0);
    }

    public int getLastInterviewEndingHour() {
        return lastInterviewEndingHour;
    }

    public int getFirstInterviewStartingHour() {
        return firstInterviewStartingHour;
    }

    public int getLunchDuration() {
        return lunchDuration;
    }

    public int getLunchEndingHour() {
        return lunchEndingHour;
    }

    public void setLunchEndingHour(int lunchEndingHour) {
        this.lunchEndingHour = lunchEndingHour;
    }

    public int getLunchStartingHour() {
        return lunchStartingHour;
    }

    public void setLunchStartingHour(int lunchStartingHour) {
        this.lunchStartingHour = lunchStartingHour;
        calculateLunchEndingHour(lunchStartingHour);
    }

    private void calculateLunchEndingHour(int lunchStartingHour) {
        this.lunchEndingHour = lunchStartingHour + lunchDuration;

        if (lunchStartingHour == 12) {
            setLunchEndingHour(1);
        }

    }

    public void setAvailableInterviewSlotsByHourRange(String date, int startingHour, int endingHour) {
        int currentMeetingStartingHour = startingHour;
        int currentMeetingStartingMinute = 0;

        InterviewSlot interviewSlot = null;

        while (currentMeetingStartingHour != endingHour) {

            if (currentMeetingStartingHour != lunchStartingHour) {
                interviewSlot = getInterviewSlot(date, currentMeetingStartingHour, currentMeetingStartingMinute);
                if (interviewSlot == null) {
                    interviewSlots
                            .add(new InterviewSlot(date, currentMeetingStartingHour, currentMeetingStartingMinute));
                } else {
                    interviewSlot.setAvailable(true);
                }
            }

            currentMeetingStartingMinute = currentMeetingStartingMinute + 15;

            if (currentMeetingStartingMinute == 60) {
                currentMeetingStartingMinute = 0;
                currentMeetingStartingHour = currentMeetingStartingHour + 1;
            }

            if (currentMeetingStartingHour == 13) {
                currentMeetingStartingHour = 1;
            }

        }

    }

    public void setUnavailableInterviewSlotsByHourRange(String day, int startingHour, int endingHour) {
        int currentMeetingStartingHour = startingHour;
        int currentMeetingStartingMinute = 0;

        InterviewSlot interviewSlot = null;

        while (currentMeetingStartingHour != endingHour) {

            if (currentMeetingStartingHour != lunchStartingHour) {
                interviewSlot = getInterviewSlot(day, currentMeetingStartingHour, currentMeetingStartingMinute);

                if (interviewSlot == null) {
                    InterviewSlot newInterviewSlot = new InterviewSlot(day, currentMeetingStartingHour,
                            currentMeetingStartingMinute);
                    newInterviewSlot.setAvailable(false);
                    interviewSlots.add(newInterviewSlot);
                } else {
                    interviewSlot.setAvailable(false);
                }
            }

            currentMeetingStartingMinute = currentMeetingStartingMinute + 15;

            if (currentMeetingStartingMinute == 60) {
                currentMeetingStartingMinute = 0;
                currentMeetingStartingHour = currentMeetingStartingHour + 1;
            }

            if (currentMeetingStartingHour == 13) {
                currentMeetingStartingHour = 1;
            }

        }
    }

    public InterviewSlot getInterviewSlot(String day, int startingHour, int startingMinute) {
        for (InterviewSlot interviewSlot : interviewSlots) {
            if ((interviewSlot.getDay().equalsIgnoreCase(day)) && (interviewSlot.getStartingHour() == startingHour)
                    && (interviewSlot.getStartingMinute() == startingMinute)) {
                return interviewSlot;
            }
        }
        return null;
    }

    public void viewSchedule() {
        System.out.println("Test View schedule");
        for (InterviewSlot interviewSlot : interviewSlots) {
            System.out.println(interviewSlot.toString());
        }
    }
}
