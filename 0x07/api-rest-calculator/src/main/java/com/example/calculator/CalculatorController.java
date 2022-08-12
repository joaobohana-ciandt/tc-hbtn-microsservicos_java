package com.example.calculator;

import com.example.calculator.model.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        double result = calculator.sum(n1, n2);
        return String.format("%.2f + %.2f = %.2f", n1, n2, result);
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        double result = calculator.sub(n1, n2);
        return String.format("%.2f - %.2f = %.2f", n1, n2, result);
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        double result = calculator.divide(n1, n2);
        return String.format("%.2f / %.2f = %.2f", n1, n2, result);
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        int factorialOf = calculator.factorial(factorial);
        return String.format("%d! = %d", factorial, factorialOf);
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        int daysBetweenDates = calculator.calculeDayBetweenDate(localDate1, localDate2);
        return "There are " + daysBetweenDates + " days between " + localDate2 + " and " + localDate1 + ".";
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        Integer numToBinary = calculator.integerToBinary(n1);
        return String.format("The equivalent of number %d in binary is: %d.", n1, numToBinary);
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        String numToHex = calculator.integerToHexadecimal(n1);
        numToHex = numToHex.toUpperCase();
        return String.format("The equivalent of number %d in hex is: %s.", n1, numToHex);
    }

}
