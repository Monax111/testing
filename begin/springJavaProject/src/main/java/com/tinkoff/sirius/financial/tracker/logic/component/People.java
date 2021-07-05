package com.tinkoff.sirius.financial.tracker.logic.component;


import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class People {

    @NotNull
    public Integer age;

    @NotNull
    public String Name;

    public Boolean vaccination = false;

    public List<String> knowledge = new ArrayList();
}
