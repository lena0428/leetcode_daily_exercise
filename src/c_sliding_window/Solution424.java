package c_sliding_window;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * @author: Yidan
 * @create: 2023-11-03 19:15
 **/

public class Solution424 {
  public int characterReplacement(String s, int k) {
    int[] cnt = new int[26];
    int left = 0;
    int right = 0;
    int res = 0;
    while (right < s.length()) {
      cnt[s.charAt(right) - 'A'] = 1 + cnt[s.charAt(right) - 'A'];
      while (right - left + 1 - Arrays.stream(cnt).max().getAsInt() > k) {
        cnt[s.charAt(left) - 'A']--;
        left++;
      }
      res = Math.max(res, right - left + 1);
      right++;
    }
    return res;
  }
}