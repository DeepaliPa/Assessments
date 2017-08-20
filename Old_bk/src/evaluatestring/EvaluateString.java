/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluatestring;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import org.apache.log4j.Logger;

/**
 *
 * @author DeepaliP
 */
public class EvaluateString {

    private Map<String, LinkedList<Integer>> varMap;
    final static Logger logger = Logger.getLogger(EvaluateString.class);

    public EvaluateString() {
        this.varMap = new HashMap<String, LinkedList<Integer>>();
    }

    public boolean isNumeric(String expression) {
        try {
            int d = Integer.parseInt(expression);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String[] returnStringExp(String expression) {

        if (logger.isDebugEnabled()) {
            logger.debug("String expression = " + expression);
        }

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

            } else if (strArr[0] == null || strArr[1] == null) {

                if (temp[i] >= 'a' && temp[i] <= 'z') {
                    StringBuffer sbuf = new StringBuffer();
                    while (i < temp.length && temp[i] >= 'a' && temp[i] <= 'z') {
                        sbuf.append(temp[i++]);
                    }
                    stack.push(sbuf.reverse().toString());
                    if (temp[i] == ',') {
                        strArr[0] = sbuf.toString();
                        int indexOfComma = i;
                        strArr[1] = expression.substring(i + 1, expression.length());
                        return strArr;
                    }
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

    public String[] returnStringExp2(String expression) {

        String strArr[] = new String[3];
        char temp[] = expression.toCharArray();
        Stack stack = new Stack();
        boolean flag1 = false, flag2 = false, flag3 = false;
        Map<Character, Integer> map = new HashMap<>();
        int count1 = 0, count2 = 0;

        strArr[0] = String.valueOf(temp[0]);

        int index = expression.indexOf(',');

        for (int i = index + 1; i < temp.length; i++) {

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

                    strArr[1] = sbuf.toString();
                    i--;
                }

            } else if (strArr[1] == null || strArr[2] == null && strArr[0] != null) {

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

                    strArr[1] = sb.reverse().toString();

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
                    strArr[2] = expression.substring(i + 1, expression.length());

                }

                flag3 = true;

            }
            if (flag1) {
                if (flag2) {
                    if (temp[i] == ',') {
                        int indexOfComma = i;
                        strArr[2] = expression.substring(i + 1, expression.length());
                        flag2 = false;
                    }

                }

            }
        }

        return strArr;
    }

    public int evaluate(String expression) {
        try {
            expression = expression.replaceAll("\\s", "");

            if (expression.matches("[a-zA-z]+")) {
                if (varMap.containsKey(expression)) {
                    return varMap.get(expression).peek();
                } else {
                    throw new IllegalArgumentException("The variable in let is not found");
                }

            }
            if (isNumeric(expression)) {
                return Integer.parseInt(expression);
            }
            if (expression.startsWith("add")) {

                String[] arrAdd = returnStringExp(expression.substring(4, expression.length() - 1));
                return evaluate(arrAdd[0]) + evaluate(arrAdd[1]);

            }
            if (expression.startsWith("sub")) {
                String[] arrAdd = returnStringExp(expression.substring(4, expression.length() - 1));
                return evaluate(arrAdd[0]) - evaluate(arrAdd[1]);
            }
            if (expression.startsWith("mult")) {
                String[] arrAdd = returnStringExp(expression.substring(5, expression.length() - 1));
                return evaluate(arrAdd[0]) * evaluate(arrAdd[1]);
            }
            if (expression.startsWith("div")) {

                String[] arrAdd = returnStringExp(expression.substring(4, expression.length() - 1));
                return evaluate(arrAdd[0]) / evaluate(arrAdd[1]);
            }
            if (expression.startsWith("let")) {
                String[] arrAdd = returnStringExp2(expression.substring(4, expression.length() - 1));
                String label = arrAdd[0];
                String expr1 = arrAdd[1];
                String expr2 = arrAdd[2];

                int valExpr1 = evaluate(expr1);
                LinkedList<Integer> currStack;
                if (!varMap.containsKey(label)) {
                    currStack = new LinkedList<Integer>();
                    varMap.put(label, currStack);
                }
                varMap.get(label).push(valExpr1);

                int valExpr2 = evaluate(expr2);

                LinkedList<Integer> prevStack = varMap.get(label);
                prevStack.pop();
                if (prevStack.isEmpty()) {
                    varMap.remove(label);
                }

                return valExpr2;

            }
        } catch (Exception e) {
            logger.error(e);
        }

        return 0;

    }

    // Driver method to test above methods
}

class Tester {

    static EvaluateString instance = new EvaluateString();

    public static EvaluateString getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        EvaluateString obj = new EvaluateString();
        try {
            if (args.length < 1 || args.length > 1) {
                throw new IllegalArgumentException("Error");
            }
        } catch (Exception e) {
            obj.logger.error(e);
            return;
        }

       //obj.evaluate("add(1,2)");
        System.out.println(obj.evaluate(args[0]));

    }

    //obj.evaluate("add(1,2)"); 
}
