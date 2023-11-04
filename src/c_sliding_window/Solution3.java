package c_sliding_window;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * @author: Yidan
 * @create: 2023-10-22 20:48
 **/

public class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    int left = 0;
    int longLen = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        left = Math.max(left, map.get(s.charAt(i)) + 1);
      }
      map.put(s.charAt(i), i);
      longLen = Math.max(longLen, i - left + 1);
    }
    return longLen;
  }
}