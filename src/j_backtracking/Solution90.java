package j_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/subsets-ii/
 * @author: Yidan
 * @create: 2023-11-07 13:37
 **/

public class Solution90 {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // make sure duplicate values will be adjacent to each other.
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    dfs(res, subset, nums, 0);
    return res;
  }

  public void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int index) {
    if (index == nums.length) {
      res.add(new ArrayList<>(subset));
      return;
    }
    // decide to add nums[index].
    subset.add(nums[index]);
    dfs(res, subset, nums, index + 1);
    // decide not to add nums[index], and skip same value to nums[index].
    subset.remove(subset.size() - 1);
    while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
      index++;
    }
    dfs(res, subset, nums, index + 1);
  }
}