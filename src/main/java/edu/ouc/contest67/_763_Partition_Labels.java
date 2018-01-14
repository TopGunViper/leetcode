package edu.ouc.contest67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.sun.tools.javac.util.Assert;

/**
 * @author wqx
 */
public class _763_Partition_Labels {

    /**
     * Solution:
     *
     * @param S
     *
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int partBegin = 0;
        int partEnd = 0;

        for (int i = 0; i < S.length(); i++) {
            if (i > partEnd) {
                res.add(partEnd - partBegin + 1);
                partEnd = partBegin = i;
            }
            char cur = S.charAt(i);
            int curLastIndex = S.lastIndexOf(cur);
            //System.out.println("cur:" + cur + ",curLastIndex:" + curLastIndex + "partBegin:" + partBegin + ",partEnd:"+ partEnd);
            if (curLastIndex > partEnd) {
                partEnd = curLastIndex;
            }
        }
        res.add(partEnd - partBegin + 1);
        return res;
    }

    public static void main(String args[]) {
        //test case1
        _763_Partition_Labels tester = new _763_Partition_Labels();
        String S = "ababcbacadefegdehijhklij";
        System.out.println(S.lastIndexOf('a', 3));
        List<Integer> res = tester.partitionLabels(S);
        for (Integer i : res) {
            System.out.println(i);
        }

    }

}
