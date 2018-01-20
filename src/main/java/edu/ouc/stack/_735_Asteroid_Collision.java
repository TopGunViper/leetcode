package edu.ouc.stack;

import java.util.Arrays;
import java.util.Stack;

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

            if(stack.isEmpty() || stack.peek() < 0 || asteroid > 0) {
                stack.push(asteroid);
            }else if(stack.peek() == -asteroid ){
                stack.pop();
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }

    public static void main(String args[]) {
        //test case1
        _735_Asteroid_Collision tester = new _735_Asteroid_Collision();
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(tester.asteroidCollision(asteroids)));

        int[] asteroids2 = {8, -8};
        System.out.println(Arrays.toString(tester.asteroidCollision(asteroids2)));

        int[] asteroids3 = {10, 2, -5};
        System.out.println(Arrays.toString(tester.asteroidCollision(asteroids3)));

        int[] asteroids4 = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(tester.asteroidCollision(asteroids4)));

        int[] asteroids5 = {10, 5, 4, 3, 2, -5};
        System.out.println(Arrays.toString(tester.asteroidCollision(asteroids5)));

        int[] asteroids6 = {4, 3, 2, -6};
        System.out.println(Arrays.toString(tester.asteroidCollision(asteroids6)));

        int[] asteroids7 = {-2,-2,1,-2};
        System.out.println(Arrays.toString(tester.asteroidCollision(asteroids7)));

    }

}
