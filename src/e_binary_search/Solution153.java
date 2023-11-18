package e_binary_search;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * @author: Yidan
 * @create: 2023-11-16 17:31
 **/

public class Solution153 {
  // 1 2 3 4 5  3 < 5
  // 2 3 4 5 1  4 > 1
  // 3 4 5 1 2  5 > 2
  // 4 5 1 2 3  1 < 3
  // 5 4 3 2 1  3 > 1
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] < nums[right]) {
        // The minimum element is in the left part or at mid
        right = mid;
      } else {
        // The minimum element is in the right part
        left = mid + 1;
      }
    }
    // At the end of the loop, 'left' and 'right' will converge to the minimum element
    return nums[left];
  }
}