package edu.ouc;

import java.util.HashMap;
import java.util.Map;

/**Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 
*/

public class _290_Word_Pattern_Easy {

    public boolean wordPattern(String pattern, String str) {
    	String [] strs = str.split(" ");
    	int len = pattern.length();
    	if(len != strs.length)
    		return false;
    	int a[] = new int[len];
    	for(int i = 0; i < len; i++){
    		for(int j = i+1; j < len; j++){
    			if((pattern.charAt(j) != pattern.charAt(i) && !strs[j].equals(strs[i])) || (pattern.charAt(j) == pattern.charAt(i) && strs[j].equals(strs[i])))
    				continue;
    			else{
    				return false;
    			}
    		}
    	}
        return true;
    }
    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length!=pattern.length())
            return false;
        Map<String, String> map = new HashMap<String,String>();
        
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(String.valueOf(pattern.charAt(i)))&&!map.containsKey(words[i])){
                map.put(String.valueOf(pattern.charAt(i)), words[i]);
                map.put(words[i], String.valueOf(pattern.charAt(i)));
            }else if(map.containsKey(words[i])){
                String value = map.get(words[i]);
                if(!value.equals(String.valueOf(pattern.charAt(i))))
                    return false;
            }else{
                String value = map.get(String.valueOf(pattern.charAt(i)));
                if(!value.equals(words[i]))
                    return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
