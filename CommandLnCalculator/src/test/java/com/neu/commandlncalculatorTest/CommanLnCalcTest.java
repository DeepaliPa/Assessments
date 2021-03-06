package com.neu.commandlncalculatorTest;

import com.neu.commandlncalculator.CommandLnCalc;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;

/**
 *
 * @author DeepaliP
 */
public class CommanLnCalcTest {

    public CommanLnCalcTest() {
    }

    @Test
    public void testEvaluate1() {
        System.out.println("Test for Addition");
        String expression = "add(1, 2)";
        CommandLnCalc instance = new CommandLnCalc();
        int expResult = 3;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluate2() {
        System.out.println("Test for Addition");
        String expression = "add(1, mult(2, 3))";
        CommandLnCalc instance = new CommandLnCalc();
        int expResult = 7;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluate3() {
        System.out.println("Test for multiplication");
        String expression = "mult(add(2, 2), div(9, 3))";
        CommandLnCalc instance = new CommandLnCalc();
        int expResult = 12;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluate4() {
        System.out.println("Test for let");
        String expression = "let(a, 5, add(a, a))";
        CommandLnCalc instance = new CommandLnCalc();
        int expResult = 10;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluate5() {
        System.out.println("Test for let");
        String expression = "let(a, 5, let(b, mult(a, 10), add(b, a)))";
        CommandLnCalc instance = new CommandLnCalc();
        int expResult = 55;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluate6() {
        System.out.println("Test for let");
        String expression = "let(a, let(b, 10, add(b, b)), let(b, 20, add(a, b)))";
        CommandLnCalc instance = new CommandLnCalc();
        int expResult = 40;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
    }
}
