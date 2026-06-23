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
    @Test
    void test3() {
        assertEquals(7, 3 + 3);
    }
    @Test
    void test4() {
        assertEquals(7, 4 + 3);
    }
    @Test
    void test5() {
        assertEquals(8, 4 + 4);
    }
}