package f_linked_list;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/reorder-list/
 * @author: Yidan
 * @create: 2023-11-17 21:23
 **/

public class Solution143 {
  static class ListNode {
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

  public void reorderList(ListNode head) {
    // edge case
    if (head == null || head.next == null) {
      return;
    }
    ListNode fast = head;
    ListNode slow = head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      pre = slow;
      slow = slow.next;
    }
    pre.next = null;
    // merge two linkedlist(reverse one of them)
    merge(head, reverse(slow));
  }

  public ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public void merge(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
      ListNode l1Next = l1.next;
      ListNode l2Next = l2.next;

      l1.next = l2;
      /**
       when l1 reaches the end of its half,
       there might not be any remaining nodes
       in the l1 list (l1Next will be null).
       At this point, if we attempt to set
       l2.next to l1Next, we'll be making a null reference. */
      if (l1Next != null) {
        l2.next = l1Next;
      }

      l1 = l1Next;
      l2 = l2Next;
    }
  }
}
