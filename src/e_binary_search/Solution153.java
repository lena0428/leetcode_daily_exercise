package e_binary_search;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * @author: Yidan
 * @create: 2023-11-16 17:31
 **/

public class Solution153 {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < nums[right]) {
        right--;
      } else{
        left++;
      }
    }
    return nums[right];
  }
}