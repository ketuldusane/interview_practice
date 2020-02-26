package algorithmns.dynamic_programming_recursion;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Note:

 There may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.
 Follow up: Could you improve it to O(n log n) time complexity?
 */

public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int i = 1;
    int j = 0;
    int currMax = 1;
    while (i < dp.length) {
      if (nums[j] < nums[i]) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
        currMax = Math.max(currMax, dp[i]);
      }
      j++;
      if (i == j) {
        j = 0;
        i++;
      }
    }
    return currMax;
  }
}
