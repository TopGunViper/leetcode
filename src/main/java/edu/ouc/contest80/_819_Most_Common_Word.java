package edu.ouc.contest80;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _819_Most_Common_Word {


    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        Set<String> bannedSet = new HashSet<>();
        bannedSet.addAll(Arrays.asList(banned));
        int max = 0;
        String mostCommonWord = "";
        Map<String,Integer> res = new HashMap<>();
        for(String word : words){
            String realWord = resolveWord(word);
            if(bannedSet.contains(realWord)){
                continue;
            }
            int count = res.getOrDefault(realWord, 0) + 1;
            res.put(realWord, count);
            if(count >= max){
                max = count;
                mostCommonWord = realWord;
            }
        }
        return mostCommonWord;
    }
    static Pattern p = Pattern.compile("\\w+[!?',;.]$");

    public String resolveWord(String str){
        String res = str.trim().toLowerCase();
        if(p.matcher(res).find()){
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    public static void main(String args[]) {
        //test case1
        _819_Most_Common_Word
                tester = new _819_Most_Common_Word();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println(tester.mostCommonWord(paragraph,banned ));

        String test = "hit.";
        String test1 = "?hit";
        String test2 = "hi.t";
        String test3 = "hit?";
        String test4 = "hit..";

        Matcher m = p.matcher(test);
        System.out.println(m.find());

        m = p.matcher(test1);
        System.out.println(m.find());

        m = p.matcher(test2);
        System.out.println(m.find());

        m = p.matcher(test3);
        System.out.println(m.find());

        m = p.matcher(test4);
        System.out.println(m.find());

    }
}
