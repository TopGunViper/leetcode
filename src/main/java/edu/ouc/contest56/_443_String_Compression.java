package edu.ouc.contest56;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author wqx
 */
public class _443_String_Compression {

    /**
     * Solution:
     *
     * @param chars
     *
     * @return
     */
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < chars.length; ) {
            sb.append(chars[i]);
            int j = i + 1;
            int dups = 1;
            for (; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    dups++;
                }else {
                    break;
                }
            }
            if (dups > 1) {
                sb.append(dups);
            }
            System.out.println("sb:" + sb.toString());
            i += dups;
        }

        System.out.println("sb:" + sb.toString() + ",len:" + sb.length());
        if (sb.length() <= chars.length) {
            for (int i = 0; i < sb.length(); i++) {
                chars[i] = sb.toString().charAt(i);
            }
            System.out.println(Arrays.toString(chars));
            return sb.length();
        } else {
            return chars.length;
        }
    }
    public static void main(String args[]) {
        //test case1
        _443_String_Compression tester = new _443_String_Compression();

        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //assertTrue(tester.compress(chars1) == 6);

        char[] chars2 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        //assertTrue(tester.compress(chars2) == 4);

        char[] chars3 = {'a'};
        //assertTrue(tester.compress(chars3) == 1);
        
        char[] chars4 = {'a','a','b','b','c','c','c'};
        //assertTrue(tester.compress(chars4) == 6);
        //System.out.println(Arrays.toString(chars4));
        
        char[] chars5 = {'a','a','a','b','b','a','a'};
        assertTrue(tester.compress(chars5) == 6);
        System.out.println(Arrays.toString(chars5));

        char[] chars6 = {'a', 'a'};
        assertTrue(tester.compress(chars6) == 2);
        System.out.println(Arrays.toString(chars6));
    }
}
