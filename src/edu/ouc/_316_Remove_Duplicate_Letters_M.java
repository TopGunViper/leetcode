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
		//统计每个字符出现次数
		for(int i = 0; i < len; i++) letters[s.charAt(i)-'a']++;
		//寻找第一个在当前位置及右边子串中只出现1次的字符
		for(int i = 0; i < len; i++){
			if(s.charAt(i) < s.charAt(pos)) pos = i;
			if(--letters[s.charAt(i)-'a'] == 0) break;
		}
		//删除pos左边的所有字符，返回剩余字符
		return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1));
	}
}
