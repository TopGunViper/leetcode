package edu.ouc.contest80;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _816_Ambiguous_Coordinates {

    public List<String> ambiguousCoordinates(String S) {
        String src = S.substring(1, S.length()-1);
        for(int index = 1; index < src.length(); index++){
            String first = src.substring(0, index);
            String second = src.substring(index, src.length());
            if(isLegal(first) && isLegal(second)){
                System.out.println("isLegal   first:" + first + ",second:" + second);

            }
            System.out.println("first:" + first + ",second:" + second);
        }
        return null;
    }
    public boolean isLegal(String numberStr){
        if(numberStr.length() == 1){
            return true;
        }
        if(numberStr.endsWith("0") && numberStr.startsWith("0")){
            return false;
        }
        return true;
    }
    public static void main(String args[]) {
        _816_Ambiguous_Coordinates
                tester = new _816_Ambiguous_Coordinates();
        String S = "(123)";
        System.out.println(tester.ambiguousCoordinates(S));

        String S2 = "(00011)";
        System.out.println(tester.ambiguousCoordinates(S2));

    }
}
