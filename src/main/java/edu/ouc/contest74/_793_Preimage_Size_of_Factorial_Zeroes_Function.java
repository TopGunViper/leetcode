package edu.ouc.contest74;

import org.junit.Assert;

public class _793_Preimage_Size_of_Factorial_Zeroes_Function {

    public int preimageSizeFZF(int K) {
        return findRange(K)-findRange(K-1);
    }
    int findRange(int k){
        int low = 0, high = 1000000000;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(getZeroes(mid)>k) high = mid-1;
            else
                low = mid+1;
        }
        return low-1;
    }
    int getZeroes(int N){
        int count = 0;
        for(int i=5;N/i>=1;i=i*5){
            count+=N/i;
        }
        return count;
    }

    public static void main(String args[]) {
        //test case1
        _793_Preimage_Size_of_Factorial_Zeroes_Function tester = new _793_Preimage_Size_of_Factorial_Zeroes_Function();
        int K = 0;
        Assert.assertTrue(tester.preimageSizeFZF(K) == 5);

    }
}
