package j_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/subsets/description/
 * @author: Yidan
 * @create: 2023-11-06 21:48
 **/

public class Solution78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(res, path, nums, 0);
    return res;
  }

  public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
    if (index == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }
    // decide to add nums[index]
    path.add(nums[index]);
    dfs(res, path, nums, index + 1);
    // decide not to add nums[index]
    path.remove(path.size() - 1);
    dfs(res, path, nums, index + 1);
  }
}