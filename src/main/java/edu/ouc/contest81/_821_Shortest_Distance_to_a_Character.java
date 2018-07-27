package edu.ouc.contest81;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _821_Shortest_Distance_to_a_Character {

    public int[] shortestToChar(String S, char C) {
        List<Integer> indexOfC = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (C == S.charAt(i)) {
                indexOfC.add(i);
            }
        }
        int[] res = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            int minDis = Integer.MAX_VALUE;
            for (Integer index : indexOfC) {
                if (minDis > Math.abs(index - i)) {
                    minDis = Math.abs(index - i);
                }
            }
            res[i] = minDis;
        }
        return res;
    }

    public static void main(String args[]) {
        //test case1
        _821_Shortest_Distance_to_a_Character
                tester = new _821_Shortest_Distance_to_a_Character();
        String S = "loveleetcode";
        Character C = 'e';
        System.out.println(Arrays.toString(tester.shortestToChar(S, C)));

    }
}
