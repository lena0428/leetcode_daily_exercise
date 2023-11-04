package f_linked_list;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/merge-two-sorted-lists/description/
 * @author: Yidan
 * @create: 2023-10-26 21:21
 **/

public class Solution21 {

  public class ListNode {
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

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    ListNode pointer1 = list1;
    ListNode pointer2 = list2;
    while (pointer1 != null && pointer2 != null) {
      if (pointer1.val < pointer2.val) {
        cur.next = new ListNode(pointer1.val);
        cur = cur.next;
        pointer1 = pointer1.next;
      } else if (pointer1.val > pointer2.val) {
        cur.next = new ListNode(pointer2.val);
        cur = cur.next;
        pointer2 = pointer2.next;
      } else {
        cur.next = new ListNode(pointer1.val);
        cur = cur.next;
        pointer1 = pointer1.next;
        cur.next = new ListNode(pointer2.val);
        cur = cur.next;
        pointer2 = pointer2.next;
      }
    }
    while (pointer1 != null) {
      cur.next = new ListNode(pointer1.val);
      cur = cur.next;
      pointer1 = pointer1.next;
    }
    while (pointer2 != null) {
      cur.next = new ListNode(pointer2.val);
      cur = cur.next;
      pointer2 = pointer2.next;
    }
    return dummy.next;
  }
  /**
   *   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
   *         if (list1 == null && list2 == null) {
   *             return null;
   *         }
   *         if (list1 == null && list2 != null) {
   *             return list2;
   *         }
   *         if (list1 != null && list2 == null) {
   *             return list1;
   *         }
   *         if (list1.val < list2.val) {
   *             list1.next = mergeTwoLists(list1.next, list2);
   *             return list1;
   *         } else {
   *             list2.next = mergeTwoLists(list1, list2.next);
   *             return list2;
   *         }
   *     }
   */
}