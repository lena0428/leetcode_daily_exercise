package two_pointers;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/3sum/description/
 * @author: Yidan
 * @create: 2023-10-22 20:07
 **/

public class Solution15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        if (nums[i] + nums[left] + nums[right] < 0) {
          left++;
        } else if (nums[i] + nums[left] + nums[right] > 0) {
          right--;
        } else {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(nums[i]);
          tmp.add(nums[left]);
          tmp.add(nums[right]);
          res.add(tmp);
          left++;
          // [-2, -2, 0, 0, 2, 2]
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
        }
      }
    }
    return res;
  }
}