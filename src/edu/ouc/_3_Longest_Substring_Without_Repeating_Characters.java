package edu.ouc;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Wqx
 *
 */
public class _3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<Character>(len);
        int max = 0;
        int i = 0,j = 0;
        while(j < len){
        	if(!set.contains(s.charAt(j))){
        		set.add(s.charAt(j++));
        		max = Math.max(max, set.size());
        	}else{
        		set.remove(s.charAt(i++));
        	}
        }
        return max;
    }
//    int lengthOfLongestSubstring(string s) {
//        vector<int> dict(256, -1);
//        int maxLen = 0, start = -1;
//        for (int i = 0; i != s.length(); i++) {
//            if (dict[s[i]] > start)
//                start = dict[s[i]];
//            dict[s[i]] = i;
//            maxLen = max(maxLen, i - start);
//        }
//        return maxLen;
//    }

    public static void main(String args[]){
    	String str = "aaa";
    	lengthOfLongestSubstring(str);
    }
}
