package edu.ouc;

/**
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.
Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.

 * @author wqx
 * @date 2015年11月10日
 *
 */
public class _7_Reverse_Integer {
	public static int reverse(int x) {
		if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE || x == 0)
			return 0;
		int flag = 0;
		if(x < 0){
			flag = -1;
			x = -x;
		}
		String str = String.valueOf(x);	
		char[] array = str.toCharArray();
		StringBuilder reverse = new StringBuilder(str.length());
		for (int i = array.length - 1; i >= 0; i--){
			reverse.append(array[i]);  
		}
		//反转后数值溢出
		if(String.valueOf(Integer.MAX_VALUE).length() == reverse.toString().length()){
			if(String.valueOf(Integer.MAX_VALUE).compareTo(reverse.toString()) < 0){
				return 0;
			}
		}
		return flag == 0 ? Integer.parseInt(reverse.toString()) : -1 * Integer.parseInt(reverse.toString());
	}
    public static int reverse2(int x) {
        int sum = 0;
        boolean positive = (x >= 0);

        while (x != 0) {
            int dig = x % 10;
            if (positive && sum > Integer.MAX_VALUE/10)
                return 0;
            if (!positive && sum < Integer.MIN_VALUE/10)
                return 0;
            sum = (sum * 10) + dig;
            x /=10;
        }
        return sum;  
    }
	public static void main(String args[]){
		int x = Integer.MAX_VALUE;
		System.out.println("reverse:" + reverse(x));
	}
}
