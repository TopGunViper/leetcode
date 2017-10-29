package edu.ouc.contest56;

import com.sun.tools.javac.util.Assert;

/**
 * @author wqx
 */
public class _717_1_bit_and_2_bit_Characters {

    /**
     * Solution:
     *
     * @param bits
     *
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        boolean retVal = false;
        if (bits.length == 1) {
            return true;
        }
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 0) {
                retVal = true;
                continue;
            } else if (i + 1 == bits.length - 1) {
                retVal = false;
            }
            i++;
        }
        return retVal;
    }

    public static void main(String args[]) {
        //test case1
        _717_1_bit_and_2_bit_Characters tester = new _717_1_bit_and_2_bit_Characters();

        /**
         * We can use 2 "with" stickers, and 1 "example" sticker.
         After cutting and rearrange the letters of those stickers, we can form the target "thehat".
         Also, this is the minimum number of stickers necessary to form the target string.
         */
        int[] bits1 = {1, 0, 0};
        Assert.check(tester.isOneBitCharacter(bits1) == true);

        int[] bits2 = {1, 1, 1, 0};
        Assert.check(tester.isOneBitCharacter(bits2) == false);

        int[] bits3 = {0};
        Assert.check(tester.isOneBitCharacter(bits3) == true);

        int[] bits4 = {0, 1, 0};
        Assert.check(tester.isOneBitCharacter(bits4) == false);

    }
}
