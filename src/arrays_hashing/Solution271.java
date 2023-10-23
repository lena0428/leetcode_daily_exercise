package arrays_hashing;

import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/encode-and-decode-strings/
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
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < strs.size(); i++) {
      res.append(strs.get(i) + ":;");
      if (i == strs.size() - 1) {
        continue;
      }
    }
    return res.toString();
  }

  /*
   * @param str: A string
   * @return: decodes a single string to a list of strings
   */
  public List<String> decode(String str) {
    String[] tmp = str.split(":;");
    List<String> res = new ArrayList<>();
    for (String string: tmp) {
      res.add(string);
    }
    return res;
  }
}