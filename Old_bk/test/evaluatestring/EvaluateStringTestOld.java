/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluatestring;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author DeepaliP
 */
public class EvaluateStringTestOld {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private void testEvaluate(String str, String testmsg, int expected) {
        EvaluateString eval = Tester.getInstance();
        try {
            int actualResult = eval.evaluate(str);
            assertTrue(testmsg, String.valueOf(actualResult).equals(String.valueOf(expected)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void test1() {
        String testmsg = "Test1:simple add(1,2) passed";
        int expected = 3;
        String str = "add(1,2)";
        testEvaluate(str, testmsg, expected);
    }

    /**
     * Test of isNumeric method, of class EvaluateString.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String expression = "";
        EvaluateString instance = new EvaluateString();
        boolean expResult = false;
        boolean result = instance.isNumeric(expression);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnStringExp method, of class EvaluateString.
     */
    @Test
    public void testReturnStringExp() {
        System.out.println("returnStringExp");
        String expression = "";
        EvaluateString instance = new EvaluateString();
        String[] expResult = null;
        String[] result = instance.returnStringExp(expression);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnStringExp2 method, of class EvaluateString.
     */
    @Test
    public void testReturnStringExp2() {
        System.out.println("returnStringExp2");
        String expression = "";
        EvaluateString instance = new EvaluateString();
        String[] expResult = null;
        String[] result = instance.returnStringExp2(expression);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluate method, of class EvaluateString.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        String expression = "";
        EvaluateString instance = new EvaluateString();
        int expResult = 0;
        int result = instance.evaluate(expression);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
