package algorithmns.divie_and_conquer;

/**
 * Burst Baloons
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You
 * are asked to burst all the balloons. If you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * Example:
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class BurstBalloons {
  public int maxCoins(int[] nums) {
    return getMaxCoins(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]);
  }

  private int getMaxCoins(int[] nums, int start, int end, Integer[][] cache) {
    if (start > end) {
      return 0;
    }

    if (cache[start][end] != null) {
      return cache[start][end];
    }

    int leftVal = getNum(nums, start - 1);
    int rightVal = getNum(nums, end + 1);

    if (start == end) {
      return leftVal * nums[start] * rightVal;
    }

    int max = Integer.MIN_VALUE;
    for (int i = start; i <= end; i++) {
      int left = getMaxCoins(nums, start, i - 1, cache);
      int right = getMaxCoins(nums, i + 1, end, cache);
      max = Math.max(max, left + leftVal * nums[i] * rightVal + right);
    }
    cache[start][end] = max;

    return max;
  }

  private int getNum(int[] nums, int i) {
    if (i < 0 || i >= nums.length) {
      return 1;
    }
    return nums[i];
  }
}
