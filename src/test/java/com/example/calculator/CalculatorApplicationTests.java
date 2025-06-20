package com.example.calculator;

import com.example.calculator.model.CalculatorRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testAddition() throws Exception {
        CalculatorRequest req = new CalculatorRequest("add", 3, 3);
        String json = objectMapper.writeValueAsString(req);
        mockMvc.perform(post("/api/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(5.0)));
    }

    @Test
    public void testDivision() throws Exception {
        CalculatorRequest req = new CalculatorRequest("divide", 10, 2);
        String json = objectMapper.writeValueAsString(req);
        mockMvc.perform(post("/api/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(5.0)));
    }

    @Test
    public void testDivisionByZero() throws Exception {
        CalculatorRequest req = new CalculatorRequest("divide", 10, 0);
        String json = objectMapper.writeValueAsString(req);
        mockMvc.perform(post("/api/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Division by zero")));
    }
}
