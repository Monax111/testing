package com.tinkoff.sirius.financial.tracker.logic.component;


import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class SiriusTest {

    @Test
    void whenPeopleValidThenMentorTeach() {

        Administration administration = mock(Administration.class);
        Mentor mentor = mock(Mentor.class);
        Sirius sirius = new Sirius(administration, mentor);

        People people = new People();

        when(administration.valid(people)).thenReturn(true);

        sirius.study(people);

        verify(mentor).teach(people);

    }

    @Test
    void whenPeopleInvalidThenThrow() {

        Administration administration = mock(Administration.class);
        Mentor mentor = mock(Mentor.class);
        Sirius sirius = new Sirius(administration, mentor);

        People people = new People();

        when(administration.valid(people)).thenReturn(false);

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> sirius.study(people));
        assertEquals("Без прививки нельзя", runtimeException.getMessage());

        verifyNoInteractions(mentor);
    }


    @Test
    void whenNameIsTimAndAgeIs22AndVaccinationIsTrueThenStudentStudiedTesting() {

        Administration administration = new Administration();
        Mentor mentor = new Mentor();
        Sirius sirius = new Sirius(administration, mentor);

        People people = new People();
        people.Name = "Tim";
        people.age = 22;
        people.vaccination = true;
        sirius.study(people);

        org.hamcrest.MatcherAssert.assertThat(people.knowledge, CoreMatchers.hasItem("Testing"));

        org.assertj.core.api.Assertions.assertThat(people.knowledge).contains("Testing");

    }


}