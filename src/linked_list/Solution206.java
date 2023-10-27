package linked_list;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/reverse-linked-list/description/
 * @author: Yidan
 * @create: 2023-10-26 21:07
 **/

public class Solution206 {
  class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  /**
   *     public ListNode reverseList(ListNode head) {
   *         if (head == null || head.next == null) {
   *             return head;
   *         }
   *         ListNode tmp = reverseList(head.next);
   *         head.next.next = head;
   *         head.next = null;
   *         return tmp;
   *     }
   */
}