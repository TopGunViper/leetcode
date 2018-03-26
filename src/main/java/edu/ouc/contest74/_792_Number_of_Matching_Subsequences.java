package edu.ouc.contest74;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class _792_Number_of_Matching_Subsequences {

    public int numMatchingSubseq(String S, String[] words) {
        int retVal = 0;
        Map<String, Boolean> cache = new HashMap<>();
        for(String word : words){
            Boolean res = cache.get(word);
            if(res == null){
                if(isSubseq(S, word)){
                    retVal++;
                    cache.put(word, true);
                }else {
                    cache.put(word, false);
                }
            }else {
                if(res){
                    retVal++;
                }
            }
        }
        return retVal;
    }

    /**
     * TLE!!!
     *
     * @param S
     * @param T
     * @return
     */
    private boolean isSubseq(String S, String T){
        if(S.contains(T)){
            return true;
        }
        int index = 0;
        for(Character c : T.toCharArray()){
            if(S.indexOf(c, index) == -1){
                return false;
            }
            index = S.indexOf(c, index) + 1;
        }
        return true;
    }
    public static void main(String args[]) {
        //test case1
        _792_Number_of_Matching_Subsequences tester = new _792_Number_of_Matching_Subsequences();
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        Assert.assertTrue(tester.numMatchingSubseq(S, words) == 3);

    }
}
