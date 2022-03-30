package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void isCatGetSoundClassCatReturnsMiay() {
        Cat cat = new Cat(new Feline());
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals("Метод getSound() класса Cat не возвращает Мяу", expected, actual);
    }

    @Test
    public void isGetFoodMethodIsCallingFelineClassGetFoodMethodTest() throws Exception {
        List<String> expected = List.of("1", "2", "3");
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("1", "2", "3"));
        List<String> actual = cat.getFood();
        assertEquals("Метод getFood() класса Cat не вызывает метод Метод getFood() класса Feline", expected, actual);
    }

    @Test
    public void isGetFoodMethodReturnsPredatorFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(new Feline());
        List<String> actual = cat.getFood();
        assertEquals("Метод getFood() класса Cat не возвращает пищу хищника", expected, actual);
    }
}