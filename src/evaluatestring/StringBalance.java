/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluatestring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author DeepaliP
 */
public class StringBalance {

    public static String[] returnStringExp(String expression) {

        String strArr[] = new String[2];
        char temp[] = expression.toCharArray();
        Stack stack = new Stack();
        boolean flag1 = false, flag2 = false, flag3 = false;
        Map<Character, Integer> map = new HashMap<>();
        int count1 = 0, count2 = 0;

        for (int i = 0; i < temp.length; i++) {

            if (temp[i] == ' ') {
                continue;
            }

            if (temp[i] >= '0' && temp[i] <= '9' && !flag3) {
                if (!flag1) {
                    flag1 = true;
                    flag2 = true;
                    StringBuffer sbuf = new StringBuffer();
                    while (i < temp.length && temp[i] >= '0' && temp[i] <= '9') {
                        sbuf.append(temp[i++]);
                    }

                    strArr[0] = sbuf.toString();
                    i--;
                }

            } else if (strArr[0] == null || strArr == null) {

                if (temp[i] >= 'a' && temp[i] <= 'z') {
                    StringBuffer sbuf = new StringBuffer();
                    while (i < temp.length && temp[i] >= 'a' && temp[i] <= 'z') {
                        sbuf.append(temp[i++]);
                    }
                    stack.push(sbuf.reverse().toString());
                }

                if (count1 != 0 && count2 != 0 && count1 == count2 && !stack.isEmpty()) {
                    StringBuffer sb = new StringBuffer();
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }

                    strArr[0] = sb.reverse().toString();

                } else if (temp[i] == '(') {
                    map.put(temp[i], map.get(temp[i]) == null ? 1 : (map.get(temp[i]) + 1));
                    count1 = map.get(temp[i]);
                    stack.push(temp[i]);
                } else if (temp[i] == ')') {
                    map.put(temp[i], map.get(temp[i]) == null ? 1 : (map.get(temp[i]) + 1));
                    count2 = map.get(temp[i]);
                    stack.push(temp[i]);
                } else {
                    stack.push(temp[i]);
                }

                if (temp[i] == ',' && stack.empty()) {
                    int indexOfComma = i;
                    strArr[1] = expression.substring(i + 1, expression.length());

                }

                flag3 = true;

            }
            if (flag1) {
                if (flag2) {
                    if (temp[i] == ',') {
                        int indexOfComma = i;
                        strArr[1] = expression.substring(i + 1, expression.length());
                        flag2 = false;
                    }

                }

            }
        }

        return strArr;
    }

    public static void main(String[] args) {

        String arr[] = returnStringExp("5,5");
        //add(2,4)

        System.out.println(Arrays.toString(arr));

    }

}
