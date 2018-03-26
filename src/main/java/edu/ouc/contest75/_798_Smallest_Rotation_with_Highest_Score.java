package edu.ouc.contest75;

import java.util.Arrays;

import org.junit.Assert;

public class _798_Smallest_Rotation_with_Highest_Score {

    public int bestRotation2(int[] A) {
        int N = A.length;
        int[] bad = new int[N];
        for (int i = 0; i < N; ++i) {
            int left = (i - A[i] + 1 + N) % N;
            int right = (i + 1) % N;
            bad[left]--;
            bad[right]++;
            if (left > right) {
                bad[0]--;
            }
        }

        int best = -N;
        int ans = 0, cur = 0;

        for (int i = 0; i < N; ++i) {
            cur += bad[i];
            if (cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
    }

    public int bestRotation(int[] A) {
        int res = 0;
        int max = 0;
        for (int k = 0; k < A.length; k++) {
            int curPoint = 0;
            for (int i = 0; i < A.length; i++) {
                curPoint += (A[i] <= i ? 1 : 0);
            }
            // shift
            reverse(A, 1, A.length - 1);
            reverse(A, 0, A.length - 1);
            //System.out.println("k:" + k + ",curPoint:" + curPoint);
            if (max < curPoint) {
                max = curPoint;
                res = k;
            }
        }
        return res;
    }

    private void reverse(int[] A, int begin, int end) {
        while (begin < end) {
            int t = A[begin];
            A[begin++] = A[end];
            A[end--] = t;
        }
    }

    public static void main(String args[]) {
        //test case1
        _798_Smallest_Rotation_with_Highest_Score
                tester = new _798_Smallest_Rotation_with_Highest_Score();

        int[] A = {2, 3, 1, 4, 0};
        System.out.println(tester.bestRotation(A));

        int[] A2 = {1, 3, 0, 2, 4};
        System.out.println(tester.bestRotation(A2));
    }
}
