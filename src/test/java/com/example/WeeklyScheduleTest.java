package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class WeeklyScheduleTest {

    WeeklySchedule weeklySchedule = new WeeklySchedule();

    @Test
    public void testWeeklyScheduleInstantiation() {
        assertNotNull(weeklySchedule);
    }

    @Test
    public void testLunchDuration() {
        assertEquals(1, weeklySchedule.getLunchDuration());
    }

    @Test
    public void testGetFirstInterviewStartingHour() {
        assertEquals(8, weeklySchedule.getFirstInterviewStartingHour());
    }

    @Test
    public void testGetLastInterviewEndingHour() {
        assertEquals(4, weeklySchedule.getLastInterviewEndingHour());
    }

}
