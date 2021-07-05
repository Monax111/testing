package com.tinkoff.sirius.financial.tracker.logic;

public class SomeLogic {

    public String isGood(Boolean age, Boolean size, Boolean hot) {
        if (age) {
            if (size && hot) {
                return "Good";
            } else {
                return "Normal";
            }
        } else {
            return "Bad";
        }
    }
}