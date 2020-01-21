package arrays;

/**
 * Maximum Subarray
 *
 * Kadane's Algorithm
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {

    /*
      The following approach uses Kadane's Algorithm
     */

    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length;
    int maxSum = nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i - 1] > 0) {
        nums[i] += nums[i - 1];
      }
      maxSum = Math.max(maxSum, nums[i]);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    int ans = new MaximumSubarray().maxSubArray(arr);
  }
}
