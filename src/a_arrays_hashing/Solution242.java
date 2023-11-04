package a_arrays_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/valid-anagram/description/
 * @author: Yidan
 * @create: 2023-10-21 17:02
 **/

public class Solution242 {
  public boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        int cnt = map.get(s.charAt(i));
        cnt++;
        map.put(s.charAt(i), cnt);
      } else {
        map.put(s.charAt(i), 1);
      }
    }
    for (int i = 0; i < t.length(); i++) {
      if (map.containsKey(t.charAt(i))) {
        int cnt = map.get(t.charAt(i));
        cnt--;
        map.put(t.charAt(i), cnt);
      } else {
        return false;
      }
    }
    for (Map.Entry<Character, Integer> entry: map.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }
    return true;
  }
}