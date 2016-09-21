package edu.ouc.dfs_bfs;

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
	/**
	 * 
	 * @param s  给定的字符串
	 * @param stack stack中存放的是从字符串s中获取的字符
	 * @param index 访问字符串s时的索引
	 * @param left 需要删除的左括号个数
	 * @param right 需要删除的右括号个数
	 * @param symmetry stack中的字符是否对称
	 */
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
		//left和right分别代表需要删除left个左括号，right个右括号
		int left = 0, right = 0;
		int invalidNum = 0;
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

	int invalidNum = 0;//最少需要删除的括号个数
	public  List<String> removeInvalidParentheses2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push(s.charAt(i));
			}else if(s.charAt(i) == ')'){
				if(!stack.isEmpty()){
					stack.pop();
				}else{
					invalidNum++;
				}
			}
		}
		invalidNum+= stack.size();
		stack.clear();
		//dfs(s,stack,0);
		return new ArrayList<String>(result);
	}
		public  void dfs(String s,Stack<Character> stack,int index){
			if(index == s.length()){
				if((stack.size()+invalidNum) != s.length()){
					return ;
				}
				if(!validate(stack)){
					return ;
				}
				int len = stack.size();
				StringBuilder sb = new StringBuilder(len);
				for(int i = 0; i < len; i++){
					sb.append(stack.get(i));
				}
				result.add(sb.toString());
				return ;
			}
			//剪枝操作，index - stack.size代表现在删除的括号个数，一定小于等于invalidNum
			if((index - stack.size()) > invalidNum) return ;
			Character c = s.charAt(index);
			stack.push(c);
			dfs(s,stack,index+1);
			stack.pop();
			dfs(s,stack,index+1);
		}
		//验证str中字符是否是合法的（即左、右括号完全匹配）
		public  boolean validate(Stack<Character> str){
			Stack<Character> stack = new Stack<Character>();
	       for(int i = 0; i < str.size(); i++){
	       	if(str.get(i) == '('){
	       		stack.push(str.get(i));
	       	}else if(str.get(i) == ')'){
	       		if(!stack.isEmpty()){
	       			stack.pop();
	       		}else{
	       			return false;
	       		}
	       	}
	       }
	       return stack.isEmpty();
		}
}
