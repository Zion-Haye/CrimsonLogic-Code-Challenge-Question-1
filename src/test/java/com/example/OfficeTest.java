package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class OfficeTest {

    Office office = new Office("Test");

    @Test
    public void testOfficeInstantiation() {
        assertNotNull(office);
    }

    @Test
    public void testOfficerArrayInstantiation() {
        assertNotNull(office.getWeeklySchedule());
    }

    @Test
    public void testGetOfficeLocation() {
        String officeLocation = "Test";
        assertEquals(officeLocation, office.getOfficeLocation());
    }

    @Test
    public void testSetOfficeLocation() {
        String officeLocation = "Test2";
        office.setOfficeLocation("Test2");
        assertEquals(officeLocation, office.getOfficeLocation());
    }
}
