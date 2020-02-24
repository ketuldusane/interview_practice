package queue_stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sum of Subarray Minimums
 * <p>
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * <p>
 * Note:
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 */

public class SumOfSubarrayMinimums {
  public int sumSubarrayMins(int[] A) {
    int ans = 0;
    int n = A.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    // left monotonous
    for (int i = 0; i < n; i++) {
      int count = 1;
      while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
        count += left[stack.pop()];
      }
      stack.push(i);
      left[i] = count;
    }
    stack.clear();
    // right monotonous
    for (int i = n - 1; i >= 0; i--) {
      int count = 1;
      while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
        count += right[stack.pop()];
      }
      stack.push(i);
      right[i] = count;
    }
    for (int i = 0; i < n; i++) {
      ans = (ans + (A[i] * left[i] * right[i])) % (int) (1e9 + 7);
    }
    return ans;
  }
}
