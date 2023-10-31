package arrays_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://www.lintcode.com/problem/659/
 * @author: Yidan
 * @create: 2023-10-22 19:19
 **/

public class Solution271 {
  /*
   * @param strs: a list of strings
   * @return: encodes a list of strings to a single string.
   */
  public String encode(List<String> strs) {
    // write your code here
    String res = "";
    for (String str: strs) {
      res += str.length() + "#";
      res += str;
    }
    return res;
  }

  /*
   * @param str: A string
   * @return: decodes a single string to a list of strings
   */
  public List<String> decode(String str) {
    // write your code here
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != '#') {
        j++;
      }
      int len = Integer.valueOf(str.substring(i, j));
      res.add(str.substring(j + 1, j + len + 1));
      i = j + len + 1;
    }
    return res;
  }
}