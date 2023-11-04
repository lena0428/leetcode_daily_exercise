package f_linked_list;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/add-two-numbers/description/
 * @author: Yidan
 * @create: 2023-10-28 20:29
 **/

public class Solution2 {
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode pointer1 = l1;
    ListNode pointer2 = l2;
    // make it no difference between insert a node to an empty linkedlist or not empty linkedlist. (in order not to handle the special situation when inserting node)
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    // 2 4 3, 5 6 4
    // 2 + 5 = 7
    // 4 + 6 = 10 -> carry 1
    // 3 + 4 + carry 1 = 8
    // -> 7 0 8

    int carry = 0;
    while (pointer1 != null && pointer2 != null) {
      int sum = (pointer1.val + pointer2.val + carry) % 10;
      carry = (pointer1.val + pointer2.val + carry) / 10;
      cur.next = new ListNode(sum);
      cur = cur.next;
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }
    while (pointer1 != null) {
      int sum = (pointer1.val + carry) % 10;
      carry = (pointer1.val + carry) / 10;
      cur.next = new ListNode(sum);
      cur = cur.next;
      pointer1 = pointer1.next;
    }
    while (pointer2 != null) {
      int sum = (pointer2.val + carry) % 10;
      carry = (pointer2.val + carry) / 10;
      cur.next = new ListNode(sum);
      cur = cur.next;
      pointer2 = pointer2.next;
    }
    if (carry != 0) {
      cur.next = new ListNode(carry);
    }
    return dummy.next;
  }
}