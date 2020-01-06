package edu.ouc.contest53;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

/**
 * We are given N different types of stickers. Each sticker has a lowercase English word on it.

 You would like to spell out the given target string by cutting individual letters from your
 collection of stickers and rearranging them.

 You can use each sticker more than once if you want, and you have infinite quantities of each
 sticker.

 What is the minimum number of stickers that you need to spell out the target? If the task is
 impossible, return -1.

 * @author wqx
 */
public class _691_Stickers_to_Spell_Word {

    /**
     * Solution:
     *
     *
     * @param stickers
     * @param target
     * @return
     */
    public int minStickers(String[] stickers, String target) {
        int retVal = 0;
        return retVal;
    }
    public static void main(String args[]) {
        //test case1
        _691_Stickers_to_Spell_Word tester = new _691_Stickers_to_Spell_Word();

        String[] stickers = {"with","example", "science"};
        String target = "thehat";
        /**
         * We can use 2 "with" stickers, and 1 "example" sticker.
         After cutting and rearrange the letters of those stickers, we can form the target "thehat".
         Also, this is the minimum number of stickers necessary to form the target string.
         */
        assertTrue(tester.minStickers(stickers, target) == 3);

        String[] stickers2 = {"notice","possible"};
        String target2 = "basicbasic";
        /**
         * We can't form the target "basicbasic" from cutting letters from the given stickers.
         */
        assertTrue(tester.minStickers(stickers2, target2) == -1);
    }
}
