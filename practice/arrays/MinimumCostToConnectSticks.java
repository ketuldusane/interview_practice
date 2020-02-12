package arrays;

import java.util.PriorityQueue;

/**
 * Minimum Cost to Connect Sticks
 *
 * You have some sticks with positive integer lengths.
 * You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action
 * until there is one stick remaining.
 *
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 *
 * Example 1:
 *
 * Input: sticks = [2,4,3]
 * Output: 14
 * Example 2:
 *
 * Input: sticks = [1,8,3,5]
 * Output: 30
 */

public class MinimumCostToConnectSticks {
  public int connectSticks(int[] sticks) {
    if (sticks == null || sticks.length == 0 || sticks.length == 1) {
      return 0;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i : sticks) {
      queue.offer(i);
    }
    int ans = 0;
    while (queue.size() > 1) {
      int sum = queue.poll() + queue.poll();
      ans += sum;
      queue.offer(sum);
    }
    return ans;
  }
}
