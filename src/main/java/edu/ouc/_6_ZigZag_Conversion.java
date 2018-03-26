package edu.ouc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
stepY   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 * @author wqx
 *
 */
public class _6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
    	if(numRows == 1)
    		return s;
    	int len = s.length();
    	char [][] result = new char[len][numRows];
    	int pos = 0,i = 0,j = 0;
    	result[i++][0] = s.charAt(pos++);
    	while(pos < len){
    		while(i < numRows && pos < len){
    			result[i++][j] = s.charAt(pos++);
    		}
    		if(pos == len)break;
    		i -= 2;
    		while(i >= 0 && pos < len){
    			result[i--][++j] = s.charAt(pos++);
    		}
    		i += 2;
    		if(pos == len)break;
    	}
    	StringBuilder sb = new StringBuilder();
    	for(i = 0; i < len; i++){
    		for(j = 0; j < numRows; j++){
    			if(result[i][j] >= 20){
    				sb.append(result[i][j]);
    			}
    		}
    	}
        return sb.toString();
    }
    public String convert2(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() <= numRows || numRows == 1) return s;
        List<List<Character>> resList = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++) {
            resList.add(new ArrayList<Character>());
        }
        for (int i = 0; i < s.length(); i++) {
            int indexInGroup = i % (2 * numRows - 2);
            int indexInList = indexInGroup < numRows ? indexInGroup : 2 * numRows - 2 - indexInGroup;
            resList.get(indexInList).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : resList) {
            for (Character c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
