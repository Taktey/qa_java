package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTestParametrized {
    private final String sex;
    private final boolean hasMane;

    public LionTestParametrized(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные:{0},{1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void isDoesHaveManeMethodReturnsCorrectHaseManeTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean expected = hasMane;
        boolean actual = lion.doesHaveMane();
        assertEquals("Зависимость значения переменной hasMane от переменной sex нарушена", expected, actual);
    }

}