package com.tinkoff.sirius.financial.tracker;

import com.tinkoff.sirius.financial.tracker.controller.Calculate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class ApplicationTest {

    @Autowired
    Calculate Calculate;

    @Test
    void contextUp(){
        Double result = Calculate.findById(123);
        assertThat(result).isEqualTo(24.6);
    }

}