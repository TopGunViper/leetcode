package edu.ouc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursivelyVisit(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void recursivelyVisit(int[] nums, int curIndex, List<Integer> curSubsets, List<List<Integer>> result){
        result.add(new ArrayList<>(curSubsets));
        for(int i = curIndex; i < nums.length; i++){
            curSubsets.add(nums[i]);
            recursivelyVisit(nums, i + 1, curSubsets, result);
            curSubsets.remove(curSubsets.size() - 1);
        }
    }

    public static void main(String[] args) {
        _78_Subsets tester = new _78_Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = tester.subsets(nums);
        Iterator<List<Integer>> iter = subsets.iterator();
        System.out.println(subsets.size());
        while (iter.hasNext()){
            List<Integer> subSet = iter.next();
            System.out.println(Arrays.toString(subSet.toArray()));
        }
    }
}
