package edu.ouc;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author wqx
 * @date 2015年11月9日
 *
 */
public class _5_Longest_Palindromic_Substring_Medium {
	public String longestPalindrome(String s) {
		int len = s.length();
		if(len == 0)
			return "";
		int max = 1,start = 0,end = 1;
		StringBuilder sb = new StringBuilder(len*2 + 1);
		//统一转为奇数长字符串
		for(int i = 0; i < len; i++){
			sb.append("#").append(s.charAt(i));
		}
		sb.append("#");
		s = sb.toString();
		len = s.length();
		for(int i = 1; i < len; i++){
			int step = 0;
			for(;;){
				if(i - step >= 0 && i + step < len && s.charAt(i-step) == s.charAt(i+step)){
					step++;
				}else{
					break;
				}
			}
			if((step-1)*2 + 1 > max){
				start = i-step+1;
				end = i+step;
				max = (step-1)*2 +1;
			}
		}
		//System.out.println("start:" + start + ",end:" + end);
		s = s.substring(start,end).replaceAll("\\#","");
		return s;
	}
}
