package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class AppointmentSystemTest {

    AppointmentSystem appointmentSystem = new AppointmentSystem();

    @Test
    public void testAppointmentSystemInstantiation() {
        assertNotNull(appointmentSystem);
    }

    @Test
    public void testGetOfficeFromEmptyArrayList() {
        assertNull(appointmentSystem.getOffice("Test"));
    }

    @Test
    public void testAddOffice() {
        appointmentSystem.addOffice(new Office("Test"));
        assertNotNull(appointmentSystem.getOffice("Test"));
    }

    @Test
    public void testRemoveOffice() {
        appointmentSystem.removeOffice("Test");
        assertNull(appointmentSystem.getOffice("Test"));
    }
}
