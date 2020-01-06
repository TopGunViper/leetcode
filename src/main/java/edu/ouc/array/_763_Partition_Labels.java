package edu.ouc.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author wqx
 */
public class _763_Partition_Labels {

    /**
     * Time Complexity: O(N*N)
     * Space Complexity: O(1)
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
            if (curLastIndex > partEnd) {
                partEnd = curLastIndex;
            }
        }
        res.add(partEnd - partBegin + 1);
        return res;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<Integer> partitionLabels2(String S) {
        List<Integer> res = new LinkedList<>();
        int partBegin = 0;
        int partEnd = 0;
        int[] lastIndexes = new int[26];
        for(int i = 0; i < S.length(); i++){
            lastIndexes[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            partEnd = Math.max(partEnd, lastIndexes[cur - 'a']);
            if (i == partEnd) {
                res.add(partEnd - partBegin + 1);
                partBegin = partEnd + 1;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        //test case1
        _763_Partition_Labels tester = new _763_Partition_Labels();
        String S = "ababcbacadefegdehijhklij";

        List<Integer> res = tester.partitionLabels(S);
        for (Integer i : res) {
            System.out.println(i);
        }

    }

}
