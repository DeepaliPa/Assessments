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
public class StringBalanceTest {
    
    public StringBalanceTest() {
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

    /**
     * Test of returnStringExp method, of class StringBalance.
     */
    @Test
    public void testReturnStringExp() {
        System.out.println("returnStringExp");
        String expression = "";
        String[] expResult = null;
        String[] result = StringBalance.returnStringExp(expression);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class StringBalance.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StringBalance.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
