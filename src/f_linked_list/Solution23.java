package f_linked_list;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/merge-k-sorted-lists/description/
 * @author: Yidan
 * @create: 2023-10-30 19:08
 **/
public class Solution23 {
  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    ListNode tmp = lists[0];
    for (int i = 1; i < lists.length; i++) {
      tmp = mergeTwoList(tmp, lists[i]);
    }
    return tmp;
  }

  public ListNode mergeTwoList(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeTwoList(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoList(l1, l2.next);
      return l2;
    }
  }
}