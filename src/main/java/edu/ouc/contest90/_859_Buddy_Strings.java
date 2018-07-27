package edu.ouc.contest90;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class _859_Buddy_Strings {


    public boolean buddyStrings(String A, String B) {
        if (A.equals(B)) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length(); ++i) {
                int cur = map.getOrDefault(A.charAt(i), 0);
                if (cur == 0) {
                    map.put(A.charAt(i), 1);
                } else {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                            A.charAt(second) == B.charAt(first));
        }
    }

    public static void main(String args[]) {
        _859_Buddy_Strings
                tester = new _859_Buddy_Strings();
        String A = "ab", B = "ba";
        Assert.assertTrue(tester.buddyStrings(A , B));
    }
}
