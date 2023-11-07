package j_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/combination-sum-ii/
 * @author: Yidan
 * @create: 2023-11-07 13:43
 **/

public class Solution40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    // ensure that the duplicate values are adjacent to each other.
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(res, path, candidates, target, 0, 0);
    return res;
  }

  public void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int index, int total) {
    if (total == target) {
      res.add(new ArrayList<>(path));
      return;
    }
    if (index >= candidates.length || total > target) {
      return;
    }
    // decide to add candidates[index], and only use it once(index + 1)
    path.add(candidates[index]);
    dfs(res, path, candidates, target, index + 1, total + candidates[index]);
    // decide not to add candidates[index], and eliminate the duplicate value
    path.remove(path.size() - 1);
    while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
      index++;
    }
    dfs(res, path, candidates, target, index + 1, total);
  }
}