package edu.ouc.array;

/**
 * Write a function that takes a string as input and returns the string reversed.
 */
public class _344_Reverse_String {

    public String reverseString(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int low = 0, high = s.length() - 1;
        char[] res = s.toCharArray();
        while (low < high){
            char t = s.charAt(low);
            res[low] = s.charAt(high);
            res[high] = t;
            low++;
            high--;
        }
        return new String(res);
    }
    public static void main(String[] args) {
        _344_Reverse_String tester =
                new _344_Reverse_String();
        String s = "hello";
        System.out.println(tester.reverseString(s));
    }
}
