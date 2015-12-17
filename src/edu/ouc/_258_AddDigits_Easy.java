package edu.ouc;

public class _258_AddDigits_Easy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 19;
		System.out.println(addDigits(num));
	}
	public static int addDigits(int num) {
		if(num / 10 == 0){
			return num;
		}
        while(num/10 != 0){
        	int total = 0;
        	while(num!=0){
        		int tmp = num%10;
        		total += tmp;
        		num /= 10;
        	}
        	num = total;
        }
        return num;
    }
    public  int addDigits2(int num) {
        return num>9?addDigits(num/10+num%10):num;
    }
    public int addDigits3(int num) {
    	// use the hint dr(n)= n- 9*floor((n-1)/9)
    	    return num-9*((num-1)/9);
    }
}
