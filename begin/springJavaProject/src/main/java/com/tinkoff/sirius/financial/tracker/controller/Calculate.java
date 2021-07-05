package com.tinkoff.sirius.financial.tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
public class Calculate {

    @GetMapping("/pd")
    public Double findById(@RequestParam Integer id) {
        return id * 0.2;
    }

}