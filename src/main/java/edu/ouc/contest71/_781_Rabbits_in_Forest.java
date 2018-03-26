package edu.ouc.contest71;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _781_Rabbits_in_Forest {

    public int numRabbits(int[] answers) {
        int resVal = 0;
        if(answers.length == 0){
            return resVal;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer a : answers){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(Integer n : map.keySet()){
            int group = map.get(n)/(n+1);
            resVal += map.get(n)%(n+1) != 0 ? (group+1)*(n+1) : group*(n+1);
        }
        return resVal;
    }

    public static void main(String args[]) {
        //test case1
        _781_Rabbits_in_Forest tester = new _781_Rabbits_in_Forest();
        int an[] = {1, 1, 2};
        Assert.assertEquals(5, tester.numRabbits(an));

        int an2[] = {};
        Assert.assertEquals(0, tester.numRabbits(an2));

        int an3[] = {10, 10, 10};
        Assert.assertEquals(11, tester.numRabbits(an3));

    }
}
