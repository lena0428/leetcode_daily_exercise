package b_two_pointers;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/valid-palindrome/description/
 * @author: Yidan
 * @create: 2023-10-22 19:34
 **/

public class Solution125 {
    public boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length() - 1;
      while (left < right) {
        while (left < right && !(Character.isAlphabetic(s.charAt(left)) || Character.isDigit(s.charAt(left)))) {
          left++;
        }
        while (left < right && !(Character.isAlphabetic(s.charAt(right)) || Character.isDigit(s.charAt(right)))) {
          right--;
        }
        if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
}