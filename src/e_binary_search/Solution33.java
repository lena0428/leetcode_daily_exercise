package e_binary_search;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * @author: Yidan
 * @create: 2023-11-16 18:03
 **/

public class Solution33 {
  class Solution {
    // 1 2 3 4 5  3 < 5
    // 2 3 4 5 1  4 > 1
    // 3 4 5 1 2  5 > 2
    // 4 5 1 2 3  1 < 3
    // 5 4 3 2 1  3 > 1
    /**
     In some traditional binary search implementations, you might see left < right as the condition for the search loop. However, in the context of this rotated sorted array problem, using left < right might lead to missing a potential solution, especially in certain edge cases.

     Let's consider an example:

     Array: [4, 5, 6, 7, 0, 1, 2]
     Target: 0
     If we set the condition as left < right, the algorithm might miss checking the last element because left will be equal to right when there are only two elements left to check. In this particular problem, it's important to include that final check because the solution might be the last remaining element in the search space.

     Using left <= right ensures that the algorithm exhaustively checks the last remaining element in the search space before concluding the search. This ensures that the algorithm considers all elements within the range before terminating the search loop.

     Hence, for this rotated sorted array problem, it's more suitable to use left <= right to avoid missing potential solutions at the end of the search space. */
    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
          return mid;
        }
        // right half is sorted
        if (nums[mid] <= nums[right]) {
          if (nums[mid] < target && target <= nums[right]) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
          // left half is sorted
        } else {
          if (nums[mid] > target && target >= nums[left]) {
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }
      }
      return -1;
    }
  }
}