package arrays;

/**
 * Minimum Size Subarray Sum
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class MinSizeSubArraySum {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int sum = 0;
    int length = Integer.MAX_VALUE;
    int left = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      while (sum >= s) {
        length = Math.min(length, i - left + 1);
        sum -= nums[left++];
      }
    }

    return (length == Integer.MAX_VALUE) ? 0 : length;
  }
}
