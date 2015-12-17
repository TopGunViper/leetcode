package edu.ouc;

import java.util.Arrays;

public class _14_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		int minStr = Integer.MAX_VALUE;
		if(strs.length == 0)
			return "";
		for(int i = 0 ;i < len; i++){
			if(minStr >= strs[i].length()){
				minStr = strs[i].length();
			}
		}
		int longest = -1;
		boolean flag = true;
		for(int i = 0; i < minStr; i++){
			for(int j = 1; j < len; j++){
				if(strs[0].charAt(i) != strs[j].charAt(i)){
					flag = false;
					break;
				}
			}
			if(!flag)
				break;
			longest = i;
		}

		if(longest == -1)
			return "";
		else return strs[0].substring(0,longest+1);
	}
	public String longestCommonPrefix2(String[] strs) {
		StringBuilder result = new StringBuilder();

		if (strs!= null && strs.length > 0){
			Arrays.sort(strs);
			char [] a = strs[0].toCharArray();
			char [] b = strs[strs.length-1].toCharArray();

			for (int i = 0; i < a.length; i ++){
				if (b.length > i && b[i] == a[i]){
					result.append(b[i]);
				}
				else {
					return result.toString();
				}
			}
			return result.toString();
		}else{
			return "";
		}
	}
}
