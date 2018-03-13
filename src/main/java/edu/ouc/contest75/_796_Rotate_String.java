package edu.ouc.contest75;

import org.junit.Assert;

public class _796_Rotate_String {

    public boolean rotateString(String A, String B) {
        if(A.equals(B)){
            return true;
        }
        if(A.length() != B.length()){
            return false;
        }
        int nextPos = -1;
        Character c = A.charAt(0);
        int len = A.length();
        while (nextPos < len){
            nextPos = B.indexOf(c, nextPos + 1);
            if(nextPos == -1){
                break;
            }
            //System.out.println("nextPos:" + nextPos);
            String leftB = B.substring(0, nextPos);
            String rightB = B.substring(nextPos);
            //System.out.println("left:" + leftB + ",right:" + rightB);
            if(rightB.equals(A.substring(0, len - nextPos)) && leftB.equals(A.substring(len - nextPos))){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        //test case1
        _796_Rotate_String
                tester = new _796_Rotate_String();

        String A = "abcde";
        String B = "cdeab";
        Assert.assertTrue(tester.rotateString(A,B));

        String A1 = "abcde";
        String B1 = "abced";
        Assert.assertFalse(tester.rotateString(A1,B1));

    }
}
