package edu.ouc.contest87;

public class _845_Longest_Mountain_in_Array {

    public int longestMountain(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        right[A.length - 1] = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if(left[i] > 0 && right[i] > 0){
                int cur = left[i] + right[i] + 1;
                max = max < cur ? cur : max;
            }
        }
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        return max;
    }

    public static void main(String args[]) {
        //test case1
        _845_Longest_Mountain_in_Array
                tester = new _845_Longest_Mountain_in_Array();
        int N = 9;
        int[] arr = {2,1,4,7,3,2,5};

        System.out.println(tester.longestMountain(arr));
        int[] arr2 = {2,2,2};
        System.out.println(tester.longestMountain(arr2));
        N = 4;
    }
}
