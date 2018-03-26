package edu.ouc.contest77;

import java.util.LinkedList;
import java.util.List;

public class _805_Split_Array_With_Same_Average {



    public boolean splitArraySameAverage(int[] A) {
        int sum = 0, len = A.length;
        for (int a : A) {
            sum += a;
        }
        for (int count = 1; count <= len / 2; count++) {
            if (sum * count % len != 0) {
                continue;
            }

            if (checkSum(A, sum * count / len, count, 0, 0, 0)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkSum(int[] A, int sum, int count, int curIndex, int curSum, int curCount) {
        if (curCount == count && curSum == sum) {
            return true;
        }
        if (curCount == count) {
            return false;
        }

        for (int i = curIndex; i < A.length; i++) {
            if (curSum + A[i] <= sum) {
                if (checkSum(A, sum, count, i + 1, curSum + A[i], curCount + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean res;

    public boolean splitArraySameAverage2(int[] A) {
        int N = A.length;

        List<Integer> B = new LinkedList<>();
        List<Integer> C = new LinkedList<>();
        res = false;
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        dfs(A, 0, sum, B, 0, C, 0);

        System.out.println("res:" + res);
        return res;
    }

    private void dfs(int[] A, int index, int remainA, List<Integer> B, int sumB, List<Integer> C, int sumC) {
        if (index == A.length) {

            int sizeB = B.size();
            int sizeC = C.size();
            if (sizeB == 0 || sizeC == 0) {
                return;
            }
            if (sumB * 1.0 / B.size() == sumC * 1.0 / C.size()) {
                //System.out.println("sumB:" + sumB + ",sumC:" + sumC);
                //System.out.println(Arrays.toString(B.toArray()));
                //System.out.println(Arrays.toString(C.toArray()));
                res = true;

            }
            return;
        }
        //        if (Math.abs(sumB - sumC) > remainA) {
        //            return;
        //        }

        sumB += A[index];
        B.add(A[index]);
        dfs(A, index + 1, remainA - A[index], B, sumB, C, sumC);
        B.remove(B.size() - 1);
        sumB -= A[index];

        sumC += A[index];
        C.add(A[index]);
        dfs(A, index + 1, remainA - A[index], B, sumB, C, sumC);
        C.remove(C.size() - 1);
        sumC -= A[index];

    }

    public static void main(String args[]) {
        _805_Split_Array_With_Same_Average
                tester = new _805_Split_Array_With_Same_Average();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        //tester.splitArraySameAverage(arr);

        int[] arr2 = {6, 8, 18, 3, 1};
        tester.splitArraySameAverage(arr2);

        int[] arr3 = {5, 3, 11, 19, 2};
        //tester.splitArraySameAverage(arr3);
    }
}
