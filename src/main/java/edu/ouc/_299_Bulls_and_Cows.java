package edu.ouc;

import java.util.HashMap;
import java.util.Map;

public class _299_Bulls_and_Cows {
	
    public static String getHint(String secret, String guess) {
    	int bull = 0,cows = 0;
    	/*
    	 * 1212 1221 2A2B
    	 * "1234""0111"  0A1B
    	 * "1122""2211"  0A4B
    	 */
//    	if("".equals(secret))
//    		return "0A0B";
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>(10); 
    	
    	for(int i = 0; i < 10; i++)
    		map.put(i,0);
    		
    	
    	for(int i = 0; i < secret.length(); i++){
    		if(secret.charAt(i) == guess.charAt(i)){
    			bull++;
    		}
    		map.put(secret.charAt(i)-'0',map.get(secret.charAt(i)-'0')+1);
    	}
    	int sum = 0;
    	for(int i = 0; i < secret.length(); i++){
    		int count = map.get(guess.charAt(i)-'0');
    		if(count > 0){
    			sum ++;
    			map.put(guess.charAt(i)-'0',map.get(guess.charAt(i)-'0')-1);
    		}
    	}
    	
    	System.out.println("sum:" + sum + ",bull:" + bull);
        return bull + "A" + cows + "B";
    }
    
    public static String getHint2(String secret, String guess) {
        int a=0,b=0;
        int[] digits=new int[10];
        
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) a++;
            else{
            	
                if(++digits[secret.charAt(i)-'0']<=0) b++;
                if(--digits[guess.charAt(i)-'0']>=0) b++;
            }
        }
        return a+"A"+b+"B";
    }
    //1122 2211
    public String getHint3(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bulls + "A" + cows +"";
    }
    public static void main(String args[]){
    	String secret = "1122";
    	String guess = "2211";
    	getHint(secret,guess);
    }
}
