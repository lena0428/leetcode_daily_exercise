package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/clone-graph/description/
 * @author: Yidan
 * @create: 2023-10-29 15:28
 **/

public class Solution133 {
  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    HashMap<Node, Node> oldAndNewMap = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    // 1.create node
    queue.offer(node);
    while (!queue.isEmpty()) {
      Node tmp = queue.poll();
      if (visited.contains(tmp)) {
        continue;
      }
      visited.add(tmp);
      oldAndNewMap.put(tmp, new Node(tmp.val));
      if (tmp.neighbors != null && tmp.neighbors.size() != 0) {
        for (Node neighbor: tmp.neighbors) {
          queue.offer(neighbor);
        }
      }
    }
    visited.clear();
    // 2.add neighbors
    for (Map.Entry<Node, Node> entry: oldAndNewMap.entrySet()) {
      Node oldNode = entry.getKey();
      if (visited.contains(oldNode)) {
        continue;
      }
      visited.add(oldNode);
      Node newNode = entry.getValue();
      if (oldNode.neighbors != null && oldNode.neighbors.size() != 0) {
        newNode.neighbors = new ArrayList<>();
        for (Node neighbor: oldNode.neighbors) {
          newNode.neighbors.add(oldAndNewMap.get(neighbor));
        }
      }
    }
    return oldAndNewMap.get(node);
  }
}