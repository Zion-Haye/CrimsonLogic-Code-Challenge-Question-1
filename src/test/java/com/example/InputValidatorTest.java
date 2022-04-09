package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    public void testValidateDayTrue() {
        assertTrue(InputValidator.validateDay("Monday"));
    }

    @Test
    public void testValidateDayFalse() {
        assertFalse(InputValidator.validateDay("June"));
    }

    @Test
    public void testValidateMinuteTrue() {
        assertTrue(InputValidator.validateMinute(30));
    }

    @Test
    public void testValidateMinuteFalse() {
        assertFalse(InputValidator.validateMinute(60));
    }

    @Test
    public void testValidateHourTrue() {
        assertTrue(InputValidator.validateHour(3));
    }

    @Test
    public void testValidateHourFalse() {
        assertFalse(InputValidator.validateHour(13));
    }
}
