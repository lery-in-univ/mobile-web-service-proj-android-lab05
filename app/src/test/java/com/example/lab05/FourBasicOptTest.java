package com.example.lab05;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourBasicOptTest {
    @Test
    public void should_1_add_1_be_2() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(2, opt.add(1, 1));
    }

    @Test
    public void should_100_add_minus_100_be_0() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(0, opt.add(100, -100));
    }

    @Test
    public void should_minus100_add_minus100_be_minus200() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(-200, opt.add(-100, -100));
    }

    @Test
    public void should_10_subtract_8_be_2() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(2, opt.subtract(10, 8));
    }

    @Test
    public void should_10_subtract_20_be_minus10() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(-10, opt.subtract(10, 20));
    }

    @Test
    public void should_10_subtract_minus20_be_30() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(30, opt.subtract(10, -20));
    }

    @Test
    public void should_2_multiply_5_be_10() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(10, opt.multiply(2, 5));
    }

    @Test
    public void should_2_multiply_0_be_0() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(0, opt.multiply(2, 0));
    }

    @Test
    public void should_2_multiply_minus10_be_minus20() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(-20, opt.multiply(2, -10));
    }

    @Test
    public void should_minus10_multiply_minus_20_be_200() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(200, opt.multiply(-10, -20));
    }

    @Test
    public void should_10_divide_2_be_5() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(5, opt.divide(10, 2));
    }

    // 정수 연산이므로 나머지를 버립니다.
    @Test
    public void should_10_divide_3_be_3() {
        FourBasicOpt opt = new FourBasicOpt();
        assertEquals(3, opt.divide(10, 3));
    }

    @Test
    public void should_10_divide_0_throw_error() {
        FourBasicOpt opt = new FourBasicOpt();
        assertThrows(ArithmeticException.class, opt.divide(10, 0));
    }
}