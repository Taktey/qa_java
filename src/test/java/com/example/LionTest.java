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
                assertEquals(expectedExceptionMessage, actual);
            }
        }
        @Test
        public void isGetKittensCallingFelineGetKittensWithoutArgumentTest() throws Exception {
            int expected = 4;
            Lion lion = new Lion("Самец", feline);
            Mockito.when(feline.getKittens()).thenReturn(4);
            int actual = lion.getKittens();
            assertEquals(expected, actual);
        }
        @Test
        public void isGetKittensReturnsOneTest() throws Exception{
            Lion lion = new Lion("Самец", new Feline());
            int actual = lion.getKittens();
            int expected = lionGetKittensExpected;
            assertEquals(expected, actual);
        }

        @Test
        public void isGetFoodMethodIsCalingFelineClassGetFoodMethodTest() throws Exception {
            List<String> expected = List.of("1", "2", "3");
            Lion lion = new Lion("Самец", feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("1", "2", "3"));
            List<String> actual = lion.getFood();
            assertEquals(expected, actual);
        }
        @Test
        public void isGetFoodMethodReturnsPredatorFoodTest() throws Exception {
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Lion lion = new Lion("Самец", new Feline());
            List<String> actual = lion.getFood();
            assertEquals(expected, actual);
        }
    }