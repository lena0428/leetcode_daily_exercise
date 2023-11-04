package e_binary_search;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/binary-search/description/
 * @author: Yidan
 * @create: 2023-10-23 19:54
 **/

public class Solution704 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      // prevent integer overflow
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}