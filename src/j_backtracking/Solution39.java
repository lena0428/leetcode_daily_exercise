package j_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/combination-sum/description/
 * @author: Yidan
 * @create: 2023-11-07 13:50
 **/

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> combination = new ArrayList<>();
      dfs(res, combination, candidates, 0, 0, target);
      return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> combination, int[] candidates, int index, int total, int target) {
      if (total == target) {
        res.add(new ArrayList<>(combination));
        return;
      }
      if (index >= candidates.length || total > target) {
        return;
      }
      // 1. add the candidates[index] into combination.
      combination.add(candidates[index]);
      dfs(res, combination, candidates, index, total + candidates[index], target);
      // 2. not add the candidates[index] into combination, skip it. (combination, not permutation)
      combination.remove(combination.size() - 1);
      dfs(res, combination, candidates, index + 1, total, target);
    }
}