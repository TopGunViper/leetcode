package edu.ouc;

public class _9_Palindrome_Number {
    public boolean isPalindrome(int x) {
    	String str = String.valueOf(x);
    	for(int i = 0; i < str.length()/2 ; i++){
    		if(str.charAt(i) != str.charAt(str.length() - i -1)){
    			return false;
    		}
    	}
        return true;
    }
    public boolean isPalindrome2(int x) {
        int xx = x;
        int reversed = 0;
        while(xx > 0) {
            reversed = reversed * 10 + xx % 10;
            xx /= 10;
        }
        return x == reversed;
    }
}