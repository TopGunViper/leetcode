package edu.ouc.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * @author Wqx
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/" >3. Longest Substring
 * Without Repeating Characters
 * </a>
 */
public class _3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>(len);
        int max = 0;
        int i = 0, j = 0;
        while (j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String args[]) {
        String str = "abcdefgdhijklmnopq";
        System.out.println(lengthOfLongestSubstring2(str));

    }
}
