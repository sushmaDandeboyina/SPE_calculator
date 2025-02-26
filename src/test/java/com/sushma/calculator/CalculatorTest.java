package com.sushma.calculator;

import org.junit.Test;
import static org.junit.Assert.*;


public class CalculatorTest {
    Calculator calci = new Calculator();
    @Test
    public void testPositiveSquareRoot() {
        assertEquals(3.0, calci.squareRoot(9),0.000);
        assertEquals(5.0, calci.squareRoot(25),0.000);
        assertEquals(Math.sqrt(3), calci.squareRoot(3), 0.001);
        assertEquals(Math.sqrt(4.8), calci.squareRoot(4.8), 0.001);
        assertNotEquals(2.0, calci.squareRoot(16),0.000);
    }

    @Test
    public void testZeroSquareRoot() {
        assertEquals(0.0, calci.squareRoot(0),0.000);
        assertNotEquals(2.0, calci.squareRoot(0),0.0001);
    }

    @Test
    public void testNegativeSquareRoot() {
        assertEquals(-1.0, calci.squareRoot(-6),0.000);
        assertNotEquals(3.0, calci.squareRoot(-9),0.000);
    }

    @Test
    public void testPositivePowerFunction() {
        assertEquals(27.0, calci.powerFunction(3, 3),0.000);
        assertEquals(32.0, calci.powerFunction(2, 5),0.000);
        assertNotEquals(30.0, calci.powerFunction(2, 5),0.000);
    }

    @Test
    public void testZeroPowerFunction() {
        assertEquals(0.0, calci.powerFunction(0, 5),0.000);
        assertEquals(1.0, calci.powerFunction(0, 0),0.000);
        assertNotEquals(0.0, calci.powerFunction(5, 0),0.000);
    }

    @Test
    public void testNegativePowerFunction() {
        assertEquals(0.25, calci.powerFunction(4, -1), 0.001);
        assertEquals(-8.0, calci.powerFunction(-2, 3),0.000);
        assertNotEquals(-0.111, calci.powerFunction(-3, -2), 0.001);
    }

    @Test
    public void testPositiveFactorial() {
        assertEquals(120, calci.factorial(5));
        assertEquals(5040, calci.factorial(7));
        assertNotEquals(362880, calci.factorial(10));
    }

    @Test
    public void testZeroFactorial() {
        assertEquals(1, calci.factorial(0));
        assertEquals(1, calci.factorial(1));
    }

    @Test
    public void testNegativeFactorial() {
        assertEquals(-1.0, calci.factorial(-5),0.000);
        assertNotEquals(6.0, calci.factorial(-3),0.000);
    }

    @Test
    public void testEdgeLogarithm() {
        assertEquals(-1.0, calci.logarithm(-5, 2),0.000);
        assertEquals(-1.0, calci.logarithm(5, -2),0.000);
        assertEquals(-1.0, calci.logarithm(5, 1),0.000);
    }

    @Test
    public void testLogarithm() {
        assertEquals(3.0, calci.logarithm(8, 2), 0.00001);
        assertEquals(2.0, calci.logarithm(100, 10), 0.00001);
        assertEquals(-1.0, calci.logarithm(0.5, 2), 0.00001);
        assertNotEquals(3.0, calci.logarithm(9, 3),0.000);
    }
}
