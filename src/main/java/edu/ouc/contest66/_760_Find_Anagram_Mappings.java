package edu.ouc.contest66;

import java.util.Arrays;

import com.sun.tools.javac.util.Assert;

/**
 * @author wqx
 */
public class _760_Find_Anagram_Mappings {

    /**
     * Solution:
     *
     * @return
     */
    public int[] anagramMappings(int[] A, int[] B) {
        int[] P = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (B[j] == A[i]) {
                    P[i] = j;
                }
            }
        }
        return P;
    }

    public static void main(String args[]) {
        //test case1
        _760_Find_Anagram_Mappings tester = new _760_Find_Anagram_Mappings();
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        int[] expectedResult = {1, 4, 3, 2, 0};
        org.junit.Assert.assertArrayEquals(expectedResult, tester.anagramMappings(A, B));

        int[] C = {21, 5, 74, 5, 74, 21};
        int[] D = {21, 5, 74, 74, 5, 21};
        int[] expectedResult2 = {5, 4, 3, 4, 3, 5};
        org.junit.Assert.assertArrayEquals(expectedResult2, tester.anagramMappings(C, D));

    }
}
