package edu.ouc.contest67;

import static org.junit.Assert.assertTrue;

/**
 * @author wqx
 */
public class _762_Prime_Number_of_Set_Bits_in_Binary_Representation {

    /**
     * Given two integers L and R, find the count of numbers in the range [L, R]
     * (inclusive) having a prime number of set bits in their binary representation.
     * <p>
     * (Recall that the number of set bits an integer has is the number of 1s present
     * when written in binary. For example, 21 written in binary is 10101 which has 3 set bits.
     * Also, 1 is not a prime.)
     */
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            String binary = Integer.toBinaryString(i);
            int bitNum = getBitNumber(binary);
            if (isPrime(bitNum)) {
                res++;
            }
        }
        return res;
    }

    private int getBitNumber(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n < 3) {
            return n > 1;

        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        //test case1
        _762_Prime_Number_of_Set_Bits_in_Binary_Representation
                tester = new _762_Prime_Number_of_Set_Bits_in_Binary_Representation();

        int L = 6;
        int R = 10;

        assertTrue(tester.countPrimeSetBits(L, R) == 4);

        L = 10;
        R = 15;

        assertTrue(tester.countPrimeSetBits(L, R) == 5);

        L = 842;
        R = 888;

    }
}
