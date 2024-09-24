package com.junitpushup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    private Example example;
    @BeforeEach
    public void init() {
        this.example = new Example();
    }
    @Test
    public void testSumar(){
        //Given - elementos que se tienen para realizar la prueba
        int numberA = 5;
        int numberB = 10;
        //When : Cuando
        int result = example.sumar(numberA, numberB);
        //Then - Entonces
        assertNotNull(result);
        assertEquals(15, result);
        assertInstanceOf(Integer.class, result);
    }   
}
