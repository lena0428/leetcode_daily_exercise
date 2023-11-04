package f_linked_list;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * @author: Yidan
 * @create: 2023-10-30 19:15
 **/

public class Solution19 {
   public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = dummy;
    for (int i = 0; i < n; i++) {
      cur = cur.next;
    }
    ListNode pre = dummy;
    while (cur.next != null) {
      pre = pre.next;
      cur = cur.next;
    }
    pre.next = pre.next.next;
    return dummy.next;
  }
}