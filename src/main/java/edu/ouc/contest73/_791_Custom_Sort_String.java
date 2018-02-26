package edu.ouc.contest73;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class _791_Custom_Sort_String {


    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : T.toCharArray()){
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        StringBuilder sb = new StringBuilder(T.length());

        for(Character c : S.toCharArray()){
            Integer count = map.getOrDefault(c, 0);
            if(count != 0){
                while(count != 0){
                    sb.append(c);
                    count--;
                }
            }
            map.put(c, -1);
        }
        for(Character c : map.keySet()){
            Integer count = map.get(c);
            if(count != -1){
                while(count != 0){
                    sb.append(c);
                    count--;
                }
            }
        }
        //System.out.println("sb:" + sb.toString());
        return sb.toString();
    }

    public static void main(String args[]) {
        //test case1
        _791_Custom_Sort_String tester = new _791_Custom_Sort_String();
        String S = "cba";
        String T = "abcd";
        Assert.assertEquals("cbad", tester.customSortString(S, T));

    }
}
