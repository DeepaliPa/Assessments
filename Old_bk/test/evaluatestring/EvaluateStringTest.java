/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluatestring;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DeepaliP
 */
public class EvaluateStringTest {
    
    public EvaluateStringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
//
//    /**
//     * Test of isNumeric method, of class EvaluateString.
//     */
//    @Test
//    public void testIsNumeric() {
//        System.out.println("isNumeric");
//        String expression = "";
//        EvaluateString instance = new EvaluateString();
//        boolean expResult = false;
//        boolean result = instance.isNumeric(expression);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of returnStringExp method, of class EvaluateString.
//     */
//    @Test
//    public void testReturnStringExp() {
//        System.out.println("returnStringExp");
//        String expression = "";
//        EvaluateString instance = new EvaluateString();
//        String[] expResult = null;
//        String[] result = instance.returnStringExp(expression);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of returnStringExp2 method, of class EvaluateString.
//     */
//    @Test
//    public void testReturnStringExp2() {
//        System.out.println("returnStringExp2");
//        String expression = "";
//        EvaluateString instance = new EvaluateString();
//        String[] expResult = null;
//        String[] result = instance.returnStringExp2(expression);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of evaluate method, of class EvaluateString.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        String expression = "add(1, 2)";
        EvaluateString instance = new EvaluateString();
        int expResult = 3;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
