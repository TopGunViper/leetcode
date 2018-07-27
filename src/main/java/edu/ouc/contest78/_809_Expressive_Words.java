package edu.ouc.contest78;

import java.util.HashMap;
import java.util.Map;

public class _809_Expressive_Words {

    public int expressiveWords(String S, String[] words) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        int seq = 0;
        int index = 0;

        while (index < S.length()) {
            int r = 0;
            Character c = S.charAt(index);
            String key = seq + ":" + c;
            while (index < S.length() && c == S.charAt(index)) {
                r++;
                index++;
            }
            map.put(key, r);
            seq++;
        }

        //System.out.println(Arrays.toString(map.entrySet().toArray()));
        for (String word : words) {
            if(word.length() > S.length()){
                continue;
            }
            boolean isStretchy = true;
            seq = 0;
            index = 0;
            while (index < word.length()) {
                int repeated = 0;
                Character c = word.charAt(index);
                String key = seq + ":" + c;
                while (index < word.length() && c == word.charAt(index)) {
                    repeated++;
                    index++;
                }
                int expectedRepeated = map.getOrDefault(key, 0);
                System.out.println("c:" + c + ",repeated:" + repeated + ",expectedRepeated:"
                        + expectedRepeated);

                if (repeated == 0 || (expectedRepeated != repeated && expectedRepeated < 3)) {
                    isStretchy = false;
                    break;
                }
                seq++;
            }
            System.out.println("word:" + word + ",seq:" + seq + ",size:" + map.size());
            if (seq == map.size() && isStretchy) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        _809_Expressive_Words
                tester = new _809_Expressive_Words();
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(tester.expressiveWords(S, words));

        String S2 = "abcd";
        String[] words2 = {"abc"};
        System.out.println(tester.expressiveWords(S2, words2));

        String S3 = "dddiiiinnssssssoooo";
        String[] words3 = {"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"};
        System.out.println(tester.expressiveWords(S3, words3));


        String S4 = "aaa";
        String[] words4 = {"aaaa"};
        System.out.println(tester.expressiveWords(S4, words4));

    }
}
