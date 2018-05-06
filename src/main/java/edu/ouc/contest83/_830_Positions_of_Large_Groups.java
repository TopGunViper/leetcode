package edu.ouc.contest83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830_Positions_of_Large_Groups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S.length() < 3) {
            return res;
        }
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; ) {
            int k = i;
            while (k < arr.length && arr[k] == arr[i]) {
                k++;
            }
            if (k - i > 2) {
                res.add(Arrays.asList(i, k - 1));
            }
            i = k;
        }
        return res;
    }

    public static void main(String args[]) {
        _830_Positions_of_Large_Groups
                tester = new _830_Positions_of_Large_Groups();
        String str = "abcdddeeeeaabbbcd";
        System.out.println(Arrays.toString(tester.largeGroupPositions(str).toArray()));

    }
}
