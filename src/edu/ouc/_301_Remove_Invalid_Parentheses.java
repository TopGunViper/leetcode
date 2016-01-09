package edu.ouc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *  
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:

"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

 * @author wqx
 * @Date 2015-12-06
 */
public class _301_Remove_Invalid_Parentheses {
	static Set<String> result = new HashSet<String>();
	public static List<String> removeInvalidParentheses(String s) {
		Stack<Character> stack = new Stack<Character>();
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            if(s.charAt(i) == ')') {
                if(left != 0) left--;
                else right++;
            }
        }
		dfs(s,stack,0,left,right,0);
		return new ArrayList<String>(result);
	}
	public static void dfs(String s,Stack<Character> stack,int index,int left,int right,int symmetry){
		if(index == s.length() && left == 0 && right == 0 && symmetry == 0){
			int len = stack.size();
			StringBuilder sb = new StringBuilder(len);
			for(int i = 0; i < len; i++){
				sb.append(stack.get(i));
			}
			result.add(sb.toString());
			return ;
		}
		if(index >= s.length() || left < 0 || right < 0 || symmetry < 0) return ;
		Character c = s.charAt(index);
		if(c == '('){
			stack.push(c);
			dfs(s,stack,index+1,left,right,symmetry+1);
			stack.pop();
			dfs(s,stack,index+1,left-1,right,symmetry);
		}else if(c == ')'){
			stack.push(c);
			dfs(s,stack,index+1,left,right,symmetry-1);
			stack.pop();
			dfs(s,stack,index+1,left,right-1,symmetry);
		}else{
			stack.push(c);
			dfs(s,stack,index+1,left,right,symmetry);
			stack.pop();
		}
	}
    public static void main(String[] args){
    	String s = "((z(((fp))()((((((g(";
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            if(s.charAt(i) == ')') {
                if(left != 0) left--;
                else right++;
            }
        }
        System.out.println("s:" + s + ",left:" + left + ",right:" + right);
    	long startTime = System.currentTimeMillis();
    	removeInvalidParentheses(s);
    	System.out.println("time:" + (System.currentTimeMillis() - startTime));
    }
//	 Set<String> result = new HashSet<String>();
//	 int invalidNum = 0;
//	public  List<String> removeInvalidParentheses(String s) {
//		Stack<Character> stack = new Stack<Character>();
//       for(int i = 0; i < s.length(); i++){
//       	if(s.charAt(i) == '('){
//       		stack.push(s.charAt(i));
//       	}else if(s.charAt(i) == ')'){
//       		if(!stack.isEmpty()){
//       			stack.pop();
//       		}else{
//       			invalidNum++;
//       		}
//       	}
//       }
//       invalidNum+= stack.size();
//       stack.clear();
//		dfs(s,stack,0);
//		return new ArrayList<String>(result);
//	}
//	public  void dfs(String s,Stack<Character> stack,int index){
//		if(index == s.length()){
//			if((stack.size()+invalidNum) != s.length()){
//				return ;
//			}
//			if(!validate(stack)){
//				return ;
//			}
//			int len = stack.size();
//			StringBuilder sb = new StringBuilder(len);
//			for(int i = 0; i < len; i++){
//				sb.append(stack.get(i));
//			}
//			result.add(sb.toString());
//			return ;
//		}
//		if((index - stack.size()) > invalidNum) return ;
//		Character c = s.charAt(index);
//		stack.push(c);
//		dfs(s,stack,index+1);
//		stack.pop();
//		dfs(s,stack,index+1);
//	}
//	public  boolean validate(Stack<Character> str){
//		Stack<Character> stack = new Stack<Character>();
//       for(int i = 0; i < str.size(); i++){
//       	if(str.get(i) == '('){
//       		stack.push(str.get(i));
//       	}else if(str.get(i) == ')'){
//       		if(!stack.isEmpty()){
//       			stack.pop();
//       		}else{
//       			return false;
//       		}
//       	}
//       }
//       return stack.isEmpty();
//	}
}
