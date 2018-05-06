package edu.ouc.contest83;

import org.junit.Assert;

public class _831_Masking_Personal_Information {

    public String maskPII(String S) {
        StringBuilder sb = new StringBuilder();
        String lowerCaseStr = S.toLowerCase();
        if (lowerCaseStr.contains("@")) {
            int indexOf = lowerCaseStr.indexOf('@');
            sb.append(lowerCaseStr.charAt(0))
                    .append("*****")
                    .append(lowerCaseStr.charAt(indexOf - 1))
                    .append(lowerCaseStr.substring(indexOf, lowerCaseStr.length()));
        } else {
            StringBuilder phone = new StringBuilder();
            for (int i = 0; i < lowerCaseStr.length(); i++) {
                if (lowerCaseStr.charAt(i) >= '0' && lowerCaseStr.charAt(i) <= '9') {
                    phone.append(lowerCaseStr.charAt(i));
                }
            }
            if (phone.length() == 10) {
                sb.append("***-***-")
                        .append(phone.toString().substring(6, 10));
            }else {
                sb.append("+");
                int i = 0;
                while (i++ < (phone.length() - 10)){
                    sb.append("*");
                }
                sb.append("-***-***-");
                sb.append(phone.toString().substring(phone.length() - 4, phone.length()));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        //test case1
        _831_Masking_Personal_Information
                tester = new _831_Masking_Personal_Information();
        String S = "LeetCode@LeetCode.com";
        Assert.assertEquals("l*****e@leetcode.com", tester.maskPII(S));
        S = "AB@qq.com";
        Assert.assertEquals("a*****b@qq.com", tester.maskPII(S));
        S = "1(234)567-890";
        Assert.assertEquals("***-***-7890", tester.maskPII(S));
        S = "86-(10)12345678";
        Assert.assertEquals("+**-***-***-5678", tester.maskPII(S));

    }
}
