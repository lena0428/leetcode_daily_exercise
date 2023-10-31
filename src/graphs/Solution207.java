package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/course-schedule/description/
 * @author: Yidan
 * @create: 2023-10-30 21:59
 **/

public class Solution207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] degrees = new int[numCourses];
    List<List<Integer>> graphs = new ArrayList<>();
    boolean[] visited = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graphs.add(new ArrayList<>());
    }
    for (int[] prerequisite: prerequisites) {
      degrees[prerequisite[0]]++;
      graphs.get(prerequisite[1]).add(prerequisite[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < degrees.length; i++) {
      if (degrees[i] == 0) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      int i = queue.poll();
      List<Integer> neighbors = graphs.get(i);
      for (int neighbor: neighbors) {
        degrees[neighbor]--;
        if (degrees[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }
    for (int i = 0; i < degrees.length; i++) {
      if (degrees[i] != 0) {
        return false;
      }
    }
    return true;
  }
}