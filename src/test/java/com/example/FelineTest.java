package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    String getFamilyExpected ="Кошачьи";
    int getKittensWithoutArgumentsExpected = 1;
    List<String> expectedPredatorFood = List.of("Животные", "Птицы", "Рыба");

    @Mock
    Animal animal;

    @Test
    public void isEatMeatMethodReturnsPredatorFoodTest() throws Exception{
        Feline feline = new Feline();
        List<String> actual =feline.eatMeat();
        List<String> expected = expectedPredatorFood;
        assertEquals(expected, actual);
    }

    @Test
    public void isGetFamilyReturnsFelineTest() {
        Feline feline = new Feline();
        String actual =feline.getFamily();
        assertEquals(getFamilyExpected, actual);
    }

    @Test
    public void isGetKittensWithoutArgumentsRetutns1Test() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = getKittensWithoutArgumentsExpected;
        assertEquals(expected, actual);
    }

}