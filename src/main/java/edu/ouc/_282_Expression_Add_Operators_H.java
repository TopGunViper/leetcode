package edu.ouc;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a string that contains only digits 0-9 and a target value, 
 *  return all possibilities to add binary operators (not unary) +, -, or * 
 *  between the digits so they evaluate to the target value.

Examples:

"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []


 * @author wqx
 *
 */
public class _282_Expression_Add_Operators_H {
	
    public List<String> addOperators(String num, int target) {
        return null;
    }
    public List<Integer> result(String num, int target){
    	List<Integer> results = new ArrayList<Integer>();
    	int len = num.length();
    	if(num.length() == 1){
    		results.add(Integer.valueOf(num));
    		return results;
    	}else{
    		for(int i = 0; i < len ; i++){
    			int a = Integer.valueOf(num.substring(0,i+1),target);
    			
    			List<Integer> res = result(num.substring(i+1),target);
    			for(Integer b : res){
    				if(a + b == target){
    					
    				}
    				
    			}
    		}
    	}
    	return null;
    }
}
