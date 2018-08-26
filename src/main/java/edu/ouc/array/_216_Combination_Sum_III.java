package edu.ouc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.
 *
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class _216_Combination_Sum_III {

    /**
     * backtracking
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        backtracking(k, n, 1, new HashSet<>(), 0);
        return res;
    }

    private static List<List<Integer>> res;

    private void backtracking(int k, int n, int curV, Set<Integer> curSet, int sum){
        if(curSet.size() == k){
            if(sum == n){
                res.add(new ArrayList<>(curSet));
            }
            return;
        }
        for(int i = curV; i <= 9; i++){
            curSet.add(i);
            backtracking(k, n, i + 1, curSet, sum + i);
            curSet.remove(i);
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        _216_Combination_Sum_III tester = new _216_Combination_Sum_III();
        tester.combinationSum3(k, n);
        System.out.println(res.size());
        for(List<Integer> r : res){
            System.out.println(Arrays.toString(r.toArray()));
        }
    }
}
