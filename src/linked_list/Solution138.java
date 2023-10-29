package linked_list;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * @author: Yidan
 * @create: 2023-10-28 19:33
 **/

public class Solution138 {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    HashMap<Node, Node> oldAndNewNodeMap = new HashMap<>();
    Node cur = head;
    while (cur != null) {
      oldAndNewNodeMap.put(cur, new Node(cur.val));
      cur = cur. next;
    }
    cur = head;
    while (cur != null) {
      Node newNode = oldAndNewNodeMap.get(cur);
      newNode.next = oldAndNewNodeMap.get(cur.next);
      newNode.random = oldAndNewNodeMap.get(cur.random);
      cur = cur.next;
    }
    return oldAndNewNodeMap.get(head);
  }
}