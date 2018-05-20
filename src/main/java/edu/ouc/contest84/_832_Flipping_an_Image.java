package edu.ouc.contest84;

public class _832_Flipping_an_Image {

    public int[][] flipAndInvertImage(int[][] A) {

        // flip
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length / 2; j++){
                swap(A[i], j, A[i].length - j - 1);
            }
            for(int j = 0; j < A[i].length; j++){
                A[i][j] = revert(A[i][j]);
            }
        }
        return A;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private int revert(int a){
        return a == 1 ? 0 : 1;
    }
    public static void main(String args[]) {
        //test case1
        _832_Flipping_an_Image
                tester = new _832_Flipping_an_Image();
        int N = 9;
        //System.out.println(tester.consecutiveNumbersSum(N));
        N = 4;
    }
}
