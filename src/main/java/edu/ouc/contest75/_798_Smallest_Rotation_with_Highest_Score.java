package edu.ouc.contest75;

public class _798_Smallest_Rotation_with_Highest_Score {

    public int bestRotation(int[] A) {
        int N = A.length;
        int[] bad = new int[N];
        for (int i = 0; i < N; ++i) {
            int left = (i - A[i] + 1 + N) % N;
            int right = (i + 1) % N;
            bad[left]--;
            bad[right]++;
            if (left > right)
                bad[0]--;
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

    public static void main(String args[]) {
        //test case1
        _798_Smallest_Rotation_with_Highest_Score
                tester = new _798_Smallest_Rotation_with_Highest_Score();
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        int[] A = {2, 3, 1, 4, 0};
        System.out.println(tester.bestRotation(A));
        //Assert.assertTrue(tester.bestRotation(S, words) == 3);

    }
}
