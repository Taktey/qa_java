package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private final String expectedExceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
    private final int lionGetKittensExpected = 1;
    @Mock
    Feline feline;

    @Test
    public void isLionClassThrowsCorrectExceptionWithInvalidSexTest() throws Exception {
        try {
            Lion lion = new Lion("sfadfd", new Feline());
            fail("expected Exception for non invalid values of sex variable");
        } catch (Exception ex) {
            String actual = ex.getMessage();
            assertEquals("Сообщение об ошибке невалидного пола (sex) экземпляра класса Lion не соответствует ожидаемому", expectedExceptionMessage, actual);
        }
    }

    @Test
    public void isGetKittensCallingFelineGetKittensWithoutArgumentTest() throws Exception {
        int expected = 4;
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(4);
        int actual = lion.getKittens();
        assertEquals("Метод getKittens() класса Lion не вызывает метод getKittens() Feline без аргументов", expected, actual);
    }

    @Test
    public void isGetKittensReturnsOneTest() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int actual = lion.getKittens();
        int expected = lionGetKittensExpected;
        assertEquals("Метод getKittens() класса Lion не возвращает единицу", expected, actual);
    }

    @Test
    public void isGetFoodMethodIsCallingFelineClassGetFoodMethodTest() throws Exception {
        List<String> expected = List.of("1", "2", "3");
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("1", "2", "3"));
        List<String> actual = lion.getFood();
        assertEquals("Метод getFood() класса Lion не вызывает метод getFood() класса Feline", expected, actual);
    }

    @Test
    public void isGetFoodMethodReturnsPredatorFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец", new Feline());
        List<String> actual = lion.getFood();
        assertEquals("Метод getFood() класса Lion не возвращает пищу хищника", expected, actual);
    }
}