package com.example.calculator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.example.calculator.controller")
public class CalculatorApplication {
   public static void main(String[] args) {
       SpringApplication.run(CalculatorApplication.class, args);
   }
}
