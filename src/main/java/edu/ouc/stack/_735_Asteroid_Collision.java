package edu.ouc.stack;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;

import jdk.nashorn.internal.AssertsEnabled;

/**
 * @author wqx
 */
public class _735_Asteroid_Collision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int asteroid : asteroids) {

            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < 0 || asteroid > 0) {
                stack.push(asteroid);
            } else if (stack.peek() == -asteroid) {
                stack.pop();
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String args[]) {
        //test case1
        _735_Asteroid_Collision tester = new _735_Asteroid_Collision();
        int[] asteroids = {5, 10, -5};
        int[] expected = {5, 10};
        Assert.assertArrayEquals(expected, tester.asteroidCollision(asteroids));

        int[] asteroids2 = {8, -8};
        int[] expected2 = {};
        Assert.assertArrayEquals(expected2, tester.asteroidCollision(asteroids2));

        int[] asteroids3 = {10, 2, -5};
        int[] expected3 = {10};
        Assert.assertArrayEquals(expected3, tester.asteroidCollision(asteroids3));

        int[] asteroids4 = {-2, -1, 1, 2};
        int[] expected4 = {-2, -1, 1, 2};
        Assert.assertArrayEquals(expected4, tester.asteroidCollision(asteroids4));

        int[] asteroids5 = {10, 5, 4, 3, 2, -5};
        int[] expected5 = {10};
        Assert.assertArrayEquals(expected5, tester.asteroidCollision(asteroids5));

        int[] asteroids6 = {4, 3, 2, -6};
        int[] expected6 = {-6};
        Assert.assertArrayEquals(expected6, tester.asteroidCollision(asteroids6));

        int[] asteroids7 = {-2, -2, 1, -2};
        int[] expected7 = {-2, -2, -2};
        Assert.assertArrayEquals(expected7, tester.asteroidCollision(asteroids7));

    }

}
