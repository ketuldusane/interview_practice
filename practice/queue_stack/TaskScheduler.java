package queue_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Task Scheduler
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 * represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
 * intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * Note:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */

public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    for (char task : tasks) {
      map.put(task, map.getOrDefault(task, 0) + 1);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    // Store the frequency of the tasks in the PQ
    for (char task : map.keySet()) {
      queue.offer(map.get(task));
    }
    int time = 0;

    // The idea is we will get the element from the queue with the highest frequency
    // If that number is more than 1, than we need to process it multiple time, but we cannot process it until the current round
    // So we store it temporarily in the list and add it back to the queue after the round is complete
    while (!queue.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int round = 0;
      // Run the round until the cooldown period
      while (round <= n) {
        if (!queue.isEmpty()) {
          int task = queue.poll();
          if (task > 1) {
            temp.add(task - 1);
          }
        }
        time++;
        round++;
        if (queue.isEmpty() && temp.size() == 0) {
          break;
        }
      }
      for (int task : temp) {
        queue.offer(task);
      }
    }
    return time;
  }
}
