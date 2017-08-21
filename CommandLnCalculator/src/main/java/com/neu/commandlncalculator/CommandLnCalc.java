package com.neu.commandlncalculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Example of the calculator in Java that evaluates expressions in a very simple
 * integer expression language.
 *
 * @author DeepaliP
 * @version 1.0
 */
public class CommandLnCalc {

    private Map<String, LinkedList<Integer>> varMap;
    final static Logger logger = Logger.getLogger(CommandLnCalc.class);
    int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
    public static final BigInteger INTEGER_MIN = BigInteger.valueOf((long) Integer.MIN_VALUE);
    public static final BigInteger INTEGER_MAX = BigInteger.valueOf((long) Integer.MAX_VALUE);

    public CommandLnCalc() {
        this.varMap = new HashMap<String, LinkedList<Integer>>();
    }

    /**
     * isNumeric() checks if given string is a number
     *
     * @param expression is the string passed
     * @return true if its a number or returns false
     *
     */
    public boolean isNumeric(String expression) {
        try {
            int d = Integer.parseInt(expression);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * isInIntegerRange() checks if a number is in the range
     *
     * @param number is the input number passed
     * @return isInRange is returned along with number and min and max Integer
     * range
     *
     */
    public boolean isInIntegerRange(Number number) {
        return isInRange(number, INTEGER_MIN, INTEGER_MAX);
    }

    public static boolean isInRange(Number number, BigInteger min,
            BigInteger max) {
        try {
            BigInteger bigInteger = null;
            if (number instanceof Byte || number instanceof Short
                    || number instanceof Integer || number instanceof Long) {
                bigInteger = BigInteger.valueOf(number.longValue());
            } else if (number instanceof Float || number instanceof Double) {
                bigInteger = new BigDecimal(number.doubleValue())
                        .toBigInteger();
            } else if (number instanceof BigInteger) {
                bigInteger = (BigInteger) number;
            } else if (number instanceof BigDecimal) {
                bigInteger = ((BigDecimal) number).toBigInteger();
            } else {
                // not a standard number
                bigInteger = new BigDecimal(number.doubleValue())
                        .toBigInteger();
            }
            return max.compareTo(bigInteger) >= 0
                    && min.compareTo(bigInteger) <= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * returnStringExp() splits input string into the form of individual
     * expressions for add,mult,div,sub
     *
     * @param expression is the string passed
     * @return array of separate expressions strArr[0],strArr[1]
     *
     *
     */
    public String[] returnStringExp(String expression) {

        if (logger.isDebugEnabled()) {
            logger.debug("String expression = " + expression);
        }

        if (logger.isInfoEnabled()) {
            logger.info("This is info : " + expression);
        }

        String strArr[] = new String[2];
        char temp[] = expression.toCharArray();
        Stack stack = new Stack();
        boolean flag1 = false, flag2 = false, flag3 = false;
        Map<Character, Integer> map = new HashMap();
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

    /**
     * returnStringExp2() splits input string into the form of individual
     * expressions for let
     *
     * @param expression is the string passed
     * @return array of separate expressions strArr[0],strArr[1],strArr[2]
     *
     *
     */
    public String[] returnStringExp2(String expression) {

        String strArr[] = new String[3];
        char temp[] = expression.toCharArray();
        Stack stack = new Stack();
        boolean flag1 = false, flag2 = false, flag3 = false;
        Map<Character, Integer> map = new HashMap();
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

    /**
     * evaluate() evaluates the input string and perform operation
     *
     * @param expression is the string passed
     * @return value generated by an operation
     *
     *
     */
    public int evaluate(String expression) {

        try {

            if (checksyntax(expression) == true) {
                expression = expression.replaceAll("\\s", "");

                if (expression.matches("[a-zA-z]+")) {
                    if (varMap.containsKey(expression)) {
                        return varMap.get(expression).peek();
                    } else {

                        logger.error("The variable in let is not found");
                        throw new IllegalArgumentException("The variable in let is not found");
                    }

                } else if (isNumeric(expression)) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Expression is a number: Expr[0] = " + Integer.parseInt(expression));
                    }

                    int num = Integer.parseInt(expression);
                    if (!isInIntegerRange(num)) {
                        logger.error("Invalid number");
                        throw new IllegalArgumentException("Invalid number");

                    } else {
                        return Integer.parseInt(expression);
                    }
                } else if (expression.startsWith("add")) {

                    String[] arrAdd = returnStringExp(expression.substring(4, expression.length() - 1));
                    if (logger.isDebugEnabled()) {
                        logger.debug("Addition Expression: Expr[0] = " + arrAdd[0] + ", Expr[1] = " + arrAdd[1]);
                    }
                    return evaluate(arrAdd[0]) + evaluate(arrAdd[1]);

                } else if (expression.startsWith("sub")) {

                    String[] arrAdd = returnStringExp(expression.substring(4, expression.length() - 1));
                    if (logger.isDebugEnabled()) {
                        logger.debug("Subtraction Expression: Expr[0] = " + arrAdd[0] + ", Expr[1] = " + arrAdd[1]);
                    }
                    return evaluate(arrAdd[0]) - evaluate(arrAdd[1]);

                } else if (expression.startsWith("mult")) {
                    String[] arrAdd = returnStringExp(expression.substring(5, expression.length() - 1));

                    if (logger.isDebugEnabled()) {
                        logger.debug("Multiplication Expression: Expr[0] = " + arrAdd[0] + ", Expr[1] = " + arrAdd[1]);
                    }

                    return evaluate(arrAdd[0]) * evaluate(arrAdd[1]);
                }
                if (expression.startsWith("div")) {

                    String[] arrAdd = returnStringExp(expression.substring(4, expression.length() - 1));

                    if (logger.isDebugEnabled()) {
                        logger.debug("Division Expression: Expr[0] = " + arrAdd[0] + ", Expr[1] = " + arrAdd[1]);
                    }
                    return evaluate(arrAdd[0]) / evaluate(arrAdd[1]);

                } else if (expression.startsWith("let")) {

                    String[] arrAdd = returnStringExp2(expression.substring(4, expression.length() - 1));
                    String label = arrAdd[0];
                    String expr1 = arrAdd[1];
                    String expr2 = arrAdd[2];

                    if (logger.isDebugEnabled()) {
                        logger.debug("Let Expression: Expr[0] = " + arrAdd[0] + ", Expr[1] = " + arrAdd[1] + ", Expr[2] = " + arrAdd[2]);
                    }

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
                } else {
                    logger.error("Invalid operation entered!");
                    throw new IllegalArgumentException("Invalid operation entered!");
                }
            } else {
                logger.error("Invalid syntax");
                throw new IllegalArgumentException("Invalid syntax!");
            }
        } catch (Exception e) {
            logger.error("Error in evaluate method", e);
        }

        return 0;

    }

    /**
     * checksyntax() validates the syntax of the string
     *
     * @param expression is the string passed
     * @return true or false
     *
     *
     */
    public boolean checksyntax(String expression) {
        Stack stack = new Stack();
        char temp[] = expression.toCharArray();
        Map<Character, Integer> map = new HashMap();
        int count1 = 0, count2 = 0;

        expression = expression.replaceAll("\\s", "");

        try {

            if (String.valueOf(expression).matches("^null|$")) {
                return false;
            }
            if (expression.matches("[()]")) {
                return false;
            }
            for (int i = 0; i < temp.length; i++) {

                if (temp[i] == ' ') {
                    continue;

                } else if (temp[i] == '(') {
                    map.put(temp[i], map.get(temp[i]) == null ? 1 : (map.get(temp[i]) + 1));
                    count1 = map.get(temp[i]);
                    stack.push(temp[i]);
                } else if (temp[i] == ')') {
                    map.put(temp[i], map.get(temp[i]) == null ? 1 : (map.get(temp[i]) + 1));
                    count2 = map.get(temp[i]);
                    stack.push(temp[i]);
                }

            }

            if (count1 != count2) {
                return false;

            }

        } catch (Exception e) {

            logger.error("Syntactical Error! Invalid expression format!");

        }

        return true;

    }

    /**
     * @param args the command line argument
     *
     */
    public static void main(String[] args) {
        CommandLnCalc obj = new CommandLnCalc();
        BasicConfigurator.configure();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String expression = sc.nextLine();
        try {
            int res = obj.evaluate(expression);

            if (res == 0) {
                throw new IllegalArgumentException("Please check the format of the string!");
            } else {
                System.out.println("Output is: " + res);
            }

        } catch (Exception e) {

            logger.error(e);

        }

    }

}
