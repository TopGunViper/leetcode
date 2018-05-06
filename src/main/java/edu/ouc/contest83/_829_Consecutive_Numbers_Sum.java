package edu.ouc.contest83;

public class _829_Consecutive_Numbers_Sum {

    public int consecutiveNumbersSum(int N) {
        int sum,count = 0;
        for (int i = 1; i <= N; i++) {
            sum = i * (i - 1) / 2;
            if (sum >= N) {
                break;
            }
            int diff = N - sum;
            if (diff % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        //test case1
        _829_Consecutive_Numbers_Sum
                tester = new _829_Consecutive_Numbers_Sum();
        int N = 9;
        System.out.println(tester.consecutiveNumbersSum(N));
        N = 4;
        System.out.println(tester.consecutiveNumbersSum(N));
        N = 6;
        System.out.println(tester.consecutiveNumbersSum(N));
        N = 15;
        System.out.println(tester.consecutiveNumbersSum(N));
        N = 8;
        System.out.println(tester.consecutiveNumbersSum(N));
        N = 72316829;
        System.out.println(tester.consecutiveNumbersSum(N));
        N = 78729668;
        System.out.println(tester.consecutiveNumbersSum(N));
        N = 84418900;
        System.out.println(tester.consecutiveNumbersSum(N));

    }
}
