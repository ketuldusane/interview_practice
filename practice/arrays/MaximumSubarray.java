package arrays;

/**
 * Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int currMax = nums[0];
    int allMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currMax = Math.max(nums[i], currMax + nums[i]);
      allMax = Math.max(allMax, currMax);
    }

    return allMax;
  }

  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    int ans = new MaximumSubarray().maxSubArray(arr);
  }
}
