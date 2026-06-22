package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void test1() {
        assertEquals(5, 3 + 2);
    }

    @Test
    void test2() {
        assertEquals(6, 3 + 3);
    }
}