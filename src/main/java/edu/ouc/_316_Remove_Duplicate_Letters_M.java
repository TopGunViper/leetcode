package edu.ouc;

/**
 *  Given a string which contains only lowercase letters, 
 *  remove duplicate letters so that every letter appear once and only once.
You must make sure your result is the smallest in lexicographical order among 
all possible results.

Example:

Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb" 

 * @author wqx
 *
 */
public class _316_Remove_Duplicate_Letters_M {
	public String removeDuplicateLetters(String s) {
		int len = s.length();
		int [] letters = new int[26];
		int pos = 0;
		for(int i = 0; i < len; i++) letters[s.charAt(i)-'a']++;
		for(int i = 0; i < len; i++){
			if(s.charAt(i) < s.charAt(pos)) pos = i;
			if(--letters[s.charAt(i)-'a'] == 0) break;
		}
		
		return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1));
	}
}
