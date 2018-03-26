package edu.ouc.contest68;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _766_Toeplitz_Matrix {


    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean retVal = true;
        for(int i = 0; i < matrix.length - 1; i++){
            for(int j = i; j < matrix[i].length - 1; j++){
                if(matrix[i][j] != matrix[i + 1][j + 1]){
                    retVal = false;
                }
            }
        }
        for(int j = 1; j < matrix[0].length - 1; j++){
            for(int i = j; i < matrix.length - 1; i++){
                if(matrix[i][j] != matrix[i + 1][j + 1]){
                    retVal = false;
                }
            }
        }

        return retVal;
    }

    public static void main(String args[]) {
        //test case1
        _766_Toeplitz_Matrix tester = new _766_Toeplitz_Matrix();
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        Assert.assertTrue(tester.isToeplitzMatrix(matrix));

        int[][] matrix2 = {{1,2},{2,2}};
        Assert.assertFalse(tester.isToeplitzMatrix(matrix2));

    }

}
