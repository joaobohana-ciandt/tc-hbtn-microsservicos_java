package com.example.calculator.controller;

import com.example.calculator.CalculatorController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/welcome")).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/addNumbers")
                        .param("number1", "10")
                        .param("number2", "20"))
                        .andReturn();

        assertEquals("10,00 + 20,00 = 30,00", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/subNumbers")
                        .param("number1", "10")
                        .param("number2", "20"))
                        .andReturn();

        assertEquals("10,00 - 20,00 = -10,00", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/divideNumbers")
                        .param("number1", "100")
                        .param("number2", "20"))
                .andReturn();

        assertEquals("100,00 / 20,00 = 5,00", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/factorial")
                        .param("factorial", "5"))
                        .andReturn();

        assertEquals("5! = 120", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2000-10-31")
                        .param("localDate2", "2000-11-15"))
                        .andReturn();

        assertEquals("There are 15 days between 2000-11-15 and 2000-10-31.", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/integerToBinary")
                        .param("number1", "25"))
                        .andReturn();

        assertEquals("The equivalent of number 25 in binary is: 11001.", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/integerToHexadecimal")
                        .param("number1", "236"))
                        .andReturn();

        assertEquals("The equivalent of number 236 in hex is: EC.", result.getResponse().getContentAsString());
    }
}