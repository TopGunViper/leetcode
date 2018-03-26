package edu.ouc.contest68;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _767_Reorganize_String {

    /**
     * Solution:
     * Build a empty result StringBuilder sb. Pick a character and append it to sb.
     * <p>
     * 1. if sb is end with character which is repeated most in S, choose second.
     *
     * @param S
     *
     * @return
     */
    public String reorganizeString(String S) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (S.length() + 1) / 2) {
                return "";
            }
            map.put(c, count);
        }

        PriorityQueue<Entry> queue = new PriorityQueue<Entry>((a, b) -> b.count - a.count);
        for (char c : map.keySet()) {
            queue.add(new Entry(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Entry mostRepeatedEntry = queue.poll();
            if (sb.length() == 0 || mostRepeatedEntry.c != sb.charAt(sb.length() - 1)) {
                sb.append(mostRepeatedEntry.c);
                if (--mostRepeatedEntry.count > 0) {
                    queue.add(mostRepeatedEntry);
                }
            } else {
                Entry secondRepeatedEntry = queue.poll();
                sb.append(secondRepeatedEntry.c);
                if (--secondRepeatedEntry.count > 0) {
                    queue.add(secondRepeatedEntry);
                }
                // push the mostRepeatedEntry back to queue.
                queue.add(mostRepeatedEntry);
            }
        }
        return sb.toString();
    }
    static class Entry{
        Character c;
        int count;

        public Entry(Character c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public static void main(String args[]) {
        //test case1
        _767_Reorganize_String tester = new _767_Reorganize_String();
        String S = "aab";
        String expected = "aba";
        Assert.assertEquals(expected, tester.reorganizeString(S));

        String S2 = "aaab";
        String expected2 = "";
        Assert.assertEquals(expected2, tester.reorganizeString(S2));

        String S3 = "vvvlo";
        String expected3 = "vlvov";
        Assert.assertEquals(expected3, tester.reorganizeString(S3));

    }

}
