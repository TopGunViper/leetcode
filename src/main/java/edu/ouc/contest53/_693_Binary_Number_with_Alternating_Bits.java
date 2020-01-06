package edu.ouc.contest53;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have
 * different values.
 *
 * @author wqx
 */
public class _693_Binary_Number_with_Alternating_Bits {
    /**
     * Solution:
     *
     * @param n
     *
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int lastBit = n % 2;
        n >>>= 1;
        while(n > 0){
            if (lastBit == n % 2) {
                return false;
            }
            lastBit = n % 2;
            n >>>= 1;
        }
        return true;
    }

    public static void main(String args[]) {
        //test case1
        _693_Binary_Number_with_Alternating_Bits tester = new _693_Binary_Number_with_Alternating_Bits();

        //The binary representation of 5 is: 101
        assertTrue(tester.hasAlternatingBits(5));

        // The binary representation of 7 is: 111.
        assertTrue(!tester.hasAlternatingBits(7));

        //The binary representation of 11 is: 1011.
        assertTrue(!tester.hasAlternatingBits(11));

        //The binary representation of 10 is: 1010.
        assertTrue(tester.hasAlternatingBits(10));

    }
}
