package d_stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/car-fleet/description/
 * @author: Yidan
 * @create: 2023-11-16 13:31
 **/

public class Solution853 {
  class Solution {
    class Car {
      int position;
      int speed;
      double time;

      Car(int position, int speed, double time) {
        this.position = position;
        this.speed = speed;
        this.time = time;
      }
    }

    public int carFleet(int target, int[] position, int[] speed) {
      List<Car> carList = new ArrayList<>();
      for (int i = 0; i < position.length; i++) {
        carList.add(new Car(position[i], speed[i], (target - position[i]) * 1.0 / speed[i]));
      }
      // sort by position, which position ahead of others will be first.
      carList.sort(new Comparator<Car>() {
        @Override public int compare(Car c1, Car c2) {
          return c2.position - c1.position;
        }
      });
      Stack<Car> stack = new Stack<>();
      for (Car car : carList) {
        stack.push(car);
        while (stack.size() >= 2 && stack.get(stack.size() - 1).time <= stack.get(
            stack.size() - 2).time) {
          stack.pop();
        }
      }
      return stack.size();
    }
  }
}