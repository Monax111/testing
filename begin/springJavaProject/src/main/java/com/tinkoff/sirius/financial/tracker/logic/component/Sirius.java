package com.tinkoff.sirius.financial.tracker.logic.component;

public class Sirius {


    public Sirius(Administration administration, Mentor mentor) {
        this.administration = administration;
        this.mentor = mentor;
    }

    private Administration administration;
    private Mentor mentor;

    public void study(People people) {
        if (administration.valid(people)) {
            mentor.teach(people);
        } else {
            throw new RuntimeException("Без прививки нельзя");
        }
    }
}