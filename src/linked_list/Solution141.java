package linked_list;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/linked-list-cycle/description/
 * @author: Yidan
 * @create: 2023-10-28 20:46
 **/

public class Solution141 {
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}