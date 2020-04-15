package arrays;

import java.util.Arrays;

/**
 * 3Sum Closest
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int start;
    int end;
    int dist = Integer.MAX_VALUE;
    int ans = 0;

    for (int k = 0; k < nums.length - 2; k++) {
      start = k + 1;
      end = nums.length - 1;

      while (start < end) {
        int sum = nums[k] + nums[start] + nums[end];
        int d = Math.abs(target - sum);

        if (d < dist) {
          dist = d;
          ans = sum;
        }

        if (sum > target) {
          end--;
        } else {
          start++;
        }
      }
    }

    return ans;
  }
}
