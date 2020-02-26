package algorithmns.dynamic_programming_recursion;

import java.util.Arrays;

/**
 * Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step
 */

public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n < 0) return 0;
    int[] cache = new int[n + 1];
    Arrays.fill(cache, -1);
    cache[0] = 1;
    cache[1] = 1;
    return climbStairs(n, cache);
  }

  private int climbStairs(int n, int[] cache) {
    if (n < 0) return 0;
    if (cache[n] != -1) return cache[n];
    cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
    return cache[n];
  }
}
