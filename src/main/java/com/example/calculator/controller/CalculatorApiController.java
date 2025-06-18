
package com.example.calculator.controller;

import com.example.calculator.model.CalculatorRequest;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorApiController {

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestBody CalculatorRequest request) {
        double a = request.getA();
        double b = request.getB();
        String operation = request.getOperation();

        double result;
        switch (operation) {
            case "add":
                result = a + b;
                break;
            case "subtract":
                result = a - b;
                break;
            case "multiply":
                result = a * b;
                break;
            case "divide":
                if (b == 0) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(Map.of("error", "Division by zero"));
                }
                result = a / b;
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("error", "Invalid operation"));
        }
        return ResponseEntity.ok(Map.of("result", result));
    }
}
