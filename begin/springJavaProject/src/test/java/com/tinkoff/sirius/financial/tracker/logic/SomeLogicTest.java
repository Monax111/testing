package com.tinkoff.sirius.financial.tracker.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeLogicTest {
    @Test
    public void testIsGood() {
        // Arrange
        SomeLogic someLogic = new SomeLogic();
        boolean age = true;
        boolean size = true;
        boolean hot = true;

        // Act
        String actualIsGoodResult = someLogic.isGood(age, size, hot);

        // Assert
        assertEquals("Good", actualIsGoodResult);
    }

    @Test
    public void testIsGood2() {
        // Arrange
        SomeLogic someLogic = new SomeLogic();
        boolean age = false;
        boolean size = true;
        boolean hot = true;

        // Act
        String actualIsGoodResult = someLogic.isGood(age, size, hot);

        // Assert
        assertEquals("Bad", actualIsGoodResult);
    }

    @Test
    public void testIsGood3() {
        // Arrange
        SomeLogic someLogic = new SomeLogic();
        boolean age = true;
        boolean size = false;
        boolean hot = true;

        // Act
        String actualIsGoodResult = someLogic.isGood(age, size, hot);

        // Assert
        assertEquals("Normal", actualIsGoodResult);
    }

    @Test
    public void testIsGood4() {
        // Arrange
        SomeLogic someLogic = new SomeLogic();
        boolean age = true;
        boolean size = true;
        boolean hot = false;

        // Act
        String actualIsGoodResult = someLogic.isGood(age, size, hot);

        // Assert
        assertEquals("Normal", actualIsGoodResult);
    }
}

