package two_pointers;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 * @author: Yidan
 * @create: 2023-10-22 19:37
 **/

public class Solution167 {
  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      if (numbers[left] + numbers[right] == target) {
        return new int[] { left + 1, right + 1 };
      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[] { -1, -1 };
  }
}