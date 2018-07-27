package edu.ouc.contest78;

import java.util.Arrays;

public class _810_Chalkboard_XOR_Game {

    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int i: nums) xor ^= i;
        return xor == 0 || nums.length % 2 == 0;

    }

    public static void main(String args[]) {
        //test case1
        _810_Chalkboard_XOR_Game
                tester = new _810_Chalkboard_XOR_Game();

    }
}
