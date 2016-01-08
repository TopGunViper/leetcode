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
    public static List<String> removeInvalidParentheses(String s) {
    	Set<String> result = new HashSet<String>();
        List<Node> invalid = new ArrayList<Node>();
        
        invalid = getInvalid(s);
        System.out.println("getResult(invalid,s)1:" + getResult(invalid,s));
        result.add(getResult(invalid,s));
        StringBuffer buf = new StringBuffer(s);
        String reverse  = buf.reverse().toString();
        invalid = getInvalid(reverse);
        System.out.println("getResult(invalid,s)2:" + getResult(invalid,s));
        result.add(getResult(invalid,s));
        return new ArrayList<>(result);
    }
    public static String getResult(List<Node> invalid,String s){
    	StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<Integer>();
        for(Node c : invalid){
        	set.add(c.pos);
        }
        for(int i = 0; i < s.length(); i++){
        	if(!set.contains(i)){
        		sb.append(s.charAt(i));
        	}
        }
        return sb.toString();
    }
    public static List<Node>  getInvalid(String s){
        List<Node> invalid = new ArrayList<Node>();
        Stack<Node> stack = new Stack<Node>();
        
        for(int i = 0; i < s.length(); i++){
        	Node node = new Node(s.charAt(i),i);
        	if(node.c == '('){
               	stack.push(node);//push left parenthese into stack 
        	}
        	if(node.c == ')'){
        		if(!stack.empty()){
        			stack.pop(); 
        		}else{
        			invalid.add(node);
        		}
        	}
        	//skip other letters,do nothing
        }
        while(!stack.isEmpty()){
        	invalid.add(stack.pop());
        }
        return invalid;
    }
    static class Node{
    	Character c;
    	int pos;
    	public Node(Character c,int pos){
    		this.c = c;
    		this.pos = pos;
    	}
    	public Character getC(){
    		return c;
    	}
    	public int getPos(){
    		return pos;
    	}
    	public boolean equals(Node node){
    		return node.c.equals(c);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "()())()";
		removeInvalidParentheses(str);
		
	}

}
