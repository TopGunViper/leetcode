package edu.ouc.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _71_Simplify_Path {

    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     * <p>
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     *
     * @param path
     *
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        Arrays.stream(path.split("/"))
                .filter(p -> !".".equals(p) && !"".equals(p))
                .forEach(elem -> {
                    if ("..".equals(elem) && !stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push(elem);
                    }
                });

        return "/" + stack.stream()
                .filter(e -> !e.equals(".."))
                .collect(Collectors.joining("/"));
    }

    public static void main(String args[]) {
        //test case1
        _71_Simplify_Path tester = new _71_Simplify_Path();
        String s = "/a/./b/../../c/";
        String expected = "/c";
        Assert.assertEquals(expected, tester.simplifyPath(s));

        String s2 = "/home/";
        String expected2 = "/home";
        Assert.assertEquals(expected2, tester.simplifyPath(s2));

        String s3 = "/home/../../";
        String expected3 = "/";
        Assert.assertEquals(expected3, tester.simplifyPath(s3));

        String s4 = "/..";
        String expected4 = "/";
        Assert.assertEquals(expected4, tester.simplifyPath(s4));

    }

}
