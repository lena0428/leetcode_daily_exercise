package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/course-schedule-ii/description/
 * @author: Yidan
 * @create: 2023-10-30 22:12
 **/

public class Solution210 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] res = new int[numCourses];
    int[] degrees = new int[numCourses];
    List<List<Integer>> graphs = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graphs.add(new ArrayList<>());
    }
    for (int[] prerequisite: prerequisites) {
      degrees[prerequisite[0]]++;
      graphs.get(prerequisite[1]).add(prerequisite[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (degrees[i] == 0) {
        queue.offer(i);
      }
    }
    int index = 0;
    while (!queue.isEmpty()) {
      int tmp = queue.poll();
      res[index++] = tmp;
      List<Integer> neighbors = graphs.get(tmp);
      for (int neighbor: neighbors) {
        degrees[neighbor]--;
        if (degrees[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }
    for (int i = 0; i < numCourses; i++) {
      if (degrees[i] != 0) {
        return new int[0];
      }
    }
    return res;
  }
}