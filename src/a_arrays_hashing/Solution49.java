package a_arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/group-anagrams/
 * @author: Yidan
 * @create: 2023-10-21 19:51
 **/

public class Solution49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> groupMap = new HashMap<>();
    for (String str : strs) {
      // must use this array to create string
      char[] count = new char[26];
      for (int i = 0; i < str.length(); i++) {
        count[str.charAt(i) - 'a'] ++;
      }
      String countStr = String.valueOf(count);
      if (groupMap.containsKey(countStr)) {
        List<String> list = groupMap.get(countStr);
        list.add(str);
        groupMap.put(countStr, list);
      } else {
        List<String> list = new ArrayList<>();
        list.add(str);
        groupMap.put(countStr, list);
      }
    }
    List<List<String>> res = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry: groupMap.entrySet()) {
      res.add(entry.getValue());
    }
    return res;
  }
}