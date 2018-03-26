package edu.ouc;

/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 */
public class _8_String_to_Integer {
	
	
	public int myAtoi(String str) {
		String tmp = str.trim();
		if(tmp.length() == 0)
			return 0;
		int pos = 0,result = 0;
		boolean flag = (tmp.charAt(pos) != '-');
		if(tmp.charAt(pos) == '+' || tmp.charAt(pos) == '-'){
			pos++;
		}
		int len = tmp.length();
		for(;pos < len; pos++){
			if(tmp.charAt(pos) > '9' || tmp.charAt(pos) < '0'){
				break;
			}else{//处理数值溢出的情况
				int digit = tmp.charAt(pos) - '0';
				
				if(flag && result > (Integer.MAX_VALUE - digit)/10) return Integer.MAX_VALUE;
				else if(!flag && result < (Integer.MIN_VALUE + digit)/10) return Integer.MIN_VALUE;
				result = result * 10 + (flag ? digit : -digit);
			}
		}
		return result;
	}
	
	public int myAtoi2(String str) {
        int p = 0, ret = 0;
        while(p <str.length() && Character.isWhitespace(str.charAt(p))) ++p;
        if(p == str.length()) return 0;
        boolean negFlag = (str.charAt(p) == '-');
        if(str.charAt(p) == '+'  || str.charAt(p) == '-') ++p;
        for(; p<str.length(); ++p) {
            if(str.charAt(p) > '9' || str.charAt(p) < '0') {
                break;
            }else {
                int digit = str.charAt(p) - '0';
                if(!negFlag && ret > (Integer.MAX_VALUE - digit) /10) return Integer.MAX_VALUE;
                else if(negFlag && ret < (Integer.MIN_VALUE + digit)/10) return Integer.MIN_VALUE;
                ret = ret * 10 + (negFlag? -digit: digit);
            }
        }
        return ret;
    }
}
