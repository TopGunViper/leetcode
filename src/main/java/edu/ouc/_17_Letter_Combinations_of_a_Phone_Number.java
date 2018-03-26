package edu.ouc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, 
your answer could be in any order you want.
 
@author TopGun
@date 20015-11-25
@Idea
1.定义一个phoneMap代表手机的键盘，输入i,则phoneMap[i]就表示按键i上的所有字符集。
2.简单的DFS解决战斗！Over...
*/
public class _17_Letter_Combinations_of_a_Phone_Number {
	public String [] phoneMap = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	if(digits == null || digits.length() == 0)
    		return result;
    	com("",digits,0,result);
    	return result;
    }
    public void com(String sb,String digits,int pos,List<String> result){
    	if(pos == digits.length()){
    		//System.out.println("pos:" + pos);
    		result.add(sb);
    	}else{
    		//System.out.println("sb.toString():" + sb.toString());
    		for(int j = 0; j < phoneMap[digits.charAt(pos) - '1'].length();j++){
    			Character c = phoneMap[digits.charAt(pos) - '1'].charAt(j);
    			int len = sb.length();
    			sb += c;
    			com(sb,digits,pos+1,result);
    			//状态还原
    			sb = sb.substring(0,len);
    		}
    	}
    }
    
    Map<Integer, List<String>> digitMap = new HashMap<Integer, List<String>>();

    _17_Letter_Combinations_of_a_Phone_Number() {
        digitMap.put(2, Arrays.asList(new String[] {"a", "b", "c"}));
        digitMap.put(3, Arrays.asList(new String[] {"d", "e", "f"}));
        digitMap.put(4, Arrays.asList(new String[] {"g", "h", "i"}));
        digitMap.put(5, Arrays.asList(new String[] {"j", "k", "l"}));
        digitMap.put(6, Arrays.asList(new String[] {"m", "n", "o"}));
        digitMap.put(7, Arrays.asList(new String[] {"p", "q", "r", "s"}));
        digitMap.put(8, Arrays.asList(new String[] {"t", "u", "v"}));
        digitMap.put(9, Arrays.asList(new String[] {"w", "x", "y", "z"}));
    }

    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length() == 0)
            return result;
        if(digits.length() == 1)
            return digitMap.get(digits.charAt(0) - '0');
        List<String> intermediate = letterCombinations2(digits.substring(1, digits.length()));
        for(String first : digitMap.get(digits.charAt(0) - '0'))
            for(String rest : intermediate)
                result.add(first + rest);
        return result;
    }
}
