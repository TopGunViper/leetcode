package edu.ouc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _90_Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        recursivelyVisit(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void recursivelyVisit(int[] nums, int curIndex, List<Integer> curSubsets, List<List<Integer>> result) {
        result.add(new ArrayList<>(curSubsets));
        for (int i = curIndex; i < nums.length; i++) {
            curSubsets.add(nums[i]);
            recursivelyVisit(nums, i + 1, curSubsets, result);
            curSubsets.remove(curSubsets.size() - 1);
        }
    }

    public static void main(String[] args) {
        _90_Subsets2 tester = new _90_Subsets2();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = tester.subsetsWithDup(nums);
        Iterator<List<Integer>> iter = subsets.iterator();
        System.out.println(subsets.size());
        while (iter.hasNext()) {
            List<Integer> subSet = iter.next();
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}
