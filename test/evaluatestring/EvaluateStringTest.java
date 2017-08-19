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
public class EvaluateStringTest {

    private void testReverse(String str, String testmsg, int expected) {
        EvaluateString eval = Tester.getInstance();
        try {
            int actualResult = eval.evaluate(str);
            assertTrue(testmsg, actualResult == expected);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void test1() {
        String testmsg = "Test1:If simple add(1,2) passed";
        int expected = 3;
        String str1 = "add(1,2)";
        testReverse(str1, testmsg, expected);
    }

}
