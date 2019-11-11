package queue_stack;

import java.util.Arrays;

public class TargetSum {
  public static void main(String[] args) {
    System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1,}, 3));
  }

  public int findTargetSumWays(int[] nums, int S) {
    int[][] memo = new int[nums.length][2001];
    for (int[] aMemo : memo) {
      Arrays.fill(aMemo, Integer.MIN_VALUE);
    }
    return calculate(nums, 0, 0, S, memo);
  }

  private int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
    if (i == nums.length) {
      if (sum == S) {
        return 1;
      } else {
        return 0;
      }
    } else {
      if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
        return memo[i][sum + 1000];
      }
      int a = calculate(nums, i + 1, sum + nums[i], S, memo);
      int b = calculate(nums, i + 1, sum - nums[i], S, memo);
      memo[i][sum + 1000] = a + b;
      return memo[i][sum + 1000];
    }
  }
}
