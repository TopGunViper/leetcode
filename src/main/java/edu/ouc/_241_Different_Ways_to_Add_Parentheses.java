package edu.ouc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a string of numbers and operators, return all possible results 
 * from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.

Example 1

Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2

Output: [0, 2]

Example 2

Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Output: [-34, -14, -10, -10, 10]

 * @author wqx
 *
 */
public class _241_Different_Ways_to_Add_Parentheses {
	
    public   List<Integer> diffWaysToCompute(String input) {
    	return compute(input);
    }
    /**
     *
     * @param input
     * @return
     */
    public   List<Integer> compute(String input){
    	List<Integer> res = new ArrayList<Integer>();
    	if(isNumber(input)){
    		res.add(Integer.valueOf(input));
    		return res;
    	}
    	for(int i = 0; i < input.length() ; i++){
    		String operator = input.substring(i,i+1);
    		if(isOperator(operator)){
        		List<Integer> firstNums = compute(input.substring(0,i));
        		List<Integer> secondNums = compute(input.substring(i+1,input.length()));
        		switch(operator){
        		case "+" : 
        			for(Integer a : firstNums){
        				for(Integer b: secondNums){
        					res.add(a + b);
        				}
        			}
        			break;
        		case "-" :
        			for(Integer a : firstNums){
        				for(Integer b: secondNums){
        					res.add(a - b);
        				}
        			}
        			break;
        		case "*" :
        			for(Integer a : firstNums){
        				for(Integer b: secondNums){
        					res.add(a * b);
        				}
        			}
        			break;
        		}
    		}
    	}//end for
    	return res;
    }
    /**
     * operator�Ƿ�Ϊ����
     * @param operator
     * @return
     */
    public  boolean isOperator(String operator){
    	return operator.equals("-") || operator.equals("+") || operator.equals("*");
    }
    /**
     * number�Ƿ�Ϊ����
     * @param number
     * @return
     */
    public  boolean isNumber(String number){
    	Pattern p = Pattern.compile("[0-9]+");
    	Matcher matcher = p.matcher(number);
    	return matcher.matches();
    }
}
