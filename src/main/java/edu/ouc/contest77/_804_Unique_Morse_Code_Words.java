package edu.ouc.contest77;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class _804_Unique_Morse_Code_Words {

    private String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> encodedStr = new HashSet<>();
        for (String word : words){
            encodedStr.add(encode(word));
        }
        return encodedStr.size();
    }
    private String encode(String word){
        StringBuilder res = new StringBuilder();
        for(Character c : word.toCharArray()){
            res.append(map[c - 'a']);
        }
        return res.toString();
    }

    public static void main(String args[]) {
        //test case1
        _804_Unique_Morse_Code_Words
                tester = new _804_Unique_Morse_Code_Words();
        String[] words = {"gin", "zen", "gig", "msg"};
        Assert.assertEquals(2, tester.uniqueMorseRepresentations(words));

    }
}
