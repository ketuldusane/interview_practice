package queue_stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Shortest Subarray with Sum at least K
 *
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * If there is no non-empty subarray with sum at least K, return -1.
 *
 * Example 1:
 * Input: A = [1], K = 1
 * Output: 1
 *
 * Example 2:
 * Input: A = [1,2], K = 4
 * Output: -1
 *
 * Example 3:
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 *
 * Note:
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */

public class ShortestSubArrayWithSumAtLeastK {
  public int shortestSubarray(int[] A, int K) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int n = A.length;
    int ans = n + 1;
    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + A[i];
    }
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n + 1; i++) {
      while (queue.size() > 0 && (sum[i] - sum[queue.getFirst()] >= K)) {
        ans = Math.min(ans, i - queue.pollFirst());
      }
      while (queue.size() > 0 && sum[i] <= sum[queue.getLast()]) {
        queue.pollLast();
      }
      queue.addLast(i);
    }
    return ans <= n ? ans : -1;
  }
}
