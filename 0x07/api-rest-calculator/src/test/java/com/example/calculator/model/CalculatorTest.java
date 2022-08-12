package com.example.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();
    
    @BeforeEach
    void init(){
        System.out.println("teste");
    }

    @Test
    void sumTest() {
        double num1 = 10;
        double num2 = 15;
        double result = calculator.sum(num1, num2);
        assertEquals(result, 25.0);
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () ->{
            double num1 = 10;
            double num2 = Double.parseDouble(null);
            calculator.sum(num1, num2);
        });
    }

    @Test
    void subTest() {
        double num1 = 10;
        double num2 = 15;
        double result = calculator.sub(num1, num2);
        assertEquals(result, -5.0);
    }

    @Test
    void divideTest() {
        double num1 = 6;
        double num2 = 3;
        double result = calculator.divide(num1, num2);
        assertEquals(result, 2.0);
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () ->{
            double num1 = 10;
            double num2 = 0;
            calculator.divide(num1, num2);
        });
    }

    @Test
    void factorialTest() {
        int num = 5;
        int result = calculator.factorial(num);
        assertEquals(result, 120);
    }

    @Test
    void integerToBinaryTest() {
        int num = 25;
        int result = calculator.integerToBinary(num);
        assertEquals(result, 11001);
    }

    @Test
    void integerToHexadecimalTest() {
        int num = 236;
        String result = calculator.integerToHexadecimal(num);
        assertEquals("ec", result);
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate localDate1 = LocalDate.parse("2000-10-31");
        LocalDate localDate2 = LocalDate.parse("2000-10-15");

        int result = calculator.calculeDayBetweenDate(localDate2, localDate1);
        assertEquals(16, result);
    }
}
