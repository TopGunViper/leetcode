package edu.ouc.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _20_Valid_Parentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * <p>
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid
     * but "(]" and "([)]" are not.
     *
     * @param s
     *
     * @return
     */
    public boolean isValid(String s) {
        boolean retVal = true;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')') {
                    retVal = (stack.pop() == '(');
                } else if (c == '}') {
                    retVal = (stack.pop() == '{');
                } else if (c == ']') {
                    retVal = (stack.pop() == '[');
                }
                if(!retVal){
                    return retVal;
                }
            }
        }
        retVal = retVal ? stack.isEmpty() : retVal ;
        return retVal;
    }

    public static void main(String args[]) {
        //test case1
        _20_Valid_Parentheses tester = new _20_Valid_Parentheses();
        String s = "()[]{}";
        Assert.assertTrue(tester.isValid(s));

        String s2 = "()";
        Assert.assertTrue(tester.isValid(s2));

        String s3 = "([)]";
        Assert.assertFalse(tester.isValid(s3));

        String s4 = "(]";
        Assert.assertFalse(tester.isValid(s4));

        String s5 = "(";
        Assert.assertFalse(tester.isValid(s5));

        String s6 = "{{)}";
        Assert.assertFalse(tester.isValid(s6));

    }

}
