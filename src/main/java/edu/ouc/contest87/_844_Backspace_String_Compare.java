package edu.ouc.contest87;

import java.util.Arrays;
import java.util.Stack;

public class _844_Backspace_String_Compare {


    public boolean backspaceCompare(String S, String T) {
        Stack s = new Stack();
        Stack t = new Stack();
        for(Character c : S.toCharArray()){
            if(c == '#' && !s.isEmpty()){
                s.pop();
            }else {
                s.push(c);
            }
        }
        System.out.println(Arrays.toString(s.toArray()));
        for(Character c : T.toCharArray()){
            if(c == '#' && !t.isEmpty()){
                t.pop();
            }else if(c != '#'){
                t.push(c);
            }
        }
        System.out.println(Arrays.toString(t.toArray()));
        System.out.println("size:" + s.size() + ",T.size:" + t.size());
        if(s.size() != t.size()){
            return false;
        }
        while (!s.isEmpty() && !t.isEmpty()){
            if(s.pop() != t.pop()){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        //test case1
        _844_Backspace_String_Compare
                tester = new _844_Backspace_String_Compare();
        //S = "ab##", T = "c#d#"
        String S = "ab##";
        String T = "c#d#";
//        System.out.println(tester.backspaceCompare(S,T));
//        S = "ab##"; T = "c#d#";
//        System.out.println(tester.backspaceCompare(S,T));
//        S = "a##c"; T = "#a#c";
//        System.out.println(tester.backspaceCompare(S,T));
//        S = "a#c"; T = "b";
//        System.out.println(tester.backspaceCompare(S,T));
        S = "y#fo##f";
        T = "y#f#o##f";
        System.out.println(tester.backspaceCompare(S,T));
    }
}
