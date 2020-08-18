package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private static final double DELTA = 0.00001;
    private Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void nonexistentOperation() {
        try {
            calculator.calculate(4, 20, '?');
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail("Operation not supported was expected");
    }

    @Test
    public void addsCorrectly() {
        assertEquals(15,
                calculator.calculate(10, 5, '+'),
                DELTA);
    }

    @Test
    public void subtractsCorrectly() {
        assertEquals(20,
                calculator.calculate(21, 1, '-'),
                DELTA);
    }

    @Test
    public void multiplyFirstZero() {
        assertEquals(0,
                calculator.calculate(0, 1, '*'),
                DELTA);
    }

    @Test
    public void dividesCorrectly() {
        assertEquals(5,
                calculator.calculate(10, 2, '/'),
                DELTA);
    }

    @Test
    public void divideByZero() {
        try {
            calculator.calculate(5, 0, '/');
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail("Cannot divide by 0 was expected");
    }

    @Test
    public void powerOfZero() {
       assertTrue("Result should be 0.0",
               calculator.calculate(0, 2, '^') == 0.0);
    }

    @Test
    public void toPowerZero() {
        assertEquals("Result should be 0.0", 1.0,
                calculator.calculate(10, 0, '^'), DELTA);
    }
}