package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTestParametrized {
    int getKittensArgument;
    int getKittensReturnExpected;

    public FelineTestParametrized(int getKittensArgument, int getKittensReturnExpected){
        this.getKittensArgument = getKittensArgument;
        this.getKittensReturnExpected = getKittensReturnExpected;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
        };
    }
    @Test
    public void isGetKittensWisArgumentReturnsEqualKittensCountTest() {
        Feline feline = new Feline();
        int actual =feline.getKittens(getKittensArgument);
        int expected = getKittensReturnExpected;
        assertEquals("Метод getKittens() класса Feline возвращает значение, не соответствующее передаваемому аргументу", expected, actual);
    }
}